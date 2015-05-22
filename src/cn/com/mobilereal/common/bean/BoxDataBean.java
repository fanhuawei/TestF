package cn.com.mobilereal.common.bean;

import java.util.Map;

public class BoxDataBean {
    private String date ; 
    private String mode;
    private String status;
    private Map<String,Object> map ;
    
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }
    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Map<String, Object> getMap() {
        return map;
    }
    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
