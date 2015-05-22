/**
 * PartBase.java
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

import cn.com.mobilereal.test.dao.PartBaseDao;

/**
 * <p>ClassName: PartBase</p>
 * <p>Description: 配件库Bean类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class PartBase extends BaseBean {
    /**
     * dao
     */
    public static final PartBaseDao I = new PartBaseDao();
    /**
     * 名称
     */
    private String name;

    /**
     * 编码
     */
    private String code;

    /**
     * 规格
     */
    private String spec;

    /**
     * 货币
     */
    private String currency;

    /**
     * 价格
     */
    private java.math.BigDecimal price;

    /**
     * 单位
     */
    private String unit;

    /**
     * 分组
     */
    private String grp;

    /**
     * 数量
     */
    private Long amount;

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
     * <p>Description: 设置规格</p>
     * @param newValue 规格
     */
    public void setSpec(String newValue) {
        this.spec = newValue;
    }

    /**
     * <p>Description: 获取规格</p>
     * @return 规格
     */
    public String getSpec() {
        return this.spec;
    }

    /**
     * <p>Description: 设置货币</p>
     * @param newValue 货币
     */
    public void setCurrency(String newValue) {
        this.currency = newValue;
    }

    /**
     * <p>Description: 获取货币</p>
     * @return 货币
     */
    public String getCurrency() {
        return this.currency;
    }

    /**
     * <p>Description: 设置价格</p>
     * @param newValue 价格
     */
    public void setPrice(java.math.BigDecimal newValue) {
        this.price = newValue;
    }

    /**
     * <p>Description: 获取价格</p>
     * @return 价格
     */
    public java.math.BigDecimal getPrice() {
        return this.price;
    }

    /**
     * <p>Description: 设置单位</p>
     * @param newValue 单位
     */
    public void setUnit(String newValue) {
        this.unit = newValue;
    }

    /**
     * <p>Description: 获取单位</p>
     * @return 单位
     */
    public String getUnit() {
        return this.unit;
    }

    /**
     * <p>Description: 设置分组</p>
     * @param newValue 分组
     */
    public void setGrp(String newValue) {
        this.grp = newValue;
    }

    /**
     * <p>Description: 获取分组</p>
     * @return 分组
     */
    public String getGrp() {
        return this.grp;
    }

    /**
     * <p>Description: 设置数量</p>
     * @param newValue 数量
     */
    public void setAmount(Long newValue) {
        this.amount = newValue;
    }

    /**
     * <p>Description: 获取数量</p>
     * @return 数量
     */
    public Long getAmount() {
        return this.amount;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.name);
        LIST.add(this.code);
        LIST.add(this.spec);
        LIST.add(this.currency);
        LIST.add(this.price);
        LIST.add(this.unit);
        LIST.add(this.grp);
        LIST.add(this.amount);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.name = rs.getString("NAME");
        this.code = rs.getString("CODE");
        this.spec = rs.getString("SPEC");
        this.currency = rs.getString("CURRENCY");
        this.price = rs.getBigDecimal("PRICE");
        this.unit = rs.getString("UNIT");
        this.grp = rs.getString("GRP");
        this.amount = makeLongValue(rs, "AMOUNT");

    }
}

