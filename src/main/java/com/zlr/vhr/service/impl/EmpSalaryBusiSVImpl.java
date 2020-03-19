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
import com.zlr.vhr.controller.respVO.EmployeeSalaryVO;
import com.zlr.vhr.dao.interfaces.EmpSalaryMappers;
import com.zlr.vhr.service.interfaces.IEmpSalaryBusiSV;
import com.zlr.vhr.util.DateUtil;

/**   
* @Title: EmpSalaryBusiSVImpl.java 
* @Package com.zlr.vhr.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2020年3月17日 下午7:47:32 
* @version V1.0   
*/
/** 
* @ClassName: EmpSalaryBusiSVImpl <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月17日 下午7:47:32 <br> 
*   <br>
*/
@Service
public class EmpSalaryBusiSVImpl implements IEmpSalaryBusiSV{

	/** 
	* @Title: querySalary  <br>
	* @Description: TODO <br>
	* @param @return     <br>
	* @throws  <br>
	*/
	@Autowired
	private EmpSalaryMappers mappers;
	@Override
	public BaseResponse<List<EmployeeSalaryVO>> querySalary() {
		BaseResponse<List<EmployeeSalaryVO>> response=new BaseResponse<List<EmployeeSalaryVO>>();
		List<EmployeeSalaryVO> result=mappers.selectAll();
		List<EmployeeSalaryVO> list=new ArrayList<EmployeeSalaryVO>();
		for(EmployeeSalaryVO res:result) {
			EmployeeSalaryVO vo=new EmployeeSalaryVO();
			BeanUtils.copyProperties(res, vo);
			//计算工资
			if(res.getBasicsalary()!=null || res.getPensionbase()!=null) {
				Integer salaryAllInteger=(int) (res.getBasicsalary()+res.getBonus()+res.getTrafficsalary()+res.getLunchsalary()
				-res.getPensionbase()*res.getPensionper()-res.getMedicalbase()*res.getMedicalper()-res.getAccumulationfundbase()*res.getAccumulationfundper());
				vo.setAllsalary(salaryAllInteger);
			}
			
			String createDateDesc;
			try {
				if(res.getCreatedate()!=null) {
					createDateDesc = DateUtil.getDateFormat(res.getCreatedate());
					vo.setCreateDateDesc(createDateDesc);
				}	
			} catch (ParseException e) {
				e.printStackTrace();
			}
			list.add(vo);
			
		}
		
		response.setResult(list);
		return response;
	}

}
