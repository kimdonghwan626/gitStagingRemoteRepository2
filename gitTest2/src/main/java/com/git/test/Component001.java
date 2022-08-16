package com.git.test;

import bxm.common.annotaion.BxmCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Component001
 *
 * @author sysadmin
 */
@Component
@BxmCategory(logicalName="Component001", description="Component001")
public class Component001 {
	private Logger logger= LoggerFactory.getLogger(getClass());
	
}
