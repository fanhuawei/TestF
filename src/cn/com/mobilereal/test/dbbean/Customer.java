/**
 * Customer.java
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

import cn.com.mobilereal.test.dao.CustomerDao;

/**
 * <p>ClassName: Customer</p>
 * <p>Description: 客户Bean类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class Customer extends BaseBean {
    /**
     * dao
     */
    public static final CustomerDao I = new CustomerDao();
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
     * 联系人1邮箱
     */
    private String email1;

    /**
     * 联系人2
     */
    private String contact2;

    /**
     * 联系人2电话
     */
    private String mobile2;

    /**
     * 联系人2邮箱
     */
    private String email2;

    /**
     * [TITLE1]
     */
    private String title1;

    /**
     * [TITLE2]
     */
    private String title2;

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
     * <p>Description: 设置联系人1邮箱</p>
     * @param newValue 联系人1邮箱
     */
    public void setEmail1(String newValue) {
        this.email1 = newValue;
    }

    /**
     * <p>Description: 获取联系人1邮箱</p>
     * @return 联系人1邮箱
     */
    public String getEmail1() {
        return this.email1;
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
     * <p>Description: 设置联系人2邮箱</p>
     * @param newValue 联系人2邮箱
     */
    public void setEmail2(String newValue) {
        this.email2 = newValue;
    }

    /**
     * <p>Description: 获取联系人2邮箱</p>
     * @return 联系人2邮箱
     */
    public String getEmail2() {
        return this.email2;
    }

    /**
     * <p>Description: 设置[TITLE1]</p>
     * @param newValue [TITLE1]
     */
    public void setTitle1(String newValue) {
        this.title1 = newValue;
    }

    /**
     * <p>Description: 获取[TITLE1]</p>
     * @return [TITLE1]
     */
    public String getTitle1() {
        return this.title1;
    }

    /**
     * <p>Description: 设置[TITLE2]</p>
     * @param newValue [TITLE2]
     */
    public void setTitle2(String newValue) {
        this.title2 = newValue;
    }

    /**
     * <p>Description: 获取[TITLE2]</p>
     * @return [TITLE2]
     */
    public String getTitle2() {
        return this.title2;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.oldId);
        LIST.add(this.shortName);
        LIST.add(this.name);
        LIST.add(this.profession);
        LIST.add(this.region);
        LIST.add(this.provinceId);
        LIST.add(this.cityId);
        LIST.add(this.countyId);
        LIST.add(this.address);
        LIST.add(this.zip);
        LIST.add(this.tel);
        LIST.add(this.email);
        LIST.add(this.fax);
        LIST.add(this.contact1);
        LIST.add(this.mobile1);
        LIST.add(this.email1);
        LIST.add(this.contact2);
        LIST.add(this.mobile2);
        LIST.add(this.email2);
        LIST.add(this.title1);
        LIST.add(this.title2);
        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.oldId = makeLongValue(rs, "OLD_ID");
        this.shortName = rs.getString("SHORT_NAME");
        this.name = rs.getString("NAME");
        this.profession = rs.getString("PROFESSION");
        this.region = rs.getString("REGION");
        this.provinceId = makeLongValue(rs, "PROVINCE_ID");
        this.cityId = makeLongValue(rs, "CITY_ID");
        this.countyId = makeLongValue(rs, "COUNTY_ID");
        this.address = rs.getString("ADDRESS");
        this.zip = rs.getString("ZIP");
        this.tel = rs.getString("TEL");
        this.email = rs.getString("EMAIL");
        this.fax = rs.getString("FAX");
        this.contact1 = rs.getString("CONTACT1");
        this.mobile1 = rs.getString("MOBILE1");
        this.email1 = rs.getString("EMAIL1");
        this.contact2 = rs.getString("CONTACT2");
        this.mobile2 = rs.getString("MOBILE2");
        this.email2 = rs.getString("EMAIL2");
        this.title1 = rs.getString("TITLE1");
        this.title2 = rs.getString("TITLE2");
    }
}

