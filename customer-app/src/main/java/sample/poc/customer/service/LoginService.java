package sample.poc.customer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bxm.common.annotaion.BxmCategory;
import bxmc.request.ApplicationException;
import sample.poc.customer.component.LoginComponent;
import sample.poc.customer.dbio.CustomerDBIO;
import sample.poc.customer.domain.CustomerOut;
import sample.poc.customer.domain.LoginIn;
import sample.poc.customer.domain.LoginOut;

/**
 * 로그인 서비스
 *
 * @author sysadmin
 */
@Service
@BxmCategory(logicalName = "로그인 서비스", description = "로그인 서비스")
public class LoginService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CustomerDBIO customerDBIO;
	
	@Autowired
	private LoginComponent loginComponent;

	/**
	 * 로그인 수행
	 * @param in 로그인 정보
	 * @return 로그인 결과
	 */
	@BxmCategory(logicalName = "로그인 수행", description = "로그인 수행")
	public LoginOut login(LoginIn in) {
		
		// 고객 정보 조회
		CustomerOut customerOut = customerDBIO.selectCustomer(in.getCustId());

		if (customerOut == null) {
			logger.error("고객 ID가 [{}]인 고객 정보가 존재하지 않습니다.", in.getCustId());
			throw new ApplicationException("sample.poc.customer.id.not.exist", new Object[] { in.getCustId() },
					"Customer id is not exist.");
		}

		// 로그인 검증
		loginComponent.validateLogin(in.getCustPasswd(), customerOut);
		
		// 로그인 결과
		LoginOut result = new LoginOut();

		result.setCustId(customerOut.getCustId());
		result.setCustNm(customerOut.getCustNm());

		return result;
	}
}
