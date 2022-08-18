package sample.poc.transfer.controller;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.microprofile.lra.annotation.Compensate;
import org.eclipse.microprofile.lra.annotation.Complete;
import org.eclipse.microprofile.lra.annotation.ParticipantStatus;
import org.eclipse.microprofile.lra.annotation.ws.rs.LRA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bxm.common.annotaion.BxmCategory;
import bxmc.common.RequestContextTrace;
import bxmc.request.ApplicationException;
import bxmc.request.SystemHeader;
import bxmc.request.client.RestTemplateWithHeader;
import bxmc.request.client.RestTemplateWithHeader.PrependedSystemHeader;
import lra.common.context.LRAContext;
import sample.poc.transfer.domain.DepositIn;
import sample.poc.transfer.domain.LRATransferIn;
import sample.poc.transfer.domain.LRATransferOut;
import sample.poc.transfer.domain.WithdrawIn;

/**
 * LRA 이체 컨트롤러
 *
 * @author sysadmin
 */
@RestController
@RequestMapping("/")
@BxmCategory(logicalName = "LRA 이체 컨트롤러", description = "LRA 이체 컨트롤러")
public class LRATransferController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private RestTemplateWithHeader restTemplate;

	/**
	 * LRA - 이체 처리
	 * @param in 이체정보
	 * @return 이체 처리 결과
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/transfer")
	@LRA(value = LRA.Type.REQUIRED, timeLimit = 10, timeUnit = ChronoUnit.SECONDS)
	@BxmCategory(logicalName = "LRA 이체 처리", description = "LRA 이체 처리")
	public ResponseEntity<LRATransferOut> transfer(@RequestBody LRATransferIn in) {
		Map<Object, Object> terminationData = new HashMap<>();
		LRAContext.storeTerminationData(terminationData);

		SystemHeader systemHeader = RequestContextTrace.getRequestSystemHeader().orElse(null);
		PrependedSystemHeader header = PrependedSystemHeader.prepend(systemHeader);

		// 출금
		WithdrawIn withdrawIn = new WithdrawIn();
		withdrawIn.setCustId(in.getCustId());
		withdrawIn.setAcctNum(in.getWithdrawAcctNum());
		withdrawIn.setSummary(in.getSummary());
		withdrawIn.setWithdrawAmt(in.getTransferAmt());

		try {
			Object withdrawResult = restTemplate.postForObject("http://deposit-app:8080/lra/withdraw", header,
					withdrawIn, String.class);
		} catch (Exception e) {
			logger.error("Failed to withdraw...", e);
			throw new ApplicationException("sample.poc.transfer.failed", "Failed to transfer");
		}

		// 출금이 성공한 경우 입금 실패시 처리를 위해 terminataionData에 출금정보를 저장
		terminationData.put("withdrawCustId", withdrawIn.getCustId());
		terminationData.put("withdrawAcctNum", withdrawIn.getAcctNum());
		terminationData.put("withdrawAmt", withdrawIn.getWithdrawAmt().toString());
		LRAContext.storeTerminationData(terminationData);

		// 입금
		header = PrependedSystemHeader.prepend(systemHeader);

		DepositIn depositIn = new DepositIn();
		depositIn.setCustId(in.getCustId());
		depositIn.setAcctNum(in.getDepositAcctNum());
		depositIn.setSummary(in.getSummary());
		depositIn.setDepositAmt(in.getTransferAmt());

		try {
			Object depositResult = restTemplate.postForObject("http://deposit-app:8080/lra/deposit", header, depositIn,
					String.class);
		} catch (Exception e) {
			logger.error("Failed to deposit...", e);
			throw new ApplicationException("sample.poc.transfer.failed", "Failed to transfer");
		}

		LRATransferOut result = new LRATransferOut();
		result.setSuccessYn("Y");

		return ResponseEntity.ok(result);
	}

	/**
	 * LRA - 이체 성공 처리
	 * @param terminationData 처리 데이터
	 * @return 결과
	 */
	@RequestMapping(method = RequestMethod.PUT, path = "/transfer/complete")
	@Complete
	@BxmCategory(logicalName = "LRA 이체 성공", description = "LRA 이체 성공")
	public ResponseEntity<String> complete(@RequestBody Map<Object, Object> terminationData) {
		return ResponseEntity.ok(ParticipantStatus.Completed.name());
	}

	/**
	 * LRA - 이체 보상 처리
	 * @param terminationData 처리 데이터
	 * @return 결과
	 */
	@RequestMapping(method = RequestMethod.PUT, path = "/transfer/compensate")
	@Compensate
	@BxmCategory(logicalName = "LRA 이체 실패", description = "LRA 이체 실패")
	public ResponseEntity<String> compensate(@RequestBody Map<Object, Object> terminationData) {
		// terminationData에 출금 정보가 있을 경우 (출금 후 입금이 실패한 경우) 출금한 액수만큼 재입금  
		if (terminationData.containsKey("withdrawCustId")) {
			SystemHeader systemHeader = RequestContextTrace.getRequestSystemHeader().orElse(null);
			PrependedSystemHeader header = PrependedSystemHeader.prepend(systemHeader);

			String custId = (String) terminationData.get("withdrawCustId");
			String acctNum = (String) terminationData.get("withdrawAcctNum");
			BigDecimal depositAmt = new BigDecimal((String) terminationData.get("withdrawAmt"));

			DepositIn depositIn = new DepositIn();
			depositIn.setCustId(custId);
			depositIn.setAcctNum(acctNum);
			depositIn.setSummary("이체 오류 재입금");
			depositIn.setDepositAmt(depositAmt);

			Object depositResult = restTemplate.postForObject("http://deposit-app:8080/lra/deposit", header,
					depositIn, String.class);
		}

		return ResponseEntity.ok(ParticipantStatus.Compensated.name());
	}
}
