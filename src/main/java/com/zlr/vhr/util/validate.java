/**
 * 
 */
package com.zlr.vhr.util;

import java.util.Random;

import com.zlr.vhr.common.BaseResponse;

/** 
* @ClassName: validate <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月13日 上午9:20:12 <br> 
*   <br>
*/
public class validate {
	/**
     * 获取6位随机验证码
     * @return
     */
    public static BaseResponse<String> getValidationCode(){
    	BaseResponse<String> response=new BaseResponse<String>();
        String value=String.valueOf((new Random().nextInt(899999) + 100000));
        response.setResult(value);
        response.setResultMessage("000000");
		return response;
    }

}
