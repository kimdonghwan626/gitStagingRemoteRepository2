/**
 * Generated 2022. 08. 17. 01:30:17
 */
package com.git.test;

import bxm.common.annotaion.BxmCategory;
import bxmc.annotation.dbio.BxmDataAccess;

/**
 * Dbio001
 *
 * @author sysadmin
 */
@SuppressWarnings({ "all" })
@BxmDataAccess(datasource = "main-ds")
@BxmCategory(logicalName="Dbio001", description="Dbio001", author="sysadmin")
public interface Dbio001
{
	/**
	 * 
	 */
	@BxmCategory(logicalName="", description="", author="sysadmin")
	String selectId();
}
