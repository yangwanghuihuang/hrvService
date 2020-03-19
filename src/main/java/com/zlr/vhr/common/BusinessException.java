/**
 * 
 */
package com.zlr.vhr.common;

/**   
* @Title: BusinessException.java 
* @Package com.zlr.vhr.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2020年3月12日 下午4:30:05 
* @version V1.0   
*/
/** 
* @ClassName: BusinessException <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月12日 下午4:30:05 <br> 
*   <br>
*/
public class BusinessException extends RuntimeException {
    private String errorCode;
    private String errorMessage;
    
    
	/**
	 * @param errorCode
	 * @param errorMessage
	 */
	public BusinessException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	/**
	 * @param errorMessage
	 */
	public BusinessException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
    
}
