/**
 * 
 */
package com.zlr.vhr.controller.respVO;

import com.zlr.vhr.dao.bo.Salary;

/**   
* @Title: EmployeeSalaryVO.java 
* @Package com.zlr.vhr.controller.respVO 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2020年3月17日 下午7:38:44 
* @version V1.0   
*/
/** 
* @ClassName: EmployeeSalaryVO <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月17日 下午7:38:44 <br> 
*   <br>
*/
public class EmployeeSalaryVO extends Salary{
	 private Integer id;

	 private String name;
	 private String phone;
	 private Integer departmentid;
	 private String workid;
	 private String departName;
	 private String createDateDesc;
	 
	public String getCreateDateDesc() {
		return createDateDesc;
	}
	public void setCreateDateDesc(String createDateDesc) {
		this.createDateDesc = createDateDesc;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}
	public String getWorkid() {
		return workid;
	}
	public void setWorkid(String workid) {
		this.workid = workid;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	 

}
