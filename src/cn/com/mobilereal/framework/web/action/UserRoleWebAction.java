/**
 * UserRoleWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.web.action;

import java.util.List;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;
import cn.com.mobilereal.framework.dbbean.User;
import cn.com.mobilereal.framework.dbbean.UserRole;
import cn.com.mobilereal.framework.service.RoleService;
import cn.com.mobilereal.framework.service.UserRoleService;

/**
 * <p>ClassName: UserRoleWebAction</p>
 * <p>Description: 系统用户角色对应表管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class UserRoleWebAction extends BaseCrudWebAction<UserRole> {
    /**
     * 当前角色的关联用户 
     */
    private List<User> roleUsers;
    /**
     * 当前角色的未关联用户
     */
    private List<User> users;
    
    /**
     * 添加的用户id列表
     */
    private Long[] userId;
     
    /**
     * <p>Description: 构造方法</p>
     */
    public UserRoleWebAction() {
        this.service = UserRoleService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
        if (log.isDebugEnabled()) {
            log.debug(this.userId);
            log.debug(this.users);
            log.debug(this.roleUsers);
        }
    }
    
    @Override
    public void search() {
        setParentBean(RoleService.I.findById(this.pid));
        this.roleUsers = UserRoleService.I.findRoleUser(this.pid);        
        this.users = UserRoleService.I.findNotRoleUser(this.pid);
    }

    @Override
    public void delete() {
        UserRoleService.I.deleteUser(this.pid, this.chk[0]); 
    }

    @Override
    public void save() {
        UserRoleService.I.saveUser(this.pid, this.userId); 
    }  

}
