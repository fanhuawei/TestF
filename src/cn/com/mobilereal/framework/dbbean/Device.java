/**
 * Device.java
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
import cn.com.mobilereal.framework.dao.DeviceDao;

/**
 * 
 * <p>ClassName: Device</p>
 * <p>Description: PAD设备Bean</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class Device extends BaseBean {
    /**
     * dao
     */
    public static final DeviceDao I = new DeviceDao();
    /**
     * 设备序列号
     */
    private String sn;

    /**
     * 设备名
     */
    private String name;

    /**
     * 使用状态Y：使用中 N:空闲
     */
    private String useFlag;

    /**
     * 挂失标记Y:挂失 N:未挂失
     */
    private String lostFlag;

    /**
     * <p>Description: 设置设备序列号</p>
     * @param newValue 设备序列号
     */
    public void setSn(String newValue) {
        this.sn = newValue;
    }

    /**
     * <p>Description: 获取设备序列号</p>
     * @return 设备序列号
     */
    public String getSn() {
        return this.sn;
    }

    /**
     * <p>Description: 设置设备名</p>
     * @param newValue 设备名
     */
    public void setName(String newValue) {
        this.name = newValue;
    }

    /**
     * <p>Description: 获取设备名</p>
     * @return 设备名
     */
    public String getName() {
        return this.name;
    }

    /**
     * <p>Description: 设置使用状态Y：使用中 N:空闲</p>
     * @param newValue 使用状态Y：使用中 N:空闲
     */
    public void setUseFlag(String newValue) {
        this.useFlag = newValue;
    }

    /**
     * <p>Description: 获取使用状态Y：使用中 N:空闲</p>
     * @return 使用状态Y：使用中 N:空闲
     */
    public String getUseFlag() {
        return this.useFlag;
    }

    /**
     * <p>Description: 设置挂失标记Y:挂失 N:未挂失</p>
     * @param newValue 挂失标记Y:挂失 N:未挂失
     */
    public void setLostFlag(String newValue) {
        this.lostFlag = newValue;
    }

    /**
     * <p>Description: 获取挂失标记Y:挂失 N:未挂失</p>
     * @return 挂失标记Y:挂失 N:未挂失
     */
    public String getLostFlag() {
        return this.lostFlag;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.sn);
        LIST.add(this.name);
        LIST.add(this.useFlag);
        LIST.add(this.lostFlag);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.sn = rs.getString("SN");
        this.name = rs.getString("NAME");
        this.useFlag = rs.getString("USE_FLAG");
        this.lostFlag = rs.getString("LOST_FLAG");

    }
}

