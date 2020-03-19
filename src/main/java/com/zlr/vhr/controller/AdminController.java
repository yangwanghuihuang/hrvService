/**
 * 
 */
package com.zlr.vhr.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.Session;
import com.zlr.vhr.common.BaseResponse;
import com.zlr.vhr.controller.vo.AdminVO;
import com.zlr.vhr.dao.bo.Admin;
import com.zlr.vhr.service.interfaces.IAdminBusiSV;
import com.zlr.vhr.util.VerificationCode;
import com.zlr.vhr.util.validate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/** 
* @ClassName: AdminController <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月12日 下午4:03:55 <br> 
*   <br>
*/
@Api(tags = "登录与账号密码")
@RequestMapping("/api/admin")
@CrossOrigin
@RestController
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private IAdminBusiSV sv;
	
	@ApiOperation(value = "新增管理员", httpMethod = "POST", consumes = "application/json")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@RequestMapping(value = "/v1.0/add")
	public Integer add(@RequestBody AdminVO request) {
		Integer response=sv.add(request);
		return response;
	}
	@ApiOperation(value = "获取验证码", httpMethod = "POST", consumes = "application/json")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@RequestMapping(value = "/v1.0/getValidate")
	public void getValidate(HttpSession session,HttpServletResponse resp) throws IOException {
		//获取验证码
		VerificationCode code=new VerificationCode();
		BufferedImage image=code.getImage();
		String text=code.getText();
		session.setAttribute("verift_code", text);
		VerificationCode.output(image, resp.getOutputStream());
	}
	@ApiOperation(value = "账号密码验证码登录", httpMethod = "POST", consumes = "application/json")
	@ApiResponse(code = 200, message = "success", response = String.class)
	@RequestMapping(value = "/v1.0/goLogin")
	public BaseResponse<Admin> goLogin(@RequestBody AdminVO request,HttpSession session) {
		//获取session验证码
		String text=(String) session.getAttribute("verift_code");
		System.out.println(text);
		
		BaseResponse<Admin> response=sv.login(request);
		
		return response;
	}

}
