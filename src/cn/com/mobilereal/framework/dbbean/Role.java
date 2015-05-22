/**
 * Role.java
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
import cn.com.mobilereal.framework.dao.RoleDao;

/**
 * 
 * <p>ClassName: Role</p>
 * <p>Description: 系统角色Bean</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class Role extends BaseBean {
    /**
     * dao
     */
    public static final RoleDao I = new RoleDao();
    /**
     * 编号
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 系统标志
     */
    private String flag;

    /**
     * <p>Description: 设置编号</p>
     * @param newValue 编号
     */
    public void setCode(String newValue) {
        this.code = newValue;
    }

    /**
     * <p>Description: 获取编号</p>
     * @return 编号
     */
    public String getCode() {
        return this.code;
    }

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
     * <p>Description: 设置系统标志</p>
     * @param newValue 系统标志
     */
    public void setFlag(String newValue) {
        this.flag = newValue;
    }

    /**
     * <p>Description: 获取系统标志</p>
     * @return 系统标志
     */
    public String getFlag() {
        return this.flag;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.code);
        LIST.add(this.name);
        LIST.add(this.flag);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.code = rs.getString("CODE");
        this.name = rs.getString("NAME");
        this.flag = rs.getString("FLAG");

    }
}

