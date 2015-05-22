/**
 * Work.java
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

import cn.com.mobilereal.test.dao.WorkDao;

/**
 * <p>ClassName: Work</p>
 * <p>Description: 代班Bean类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class Work extends BaseBean {
    /**
     * dao
     */
    public static final WorkDao I = new WorkDao();
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 代班人ID
     */
    private Long coverUserId;

    /**
     * 开始时间
     */
    private java.sql.Timestamp startTime;

    /**
     * 结束时间
     */
    private java.sql.Timestamp endTime;

    /**
     * 有效标记
     */
    private String validFlag;

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
     * <p>Description: 设置代班人ID</p>
     * @param newValue 代班人ID
     */
    public void setCoverUserId(Long newValue) {
        this.coverUserId = newValue;
    }

    /**
     * <p>Description: 获取代班人ID</p>
     * @return 代班人ID
     */
    public Long getCoverUserId() {
        return this.coverUserId;
    }

    /**
     * <p>Description: 设置开始时间</p>
     * @param newValue 开始时间
     */
    public void setStartTime(java.sql.Timestamp newValue) {
        this.startTime = newValue;
    }

    /**
     * <p>Description: 获取开始时间</p>
     * @return 开始时间
     */
    public java.sql.Timestamp getStartTime() {
        return this.startTime;
    }

    /**
     * <p>Description: 设置结束时间</p>
     * @param newValue 结束时间
     */
    public void setEndTime(java.sql.Timestamp newValue) {
        this.endTime = newValue;
    }

    /**
     * <p>Description: 获取结束时间</p>
     * @return 结束时间
     */
    public java.sql.Timestamp getEndTime() {
        return this.endTime;
    }

    /**
     * <p>Description: 设置有效标记</p>
     * @param newValue 有效标记
     */
    public void setValidFlag(String newValue) {
        this.validFlag = newValue;
    }

    /**
     * <p>Description: 获取有效标记</p>
     * @return 有效标记
     */
    public String getValidFlag() {
        return this.validFlag;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.userId);
        LIST.add(this.coverUserId);
        LIST.add(this.startTime);
        LIST.add(this.endTime);
        LIST.add(this.validFlag);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.userId = makeLongValue(rs, "USER_ID");
        this.coverUserId = makeLongValue(rs, "COVER_USER_ID");
        this.startTime = rs.getTimestamp("START_TIME");
        this.endTime = rs.getTimestamp("END_TIME");
        this.validFlag = rs.getString("VALID_FLAG");

    }
}

