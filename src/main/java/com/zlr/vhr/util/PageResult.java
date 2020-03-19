/**
 * 
 */
package com.zlr.vhr.util;

import java.io.Serializable;
import java.util.List;

/**   
* @Title: PageResult.java 
* @Package com.zlr.vhr.util 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2020年3月13日 上午11:26:41 
* @version V1.0   
*/
/** 
* @ClassName: PageResult <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
 * @param <T>
* @date 2020年3月13日 上午11:26:41 <br> 
*   <br>
*/
public class PageResult<T> implements Serializable{
	 private static final long serialVersionUID = 1L;
	    /**
	     * 是否业务成功
	     */
	    private boolean success;

	    /**
	     * 请求查询的页码
	     */
	    private int pageNum = 1;

	    /**
	     * 每页显示条数
	     */
	    private int pageSize=10;

	    /**
	     * 结果集
	     */
	    private List<T> result;

	    /**
	     * 总条数
	     */
	    private long count = 0;

	    /**
	     * 总页数
	     */
	    private long pageCount;
	    
	    private long startRowIndex;
	    private long endRowIndex;
		public boolean isSuccess() {
			return success;
		}
		public void setSuccess(boolean success) {
			this.success = success;
		}
		public int getPageNum() {
			return pageNum;
		}
		public void setPageNum(int pageNum) {
			this.pageNum = pageNum;
		}
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		public List<T> getResult() {
			return result;
		}
		public void setResult(List<T> result) {
			this.result = result;
		}
		public long getCount() {
			return count;
		}
		public void setCount(long count) {
			this.count = count;
		}
		public long getPageCount() {
			long quotient = this.getCount() / this.getPageSize();
	    	long remainder = this.getCount() % this.getPageSize();
	        pageCount = quotient;
	        if (remainder > 0) {
	            pageCount += 1;
	        }
	        return pageCount;
		}
		public void setPageCount(long pageCount) {
			this.pageCount = pageCount;
		}
		public long getStartRowIndex() {
			startRowIndex=(this.getPageNum() - 1) * this.getPageSize();
	        return startRowIndex;
		}
		public void setStartRowIndex(long startRowIndex) {
			this.startRowIndex = startRowIndex;
		}
		public long getEndRowIndex() {
			endRowIndex=this.getPageNum() * this.getPageSize();
	        return endRowIndex;
		}
		public void setEndRowIndex(long endRowIndex) {
			this.endRowIndex = endRowIndex;
		}
	    
}
