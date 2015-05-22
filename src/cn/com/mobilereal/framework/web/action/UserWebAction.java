/**
 * UserWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.web.action;


import java.util.ArrayList;
import java.util.List;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;
import cn.com.mobilereal.common.util.ConstUtil;
import cn.com.mobilereal.common.util.JSPFunction;
import cn.com.mobilereal.framework.dbbean.Role;
import cn.com.mobilereal.framework.dbbean.User;
import cn.com.mobilereal.framework.service.RoleService;
import cn.com.mobilereal.framework.service.UserRoleService;
import cn.com.mobilereal.framework.service.UserService;

/**
 * <p>ClassName: UserWebAction</p>
 * <p>Description: 系统用户管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class UserWebAction extends BaseCrudWebAction<User> {

    /**
     * 用户的所有角色id
     */
    private Long[] roleIdList;
    
    /**
     * <p>Description:角色列表</p>
     */
    private List<Role> roleList;
    
    /**
     * <p>Description: 构造方法</p>
     */
    public UserWebAction() {
        this.service = UserService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        this.roleList = RoleService.I.findCustomRoleList();
        if (log.isDebugEnabled()) {
            log.debug(roleList);
        }
        super.init();
    }
    
    
    
    
    @Override
    public void search() {
        pageBean = UserService.I.searchByExample(this.pageNo, this.pageSize,this.filter, roleList);
        List<Long> ridList = new ArrayList<Long>();
        List<User> beanList = makeSearchList();
        for (User bean : beanList) {
            if (bean.getRoleId()!=null){
               ridList.add(bean.getRoleId());
            }
        }
        JSPFunction.initRequest("ROLE", ridList.toArray());
    }

    @Override
    public void add() {
       if (roleList == null) {
          this.roleList = RoleService.I.findCustomRoleList();
       }
       super.add();
    }

    @Override
    public void edit() {
        if (roleList == null) {
            this.roleList = RoleService.I.findCustomRoleList();
         }
        super.edit();
    }

    @Override
    public void save() {
        bean.setValidFlag(ConstUtil.FLAG.YES);
        super.save();
        UserRoleService.I.saveUserAndRole(bean.getId(), new Long[]{bean.getRoleId()});
    }

    /**
     * <p>Description: 为用户更新角色</p>
     */
    public void updateRole() {
        UserRoleService.I.saveUserAndRole(bean.getId(), roleIdList);
    }
    
    /**
     * <p>Description: 为用户更新角色</p>
     */
    public void assignRole() {
        edit();
        this.roleList = RoleService.I.findRoleList();
        this.roleIdList = UserRoleService.I.makeRoleByUserId(bean.getId());
    } 

}
