/**
 * 
 */
package com.zlr.vhr.service.interfaces;

import java.util.List;

import com.zlr.vhr.common.BaseResponse;
import com.zlr.vhr.controller.respVO.SalaryVO;
import com.zlr.vhr.dao.bo.Salary;

/** 
* @ClassName: ISalaryBusiSV <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月17日 上午10:04:53 <br> 
*   <br>
*/
public interface ISalaryBusiSV {
	public BaseResponse<List<SalaryVO>> querySalary();
	public BaseResponse<SalaryVO> querySalaryById(Salary req);
	public BaseResponse<Integer> updateSalary(Salary request);
	public BaseResponse<Integer> deleteSalary(Salary request);
}
