/**
 * RoleShortCut.java
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
import cn.com.mobilereal.framework.dao.RoleShortCutDao;

/**
 * 
 * <p>ClassName: RoleShortCut</p>
 * <p>Description: 角色的快捷方式信息Bean</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class RoleShortCut extends BaseBean {
    /**
     * dao
     */
    public static final RoleShortCutDao I = new RoleShortCutDao();
    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 快捷方式ID
     */
    private Long shortCutId;

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
     * <p>Description: 设置快捷方式ID</p>
     * @param newValue 快捷方式ID
     */
    public void setShortCutId(Long newValue) {
        this.shortCutId = newValue;
    }

    /**
     * <p>Description: 获取快捷方式ID</p>
     * @return 快捷方式ID
     */
    public Long getShortCutId() {
        return this.shortCutId;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.roleId);
        LIST.add(this.shortCutId);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.roleId = makeLongValue(rs, "ROLE_ID");
        this.shortCutId = makeLongValue(rs, "SHORT_CUT_ID");

    }
}

