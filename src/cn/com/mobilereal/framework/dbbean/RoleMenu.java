/**
 * RoleMenu.java
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
import cn.com.mobilereal.framework.dao.RoleMenuDao;

/**
 * 
 * <p>ClassName: RoleMenu</p>
 * <p>Description: 系统角色权限Bean</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class RoleMenu extends BaseBean {
    /**
     * dao
     */
    public static final RoleMenuDao I = new RoleMenuDao();
    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * <p>Description: 设置角色ID</p>
     * @param newValue 角色ID
     */
    public void setRoleId(Long newValue) {
        this.roleId = newValue;
    }

    /**
     * <p>Description: 获取角色ID</p>
     * @return 角色ID
     */
    public Long getRoleId() {
        return this.roleId;
    }

    /**
     * <p>Description: 设置菜单ID</p>
     * @param newValue 菜单ID
     */
    public void setMenuId(Long newValue) {
        this.menuId = newValue;
    }

    /**
     * <p>Description: 获取菜单ID</p>
     * @return 菜单ID
     */
    public Long getMenuId() {
        return this.menuId;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.roleId);
        LIST.add(this.menuId);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.roleId = makeLongValue(rs, "ROLE_ID");
        this.menuId = makeLongValue(rs, "MENU_ID");

    }
}

