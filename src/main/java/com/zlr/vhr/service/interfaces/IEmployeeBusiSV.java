/**
 * 
 */
package com.zlr.vhr.service.interfaces;
/**   
* @Title: IEmployeeBusiSV.java 
* @Package com.zlr.vhr.service.interfaces 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2020年3月13日 下午12:25:18 
* @version V1.0   
*/
/** 
* @ClassName: IEmployeeBusiSV <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月13日 下午12:25:18 <br> 
*   <br>
*/

import java.util.List;

import com.zlr.vhr.common.BaseResponse;
import com.zlr.vhr.controller.respVO.EmployeeVo;
import com.zlr.vhr.controller.vo.EmployeeVO;
import com.zlr.vhr.dao.bo.Department;
import com.zlr.vhr.dao.bo.Employee;
import com.zlr.vhr.dao.bo.Position;
import com.zlr.vhr.util.PageResult;

public interface IEmployeeBusiSV {
	BaseResponse<PageResult<Employee>> queryEmployee(EmployeeVO req);
	
	BaseResponse<List<EmployeeVo>> queryEmployee();

	BaseResponse<EmployeeVo> queryEmployeeById(Employee request);

	BaseResponse<Integer> deleteEmployeeById(Employee request);

	BaseResponse<Integer> addEmployee(Employee request);

	BaseResponse<List<Employee>> queryEmployeeAll();

	BaseResponse<List<EmployeeVo>> queryEmployeeByName(EmployeeVO request);

	BaseResponse<Integer> updateEmployee(Employee request);

	BaseResponse<List<Department>> getDepartments();

	/** 
	* @param integer 
	 * @Title: getPostName  <br>
	* @Description: TODO <br>
	* @param @return   <br>
	* @return BaseResponse<List<Position>>  <br>  
	* @throws  <br>
	*/
	BaseResponse<List<Position>> getPostName(Integer integer);


}
