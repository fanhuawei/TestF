/**
 * WorkOrder.java
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

import cn.com.mobilereal.test.dao.WorkOrderDao;

/**
 * <p>ClassName: WorkOrder</p>
 * <p>Description: 工单Bean类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class WorkOrder extends BaseBean {
    /**
     * dao
     */
    public static final WorkOrderDao I = new WorkOrderDao();
    /**
     * 单号
     */
    private String code;

    /**
     * 客服人员
     */
    private Long userId;

    /**
     * 代理商ID
     */
    private Long agentId;

    /**
     * 客户
     */
    private Long customerId;

    /**
     * 区域服务中心
     */
    private Long serviceCenterId;

    /**
     * 机器ID
     */
    private Long machineId;

    /**
     * 服务类型
     */
    private String serviceType;

    /**
     * 故障描述
     */
    private String comments;

    /**
     * 机器运行状态ID
     */
    private Long runStateId;

    /**
     * 最近工单流ID
     */
    private Long workOrderFlowId;

    /**
     * 纬度
     */
    private java.math.BigDecimal latitude;

    /**
     * 经度
     */
    private java.math.BigDecimal longitude;

    /**
     * 到达现场时间
     */
    private java.sql.Timestamp arrivedTime;

    /**
     * 工单状态
     */
    private String status;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 联系电话
     */
    private String contactTel;

    /**
     * 省份
     */
    private Long provinceId;

    /**
     * 城市
     */
    private Long cityId;

    /**
     * 区县
     */
    private Long countyId;

    /**
     * 地址
     */
    private String address;

    /**
     * <p>Description: 设置单号</p>
     * @param newValue 单号
     */
    public void setCode(String newValue) {
        this.code = newValue;
    }

    /**
     * <p>Description: 获取单号</p>
     * @return 单号
     */
    public String getCode() {
        return this.code;
    }

    /**
     * <p>Description: 设置客服人员</p>
     * @param newValue 客服人员
     */
    public void setUserId(Long newValue) {
        this.userId = newValue;
    }

    /**
     * <p>Description: 获取客服人员</p>
     * @return 客服人员
     */
    public Long getUserId() {
        return this.userId;
    }

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
     * <p>Description: 设置客户</p>
     * @param newValue 客户
     */
    public void setCustomerId(Long newValue) {
        this.customerId = newValue;
    }

    /**
     * <p>Description: 获取客户</p>
     * @return 客户
     */
    public Long getCustomerId() {
        return this.customerId;
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
     * <p>Description: 设置服务类型</p>
     * @param newValue 服务类型
     */
    public void setServiceType(String newValue) {
        this.serviceType = newValue;
    }

    /**
     * <p>Description: 获取服务类型</p>
     * @return 服务类型
     */
    public String getServiceType() {
        return this.serviceType;
    }

    /**
     * <p>Description: 设置故障描述</p>
     * @param newValue 故障描述
     */
    public void setComments(String newValue) {
        this.comments = newValue;
    }

    /**
     * <p>Description: 获取故障描述</p>
     * @return 故障描述
     */
    public String getComments() {
        return this.comments;
    }

    /**
     * <p>Description: 设置机器运行状态ID</p>
     * @param newValue 机器运行状态ID
     */
    public void setRunStateId(Long newValue) {
        this.runStateId = newValue;
    }

    /**
     * <p>Description: 获取机器运行状态ID</p>
     * @return 机器运行状态ID
     */
    public Long getRunStateId() {
        return this.runStateId;
    }

    /**
     * <p>Description: 设置最近工单流ID</p>
     * @param newValue 最近工单流ID
     */
    public void setWorkOrderFlowId(Long newValue) {
        this.workOrderFlowId = newValue;
    }

    /**
     * <p>Description: 获取最近工单流ID</p>
     * @return 最近工单流ID
     */
    public Long getWorkOrderFlowId() {
        return this.workOrderFlowId;
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
     * <p>Description: 设置经度</p>
     * @param newValue 经度
     */
    public void setLongitude(java.math.BigDecimal newValue) {
        this.longitude = newValue;
    }

    /**
     * <p>Description: 获取经度</p>
     * @return 经度
     */
    public java.math.BigDecimal getLongitude() {
        return this.longitude;
    }

    /**
     * <p>Description: 设置到达现场时间</p>
     * @param newValue 到达现场时间
     */
    public void setArrivedTime(java.sql.Timestamp newValue) {
        this.arrivedTime = newValue;
    }

    /**
     * <p>Description: 获取到达现场时间</p>
     * @return 到达现场时间
     */
    public java.sql.Timestamp getArrivedTime() {
        return this.arrivedTime;
    }

    /**
     * <p>Description: 设置工单状态</p>
     * @param newValue 工单状态
     */
    public void setStatus(String newValue) {
        this.status = newValue;
    }

    /**
     * <p>Description: 获取工单状态</p>
     * @return 工单状态
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * <p>Description: 设置联系人</p>
     * @param newValue 联系人
     */
    public void setContact(String newValue) {
        this.contact = newValue;
    }

    /**
     * <p>Description: 获取联系人</p>
     * @return 联系人
     */
    public String getContact() {
        return this.contact;
    }

    /**
     * <p>Description: 设置联系电话</p>
     * @param newValue 联系电话
     */
    public void setContactTel(String newValue) {
        this.contactTel = newValue;
    }

    /**
     * <p>Description: 获取联系电话</p>
     * @return 联系电话
     */
    public String getContactTel() {
        return this.contactTel;
    }

    /**
     * <p>Description: 设置省份</p>
     * @param newValue 省份
     */
    public void setProvinceId(Long newValue) {
        this.provinceId = newValue;
    }

    /**
     * <p>Description: 获取省份</p>
     * @return 省份
     */
    public Long getProvinceId() {
        return this.provinceId;
    }

    /**
     * <p>Description: 设置城市</p>
     * @param newValue 城市
     */
    public void setCityId(Long newValue) {
        this.cityId = newValue;
    }

    /**
     * <p>Description: 获取城市</p>
     * @return 城市
     */
    public Long getCityId() {
        return this.cityId;
    }

    /**
     * <p>Description: 设置区县</p>
     * @param newValue 区县
     */
    public void setCountyId(Long newValue) {
        this.countyId = newValue;
    }

    /**
     * <p>Description: 获取区县</p>
     * @return 区县
     */
    public Long getCountyId() {
        return this.countyId;
    }

    /**
     * <p>Description: 设置地址</p>
     * @param newValue 地址
     */
    public void setAddress(String newValue) {
        this.address = newValue;
    }

    /**
     * <p>Description: 获取地址</p>
     * @return 地址
     */
    public String getAddress() {
        return this.address;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.code);
        LIST.add(this.userId);
        LIST.add(this.agentId);
        LIST.add(this.customerId);
        LIST.add(this.serviceCenterId);
        LIST.add(this.machineId);
        LIST.add(this.serviceType);
        LIST.add(this.comments);
        LIST.add(this.runStateId);
        LIST.add(this.workOrderFlowId);
        LIST.add(this.latitude);
        LIST.add(this.longitude);
        LIST.add(this.arrivedTime);
        LIST.add(this.status);
        LIST.add(this.contact);
        LIST.add(this.contactTel);
        LIST.add(this.provinceId);
        LIST.add(this.cityId);
        LIST.add(this.countyId);
        LIST.add(this.address);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.code = rs.getString("CODE");
        this.userId = makeLongValue(rs, "USER_ID");
        this.agentId = makeLongValue(rs, "AGENT_ID");
        this.customerId = makeLongValue(rs, "CUSTOMER_ID");
        this.serviceCenterId = makeLongValue(rs, "SERVICE_CENTER_ID");
        this.machineId = makeLongValue(rs, "MACHINE_ID");
        this.serviceType = rs.getString("SERVICE_TYPE");
        this.comments = rs.getString("COMMENTS");
        this.runStateId = makeLongValue(rs, "RUN_STATE_ID");
        this.workOrderFlowId = makeLongValue(rs, "WORK_ORDER_FLOW_ID");
        this.latitude = rs.getBigDecimal("LATITUDE");
        this.longitude = rs.getBigDecimal("LONGITUDE");
        this.arrivedTime = rs.getTimestamp("ARRIVED_TIME");
        this.status = rs.getString("STATUS");
        this.contact = rs.getString("CONTACT");
        this.contactTel = rs.getString("CONTACT_TEL");
        this.provinceId = makeLongValue(rs, "PROVINCE_ID");
        this.cityId = makeLongValue(rs, "CITY_ID");
        this.countyId = makeLongValue(rs, "COUNTY_ID");
        this.address = rs.getString("ADDRESS");

    }
}

