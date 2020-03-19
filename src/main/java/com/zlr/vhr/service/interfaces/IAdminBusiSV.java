/**
 * 
 */
package com.zlr.vhr.service.interfaces;

import com.zlr.vhr.common.BaseResponse;
import com.zlr.vhr.common.BusinessException;
import com.zlr.vhr.controller.vo.AdminVO;
import com.zlr.vhr.dao.bo.Admin;

/** 
* @ClassName: IAdminBusiSV <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月12日 下午4:17:30 <br> 
*   <br>
*/

public interface IAdminBusiSV {
	Integer add(AdminVO req);

	/** 
	* @Title: login  <br>
	* @Description: TODO <br>
	* @param @param request
	* @param @return   <br>
	* @return Integer  <br>  
	 * @throws BusinessException 
	* @throws  <br>
	*/
	BaseResponse<Admin> login(AdminVO request);

}
