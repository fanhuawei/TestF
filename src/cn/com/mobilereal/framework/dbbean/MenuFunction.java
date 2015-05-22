/**
 * MenuFunction.java
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
import cn.com.mobilereal.framework.dao.MenuFunctionDao;


/**
 * 
 * <p>ClassName: MenuFunction</p>
 * <p>Description: 系统菜单及功能页面Bean</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class MenuFunction extends BaseBean {
    /**
     * dao
     */
    public static final MenuFunctionDao I = new MenuFunctionDao();
    /**
     * 名称
     */
    private String name;

    /**
     * 路径
     */
    private String path;

    /**
     * 功能实现类
     */
    private String actionClass;

    /**
     * 父菜单
     */
    private Long parentMenuId;

    /**
     * 是否是功能页面  Y:是 N:否
     */
    private String functionFlag;

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
     * <p>Description: 设置路径</p>
     * @param newValue 路径
     */
    public void setPath(String newValue) {
        this.path = newValue;
    }

    /**
     * <p>Description: 获取路径</p>
     * @return 路径
     */
    public String getPath() {
        return this.path;
    }

    /**
     * <p>Description: 设置功能实现类</p>
     * @param newValue 功能实现类
     */
    public void setActionClass(String newValue) {
        this.actionClass = newValue;
    }

    /**
     * <p>Description: 获取功能实现类</p>
     * @return 功能实现类
     */
    public String getActionClass() {
        return this.actionClass;
    }

    /**
     * <p>Description: 设置父菜单</p>
     * @param newValue 父菜单
     */
    public void setParentMenuId(Long newValue) {
        this.parentMenuId = newValue;
    }

    /**
     * <p>Description: 获取父菜单</p>
     * @return 父菜单
     */
    public Long getParentMenuId() {
        return this.parentMenuId;
    }

    /**
     * <p>Description: 设置是否是功能页面  Y:是 N:否</p>
     * @param newValue 是否是功能页面  Y:是 N:否
     */
    public void setFunctionFlag(String newValue) {
        this.functionFlag = newValue;
    }

    /**
     * <p>Description: 获取是否是功能页面  Y:是 N:否</p>
     * @return 是否是功能页面  Y:是 N:否
     */
    public String getFunctionFlag() {
        return this.functionFlag;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.name);
        LIST.add(this.path);
        LIST.add(this.actionClass);
        LIST.add(this.parentMenuId);
        LIST.add(this.functionFlag);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.name = rs.getString("NAME");
        this.path = rs.getString("PATH");
        this.actionClass = rs.getString("ACTION_CLASS");
        this.parentMenuId = makeLongValue(rs, "PARENT_MENU_ID");
        this.functionFlag = rs.getString("FUNCTION_FLAG");

    }
}

