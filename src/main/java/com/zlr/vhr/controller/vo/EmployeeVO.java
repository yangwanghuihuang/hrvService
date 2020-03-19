/**
 * 
 */
package com.zlr.vhr.controller.vo;

import java.util.List;

import com.zlr.vhr.dao.bo.Employee;

/** 
* @ClassName: EmployeeVO <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月13日 下午12:38:26 <br> 
*   <br>
*/
public class EmployeeVO extends Employee{
	private static final long serialVersionUID = 1L;

	/**
	 * 请求查询的页码
	 */
	private Integer pageNum = 1;

	/**
	 * 每页显示条数
	 */
	private Integer pageSize = 10;

	private List<Employee> employees;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	
	

}
