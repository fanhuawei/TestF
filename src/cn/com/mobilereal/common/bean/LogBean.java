/**
 * LogBean.java
 * Created at 2014年12月3日
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.common.bean;

import java.util.Map;

import cn.com.mobilereal.common.action.MobileActionEnum;
import cn.com.mobilereal.common.ui.MenuEnum;

/**
 * <p>
 * ClassName: LogBean
 * </p>
 * <p>
 * Description: 日志参数对象
 * </p>
 * <p>
 * Author: Fanhuawei
 * </p>
 * <p>
 * Date: 2014年12月3日
 * </p>
 */
public class LogBean {
    private Long userId;
    private Long roleId;
    private String path;
    private String reason;
    private String result;
    private Map<String, String[]> parameter;

    private String sessionId;
    private String clientIp;

    private MenuEnum menu;
    private String action;

    private MobileActionEnum mobileAction;
    private String sn;

    public LogBean(Long userId, Long roleId, String reason, String result,
            Map<String, String[]> parameter, String sessionId, String clientIp, MenuEnum menu, String action) {
        super();
        this.userId = userId;
        this.roleId = roleId;
        this.reason = reason;
        this.result = result;
        this.parameter = parameter;
        this.sessionId = sessionId;
        this.clientIp = clientIp;
        this.menu = menu;
        this.action = action;
    }

    public LogBean(Long userId, Long roleId, String path, String reason, String result,
            Map<String, String[]> parameter, MobileActionEnum mobileAction,String sn) {
        super();
        this.userId = userId;
        this.roleId = roleId;
        this.path = path;
        this.reason = reason;
        this.result = result;
        this.parameter = parameter;
        this.mobileAction = mobileAction;
        this.sn = sn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<String, String[]> getParameter() {
        return parameter;
    }

    public void setParameter(Map<String, String[]> parameter) {
        this.parameter = parameter;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public MenuEnum getMenu() {
        return menu;
    }

    public void setMenu(MenuEnum menu) {
        this.menu = menu;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public MobileActionEnum getMobileAction() {
        return mobileAction;
    }

    public void setMobileAction(MobileActionEnum mobileAction) {
        this.mobileAction = mobileAction;
    }

}
