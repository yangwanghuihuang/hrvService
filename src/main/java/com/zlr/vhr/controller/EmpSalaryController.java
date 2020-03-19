/**
 * 
 */
package com.zlr.vhr.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zlr.vhr.common.BaseResponse;
import com.zlr.vhr.controller.respVO.EmployeeSalaryVO;
import com.zlr.vhr.service.impl.EmpSalaryBusiSVImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/** 
* @ClassName: EmpSalaryController <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月17日 下午7:43:41 <br> 
*   <br>
*/
@Api(tags = "员工账套信息")
@RequestMapping("/api/empsalary")
@RestController
public class EmpSalaryController {
	private static final Logger logger = LoggerFactory.getLogger(EmpSalaryController.class);
	
	@Autowired
	private EmpSalaryBusiSVImpl sv;
	
	@ApiOperation(value = "查询所有员工账套信息", httpMethod = "POST", consumes = "application/json")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@RequestMapping(value = "/v1.0/salaryDept")
	public BaseResponse<List<EmployeeSalaryVO>> salaryDept() {
		BaseResponse<List<EmployeeSalaryVO>>  response=new BaseResponse<List<EmployeeSalaryVO>>() ;
		response = sv.querySalary();
		return response;
	}
}
