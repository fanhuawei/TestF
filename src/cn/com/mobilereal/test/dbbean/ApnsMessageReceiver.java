/**
 * ApnsMessageReceiver.java
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

import cn.com.mobilereal.test.dao.ApnsMessageReceiverDao;

/**
 * <p>ClassName: ApnsMessageReceiver</p>
 * <p>Description: 推送消息接受人Bean类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class ApnsMessageReceiver extends BaseBean {
    /**
     * dao
     */
    public static final ApnsMessageReceiverDao I = new ApnsMessageReceiverDao();
    /**
     * 消息ID
     */
    private Long messageId;

    /**
     * 设备ID
     */
    private Long deviceId;

    /**
     * 状态：N:未发送 F:发送失败 S：发送成功
     */
    private String status;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * <p>Description: 设置消息ID</p>
     * @param newValue 消息ID
     */
    public void setMessageId(Long newValue) {
        this.messageId = newValue;
    }

    /**
     * <p>Description: 获取消息ID</p>
     * @return 消息ID
     */
    public Long getMessageId() {
        return this.messageId;
    }

    /**
     * <p>Description: 设置设备ID</p>
     * @param newValue 设备ID
     */
    public void setDeviceId(Long newValue) {
        this.deviceId = newValue;
    }

    /**
     * <p>Description: 获取设备ID</p>
     * @return 设备ID
     */
    public Long getDeviceId() {
        return this.deviceId;
    }

    /**
     * <p>Description: 设置状态：N:未发送 F:发送失败 S：发送成功</p>
     * @param newValue 状态：N:未发送 F:发送失败 S：发送成功
     */
    public void setStatus(String newValue) {
        this.status = newValue;
    }

    /**
     * <p>Description: 获取状态：N:未发送 F:发送失败 S：发送成功</p>
     * @return 状态：N:未发送 F:发送失败 S：发送成功
     */
    public String getStatus() {
        return this.status;
    }

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


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.messageId);
        LIST.add(this.deviceId);
        LIST.add(this.status);
        LIST.add(this.userId);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.messageId = makeLongValue(rs, "MESSAGE_ID");
        this.deviceId = makeLongValue(rs, "DEVICE_ID");
        this.status = rs.getString("STATUS");
        this.userId = makeLongValue(rs, "USER_ID");

    }
}

