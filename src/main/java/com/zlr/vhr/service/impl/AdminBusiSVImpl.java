/**
 * 
 */
package com.zlr.vhr.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlr.vhr.common.BaseResponse;
import com.zlr.vhr.common.BusinessException;
import com.zlr.vhr.controller.vo.AdminVO;
import com.zlr.vhr.dao.bo.Admin;
import com.zlr.vhr.dao.bo.AdminExample;
import com.zlr.vhr.dao.bo.AdminExample.Criteria;
import com.zlr.vhr.dao.interfaces.AdminMapper;
import com.zlr.vhr.service.interfaces.IAdminBusiSV;
import com.zlr.vhr.util.StringUtil;

/**   
* @Title: AdminBusiSVImpl.java 
* @Package com.zlr.vhr.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2020年3月12日 下午4:26:05 
* @version V1.0   
*/
/**
 * @ClassName: AdminBusiSVImpl <br>
 * @Description: TODO <br>
 * @author A18ccms a18ccms_gmail_com <br>
 * @date 2020年3月12日 下午4:26:05 <br>
 *       <br>
 */
@Service
public class AdminBusiSVImpl implements IAdminBusiSV {
	/**
	 * @Title: add <br>
	 * @Description: TODO <br>
	 * @param @param  req
	 * @param @return <br>
	 * @throws <br>
	 */
	@Autowired
	private AdminMapper mapper;

	@Override
	public Integer add(AdminVO req) {
		Admin record = new Admin();
		record.setAdminId(req.getAdmin_id());
		record.setUsername(req.getUsername());
		record.setAuthority(req.getAuthority());
		record.setPassowrd(req.getPassword());
		int result = mapper.insert(record);
		if (req.getUsername().equals(record.getUsername())) {
			result = 1;

		}
		return result;
	}

	/**
	 * @Title: login <br>
	 * @Description: TODO <br>
	 * @param @param  request
	 * @param @return <br>
	 * @throws BusinessException
	 * @throws <br>
	 *                           //
	 */
	@Override
	public BaseResponse<Admin> login(AdminVO request) {
		BaseResponse<Admin> response = new BaseResponse<Admin>();
//		if(request.getAuthority()=="" && request.getUsername() == "") {
//			return response;
//		} 

		if (response == null) {
			throw new BusinessException("你把常量类，也可以考进来。",
					"你在controller捕获异常，返回友好地baseResponse类。或者不管就行了。不管最好了，集合为空，我觉得应该给前台提示下吧只能在controller捕获？");
		}		
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		if (StringUtil.isNotBlank(request.getUsername())) {
			criteria.andUsernameEqualTo(request.getUsername());
		}
		if (StringUtil.isNotBlank(request.getPassword())) {
			criteria.andPassowrdEqualTo(request.getPassword());
		}
		List<Admin> result = mapper.selectByExample(example);
		if (result.size() == 0) {
			response.setResultCode("999999");
			response.setResultMessage("未查询到数据");
		} 
		if(result.size()!=0){
  			response.setResultCode("000000");
			response.setResultMessage("成功");// 或者不填写任何内容
			response.setResult(result.get(0));
			String username = request.getUsername();
			String password = request.getPassword();
			HashMap<String, Object> hs = new HashMap<>();
			hs.put("token", "token" + username + password);
			response.setInfo(hs);
		}
		return response;

	}

}
