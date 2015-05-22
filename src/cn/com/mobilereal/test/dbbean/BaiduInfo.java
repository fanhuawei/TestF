/**
 * BaiduInfo.java
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

import cn.com.mobilereal.test.dao.BaiduInfoDao;

/**
 * <p>ClassName: BaiduInfo</p>
 * <p>Description: 百度云推送信息Bean类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class BaiduInfo extends BaseBean {
    /**
     * dao
     */
    public static final BaiduInfoDao I = new BaiduInfoDao();
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 设备序列号
     */
    private String deviceSn;

    /**
     * 客户端ID
     */
    private String clientId;

    /**
     * 通道ID
     */
    private String channelId;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 设备类型 A:android I :ios
     */
    private String deviceType;

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
     * <p>Description: 设置客户端ID</p>
     * @param newValue 客户端ID
     */
    public void setClientId(String newValue) {
        this.clientId = newValue;
    }

    /**
     * <p>Description: 获取客户端ID</p>
     * @return 客户端ID
     */
    public String getClientId() {
        return this.clientId;
    }

    /**
     * <p>Description: 设置通道ID</p>
     * @param newValue 通道ID
     */
    public void setChannelId(String newValue) {
        this.channelId = newValue;
    }

    /**
     * <p>Description: 获取通道ID</p>
     * @return 通道ID
     */
    public String getChannelId() {
        return this.channelId;
    }

    /**
     * <p>Description: 设置应用ID</p>
     * @param newValue 应用ID
     */
    public void setAppId(String newValue) {
        this.appId = newValue;
    }

    /**
     * <p>Description: 获取应用ID</p>
     * @return 应用ID
     */
    public String getAppId() {
        return this.appId;
    }

    /**
     * <p>Description: 设置设备类型 A:android I :ios</p>
     * @param newValue 设备类型 A:android I :ios
     */
    public void setDeviceType(String newValue) {
        this.deviceType = newValue;
    }

    /**
     * <p>Description: 获取设备类型 A:android I :ios</p>
     * @return 设备类型 A:android I :ios
     */
    public String getDeviceType() {
        return this.deviceType;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.userId);
        LIST.add(this.deviceSn);
        LIST.add(this.clientId);
        LIST.add(this.channelId);
        LIST.add(this.appId);
        LIST.add(this.deviceType);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.userId = makeLongValue(rs, "USER_ID");
        this.deviceSn = rs.getString("DEVICE_SN");
        this.clientId = rs.getString("CLIENT_ID");
        this.channelId = rs.getString("CHANNEL_ID");
        this.appId = rs.getString("APP_ID");
        this.deviceType = rs.getString("DEVICE_TYPE");

    }
}

