/**
 * PartUsage.java
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

import cn.com.mobilereal.test.dao.PartUsageDao;

/**
 * <p>ClassName: PartUsage</p>
 * <p>Description: 配件使用Bean类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class PartUsage extends BaseBean {
    /**
     * dao
     */
    public static final PartUsageDao I = new PartUsageDao();
    /**
     * 配件ID
     */
    private Long partId;

    /**
     * 工单ID
     */
    private Long workOrderId;

    /**
     * 价格
     */
    private java.math.BigDecimal price;

    /**
     * 数量
     */
    private Long amount;

    /**
     * <p>Description: 设置配件ID</p>
     * @param newValue 配件ID
     */
    public void setPartId(Long newValue) {
        this.partId = newValue;
    }

    /**
     * <p>Description: 获取配件ID</p>
     * @return 配件ID
     */
    public Long getPartId() {
        return this.partId;
    }

    /**
     * <p>Description: 设置工单ID</p>
     * @param newValue 工单ID
     */
    public void setWorkOrderId(Long newValue) {
        this.workOrderId = newValue;
    }

    /**
     * <p>Description: 获取工单ID</p>
     * @return 工单ID
     */
    public Long getWorkOrderId() {
        return this.workOrderId;
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
        LIST.add(this.partId);
        LIST.add(this.workOrderId);
        LIST.add(this.price);
        LIST.add(this.amount);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.partId = makeLongValue(rs, "PART_ID");
        this.workOrderId = makeLongValue(rs, "WORK_ORDER_ID");
        this.price = rs.getBigDecimal("PRICE");
        this.amount = makeLongValue(rs, "AMOUNT");

    }
}

