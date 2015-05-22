/**
 * UserRole.java
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
import cn.com.mobilereal.framework.dao.UserRoleDao;

/**
 * 
 * <p>ClassName: UserRole</p>
 * <p>Description: 系统用户角色对应表Bean</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class UserRole extends BaseBean {
    /**
     * dao
     */
    public static final UserRoleDao I = new UserRoleDao();
    /**
     * 名称
     */
    private Long userId;

    /**
     * 名称
     */
    private Long roleId;

    /**
     * <p>Description: 设置名称</p>
     * @param newValue 名称
     */
    public void setUserId(Long newValue) {
        this.userId = newValue;
    }

    /**
     * <p>Description: 获取名称</p>
     * @return 名称
     */
    public Long getUserId() {
        return this.userId;
    }

    /**
     * <p>Description: 设置名称</p>
     * @param newValue 名称
     */
    public void setRoleId(Long newValue) {
        this.roleId = newValue;
    }

    /**
     * <p>Description: 获取名称</p>
     * @return 名称
     */
    public Long getRoleId() {
        return this.roleId;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.userId);
        LIST.add(this.roleId);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.userId = makeLongValue(rs, "USER_ID");
        this.roleId = makeLongValue(rs, "ROLE_ID");

    }
}

