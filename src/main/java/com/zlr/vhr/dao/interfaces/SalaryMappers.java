/**
 * 
 */
package com.zlr.vhr.dao.interfaces;

import java.util.List;

import com.zlr.vhr.controller.respVO.SalaryVO;
import com.zlr.vhr.dao.bo.Salary;

/**   
* @Title: SalaryMappers.java 
* @Package com.zlr.vhr.dao.interfaces 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2020年3月17日 上午10:15:04 
* @version V1.0   
*/
/** 
* @ClassName: SalaryMappers <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月17日 上午10:15:04 <br> 
*   <br>
*/
public interface SalaryMappers {

	/** 
	* @Title: selectAll  <br>
	* @Description: TODO <br>
	* @param @return   <br>
	* @return List<Salary>  <br>  
	* @throws  <br>
	*/
	List<Salary> selectAll();
    
}
