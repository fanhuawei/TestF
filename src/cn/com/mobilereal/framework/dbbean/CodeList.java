/**
 * CodeList.java
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
import cn.com.mobilereal.framework.dao.CodeListDao;

/**
 * 
 * <p>ClassName: CodeList</p>
 * <p>Description: 数据字典主表Bean</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class CodeList extends BaseBean {
    /**
     * dao
     */
    public static final CodeListDao I = new CodeListDao();
    /**
     * 数据编码
     */
    private String code;

    /**
     * 数据名称
     */
    private String name;

    /**
     * 是否系统配置Y:是 N:否
     */
    private String flag;

    /**
     * 上一级ID
     */
    private Long parentId;

    /**
     * 描述
     */
    private String comments;

    /**
     * <p>Description: 设置数据编码</p>
     * @param newValue 数据编码
     */
    public void setCode(String newValue) {
        this.code = newValue;
    }

    /**
     * <p>Description: 获取数据编码</p>
     * @return 数据编码
     */
    public String getCode() {
        return this.code;
    }

    /**
     * <p>Description: 设置数据名称</p>
     * @param newValue 数据名称
     */
    public void setName(String newValue) {
        this.name = newValue;
    }

    /**
     * <p>Description: 获取数据名称</p>
     * @return 数据名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * <p>Description: 设置是否系统配置Y:是 N:否</p>
     * @param newValue 是否系统配置Y:是 N:否
     */
    public void setFlag(String newValue) {
        this.flag = newValue;
    }

    /**
     * <p>Description: 获取是否系统配置Y:是 N:否</p>
     * @return 是否系统配置Y:是 N:否
     */
    public String getFlag() {
        return this.flag;
    }

    /**
     * <p>Description: 设置上一级ID</p>
     * @param newValue 上一级ID
     */
    public void setParentId(Long newValue) {
        this.parentId = newValue;
    }

    /**
     * <p>Description: 获取上一级ID</p>
     * @return 上一级ID
     */
    public Long getParentId() {
        return this.parentId;
    }

    /**
     * <p>Description: 设置描述</p>
     * @param newValue 描述
     */
    public void setComments(String newValue) {
        this.comments = newValue;
    }

    /**
     * <p>Description: 获取描述</p>
     * @return 描述
     */
    public String getComments() {
        return this.comments;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.code);
        LIST.add(this.name);
        LIST.add(this.flag);
        LIST.add(this.parentId);
        LIST.add(this.comments);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.code = rs.getString("CODE");
        this.name = rs.getString("NAME");
        this.flag = rs.getString("FLAG");
        this.parentId = makeLongValue(rs, "PARENT_ID");
        this.comments = rs.getString("COMMENTS");

    }
}

