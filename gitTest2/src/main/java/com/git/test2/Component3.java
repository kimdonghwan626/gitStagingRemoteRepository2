package com.git.test2;

import bxm.common.annotaion.BxmCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Component1
 *
 * @author sysadmin
 */
@Component
@BxmCategory(logicalName="Component1", description="Component1")
public class Component3 {
	private Logger logger= LoggerFactory.getLogger(getClass());
	int i;
}
