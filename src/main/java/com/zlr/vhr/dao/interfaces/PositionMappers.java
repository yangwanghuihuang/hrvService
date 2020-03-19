/**
 * 
 */
package com.zlr.vhr.dao.interfaces;

import java.util.List;

import com.zlr.vhr.dao.bo.Department;
import com.zlr.vhr.dao.bo.Position;

/**   
* @Title: PositionMappers.java 
* @Package com.zlr.vhr.dao.interfaces 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2020年3月17日 上午9:39:08 
* @version V1.0   
*/
/** 
* @ClassName: PositionMappers <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月17日 上午9:39:08 <br> 
*   <br>
*/
public interface PositionMappers {
  List<Position> selectPosById(Integer integer);
}
