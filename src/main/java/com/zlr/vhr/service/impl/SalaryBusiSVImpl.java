/**
 * 
 */
package com.zlr.vhr.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlr.vhr.common.BaseResponse;
import com.zlr.vhr.controller.respVO.EmployeeVo;
import com.zlr.vhr.controller.respVO.SalaryVO;
import com.zlr.vhr.dao.bo.Salary;
import com.zlr.vhr.dao.interfaces.SalaryMapper;
import com.zlr.vhr.dao.interfaces.SalaryMappers;
import com.zlr.vhr.service.interfaces.ISalaryBusiSV;
import com.zlr.vhr.util.DateUtil;

/**   
* @Title: SalaryBusiSVImpl.java 
* @Package com.zlr.vhr.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2020年3月17日 上午10:06:10 
* @version V1.0   
*/
/** 
* @ClassName: SalaryBusiSVImpl <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月17日 上午10:06:10 <br> 
*   <br>
*/
@Service
public class SalaryBusiSVImpl implements ISalaryBusiSV{
    
	@Autowired
	private SalaryMappers mappers;
	@Autowired
	private SalaryMapper mapper;
	
	/** 
	* @Title: querySalary  <br>
	* @Description: TODO <br>
	* @param @return     <br>
	* @throws  <br>
	*/
	@Override
	public BaseResponse<List<SalaryVO>> querySalary() {
		BaseResponse<List<SalaryVO>> response=new BaseResponse<List<SalaryVO>>();
		List<Salary> result=mappers.selectAll();
		List<SalaryVO> vos = new ArrayList<SalaryVO>();
		for(Salary res:result) {
			SalaryVO vo = new SalaryVO();
			BeanUtils.copyProperties(res, vo);
			 String createDateDesc;
			if(res.getCreatedate()!=null) {
				try {
					createDateDesc= DateUtil.getDateFormat(res.getCreatedate());
					vo.setCreateDateDesc(createDateDesc);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			vos.add(vo);
		}
		
		response.setResult(vos);
		return response;
	}

	/** 
	* @Title: querySalaryById  <br>
	* @Description: TODO <br>
	* @param @param req
	* @param @return     <br>
	* @throws  <br>
	*/
	@Override
	public BaseResponse<SalaryVO> querySalaryById(Salary req) {
		BaseResponse<SalaryVO> response=new BaseResponse<SalaryVO>();
		SalaryVO vo = new SalaryVO();
		Salary result=mapper.selectByPrimaryKey(req.getId());
		BeanUtils.copyProperties(result, vo);
		 String createDateDesc;
			if(result.getCreatedate()!=null) {
				try {
					createDateDesc= DateUtil.getDateFormat(result.getCreatedate());
					vo.setCreateDateDesc(createDateDesc);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		response.setResult(vo);
		return response;
	}

	/** 
	* @Title: addSalary  <br>
	* @Description: TODO <br>
	* @param @param request
	* @param @return   <br>
	* @return BaseResponse<Integer>  <br>  
	* @throws  <br>
	*/
	public BaseResponse<Integer> addSalary(Salary request) {
		BaseResponse<Integer> response=new BaseResponse<Integer>();
		if(request.getCreatedate()!=null) {
			System.out.println(request.getCreatedate());
//			request.setCreatedate(createdate);
		}
		int result=mapper.insert(request);
		response.setResult(result);
		return response;
	}

	/** 
	* @Title: updateSalary  <br>
	* @Description: TODO <br>
	* @param @param request
	* @param @return     <br>
	* @throws  <br>
	*/
	@Override
	public BaseResponse<Integer> updateSalary(Salary request) {
		BaseResponse<Integer> response=new BaseResponse<Integer>();
       Integer result= mapper.updateByPrimaryKey(request);
       response.setResult(result);
		return response;
	}

	/** 
	* @Title: deleteSalary  <br>
	* @Description: TODO <br>
	* @param @param request
	* @param @return     <br>
	* @throws  <br>
	*/
	@Override
	public BaseResponse<Integer> deleteSalary(Salary request) {
		BaseResponse<Integer> response=new BaseResponse<Integer>();
	       Integer result= mapper.deleteByPrimaryKey(request.getId());
	       response.setResult(result);
		   return response;
	}

	
	

	

}
