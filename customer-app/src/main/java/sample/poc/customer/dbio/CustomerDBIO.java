/**
 * Generated 2021. 12. 06. 15:58:03
 */
package sample.poc.customer.dbio;

import bxm.common.annotaion.BxmCategory;
import bxmc.annotation.dbio.BxmDataAccess;
import bxmc.annotation.dbio.TestValue;
import bxmc.annotation.dbio.TestValues;
import org.apache.ibatis.annotations.Param;
import sample.poc.customer.domain.CustomerOut;

/**
 * 고객 관리 DBIO
 *
 * @author sysadmin
 */
@SuppressWarnings({ "all" })
@BxmDataAccess(datasource = "main-ds")
@BxmCategory(logicalName="고객 관리 DBIO", description="고객 관리 DBIO", author="sysadmin")
public interface CustomerDBIO
{
	/**
	 * 고객 정보 조회
	 */
	@TestValues({
		@TestValue(values="custId=1000")
	})
	@BxmCategory(logicalName="고객 정보 조회", description="", author="sysadmin")
	CustomerOut selectCustomer(
		@Param("custId")String custId
		);
}
