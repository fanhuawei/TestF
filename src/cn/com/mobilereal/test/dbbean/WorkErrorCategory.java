/**
 * WorkErrorCategory.java
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

import cn.com.mobilereal.test.dao.WorkErrorCategoryDao;

/**
 * <p>ClassName: WorkErrorCategory</p>
 * <p>Description: 工单故障类别Bean类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class WorkErrorCategory extends BaseBean {
    /**
     * dao
     */
    public static final WorkErrorCategoryDao I = new WorkErrorCategoryDao();
    /**
     * 工单ID
     */
    private Long workOrderId;

    /**
     * 故障类别
     */
    private String category;

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
     * <p>Description: 设置故障类别</p>
     * @param newValue 故障类别
     */
    public void setCategory(String newValue) {
        this.category = newValue;
    }

    /**
     * <p>Description: 获取故障类别</p>
     * @return 故障类别
     */
    public String getCategory() {
        return this.category;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.workOrderId);
        LIST.add(this.category);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.workOrderId = makeLongValue(rs, "WORK_ORDER_ID");
        this.category = rs.getString("CATEGORY");

    }
}

