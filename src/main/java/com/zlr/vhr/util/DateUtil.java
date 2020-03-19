/**
 * 
 */
package com.zlr.vhr.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
* @ClassName: DateUtil <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月16日 上午11:43:10 <br> 
*   <br>
*/
public class DateUtil {
	
	public static String getDateFormat(Date date) throws ParseException{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dt = simpleDateFormat.format(date);
		return dt;
		}
		
}
