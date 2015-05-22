package cn.com.mobilereal.common.util;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import cn.com.mobilereal.framework.dbbean.User;
import cn.com.mobilereal.common.web.CustomHttpServletRequest;


public class ThreadLocalBean {

    private Connection DBConnection;
    private Connection PKConnection;
    private Boolean RollBack;
    private String Action;
    private String Device;
    private Long DeviceId;
    private Long ProjectId;
    private String DeviceType;
    private User User;
    private Boolean WebAction=true;
    private static ThreadLocal<CustomHttpServletRequest> Request = new ThreadLocal<CustomHttpServletRequest>();
    private HttpServletResponse Response;
    private Boolean Goon = true;
    private Map<String,Map<Long,Object>> CacheMap = new HashMap<String,Map<Long,Object>>();
    
    private static ThreadLocalBean bean = new ThreadLocalBean();

    public static Map<String,Map<Long,Object>> getCache() {
        return getBean().CacheMap;
    }
    public static ThreadLocalBean getBean() {
        if (getRequest()!=null){
          return getRequest().getBean();
        }
        return bean;
    }
    public static Connection getDBConnection() {
        return getBean().DBConnection;
    }
    public static void setDBConnection(Connection dBConnection) {
        getBean().DBConnection = dBConnection;
    }
    public static Connection getPKConnection() {
        return getBean().PKConnection;
    }
    public static void setPKConnection(Connection connection) {
        getBean().PKConnection = connection;
    }
    public static Boolean getRollBack() {
        return getBean().RollBack;
    }
    public static void setRollBack(Boolean rollBack) {
        getBean().RollBack = rollBack;
    }
    public static String getAction() {
        return getBean().Action;
    }
    public static void setAction(String action) {
        getBean().Action = action;
    }
    public static String getDevice() {
        return getBean().Device;
    }
    public static void setDevice(String device) {
        getBean().Device = device;
    }
    public static Long getDeviceId() {
        return getBean().DeviceId;
    }
    public static void setDeviceId(Long deviceId) {
        getBean().DeviceId = deviceId;
    }
    public static Long getProjectId() {
        return getBean().ProjectId;
    }
    public static void setProjectId(Long projectId) {
        getBean().ProjectId = projectId;
    }
    public static String getDeviceType() {
        return getBean().DeviceType;
    }
    public static void setDeviceType(String deviceType) {
        getBean().DeviceType = deviceType;
    }
    public static User getUser() {
        return getBean().User;
    }
    public static void setUser(User user) {
        getBean().User = user;
    }
    public static Boolean getWebAction() {
        return getBean().WebAction;
    }
    public static void setWebAction(Boolean webAction) {
        getBean().WebAction = webAction;
    }
    public static CustomHttpServletRequest getRequest() {
        return Request.get();
    }
    public static void setRequest(CustomHttpServletRequest request) {
        Request.set(request);
    }
    public static HttpServletResponse getResponse() {
        return getBean().Response;
    }
    public static void setResponse(HttpServletResponse response) {
        getBean().Response = response;
    }
    public static Boolean getGoon() {
        return getBean().Goon;
    }
    public static void setGoon(Boolean goon) {
        getBean().Goon = goon;
    }

   
}
