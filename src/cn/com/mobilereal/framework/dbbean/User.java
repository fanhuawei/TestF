/**
 * User.java
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
import cn.com.mobilereal.framework.dao.UserDao;

/**
 * 
 * <p>ClassName: User</p>
 * <p>Description: 系统用户Bean</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class User extends BaseBean {
    /**
     * dao
     */
    public static final UserDao I = new UserDao();
    /**
     * 名称
     */
    private String name;

    /**
     * 登录名
     */
    private String code;

    /**
     * 登录密码
     */
    private String loginPass;

    /**
     * 部门
     */
    private Long deptId;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 角色
     */
    private Long roleId;

    /**
     * 代班帐号ID
     */
    private Long coverAccountId;

    /**
     * 有效标记
     */
    private String validFlag;

    /**
     * 移动端显示ICON
     */
    private Long headImg;

    /**
     * 是否首席
     */
    private String primaryFlag;

    /**
     * 代理商ID
     */
    private Long agentId;

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
     * <p>Description: 设置登录名</p>
     * @param newValue 登录名
     */
    public void setCode(String newValue) {
        this.code = newValue;
    }

    /**
     * <p>Description: 获取登录名</p>
     * @return 登录名
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
    public void setDeptId(Long newValue) {
        this.deptId = newValue;
    }

    /**
     * <p>Description: 获取部门</p>
     * @return 部门
     */
    public Long getDeptId() {
        return this.deptId;
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

    /**
     * <p>Description: 设置角色</p>
     * @param newValue 角色
     */
    public void setRoleId(Long newValue) {
        this.roleId = newValue;
    }

    /**
     * <p>Description: 获取角色</p>
     * @return 角色
     */
    public Long getRoleId() {
        return this.roleId;
    }

    /**
     * <p>Description: 设置代班帐号ID</p>
     * @param newValue 代班帐号ID
     */
    public void setCoverAccountId(Long newValue) {
        this.coverAccountId = newValue;
    }

    /**
     * <p>Description: 获取代班帐号ID</p>
     * @return 代班帐号ID
     */
    public Long getCoverAccountId() {
        return this.coverAccountId;
    }

    /**
     * <p>Description: 设置有效标记</p>
     * @param newValue 有效标记
     */
    public void setValidFlag(String newValue) {
        this.validFlag = newValue;
    }

    /**
     * <p>Description: 获取有效标记</p>
     * @return 有效标记
     */
    public String getValidFlag() {
        return this.validFlag;
    }

    /**
     * <p>Description: 设置移动端显示ICON</p>
     * @param newValue 移动端显示ICON
     */
    public void setHeadImg(Long newValue) {
        this.headImg = newValue;
    }

    /**
     * <p>Description: 获取移动端显示ICON</p>
     * @return 移动端显示ICON
     */
    public Long getHeadImg() {
        return this.headImg;
    }

    /**
     * <p>Description: 设置是否首席</p>
     * @param newValue 是否首席
     */
    public void setPrimaryFlag(String newValue) {
        this.primaryFlag = newValue;
    }

    /**
     * <p>Description: 获取是否首席</p>
     * @return 是否首席
     */
    public String getPrimaryFlag() {
        return this.primaryFlag;
    }

    /**
     * <p>Description: 设置代理商ID</p>
     * @param newValue 代理商ID
     */
    public void setAgentId(Long newValue) {
        this.agentId = newValue;
    }

    /**
     * <p>Description: 获取代理商ID</p>
     * @return 代理商ID
     */
    public Long getAgentId() {
        return this.agentId;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.name);
        LIST.add(this.code);
        LIST.add(this.loginPass);
        LIST.add(this.deptId);
        LIST.add(this.phone);
        LIST.add(this.email);
        LIST.add(this.roleId);
        LIST.add(this.coverAccountId);
        LIST.add(this.validFlag);
        LIST.add(this.headImg);
        LIST.add(this.primaryFlag);
        LIST.add(this.agentId);
        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.name = rs.getString("NAME");
        this.code = rs.getString("CODE");
        this.loginPass = rs.getString("LOGIN_PASS");
        this.deptId = makeLongValue(rs, "DEPT_ID");
        this.phone = rs.getString("PHONE");
        this.email = rs.getString("EMAIL");
        this.roleId = makeLongValue(rs, "ROLE_ID");
        this.coverAccountId = makeLongValue(rs, "COVER_ACCOUNT_ID");
        this.validFlag = rs.getString("VALID_FLAG");
        this.headImg = makeLongValue(rs, "HEAD_IMG");
        this.primaryFlag = rs.getString("PRIMARY_FLAG");
        this.agentId = makeLongValue(rs, "AGENT_ID");
    }
}

