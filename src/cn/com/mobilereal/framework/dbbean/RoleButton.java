/**
 * RoleButton.java
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
import cn.com.mobilereal.framework.dao.RoleButtonDao;

/**
 * 
 * <p>ClassName: RoleButton</p>
 * <p>Description: 系统角色到按钮权限Bean</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class RoleButton extends BaseBean {
    /**
     * dao
     */
    public static final RoleButtonDao I = new RoleButtonDao();
    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 按钮编码
     */
    private Long menuButtonId;

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
     * <p>Description: 设置按钮编码</p>
     * @param newValue 按钮编码
     */
    public void setMenuButtonId(Long newValue) {
        this.menuButtonId = newValue;
    }

    /**
     * <p>Description: 获取按钮编码</p>
     * @return 按钮编码
     */
    public Long getMenuButtonId() {
        return this.menuButtonId;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.roleId);
        LIST.add(this.menuButtonId);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.roleId = makeLongValue(rs, "ROLE_ID");
        this.menuButtonId = makeLongValue(rs, "MENU_BUTTON_ID");

    }
}

