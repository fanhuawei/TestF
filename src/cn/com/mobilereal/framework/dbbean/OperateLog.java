/**
 * OperateLog.java
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
import cn.com.mobilereal.framework.dao.OperateLogDao;

/**
 * 
 * <p>ClassName: OperateLog</p>
 * <p>Description: 系统操作日志Bean</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class OperateLog extends BaseBean {
    /**
     * dao
     */
    public static final OperateLogDao I = new OperateLogDao();
    /**
     * 日志ID
     */
    private Long logId;

    /**
     * 路径URL
     */
    private String path;

    /**
     * 操作模块
     */
    private String module;

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
     * <p>Description: 设置日志ID</p>
     * @param newValue 日志ID
     */
    public void setLogId(Long newValue) {
        this.logId = newValue;
    }

    /**
     * <p>Description: 获取日志ID</p>
     * @return 日志ID
     */
    public Long getLogId() {
        return this.logId;
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
     * <p>Description: 设置操作模块</p>
     * @param newValue 操作模块
     */
    public void setModule(String newValue) {
        this.module = newValue;
    }

    /**
     * <p>Description: 获取操作模块</p>
     * @return 操作模块
     */
    public String getModule() {
        return this.module;
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


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.logId);
        LIST.add(this.path);
        LIST.add(this.module);
        LIST.add(this.parameter);
        LIST.add(this.actionName);
        LIST.add(this.actionCode);
        LIST.add(this.reason);
        LIST.add(this.result);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.logId = makeLongValue(rs, "LOG_ID");
        this.path = rs.getString("PATH");
        this.module = rs.getString("MODULE");
        this.parameter = rs.getString("PARAMETER");
        this.actionName = rs.getString("ACTION_NAME");
        this.actionCode = rs.getString("ACTION_CODE");
        this.reason = rs.getString("REASON");
        this.result = rs.getString("RESULT");

    }
}

