/**
 * 
 */
package com.zlr.vhr.common;

import java.io.Serializable;

/**   
* @Title: BaseResponse.java 
* @Package com.zlr.vhr.service.interfaces 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2020年3月12日 下午4:21:43 
* @version V1.0   
*/
/** 
* @ClassName: BaseResponse <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月12日 下午4:21:43 <br> 
*   <br>
*/
public class BaseResponse<T> implements Serializable {
	 private static final long serialVersionUID = 1L;
	    /**
	     * 是否业务成功
	     */
	    private boolean success;

	    /**
	     * 是否成功代码："000000":成功，其他失败
	     */
	    private String resultCode;

	    /**
	     * 是否成功代码对应的信息
	     */
	    private String resultMessage;
	    
	    /**
	     * 用于异常时，存放堆栈信息
	     */
	    private Object info="";
	    
	    /**
	     * 业务数据
	     */
	    private T result=null;

		public boolean isSuccess() {
			return success;
		}

		public void setSuccess(boolean success) {
			this.success = success;
		}

		public String getResultCode() {
			return resultCode;
		}

		public void setResultCode(String resultCode) {
			this.resultCode = resultCode;
		}

		public String getResultMessage() {
			return resultMessage;
		}

		public void setResultMessage(String resultMessage) {
			this.resultMessage = resultMessage;
		}

		public Object getInfo() {
			return info;
		}

		public void setInfo(Object info) {
			this.info = info;
		}

		public T getResult() {
			return result;
		}

		public void setResult(T result) {
			this.result = result;
		}
	    
	    
}
