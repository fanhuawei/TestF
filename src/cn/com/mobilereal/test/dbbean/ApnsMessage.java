/**
 * ApnsMessage.java
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

import cn.com.mobilereal.test.dao.ApnsMessageDao;

/**
 * <p>ClassName: ApnsMessage</p>
 * <p>Description: 推送消息Bean类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class ApnsMessage extends BaseBean {
    /**
     * dao
     */
    public static final ApnsMessageDao I = new ApnsMessageDao();
    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 接受人数量
     */
    private Long cnt;

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
     * <p>Description: 设置标题</p>
     * @param newValue 标题
     */
    public void setTitle(String newValue) {
        this.title = newValue;
    }

    /**
     * <p>Description: 获取标题</p>
     * @return 标题
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * <p>Description: 设置内容</p>
     * @param newValue 内容
     */
    public void setContent(String newValue) {
        this.content = newValue;
    }

    /**
     * <p>Description: 获取内容</p>
     * @return 内容
     */
    public String getContent() {
        return this.content;
    }

    /**
     * <p>Description: 设置接受人数量</p>
     * @param newValue 接受人数量
     */
    public void setCnt(Long newValue) {
        this.cnt = newValue;
    }

    /**
     * <p>Description: 获取接受人数量</p>
     * @return 接受人数量
     */
    public Long getCnt() {
        return this.cnt;
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
        LIST.add(this.title);
        LIST.add(this.content);
        LIST.add(this.cnt);
        LIST.add(this.deviceId);
        LIST.add(this.status);
        LIST.add(this.userId);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.title = rs.getString("TITLE");
        this.content = rs.getString("CONTENT");
        this.cnt = makeLongValue(rs, "CNT");
        this.deviceId = makeLongValue(rs, "DEVICE_ID");
        this.status = rs.getString("STATUS");
        this.userId = makeLongValue(rs, "USER_ID");

    }
}

