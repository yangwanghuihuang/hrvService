/**
 * 
 */
package com.zlr.vhr.controller.vo;

import java.io.Serializable;

/** 
* @ClassName: AdminVO <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月12日 下午4:08:41 <br> 
*   <br>
*/
public class AdminVO implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	 
	private Long admin_id;
	private String username;
	private String password;
	private String authority;
	public Long getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Long admin_id) {
		this.admin_id = admin_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
