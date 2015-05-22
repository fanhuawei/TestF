/**
 * Agent.java
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

import cn.com.mobilereal.test.dao.AgentDao;

/**
 * <p>ClassName: Agent</p>
 * <p>Description: 代理商Bean类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class Agent extends BaseBean {
    /**
     * dao
     */
    public static final AgentDao I = new AgentDao();
    /**
     * 老系统ID
     */
    private Long oldId;

    /**
     * 简称
     */
    private String shortName;

    /**
     * 名称
     */
    private String name;

    /**
     * 简称拼音
     */
    private String pingYing;

    /**
     * 等级
     */
    private String grade;

    /**
     * 行业
     */
    private String profession;

    /**
     * 区域
     */
    private String region;

    /**
     * 省份
     */
    private Long provinceId;

    /**
     * 责任销售
     */
    private String saleManager;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮编
     */
    private String zip;

    /**
     * 电话
     */
    private String tel;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 传真
     */
    private String fax;

    /**
     * 联系人1
     */
    private String contact1;

    /**
     * 联系人1电话
     */
    private String mobile1;

    /**
     * 联系人2
     */
    private String contact2;

    /**
     * 联系人2电话
     */
    private String mobile2;

    /**
     * 售后联系人
     */
    private String customerService;

    /**
     * 售后联系人电话
     */
    private String customerServiceMobile;

    /**
     * 售后联系邮箱
     */
    private String customerServiceEmail;

    /**
     * 主管ID
     */
    private Long leaderId;

    /**
     * <p>Description: 设置老系统ID</p>
     * @param newValue 老系统ID
     */
    public void setOldId(Long newValue) {
        this.oldId = newValue;
    }

    /**
     * <p>Description: 获取老系统ID</p>
     * @return 老系统ID
     */
    public Long getOldId() {
        return this.oldId;
    }

    /**
     * <p>Description: 设置简称</p>
     * @param newValue 简称
     */
    public void setShortName(String newValue) {
        this.shortName = newValue;
    }

    /**
     * <p>Description: 获取简称</p>
     * @return 简称
     */
    public String getShortName() {
        return this.shortName;
    }

    /**
     * <p>Description: 设置名称</p>
     * @param newValue 名称
     */
    public void setName(String newValue) {
        this.name = newValue;
    }

    /**
     * <p>Description: 获取名称</p>
     * @return 名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * <p>Description: 设置简称拼音</p>
     * @param newValue 简称拼音
     */
    public void setPingYing(String newValue) {
        this.pingYing = newValue;
    }

    /**
     * <p>Description: 获取简称拼音</p>
     * @return 简称拼音
     */
    public String getPingYing() {
        return this.pingYing;
    }

    /**
     * <p>Description: 设置等级</p>
     * @param newValue 等级
     */
    public void setGrade(String newValue) {
        this.grade = newValue;
    }

    /**
     * <p>Description: 获取等级</p>
     * @return 等级
     */
    public String getGrade() {
        return this.grade;
    }

    /**
     * <p>Description: 设置行业</p>
     * @param newValue 行业
     */
    public void setProfession(String newValue) {
        this.profession = newValue;
    }

    /**
     * <p>Description: 获取行业</p>
     * @return 行业
     */
    public String getProfession() {
        return this.profession;
    }

    /**
     * <p>Description: 设置区域</p>
     * @param newValue 区域
     */
    public void setRegion(String newValue) {
        this.region = newValue;
    }

    /**
     * <p>Description: 获取区域</p>
     * @return 区域
     */
    public String getRegion() {
        return this.region;
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
     * <p>Description: 设置责任销售</p>
     * @param newValue 责任销售
     */
    public void setSaleManager(String newValue) {
        this.saleManager = newValue;
    }

    /**
     * <p>Description: 获取责任销售</p>
     * @return 责任销售
     */
    public String getSaleManager() {
        return this.saleManager;
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

    /**
     * <p>Description: 设置邮编</p>
     * @param newValue 邮编
     */
    public void setZip(String newValue) {
        this.zip = newValue;
    }

    /**
     * <p>Description: 获取邮编</p>
     * @return 邮编
     */
    public String getZip() {
        return this.zip;
    }

    /**
     * <p>Description: 设置电话</p>
     * @param newValue 电话
     */
    public void setTel(String newValue) {
        this.tel = newValue;
    }

    /**
     * <p>Description: 获取电话</p>
     * @return 电话
     */
    public String getTel() {
        return this.tel;
    }

    /**
     * <p>Description: 设置邮箱</p>
     * @param newValue 邮箱
     */
    public void setEmail(String newValue) {
        this.email = newValue;
    }

    /**
     * <p>Description: 获取邮箱</p>
     * @return 邮箱
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * <p>Description: 设置传真</p>
     * @param newValue 传真
     */
    public void setFax(String newValue) {
        this.fax = newValue;
    }

    /**
     * <p>Description: 获取传真</p>
     * @return 传真
     */
    public String getFax() {
        return this.fax;
    }

    /**
     * <p>Description: 设置联系人1</p>
     * @param newValue 联系人1
     */
    public void setContact1(String newValue) {
        this.contact1 = newValue;
    }

    /**
     * <p>Description: 获取联系人1</p>
     * @return 联系人1
     */
    public String getContact1() {
        return this.contact1;
    }

    /**
     * <p>Description: 设置联系人1电话</p>
     * @param newValue 联系人1电话
     */
    public void setMobile1(String newValue) {
        this.mobile1 = newValue;
    }

    /**
     * <p>Description: 获取联系人1电话</p>
     * @return 联系人1电话
     */
    public String getMobile1() {
        return this.mobile1;
    }

    /**
     * <p>Description: 设置联系人2</p>
     * @param newValue 联系人2
     */
    public void setContact2(String newValue) {
        this.contact2 = newValue;
    }

    /**
     * <p>Description: 获取联系人2</p>
     * @return 联系人2
     */
    public String getContact2() {
        return this.contact2;
    }

    /**
     * <p>Description: 设置联系人2电话</p>
     * @param newValue 联系人2电话
     */
    public void setMobile2(String newValue) {
        this.mobile2 = newValue;
    }

    /**
     * <p>Description: 获取联系人2电话</p>
     * @return 联系人2电话
     */
    public String getMobile2() {
        return this.mobile2;
    }

    /**
     * <p>Description: 设置售后联系人</p>
     * @param newValue 售后联系人
     */
    public void setCustomerService(String newValue) {
        this.customerService = newValue;
    }

    /**
     * <p>Description: 获取售后联系人</p>
     * @return 售后联系人
     */
    public String getCustomerService() {
        return this.customerService;
    }

    /**
     * <p>Description: 设置售后联系人电话</p>
     * @param newValue 售后联系人电话
     */
    public void setCustomerServiceMobile(String newValue) {
        this.customerServiceMobile = newValue;
    }

    /**
     * <p>Description: 获取售后联系人电话</p>
     * @return 售后联系人电话
     */
    public String getCustomerServiceMobile() {
        return this.customerServiceMobile;
    }

    /**
     * <p>Description: 设置售后联系邮箱</p>
     * @param newValue 售后联系邮箱
     */
    public void setCustomerServiceEmail(String newValue) {
        this.customerServiceEmail = newValue;
    }

    /**
     * <p>Description: 获取售后联系邮箱</p>
     * @return 售后联系邮箱
     */
    public String getCustomerServiceEmail() {
        return this.customerServiceEmail;
    }

    /**
     * <p>Description: 设置主管ID</p>
     * @param newValue 主管ID
     */
    public void setLeaderId(Long newValue) {
        this.leaderId = newValue;
    }

    /**
     * <p>Description: 获取主管ID</p>
     * @return 主管ID
     */
    public Long getLeaderId() {
        return this.leaderId;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.oldId);
        LIST.add(this.shortName);
        LIST.add(this.name);
        LIST.add(this.pingYing);
        LIST.add(this.grade);
        LIST.add(this.profession);
        LIST.add(this.region);
        LIST.add(this.provinceId);
        LIST.add(this.saleManager);
        LIST.add(this.address);
        LIST.add(this.zip);
        LIST.add(this.tel);
        LIST.add(this.email);
        LIST.add(this.fax);
        LIST.add(this.contact1);
        LIST.add(this.mobile1);
        LIST.add(this.contact2);
        LIST.add(this.mobile2);
        LIST.add(this.customerService);
        LIST.add(this.customerServiceMobile);
        LIST.add(this.customerServiceEmail);
        LIST.add(this.leaderId);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.oldId = makeLongValue(rs, "OLD_ID");
        this.shortName = rs.getString("SHORT_NAME");
        this.name = rs.getString("NAME");
        this.pingYing = rs.getString("PING_YING");
        this.grade = rs.getString("GRADE");
        this.profession = rs.getString("PROFESSION");
        this.region = rs.getString("REGION");
        this.provinceId = makeLongValue(rs, "PROVINCE_ID");
        this.saleManager = rs.getString("SALE_MANAGER");
        this.address = rs.getString("ADDRESS");
        this.zip = rs.getString("ZIP");
        this.tel = rs.getString("TEL");
        this.email = rs.getString("EMAIL");
        this.fax = rs.getString("FAX");
        this.contact1 = rs.getString("CONTACT1");
        this.mobile1 = rs.getString("MOBILE1");
        this.contact2 = rs.getString("CONTACT2");
        this.mobile2 = rs.getString("MOBILE2");
        this.customerService = rs.getString("CUSTOMER_SERVICE");
        this.customerServiceMobile = rs.getString("CUSTOMER_SERVICE_MOBILE");
        this.customerServiceEmail = rs.getString("CUSTOMER_SERVICE_EMAIL");
        this.leaderId = makeLongValue(rs, "LEADER_ID");

    }
}

