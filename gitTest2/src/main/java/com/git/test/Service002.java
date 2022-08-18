package com.git.test;

import bxm.common.annotaion.BxmCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Service001
 *
 * @author sysadmin
 */
@Service
@BxmCategory(logicalName="Service001", description="Service001")
public class Service002 {
	private Logger logger= LoggerFactory.getLogger(getClass());
	
	
}
