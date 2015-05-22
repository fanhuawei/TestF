/**
 * Dept.java
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

import cn.com.mobilereal.test.dao.DeptDao;

/**
 * <p>ClassName: Dept</p>
 * <p>Description: 部门Bean类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class Dept extends BaseBean {
    /**
     * dao
     */
    public static final DeptDao I = new DeptDao();
    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮编
     */
    private String zip;

    /**
     * 主管ID
     */
    private Long leaderId;

    /**
     * 大区
     */
    private String region;

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
     * 电话
     */
    private String tel;

    /**
     * 传真
     */
    private String fax;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 联系人电话
     */
    private String contactPhone;

    /**
     * 联系人邮箱
     */
    private String contactEmail;

    /**
     * 类型 T:公司IT,C:公司服务中心 S:区域服务中心
     */
    private String type;

    /**
     * [SHORT_NAME]
     */
    private String shortName;

    /**
     * <p>Description: 设置编码</p>
     * @param newValue 编码
     */
    public void setCode(String newValue) {
        this.code = newValue;
    }

    /**
     * <p>Description: 获取编码</p>
     * @return 编码
     */
    public String getCode() {
        return this.code;
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

    /**
     * <p>Description: 设置大区</p>
     * @param newValue 大区
     */
    public void setRegion(String newValue) {
        this.region = newValue;
    }

    /**
     * <p>Description: 获取大区</p>
     * @return 大区
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
     * <p>Description: 设置联系人电话</p>
     * @param newValue 联系人电话
     */
    public void setContactPhone(String newValue) {
        this.contactPhone = newValue;
    }

    /**
     * <p>Description: 获取联系人电话</p>
     * @return 联系人电话
     */
    public String getContactPhone() {
        return this.contactPhone;
    }

    /**
     * <p>Description: 设置联系人邮箱</p>
     * @param newValue 联系人邮箱
     */
    public void setContactEmail(String newValue) {
        this.contactEmail = newValue;
    }

    /**
     * <p>Description: 获取联系人邮箱</p>
     * @return 联系人邮箱
     */
    public String getContactEmail() {
        return this.contactEmail;
    }

    /**
     * <p>Description: 设置类型 T:公司IT,C:公司服务中心 S:区域服务中心</p>
     * @param newValue 类型 T:公司IT,C:公司服务中心 S:区域服务中心
     */
    public void setType(String newValue) {
        this.type = newValue;
    }

    /**
     * <p>Description: 获取类型 T:公司IT,C:公司服务中心 S:区域服务中心</p>
     * @return 类型 T:公司IT,C:公司服务中心 S:区域服务中心
     */
    public String getType() {
        return this.type;
    }

    /**
     * <p>Description: 设置[SHORT_NAME]</p>
     * @param newValue [SHORT_NAME]
     */
    public void setShortName(String newValue) {
        this.shortName = newValue;
    }

    /**
     * <p>Description: 获取[SHORT_NAME]</p>
     * @return [SHORT_NAME]
     */
    public String getShortName() {
        return this.shortName;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.code);
        LIST.add(this.name);
        LIST.add(this.address);
        LIST.add(this.zip);
        LIST.add(this.leaderId);
        LIST.add(this.region);
        LIST.add(this.provinceId);
        LIST.add(this.cityId);
        LIST.add(this.countyId);
        LIST.add(this.tel);
        LIST.add(this.fax);
        LIST.add(this.email);
        LIST.add(this.contact);
        LIST.add(this.contactPhone);
        LIST.add(this.contactEmail);
        LIST.add(this.type);
        LIST.add(this.shortName);
        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.code = rs.getString("CODE");
        this.name = rs.getString("NAME");
        this.address = rs.getString("ADDRESS");
        this.zip = rs.getString("ZIP");
        this.leaderId = makeLongValue(rs, "LEADER_ID");
        this.region = rs.getString("REGION");
        this.provinceId = makeLongValue(rs, "PROVINCE_ID");
        this.cityId = makeLongValue(rs, "CITY_ID");
        this.countyId = makeLongValue(rs, "COUNTY_ID");
        this.tel = rs.getString("TEL");
        this.fax = rs.getString("FAX");
        this.email = rs.getString("EMAIL");
        this.contact = rs.getString("CONTACT");
        this.contactPhone = rs.getString("CONTACT_PHONE");
        this.contactEmail = rs.getString("CONTACT_EMAIL");
        this.type = rs.getString("TYPE");
        this.shortName = rs.getString("SHORT_NAME");
    }
}

