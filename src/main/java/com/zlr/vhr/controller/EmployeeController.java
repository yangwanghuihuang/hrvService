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
import com.zlr.vhr.controller.respVO.EmployeeVo;
import com.zlr.vhr.controller.vo.EmployeeVO;
import com.zlr.vhr.dao.bo.Department;
import com.zlr.vhr.dao.bo.Employee;
import com.zlr.vhr.dao.bo.Position;
import com.zlr.vhr.service.interfaces.IEmployeeBusiSV;
import com.zlr.vhr.util.PageResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/** 
* @ClassName: EmployeeController <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月13日 下午12:23:09 <br> 
*   <br>
*/

@Api(tags = "员工信息")
@RequestMapping("/api/employee")
@RestController
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private IEmployeeBusiSV sv;

	@ApiOperation(value = "查询所有员工信息", httpMethod = "POST", consumes = "application/json")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@RequestMapping(value = "/v1.0/allEmployee0")
	public BaseResponse<List<EmployeeVo>> allEmployeez() {
		BaseResponse<List<EmployeeVo>>  response=new BaseResponse<List<EmployeeVo>>() ;
		response = sv.queryEmployee();
		return response;
	}
	@ApiOperation(value = "查询所有员工信息", httpMethod = "POST", consumes = "application/json")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@RequestMapping(value = "/v1.0/allEmployee")
	public BaseResponse<List<Employee>> allEmployee() {
		BaseResponse<List<Employee>>  response=new BaseResponse<List<Employee>>() ;
		response = sv.queryEmployeeAll();
		return response;
	}
//	@ApiOperation(value = "按条件分页查询员工信息", httpMethod = "POST", consumes = "application/json")
//	@ApiResponse(code = 200, message = "success", response = String.class)
//	@RequestMapping(value = "/v1.0/employee")
//	public BaseResponse<PageResult<Employee>> employee(@RequestBody EmployeeVO request) {
//		BaseResponse<PageResult<Employee>>  response=new BaseResponse<PageResult<Employee>>() ;
//		response = sv.queryEmployee(request);
//		return response;
//	}
	@ApiOperation(value = "按通过名字查询员工信息", httpMethod = "POST", consumes = "application/json")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@RequestMapping(value = "/v1.0/employee")
	public BaseResponse<List<EmployeeVo>> employee(@RequestBody EmployeeVO request) {
		BaseResponse<List<EmployeeVo>>  response=new BaseResponse<List<EmployeeVo>>() ;
		response = sv.queryEmployeeByName(request);
		return response;
	}
	@ApiOperation(value = "按条件id查询单个员工信息", httpMethod = "POST", consumes = "application/json")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@RequestMapping(value = "/v1.0/employeeById")
	public BaseResponse<EmployeeVo> employeeById(@RequestBody Employee request) {
		BaseResponse<EmployeeVo>  response=new BaseResponse<EmployeeVo>() ;
		response = sv.queryEmployeeById(request);
		return response;
	}
	@ApiOperation(value = "按条件id删除单个员工信息", httpMethod = "POST", consumes = "application/json")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@RequestMapping(value = "/v1.0/deleteById")
	public BaseResponse<Integer> deleteById(@RequestBody Employee request) {
		BaseResponse<Integer>  response=new BaseResponse<Integer>() ;
		response = sv.deleteEmployeeById(request);
		return response;
	}
	@ApiOperation(value = "添加单个员工信息", httpMethod = "POST", consumes = "application/json")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@RequestMapping(value = "/v1.0/add")
	public BaseResponse<Integer> add(@RequestBody Employee request) {
		BaseResponse<Integer>  response=new BaseResponse<Integer>() ;
		response = sv.addEmployee(request);
		return response;
	}
	@ApiOperation(value = "修改单个员工信息", httpMethod = "POST", consumes = "application/json")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@RequestMapping(value = "/v1.0/update")
	public BaseResponse<Integer> update(@RequestBody Employee request) {
		BaseResponse<Integer>  response=new BaseResponse<Integer>() ;
		response = sv.updateEmployee(request);
		return response;
	}
	@ApiOperation(value = "获取部门信息", httpMethod = "POST", consumes = "application/json")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@RequestMapping(value = "/v1.0/getDepart")
	public BaseResponse<List<Department>> getDepart() {
		BaseResponse<List<Department>>  response=new BaseResponse<List<Department>>() ;
		response = sv.getDepartments();
		return response;
	}
	@ApiOperation(value = "获取部门的岗位信息", httpMethod = "POST", consumes = "application/json")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@RequestMapping(value = "/v1.0/getPost")
	public BaseResponse<List<Position>> getPost(@RequestBody Department request) {
		BaseResponse<List<Position>>  response=new BaseResponse<List<Position>>() ;
		response = sv.getPostName(request.getId());
		return response;
	}
}
