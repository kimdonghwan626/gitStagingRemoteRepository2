package sample.poc.customer.component;

import bxm.common.annotaion.BxmCategory;
import bxm.das.util.StringUtils;
import bxmc.request.ApplicationException;
import sample.poc.customer.domain.CustomerOut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 로그인 검증
 *
 * @author sysadmin
 */
@Component
@BxmCategory(logicalName="로그인 검증", description = "로그인 검증")
public class LoginComponent {
	private Logger logger= LoggerFactory.getLogger(getClass());
	
	/**
	 * 로그인 검증
	 * @param password 패스워드
	 * @param customerOut 고객정보
	 */
	@BxmCategory(logicalName = "로그인 검증", description = "로그인 검증")
	public void validateLogin(String password, CustomerOut customerOut)	{
		
		if(StringUtils.isEmpty(password)) {
			logger.error("패스워드를 입력하지 않았습니다.");
			throw new ApplicationException("sample.poc.customer.empty.password", "Empty password.");
		}
		
		if (!password.equals(customerOut.getCustPasswd())) {
			logger.error("패스워드가 일치하지 않습니다.");
			throw new ApplicationException("sample.poc.customer.wrong.password", "Wrong password.");
		}
		
	}
}
