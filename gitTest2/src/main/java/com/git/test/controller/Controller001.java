package com.git.test.controller;

import bxm.common.annotaion.BxmCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller001
 *
 * @author sysadmin
 */
@RestController
@RequestMapping("/")
@BxmCategory(logicalName="Controller001", description="Controller001")
public class Controller001 {
	private Logger logger= LoggerFactory.getLogger(getClass());
	private int i2;
}
