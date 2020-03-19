/**
 * 
 */
package com.zlr.vhr.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**   
* @Title: workAgeUtil.java 
* @Package com.zlr.vhr.util 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2020年3月17日 下午5:58:26 
* @version V1.0   
*/
/** 
* @ClassName: workAgeUtil <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月17日 下午5:58:26 <br> 
*   <br>
*/
public class workAgeUtil {
	public static String getWorkAge(String str1) throws ParseException {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date date=new Date();
		String str2=sdf.format(date);
		 Calendar bef = Calendar.getInstance();
	        Calendar aft = Calendar.getInstance();
	        bef.setTime(sdf.parse(str1));
	        aft.setTime(sdf.parse(str2));
	        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
	        int year=0;
	        if(result<12) {
	           year = aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR);
	        }
	        String workage=Math.abs(year)+"年"+Math.abs(result)+"月";
			return workage;
	}
	public static void main(String[] args) throws ParseException {
      
        String str1 = "2012-02";
       
        
       String resultString= getWorkAge(str1);
        System.out.println(resultString);   
    }


}
