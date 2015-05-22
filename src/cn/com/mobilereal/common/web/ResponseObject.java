package cn.com.mobilereal.common.web;


import java.io.Serializable;
import java.util.Map;








import cn.com.mobilereal.common.util.JSonUtil;
import cn.com.mobilereal.common.util.StringUtil;

@SuppressWarnings("serial")
public class ResponseObject implements Serializable{
	// 0:成功 有data数据，1,2,3..没有data数据，只有Msg
	private int status;
	// 用于客户端调试
	@SuppressWarnings("rawtypes")
	private Map debug;
	private Object data;
	private String msg;

	static final String statustemplate = "%s";
	static final String strtemplate = "%d:%s";
	static final String msgtemplate = "{\"status\":%d,\"msg\":\"%s\"}";
	static final String msgtemplate_debug = "{\"status\":%d,\"msg\":\"%s\",\"debug\":%s}";
	static final String datatemplate = "{\"status\":0,\"data\":%s}";
	static final String datatemplate_debug = "{\"status\":0,\"data\":%s,\"debug\":%s}";
	static final String template = "{\"status\":0}";
	static final String template_debug = "{\"status\":0,\"debug\":%s}";
	public static final ResponseObject SUCCESS_RES = new ResponseObject(null);
	public ResponseObject(Object data){
		this.status = 0;
		this.data= data;
	}
	public ResponseObject(int status) {
	    this.status = status;
	}
	public ResponseObject(int status, String msg){
		this.status = status;
		this.msg= msg;
	}
	
	public int getStatus() {
		return status;
	}

	@SuppressWarnings("rawtypes")
	public Map getDebug() {
		return debug;
	}

	@SuppressWarnings("rawtypes")
	public void setDebug(Map debug) {
		this.debug = debug;
	}

	public Object getData() {
		return data;
	}

	public String getMsg() {
		return msg;
	}
	
	@Override
	public String toString() {
		return toJson();
	}
	
	public String makeString() {
        if (!StringUtil.isEmpty(msg)) {
           return String.format(strtemplate, status, msg);
        }
        if (!StringUtil.isEmpty(data)) {
           String x = data.toString();
           x = x.replaceAll(",", ";");
           x=x.replaceAll("=", ":");
           x=x.replace('{',' ');
           x=x.replace('}',' ');
           return String.format(strtemplate, status, x);
        }
        return String.valueOf(status);
    }
	
	public String backStatus() {
	    return String.format(statustemplate, status);
	}
	
	public String toJson(){
		if (status!=0){
			if (debug == null){
		        return String.format(msgtemplate, status,msg);
			}else{
				return String.format(msgtemplate_debug, status,msg,JSonUtil.toJson(debug));   
		    }
		}else{
			if (debug == null){
				if (data == null) return template;
		        return String.format(datatemplate,JSonUtil.toJson(data));
			}else{
				if (data == null) return String.format(template_debug,JSonUtil.toJson(debug));
				return String.format(datatemplate_debug,JSonUtil.toJson(data),JSonUtil.toJson(debug));  
		    }
		}
	}
}
