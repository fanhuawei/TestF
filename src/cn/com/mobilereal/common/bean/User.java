/**
 * User.java
 * Created at 2014-06-16
 * Created by Fanhuawei
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package cn.com.mobilereal.common.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.mobilereal.common.dao.BaseBean;

/**
 * 
 * <p>ClassName: User</p>
 * <p>Description: 系统用户Bean</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-06-16</p>
 */
@SuppressWarnings("serial")
public class User extends BaseBean {
    /**
     * 名称
     */
    protected String name;

    /**
     * 工号
     */
    protected String code;

    /**
     * 登录密码
     */
    protected String loginPass;

    /**
     * 部门
     */
    protected String dept;

    /**
     * 电话
     */
    protected String phone;

    /**
     * 邮箱
     */
    protected String email;
    /**
     * 角色id
     */
    protected Long roleId;
    
    
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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
     * <p>Description: 设置工号</p>
     * @param newValue 工号
     */
    public void setCode(String newValue) {
        this.code = newValue;
    }

    /**
     * <p>Description: 获取工号</p>
     * @return 工号
     */
    public String getCode() {
        return this.code;
    }

    /**
     * <p>Description: 设置登录密码</p>
     * @param newValue 登录密码
     */
    public void setLoginPass(String newValue) {
        this.loginPass = newValue;
    }

    /**
     * <p>Description: 获取登录密码</p>
     * @return 登录密码
     */
    public String getLoginPass() {
        return this.loginPass;
    }

    /**
     * <p>Description: 设置部门</p>
     * @param newValue 部门
     */
    public void setDept(String newValue) {
        this.dept = newValue;
    }

    /**
     * <p>Description: 获取部门</p>
     * @return 部门
     */
    public String getDept() {
        return this.dept;
    }

    /**
     * <p>Description: 设置电话</p>
     * @param newValue 电话
     */
    public void setPhone(String newValue) {
        this.phone = newValue;
    }

    /**
     * <p>Description: 获取电话</p>
     * @return 电话
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * <p>Description: 设置邮箱</p>
     * @param newValue 邮箱
     */
    public void setEmail(String newValue) {
        this.email = newValue;
    }

    /**
     * <p>Description: 获取邮箱</p>
     * @return 邮箱
     */
    public String getEmail() {
        return this.email;
    }

    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.name);
        LIST.add(this.code);
        LIST.add(this.loginPass);
        LIST.add(this.dept);
        LIST.add(this.phone);
        LIST.add(this.email);
        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.name = rs.getString("NAME");
        this.code = rs.getString("CODE");
        this.loginPass = rs.getString("LOGIN_PASS");
        this.dept = rs.getString("DEPT");
        this.phone = rs.getString("PHONE");
        this.email = rs.getString("EMAIL");
    }
}

