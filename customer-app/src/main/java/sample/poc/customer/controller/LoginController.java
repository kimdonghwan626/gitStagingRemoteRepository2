package sample.poc.customer.controller;

import bxm.common.annotaion.BxmCategory;
import sample.poc.customer.domain.CustomerIn;
import sample.poc.customer.domain.CustomerOut;
import sample.poc.customer.domain.LoginIn;
import sample.poc.customer.domain.LoginOut;
import sample.poc.customer.service.LoginService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 로그인 컨트롤러
 *
 * @author sysadmin
 */
@RestController
@RequestMapping("/")
@BxmCategory(logicalName = "로그인 컨트롤러", description = "로그인 컨트롤러")
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private LoginService customerService;

	@PostMapping("/login")
	@BxmCategory(description = "로그인")
	public LoginOut login(@RequestBody LoginIn in) {
		logger.debug("로그인 start : {}", in);

		LoginOut result = customerService.login(in);

		logger.debug("로그인 end : {}", result);
		return result;
	}
}
