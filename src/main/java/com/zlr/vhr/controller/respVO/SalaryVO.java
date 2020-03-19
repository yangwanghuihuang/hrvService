/**
 * 
 */
package com.zlr.vhr.controller.respVO;

import com.zlr.vhr.dao.bo.Salary;

/**   
* @Title: SalaryVO.java 
* @Package com.zlr.vhr.controller.respVO 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2020年3月17日 上午11:47:59 
* @version V1.0   
*/
/** 
* @ClassName: SalaryVO <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月17日 上午11:47:59 <br> 
*   <br>
*/
public class SalaryVO extends Salary{
	private String createDateDesc;

	public String getCreateDateDesc() {
		return createDateDesc;
	}

	public void setCreateDateDesc(String createDateDesc) {
		this.createDateDesc = createDateDesc;
	}
	

}
