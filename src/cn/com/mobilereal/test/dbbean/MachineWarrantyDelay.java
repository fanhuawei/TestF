/**
 * MachineWarrantyDelay.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.dbbean;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.mobilereal.common.dao.BaseBean;

import cn.com.mobilereal.test.dao.MachineWarrantyDelayDao;

/**
 * <p>ClassName: MachineWarrantyDelay</p>
 * <p>Description: 机器延保记录Bean类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class MachineWarrantyDelay extends BaseBean {
    /**
     * dao
     */
    public static final MachineWarrantyDelayDao I = new MachineWarrantyDelayDao();
    /**
     * 机器ID
     */
    private Long machineId;

    /**
     * 质保期
     */
    private java.sql.Timestamp warrantyTime;

    /**
     * 新质保期
     */
    private java.sql.Timestamp newWarrantyTime;

    /**
     * 操作员ID
     */
    private Long userId;

    /**
     * 描述
     */
    private String comments;

    /**
     * <p>Description: 设置机器ID</p>
     * @param newValue 机器ID
     */
    public void setMachineId(Long newValue) {
        this.machineId = newValue;
    }

    /**
     * <p>Description: 获取机器ID</p>
     * @return 机器ID
     */
    public Long getMachineId() {
        return this.machineId;
    }

    /**
     * <p>Description: 设置质保期</p>
     * @param newValue 质保期
     */
    public void setWarrantyTime(java.sql.Timestamp newValue) {
        this.warrantyTime = newValue;
    }

    /**
     * <p>Description: 获取质保期</p>
     * @return 质保期
     */
    public java.sql.Timestamp getWarrantyTime() {
        return this.warrantyTime;
    }

    /**
     * <p>Description: 设置新质保期</p>
     * @param newValue 新质保期
     */
    public void setNewWarrantyTime(java.sql.Timestamp newValue) {
        this.newWarrantyTime = newValue;
    }

    /**
     * <p>Description: 获取新质保期</p>
     * @return 新质保期
     */
    public java.sql.Timestamp getNewWarrantyTime() {
        return this.newWarrantyTime;
    }

    /**
     * <p>Description: 设置操作员ID</p>
     * @param newValue 操作员ID
     */
    public void setUserId(Long newValue) {
        this.userId = newValue;
    }

    /**
     * <p>Description: 获取操作员ID</p>
     * @return 操作员ID
     */
    public Long getUserId() {
        return this.userId;
    }

    /**
     * <p>Description: 设置描述</p>
     * @param newValue 描述
     */
    public void setComments(String newValue) {
        this.comments = newValue;
    }

    /**
     * <p>Description: 获取描述</p>
     * @return 描述
     */
    public String getComments() {
        return this.comments;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.machineId);
        LIST.add(this.warrantyTime);
        LIST.add(this.newWarrantyTime);
        LIST.add(this.userId);
        LIST.add(this.comments);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.machineId = makeLongValue(rs, "MACHINE_ID");
        this.warrantyTime = rs.getTimestamp("WARRANTY_TIME");
        this.newWarrantyTime = rs.getTimestamp("NEW_WARRANTY_TIME");
        this.userId = makeLongValue(rs, "USER_ID");
        this.comments = rs.getString("COMMENTS");

    }
}

