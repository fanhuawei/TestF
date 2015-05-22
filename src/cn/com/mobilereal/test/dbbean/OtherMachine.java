/**
 * OtherMachine.java
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

import cn.com.mobilereal.test.dao.OtherMachineDao;

/**
 * <p>ClassName: OtherMachine</p>
 * <p>Description: 客户其它厂家机器Bean类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class OtherMachine extends BaseBean {
    /**
     * dao
     */
    public static final OtherMachineDao I = new OtherMachineDao();
    /**
     * 客户ID
     */
    private Long customerId;

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
     * 机器供应商
     */
    private String supplier;

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
     * <p>Description: 设置机器供应商</p>
     * @param newValue 机器供应商
     */
    public void setSupplier(String newValue) {
        this.supplier = newValue;
    }

    /**
     * <p>Description: 获取机器供应商</p>
     * @return 机器供应商
     */
    public String getSupplier() {
        return this.supplier;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.customerId);
        LIST.add(this.type);
        LIST.add(this.model);
        LIST.add(this.serialNo);
        LIST.add(this.supplier);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.customerId = makeLongValue(rs, "CUSTOMER_ID");
        this.type = rs.getString("TYPE");
        this.model = rs.getString("MODEL");
        this.serialNo = rs.getString("SERIAL_NO");
        this.supplier = rs.getString("SUPPLIER");

    }
}

