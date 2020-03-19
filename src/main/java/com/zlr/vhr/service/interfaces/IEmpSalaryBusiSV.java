/**
 * 
 */
package com.zlr.vhr.service.interfaces;

import java.util.List;

import com.zlr.vhr.common.BaseResponse;
import com.zlr.vhr.controller.respVO.EmployeeSalaryVO;

/** 
* @ClassName: IEmpSalaryBusiSV <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月17日 下午7:46:14 <br> 
*   <br>
*/
public interface IEmpSalaryBusiSV {
	public BaseResponse<List<EmployeeSalaryVO>> querySalary();
}
