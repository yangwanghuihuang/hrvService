/**
 * 
 */
package com.zlr.vhr.controller.respVO;

import com.zlr.vhr.dao.bo.Employee;
/** 
* @ClassName: EmployeeVo <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月15日 下午8:16:10 <br> 
*   <br>
*/
public class EmployeeVo extends Employee{
   private String nationDesc;
   private String begindateDesc;
   private String conversiontimeDesc;
   private String birthdayDesc;
   private String workageDesc;


public String getWorkageDesc() {
	return workageDesc;
}

public void setWorkageDesc(String workageDesc) {
	this.workageDesc = workageDesc;
}

public String getBegindateDesc() {
	return begindateDesc;
}

public void setBegindateDesc(String begindateDesc) {
	this.begindateDesc = begindateDesc;
}

public String getConversiontimeDesc() {
	return conversiontimeDesc;
}

public void setConversiontimeDesc(String conversiontimeDesc) {
	this.conversiontimeDesc = conversiontimeDesc;
}

public String getBirthdayDesc() {
	return birthdayDesc;
}

public void setBirthdayDesc(String birthdayDesc) {
	this.birthdayDesc = birthdayDesc;
}

public String getNationDesc() {
	return nationDesc;
}

public void setNationDesc(String nationDesc) {
	this.nationDesc = nationDesc;
}
   
}
