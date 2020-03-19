/**
 * 
 */
package com.zlr.vhr.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zlr.vhr.common.BaseResponse;
import com.zlr.vhr.controller.respVO.SalaryVO;
import com.zlr.vhr.dao.bo.Salary;
import com.zlr.vhr.service.impl.SalaryBusiSVImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/** 
* @ClassName: SalaryCompanyController <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月17日 上午10:00:04 <br> 
*   <br>
*/
@Api(tags = "部门账套信息")
@RequestMapping("/api/salary")
@RestController
public class SalaryCompanyController {
	private static final Logger logger = LoggerFactory.getLogger(SalaryCompanyController.class);
	
	@Autowired
	private SalaryBusiSVImpl sv;
	
	@ApiOperation(value = "查询所有账套信息", httpMethod = "POST", consumes = "application/json")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@RequestMapping(value = "/v1.0/salaryDept")
	public BaseResponse<List<SalaryVO>> salaryDept() {
		BaseResponse<List<SalaryVO>>  response=new BaseResponse<List<SalaryVO>>() ;
		response = sv.querySalary();
		return response;
	}
	@ApiOperation(value = "按id查询单个账套信息", httpMethod = "POST", consumes = "application/json")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@RequestMapping(value = "/v1.0/salaryById")
	public BaseResponse<SalaryVO> salaryById(@RequestBody Salary request) {
		BaseResponse<SalaryVO>  response=new BaseResponse<SalaryVO>() ;
		response = sv.querySalaryById(request);
		return response;
	}
	@ApiOperation(value = "添加单个账套信息", httpMethod = "POST", consumes = "application/json")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@RequestMapping(value = "/v1.0/addSalary")
	public BaseResponse<Integer> addSalary(@RequestBody Salary request) {
		BaseResponse<Integer>  response=new BaseResponse<Integer>() ;
		response = sv.addSalary(request);
		return response;
	}
	@ApiOperation(value = "通过id修改单个账套信息", httpMethod = "POST", consumes = "application/json")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@RequestMapping(value = "/v1.0/updateSalary")
	public BaseResponse<Integer> updateSalary(@RequestBody Salary request) {
		BaseResponse<Integer>  response=new BaseResponse<Integer>() ;
		response = sv.updateSalary(request);
		return response;
	}
	@ApiOperation(value = "通过id删除单个账套信息", httpMethod = "POST", consumes = "application/json")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@RequestMapping(value = "/v1.0/deleteSalaryById")
	public BaseResponse<Integer> deleteSalary(@RequestBody Salary request) {
		BaseResponse<Integer>  response=new BaseResponse<Integer>() ;
		response = sv.deleteSalary(request);
		return response;
	}
}
