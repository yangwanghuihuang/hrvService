/**
 * 
 */
package com.zlr.vhr.dao.interfaces;

import java.util.List;

import com.zlr.vhr.dao.bo.Department;

/**   
* @Title: DepartmentMappers.java 
* @Package com.zlr.vhr.dao.interfaces 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2020年3月16日 下午2:25:24 
* @version V1.0   
*/
/** 
* @ClassName: DepartmentMappers <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月16日 下午2:25:24 <br> 
*   <br>
*/
public interface DepartmentMappers {
	 List<Department> selectAll();
}