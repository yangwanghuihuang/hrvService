/**
 * 
 */
package com.zlr.vhr.service.impl;

import java.io.Console;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zlr.vhr.common.BaseResponse;
import com.zlr.vhr.constant.BaseConstants;
import com.zlr.vhr.controller.respVO.EmployeeVo;
import com.zlr.vhr.controller.vo.EmployeeVO;
import com.zlr.vhr.dao.bo.Department;
import com.zlr.vhr.dao.bo.Employee;
import com.zlr.vhr.dao.bo.EmployeeExample;
import com.zlr.vhr.dao.bo.EmployeeExample.Criteria;
import com.zlr.vhr.dao.bo.Position;
import com.zlr.vhr.dao.interfaces.DepartmentMappers;
import com.zlr.vhr.dao.interfaces.EmployeeMapper;
import com.zlr.vhr.dao.interfaces.EmployeeMappers;
import com.zlr.vhr.dao.interfaces.PositionMappers;
import com.zlr.vhr.service.interfaces.IEmployeeBusiSV;
import com.zlr.vhr.util.DateUtil;
import com.zlr.vhr.util.PageResult;
import com.zlr.vhr.util.workAgeUtil;


/** 
* @ClassName: EmployeeBusiSVImpl <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月13日
*/
@Service
public class EmployeeBusiSVImpl implements IEmployeeBusiSV{

	/** 
	* @Title: queryEmployee  <br>
	* @Description: TODO <br>
	* @param @param req
	* @param @return     <br>
	* @throws  <br>
	*/
	@Autowired
	private EmployeeMapper mapper;
	@Autowired
	private EmployeeMappers mappers;
	@Autowired
	private DepartmentMappers deptMapper;
	@Autowired
	private PositionMappers posMappers;
	@Override
	public BaseResponse<PageResult<Employee>> queryEmployee(EmployeeVO record) {
		BaseResponse<PageResult<Employee>> response=new BaseResponse<PageResult<Employee>>();
		PageResult<Employee> pageResult = new PageResult<>();
		List<Employee> list = new ArrayList<>();
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		PageHelper.startPage(record.getPageNum(), record.getPageSize());
		try {
//			if (null != record.getAddress()) {
//				criteria.andAddressEqualTo(record.getAddress());
//			}
			if (null != record.getId()) {
				criteria.andIdEqualTo(record.getId());
			}
			if (null != record.getName()) {
				criteria.andNameEqualTo(record.getName());
			}
			
			

			list = mapper.selectByExample(example);
		} finally {
		
		}
		pageResult.setResult(list);
		pageResult.setSuccess(true);
		pageResult.setPageNum(record.getPageNum());
		pageResult.setPageSize(record.getPageSize());
		pageResult.setCount(((Page<Employee>) list).getTotal());
		
		response.setResult(pageResult);
	    return response;
	}
	/** 
	* @Title: queryEmployee  <br>
	* @Description: TODO <br>
	* @param @return     <br>
	* @throws  <br>
	*/
	@Override
	public BaseResponse<List<EmployeeVo>> queryEmployee() {
		BaseResponse<List<EmployeeVo>> response=new BaseResponse<List<EmployeeVo>>();
		List<Employee> result=mappers.selectAll();
		List<EmployeeVo> vos = new ArrayList<EmployeeVo>();
		for(Employee res:result) {
			EmployeeVo vo= new EmployeeVo();
			BeanUtils.copyProperties(res, vo);
			 if(res.getNationid()!=0) {
		    	   String value = BaseConstants.graduate.valueOf(res.getNationid()).getValue();
					vo.setNationDesc(value);
				}
			 String beginDateDesc = null;
			 String conversionTimeDesc;
			 String birthdayDesc;
			try {
				if(res.getBegindate() != null) {
					beginDateDesc = DateUtil.getDateFormat(res.getBegindate());
					
					vo.setBegindateDesc(beginDateDesc); 
				}
				if(res.getConversiontime()!=null) {
					conversionTimeDesc = DateUtil.getDateFormat(res.getConversiontime());
					vo.setConversiontimeDesc(conversionTimeDesc);
				}
				if(res.getBirthday()!=null) {
					birthdayDesc = DateUtil.getDateFormat(res.getBirthday());
					vo.setBirthdayDesc(birthdayDesc);
				}
				if(res.getWorkage()!=null) {
					vo.setWorkageDesc(workAgeUtil.getWorkAge(beginDateDesc.substring(0, 7)));
				}
				
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		
			vos.add(vo);
		}
		
		response.setResult(vos);
		
		return response;
	}
	/** 
	* @Title: queryEmployeeById  <br>
	* @Description: TODO <br>
	* @param @param request
	* @param @return     <br>
	* @throws  <br>
	*/
	@Override
	public BaseResponse<EmployeeVo> queryEmployeeById(Employee request) {
		BaseResponse<EmployeeVo> response=new BaseResponse<EmployeeVo>();
        Employee emp=mapper.selectByPrimaryKey(request.getId());
       EmployeeVo vo= new EmployeeVo();
       BeanUtils.copyProperties(emp, vo);
       if(emp.getNationid()!=0) {
    	   String value = BaseConstants.graduate.valueOf(emp.getNationid()).getValue();
			vo.setNationDesc(value);
		}
       response.setResult(vo);
		return response;
	}
	/** 
	* @Title: deleteEmployeeById  <br>
	* @Description: TODO <br>
	* @param @param request
	* @param @return     <br>
	* @throws  <br>
	*/
	@Override
	public BaseResponse<Integer> deleteEmployeeById(Employee request) {
		BaseResponse<Integer> response=new BaseResponse<Integer>();
		int result=mapper.deleteByPrimaryKey(request.getId());
		response.setResult(result);
		return response;
	}
	/** 
	* @Title: addEmployee  <br>
	* @Description: TODO <br>
	* @param @param request
	* @param @return     <br>
	* @throws  <br>
	*/
	@Override
	public BaseResponse<Integer> addEmployee(Employee request) {
		BaseResponse<Integer> response=new BaseResponse<Integer>();
		if(!StringUtils.isEmpty(request.getNationDesc())) {
			request.setNationid(BaseConstants.graduate.codeOf(request.getNationDesc()).getCode());
		}else {
			request.setNationid(1);
		}
		
		int result=mapper.insert(request);
		response.setResult(result);
		return response;
	}
	/** 
	* @Title: queryEmployeeAll  <br>
	* @Description: TODO <br>
	* @param @return     <br>
	* @throws  <br>
	*/
	@Override
	public BaseResponse<List<Employee>> queryEmployeeAll() {
		BaseResponse<List<Employee>> response=new BaseResponse<List<Employee>>();
		List<Employee> result= mappers.selectAll();
		response.setResult(result);
		return response;
	}
	/** 
	* @Title: queryEmployeeByName  <br>
	* @Description: TODO <br>
	* @param @param request
	* @param @return     <br>
	* @throws  <br>
	*/
	@Override
	public BaseResponse<List<EmployeeVo>> queryEmployeeByName(EmployeeVO request) {
		BaseResponse<List<EmployeeVo>> response=new BaseResponse<List<EmployeeVo>>();
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		if (null != request.getName()) {
			criteria.andNameEqualTo(request.getName());
		}
		List<Employee> result = mapper.selectByExample(example);
		List<EmployeeVo> vos = new ArrayList<EmployeeVo>();
		for(Employee res:result) {
			EmployeeVo vo= new EmployeeVo();
			BeanUtils.copyProperties(res, vo);
			 if(res.getNationid()!=0) {
		    	   String value = BaseConstants.graduate.valueOf(res.getNationid()).getValue();
					vo.setNationDesc(value);
				}
			 String beginDateDesc=null;
			 String conversionTimeDesc;
			 String birthdayDesc;
			try {
				if(res.getBegindate() != null) {
					beginDateDesc = DateUtil.getDateFormat(res.getBegindate());
					vo.setBegindateDesc(beginDateDesc); 
				}
				if(res.getConversiontime()!=null) {
					conversionTimeDesc = DateUtil.getDateFormat(res.getConversiontime());
					vo.setConversiontimeDesc(conversionTimeDesc);
				}
				if(res.getBirthday()!=null) {
					birthdayDesc = DateUtil.getDateFormat(res.getBirthday());
					vo.setBirthdayDesc(birthdayDesc);
				}
				if(res.getWorkage()!=null) {
					vo.setWorkageDesc(workAgeUtil.getWorkAge(beginDateDesc.substring(0, 7)));
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			vos.add(vo);
		}
		response.setResult(vos);
		return response;
	}
	/** 
	* @Title: updateEmployee  <br>
	* @Description: TODO <br>
	* @param @param request
	* @param @return     <br>
	* @throws  <br>
	*/
	@Override
	public BaseResponse<Integer> updateEmployee(Employee request) {
		BaseResponse<Integer> response=new BaseResponse<Integer>();
		if(!StringUtils.isEmpty(request.getNationDesc())) {
			request.setNationid(BaseConstants.graduate.codeOf(request.getNationDesc()).getCode());
		}else {
			request.setNationid(1);
		}
		int result=mapper.updateByPrimaryKey(request);
		response.setResult(result);
		return response;
	}
	/** 
	* @Title: getDepartments  <br>
	* @Description: TODO <br>
	* @param @return     <br>
	* @throws  <br>
	*/
	@Override
	public BaseResponse<List<Department>> getDepartments() {
		BaseResponse<List<Department>> response=new BaseResponse<List<Department>>();
		List<Department> result = deptMapper.selectAll();
		response.setResult(result);
		return response;
	}
	/** 
	* @Title: getPostName  <br>
	* @Description: TODO <br>
	* @param @param integer
	* @param @return     <br>
	* @throws  <br>
	*/
	@Override
	public BaseResponse<List<Position>> getPostName(Integer integer) {
		BaseResponse<List<Position>> response=new BaseResponse<List<Position>>();
		List<Position> result= posMappers.selectPosById(integer);
		response.setResult(result);
		return response;
	}
	
	
}
