/**
 * OperateLogMobile.java
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
import cn.com.mobilereal.framework.dao.OperateLogMobileDao;

/**
 * 
 * <p>ClassName: OperateLogMobile</p>
 * <p>Description: MOBILE操作日志Bean</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class OperateLogMobile extends BaseBean {
    /**
     * dao
     */
    public static final OperateLogMobileDao I = new OperateLogMobileDao();
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 设备序列号
     */
    private String deviceSn;

    /**
     * 路径URL
     */
    private String path;

    /**
     * 操作参数
     */
    private String parameter;

    /**
     * 操作动作名称
     */
    private String actionName;

    /**
     * 操作动作编码
     */
    private String actionCode;

    /**
     * 失败原因
     */
    private String reason;

    /**
     * 结果 S:成功 F:失败
     */
    private String result;

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
     * <p>Description: 设置设备序列号</p>
     * @param newValue 设备序列号
     */
    public void setDeviceSn(String newValue) {
        this.deviceSn = newValue;
    }

    /**
     * <p>Description: 获取设备序列号</p>
     * @return 设备序列号
     */
    public String getDeviceSn() {
        return this.deviceSn;
    }

    /**
     * <p>Description: 设置路径URL</p>
     * @param newValue 路径URL
     */
    public void setPath(String newValue) {
        this.path = newValue;
    }

    /**
     * <p>Description: 获取路径URL</p>
     * @return 路径URL
     */
    public String getPath() {
        return this.path;
    }

    /**
     * <p>Description: 设置操作参数</p>
     * @param newValue 操作参数
     */
    public void setParameter(String newValue) {
        this.parameter = newValue;
    }

    /**
     * <p>Description: 获取操作参数</p>
     * @return 操作参数
     */
    public String getParameter() {
        return this.parameter;
    }

    /**
     * <p>Description: 设置操作动作名称</p>
     * @param newValue 操作动作名称
     */
    public void setActionName(String newValue) {
        this.actionName = newValue;
    }

    /**
     * <p>Description: 获取操作动作名称</p>
     * @return 操作动作名称
     */
    public String getActionName() {
        return this.actionName;
    }

    /**
     * <p>Description: 设置操作动作编码</p>
     * @param newValue 操作动作编码
     */
    public void setActionCode(String newValue) {
        this.actionCode = newValue;
    }

    /**
     * <p>Description: 获取操作动作编码</p>
     * @return 操作动作编码
     */
    public String getActionCode() {
        return this.actionCode;
    }

    /**
     * <p>Description: 设置失败原因</p>
     * @param newValue 失败原因
     */
    public void setReason(String newValue) {
        this.reason = newValue;
    }

    /**
     * <p>Description: 获取失败原因</p>
     * @return 失败原因
     */
    public String getReason() {
        return this.reason;
    }

    /**
     * <p>Description: 设置结果 S:成功 F:失败</p>
     * @param newValue 结果 S:成功 F:失败
     */
    public void setResult(String newValue) {
        this.result = newValue;
    }

    /**
     * <p>Description: 获取结果 S:成功 F:失败</p>
     * @return 结果 S:成功 F:失败
     */
    public String getResult() {
        return this.result;
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
        LIST.add(this.deviceSn);
        LIST.add(this.path);
        LIST.add(this.parameter);
        LIST.add(this.actionName);
        LIST.add(this.actionCode);
        LIST.add(this.reason);
        LIST.add(this.result);
        LIST.add(this.roleId);
        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.userId = makeLongValue(rs, "USER_ID");
        this.deviceSn = rs.getString("DEVICE_SN");
        this.path = rs.getString("PATH");
        this.parameter = rs.getString("PARAMETER");
        this.actionName = rs.getString("ACTION_NAME");
        this.actionCode = rs.getString("ACTION_CODE");
        this.reason = rs.getString("REASON");
        this.result = rs.getString("RESULT");
        this.roleId = makeLongValue(rs, "ROLE_ID");
    }
}

