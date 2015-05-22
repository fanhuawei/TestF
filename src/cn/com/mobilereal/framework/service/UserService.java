/**
 * UserService.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.service;

import java.util.List;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ConstUtil;
import cn.com.mobilereal.common.util.PageBean;
import cn.com.mobilereal.common.util.SQLUtil;
import cn.com.mobilereal.common.util.ServiceFactory;
import cn.com.mobilereal.common.util.StringUtil;
import cn.com.mobilereal.common.web.BusinessException;
import cn.com.mobilereal.framework.dbbean.Role;
import cn.com.mobilereal.framework.dbbean.User;
/**
 * 
 * <p>ClassName: UserService</p>
 * <p>Description: 系统用户管理的业务类</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date:2014-10-16</p>
 */
@SuppressWarnings("serial")
public class UserService extends BaseCrudService<User> {
    /**
     * 实例
     */
    public static final UserService I = ServiceFactory.makeService(UserService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public UserService() {
       super(User.I, User.class);
    }

    @Override
    public void save(User t) {
        checkNull(t);
        checkCode(t);
        checkMobile(t);
        checkEmail(t);
        super.save(t);
    }
    
    public void checkNull(User t){
        if (StringUtil.isEmpty(t.getName())){
            throw new BusinessException("名称不能为空");
        }   
        if (StringUtil.isEmpty(t.getCode())) {
            throw new BusinessException("登录名不能为空");
        }        
        if (StringUtil.isEmpty(t.getLoginPass())){
            throw new BusinessException("密码不能为空");
        } 
    }
    
    private void checkCode(User user) {

        SQLUtil sql = SQLUtil.start("WHERE DELETE_MARK=?", ConstUtil.FLAG.NO);
        sql.eq("CODE", user.getCode()).ne("ID", user.getId());
        int cnt = dao.countByWhere(sql.getSql(), sql.getArgu().toArray());
        if (cnt > 0) {
            throw new BusinessException("登录名已有人使用，不能提交");
        }
    }

    private void checkMobile(User user) {
        if (StringUtil.isEmpty(user.getPhone())) {
            return;
        }
        SQLUtil sql = SQLUtil.start("WHERE DELETE_MARK=?", ConstUtil.FLAG.NO);
        sql.eq("PHONE", user.getPhone()).ne("ID", user.getId());
        int cnt = dao.countByWhere(sql.getSql(), sql.getArgu().toArray());
        if (cnt > 0) {
            throw new BusinessException("电话已有人使用，不能提交");
        }
    }

    private void checkEmail(User user) {
        if (StringUtil.isEmpty(user.getEmail())) {
            return;
        }
        SQLUtil sql = SQLUtil.start("WHERE DELETE_MARK=?", ConstUtil.FLAG.NO);
        sql.eq("EMAIL", user.getEmail()).ne("ID", user.getId());
        int cnt = dao.countByWhere(sql.getSql(), sql.getArgu().toArray());
        if (cnt > 0) {
            throw new BusinessException("邮箱已有人使用，不能提交");
        }
    }

    @Override
    public PageBean searchByExample(int pageNo, int pageSize, User filter) {
        return searchByExample(pageNo, pageSize, filter, null);
    }

    public PageBean searchByExample(int pageNo, int pageSize, User filter,List<Role> roleList) {
        SQLUtil util = SQLUtil.start("WHERE A.DELETE_MARK=? AND A.VALID_FLAG=?", ConstUtil.FLAG.NO,ConstUtil.FLAG.YES);
        if (roleList != null) {
            int size = roleList.size();            
            if (size > 0) {
                util.appendSQL(" AND A.ROLE_ID IN (").appendSQL(SQLUtil.makeQuestionMark(size)).appendSQL(")");
                for (Role role : roleList) {
                    util.addArgu(role.getId());
                }
            }
        }
        if (filter != null) {
             util.eq("A.ROLE_ID", filter.getRoleId());
             util.eq("A.DEPT_ID", filter.getDeptId());
             util.eq("A.AGENT_ID", filter.getAgentId());
             util.eq("A.ROLE_ID", filter.getRoleId());
            if (!StringUtil.isEmpty(filter.getKeyword())) {
                String condi = "%" + filter.getKeyword() + "%";
                util.multiCond("AND (A.NAME LIKE ? OR A.CODE LIKE ? OR A.PHONE LIKE ? OR A.EMAIL LIKE ?)", condi, condi, condi, condi);
            }
        }
        util.appendSQL("ORDER BY CONVERT(A.NAME USING gbk)");
        return searchByWhere(pageNo, pageSize, util.getSql(), util.getArgu().toArray());
    }   
}
