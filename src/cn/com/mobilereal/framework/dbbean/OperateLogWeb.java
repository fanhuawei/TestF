/**
 * OperateLogWeb.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal All rights reserved.
 */
package cn.com.mobilereal.framework.dbbean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.mobilereal.common.dao.BaseBean;
import cn.com.mobilereal.framework.dao.OperateLogWebDao;


/**
 * 
 * <p>ClassName: OperateLogWeb</p>
 * <p>Description: WEB操作日志Bean</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class OperateLogWeb extends BaseBean {
    /**
     * dao
     */
    public static final OperateLogWebDao I = new OperateLogWebDao();
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 会话ID
     */
    private String sessionId;

    /**
     * 客户端IP
     */
    private String clientIp;

    /**
     * 登录时间
     */
    private java.sql.Timestamp loginTime;

    /**
     * 退出时间
     */
    private java.sql.Timestamp logoutTime;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * <p>Description: 设置用户ID</p>
     * @param newValue 用户ID
     */
    public void setUserId(Long newValue) {
        this.userId = newValue;
    }

    /**
     * <p>Description: 获取用户ID</p>
     * @return 用户ID
     */
    public Long getUserId() {
        return this.userId;
    }

    /**
     * <p>Description: 设置会话ID</p>
     * @param newValue 会话ID
     */
    public void setSessionId(String newValue) {
        this.sessionId = newValue;
    }

    /**
     * <p>Description: 获取会话ID</p>
     * @return 会话ID
     */
    public String getSessionId() {
        return this.sessionId;
    }

    /**
     * <p>Description: 设置客户端IP</p>
     * @param newValue 客户端IP
     */
    public void setClientIp(String newValue) {
        this.clientIp = newValue;
    }

    /**
     * <p>Description: 获取客户端IP</p>
     * @return 客户端IP
     */
    public String getClientIp() {
        return this.clientIp;
    }

    /**
     * <p>Description: 设置登录时间</p>
     * @param newValue 登录时间
     */
    public void setLoginTime(java.sql.Timestamp newValue) {
        this.loginTime = newValue;
    }

    /**
     * <p>Description: 获取登录时间</p>
     * @return 登录时间
     */
    public java.sql.Timestamp getLoginTime() {
        return this.loginTime;
    }

    /**
     * <p>Description: 设置退出时间</p>
     * @param newValue 退出时间
     */
    public void setLogoutTime(java.sql.Timestamp newValue) {
        this.logoutTime = newValue;
    }

    /**
     * <p>Description: 获取退出时间</p>
     * @return 退出时间
     */
    public java.sql.Timestamp getLogoutTime() {
        return this.logoutTime;
    }

    /**
     * <p>Description: 设置角色ID</p>
     * @param newValue 角色ID
     */
    public void setRoleId(Long newValue) {
        this.roleId = newValue;
    }

    /**
     * <p>Description: 获取角色ID</p>
     * @return 角色ID
     */
    public Long getRoleId() {
        return this.roleId;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.userId);
        LIST.add(this.sessionId);
        LIST.add(this.clientIp);
        LIST.add(this.loginTime);
        LIST.add(this.logoutTime);
        LIST.add(this.roleId);
        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.userId = makeLongValue(rs, "USER_ID");
        this.sessionId = rs.getString("SESSION_ID");
        this.clientIp = rs.getString("CLIENT_IP");
        this.loginTime = rs.getTimestamp("LOGIN_TIME");
        this.logoutTime = rs.getTimestamp("LOGOUT_TIME");
        this.roleId = makeLongValue(rs, "ROLE_ID");
    }
}

