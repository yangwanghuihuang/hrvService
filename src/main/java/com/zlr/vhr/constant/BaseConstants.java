/**
 * 
 */
package com.zlr.vhr.constant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**   
* @Title: BaseConstants.java 
* @Package com.zlr.vhr.constant 
* @Description: 常量类
* @author A18ccms A18ccms_gmail_com   
* @date 2020年3月16日 上午9:45:38 
* @version V1.0   
*/
/** 
* @ClassName: BaseConstants <br>
* @Description: TODO <br>
* @author A18ccms a18ccms_gmail_com  <br>
* @date 2020年3月16日 上午9:45:38 <br> 
*   <br>
*/
public final class BaseConstants {
	private BaseConstants() {

	}
	
	
	public static final class BaseConfig {
		private BaseConfig() {
		}
	}
	
	
    public enum graduate {
    	GAOZHONG(1,"汉族"),
		BENKE(2,"蒙古族"),
		YANJIUSHENG(3,"回族");
    	
    	graduate(int code, String val){
            this.code = code;
            this.val = val;
        }
        private int code;
        private String val;

        public int getCode() {
            return this.code;
        }

        public String getValue(){
            return this.val;
        }

        @Override
        public String toString() {
            return this.val;
        }

        public static List<Map<String, Object>> list() {
            return Arrays.stream(graduate.values()).map(e -> {
                Map<String, Object> map = new HashMap(1);
                map.put("key", e.getCode());
                map.put("value", e.getValue());
                return map;
            }).collect(Collectors.toList());
        }

        public static graduate valueOf(int code) {
            for (graduate value : graduate.values()) {
                if (value.code == code) {
                    return value;
                }
            }
            throw new IllegalArgumentException("没有这个Code");
        }
        
        public static graduate codeOf(String val) {
            for (graduate code : graduate.values()) {
                if (code.val.equals(val)) {
                    return code;
                }
            }
            throw new IllegalArgumentException("没有这个Val");
        }
    }
    
	public static void main(String[] args) {
		  String value = graduate.valueOf(1).getValue();
		  int code = graduate.codeOf("蒙古族").getCode();
		  System.out.println(value);
		  System.out.println(code);
	}
}
