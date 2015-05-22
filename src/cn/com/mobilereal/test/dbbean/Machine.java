/**
 * Machine.java
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

import cn.com.mobilereal.test.dao.MachineDao;

/**
 * <p>ClassName: Machine</p>
 * <p>Description: 机器Bean类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class Machine extends BaseBean {
    /**
     * dao
     */
    public static final MachineDao I = new MachineDao();
    /**
     * 代理商ID
     */
    private Long agentId;

    /**
     * 区域服务中心
     */
    private Long serviceCenterId;

    /**
     * 类型
     */
    private String type;

    /**
     * 型号
     */
    private String model;

    /**
     * 系列号
     */
    private String serialNo;

    /**
     * 出厂时间
     */
    private java.sql.Timestamp productTime;

    /**
     * 开机时间
     */
    private java.sql.Timestamp openTime;

    /**
     * SAP出厂时间
     */
    private java.sql.Timestamp sapProductTime;

    /**
     * 质保期
     */
    private java.sql.Timestamp warrantyTime;

    /**
     * 数据终端ID
     */
    private Long terminalId;

    /**
     * 客户ID
     */
    private Long customerId;

    /**
     * 最新运行状态
     */
    private Long runStateId;

    /**
     * 最近服务记录
     */
    private Long lastServiceId;

    /**
     * 经度
     */
    private java.math.BigDecimal longititude;

    /**
     * 纬度
     */
    private java.math.BigDecimal latitude;

    /**
     * 安装位置
     */
    private String location;

    /**
     * <p>Description: 设置代理商ID</p>
     * @param newValue 代理商ID
     */
    public void setAgentId(Long newValue) {
        this.agentId = newValue;
    }

    /**
     * <p>Description: 获取代理商ID</p>
     * @return 代理商ID
     */
    public Long getAgentId() {
        return this.agentId;
    }

    /**
     * <p>Description: 设置区域服务中心</p>
     * @param newValue 区域服务中心
     */
    public void setServiceCenterId(Long newValue) {
        this.serviceCenterId = newValue;
    }

    /**
     * <p>Description: 获取区域服务中心</p>
     * @return 区域服务中心
     */
    public Long getServiceCenterId() {
        return this.serviceCenterId;
    }

    /**
     * <p>Description: 设置类型</p>
     * @param newValue 类型
     */
    public void setType(String newValue) {
        this.type = newValue;
    }

    /**
     * <p>Description: 获取类型</p>
     * @return 类型
     */
    public String getType() {
        return this.type;
    }

    /**
     * <p>Description: 设置型号</p>
     * @param newValue 型号
     */
    public void setModel(String newValue) {
        this.model = newValue;
    }

    /**
     * <p>Description: 获取型号</p>
     * @return 型号
     */
    public String getModel() {
        return this.model;
    }

    /**
     * <p>Description: 设置系列号</p>
     * @param newValue 系列号
     */
    public void setSerialNo(String newValue) {
        this.serialNo = newValue;
    }

    /**
     * <p>Description: 获取系列号</p>
     * @return 系列号
     */
    public String getSerialNo() {
        return this.serialNo;
    }

    /**
     * <p>Description: 设置出厂时间</p>
     * @param newValue 出厂时间
     */
    public void setProductTime(java.sql.Timestamp newValue) {
        this.productTime = newValue;
    }

    /**
     * <p>Description: 获取出厂时间</p>
     * @return 出厂时间
     */
    public java.sql.Timestamp getProductTime() {
        return this.productTime;
    }

    /**
     * <p>Description: 设置开机时间</p>
     * @param newValue 开机时间
     */
    public void setOpenTime(java.sql.Timestamp newValue) {
        this.openTime = newValue;
    }

    /**
     * <p>Description: 获取开机时间</p>
     * @return 开机时间
     */
    public java.sql.Timestamp getOpenTime() {
        return this.openTime;
    }

    /**
     * <p>Description: 设置SAP出厂时间</p>
     * @param newValue SAP出厂时间
     */
    public void setSapProductTime(java.sql.Timestamp newValue) {
        this.sapProductTime = newValue;
    }

    /**
     * <p>Description: 获取SAP出厂时间</p>
     * @return SAP出厂时间
     */
    public java.sql.Timestamp getSapProductTime() {
        return this.sapProductTime;
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
     * <p>Description: 设置数据终端ID</p>
     * @param newValue 数据终端ID
     */
    public void setTerminalId(Long newValue) {
        this.terminalId = newValue;
    }

    /**
     * <p>Description: 获取数据终端ID</p>
     * @return 数据终端ID
     */
    public Long getTerminalId() {
        return this.terminalId;
    }

    /**
     * <p>Description: 设置客户ID</p>
     * @param newValue 客户ID
     */
    public void setCustomerId(Long newValue) {
        this.customerId = newValue;
    }

    /**
     * <p>Description: 获取客户ID</p>
     * @return 客户ID
     */
    public Long getCustomerId() {
        return this.customerId;
    }

    /**
     * <p>Description: 设置最新运行状态</p>
     * @param newValue 最新运行状态
     */
    public void setRunStateId(Long newValue) {
        this.runStateId = newValue;
    }

    /**
     * <p>Description: 获取最新运行状态</p>
     * @return 最新运行状态
     */
    public Long getRunStateId() {
        return this.runStateId;
    }

    /**
     * <p>Description: 设置最近服务记录</p>
     * @param newValue 最近服务记录
     */
    public void setLastServiceId(Long newValue) {
        this.lastServiceId = newValue;
    }

    /**
     * <p>Description: 获取最近服务记录</p>
     * @return 最近服务记录
     */
    public Long getLastServiceId() {
        return this.lastServiceId;
    }

    /**
     * <p>Description: 设置经度</p>
     * @param newValue 经度
     */
    public void setLongititude(java.math.BigDecimal newValue) {
        this.longititude = newValue;
    }

    /**
     * <p>Description: 获取经度</p>
     * @return 经度
     */
    public java.math.BigDecimal getLongititude() {
        return this.longititude;
    }

    /**
     * <p>Description: 设置纬度</p>
     * @param newValue 纬度
     */
    public void setLatitude(java.math.BigDecimal newValue) {
        this.latitude = newValue;
    }

    /**
     * <p>Description: 获取纬度</p>
     * @return 纬度
     */
    public java.math.BigDecimal getLatitude() {
        return this.latitude;
    }

    /**
     * <p>Description: 设置安装位置</p>
     * @param newValue 安装位置
     */
    public void setLocation(String newValue) {
        this.location = newValue;
    }

    /**
     * <p>Description: 获取安装位置</p>
     * @return 安装位置
     */
    public String getLocation() {
        return this.location;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.agentId);
        LIST.add(this.serviceCenterId);
        LIST.add(this.type);
        LIST.add(this.model);
        LIST.add(this.serialNo);
        LIST.add(this.productTime);
        LIST.add(this.openTime);
        LIST.add(this.sapProductTime);
        LIST.add(this.warrantyTime);
        LIST.add(this.terminalId);
        LIST.add(this.customerId);
        LIST.add(this.runStateId);
        LIST.add(this.lastServiceId);
        LIST.add(this.longititude);
        LIST.add(this.latitude);
        LIST.add(this.location);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.agentId = makeLongValue(rs, "AGENT_ID");
        this.serviceCenterId = makeLongValue(rs, "SERVICE_CENTER_ID");
        this.type = rs.getString("TYPE");
        this.model = rs.getString("MODEL");
        this.serialNo = rs.getString("SERIAL_NO");
        this.productTime = rs.getTimestamp("PRODUCT_TIME");
        this.openTime = rs.getTimestamp("OPEN_TIME");
        this.sapProductTime = rs.getTimestamp("SAP_PRODUCT_TIME");
        this.warrantyTime = rs.getTimestamp("WARRANTY_TIME");
        this.terminalId = makeLongValue(rs, "TERMINAL_ID");
        this.customerId = makeLongValue(rs, "CUSTOMER_ID");
        this.runStateId = makeLongValue(rs, "RUN_STATE_ID");
        this.lastServiceId = makeLongValue(rs, "LAST_SERVICE_ID");
        this.longititude = rs.getBigDecimal("LONGITITUDE");
        this.latitude = rs.getBigDecimal("LATITUDE");
        this.location = rs.getString("LOCATION");

    }
}

