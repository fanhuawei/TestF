/**
 * UserRoleService.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.service;

import java.util.List;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;
import cn.com.mobilereal.framework.dbbean.User;
import cn.com.mobilereal.framework.dbbean.UserRole;

/**
 * 
 * <p>ClassName: UserRoleService</p>
 * <p>Description: 系统用户角色对应表管理的业务类</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date:2014-10-16</p>
 */
@SuppressWarnings("serial")
public class UserRoleService extends BaseCrudService<UserRole> {
    /**
     * 实例
     */
    public static final UserRoleService I = ServiceFactory.makeService(UserRoleService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public UserRoleService() {
       super(UserRole.I, UserRole.class);
    }
    
    /**
     * 
     * <p>Description: 根据用户id获得角色的Id</p>
     * @param uid 用户id
     * @return 角色id
     */
    public Long[] makeRoleByUserId(Long uid) {
        return UserRole.I.findIdByUserId(uid);
    }
    
      
    /**
     * 
     * <p>Description: 保存用户及角色信息</p>
     * @param uid 用户Id
     * @param roles 角色
     */
    public void saveUserAndRole(Long uid, Long... roles) {
        UserRole.I.deleteByUserId(uid);
        UserRole ur = null;
        for (Long rid : roles) {
            ur = new UserRole();
            ur.setUserId(uid);
            ur.setRoleId(rid);
            UserRole.I.save(ur);            
        }
    }
    
    /**
     * 
     * <p>Description: 查询角色用户</p>
     * @param rid 角色id
     * @return 用户列表
     */
    public List<User> findRoleUser(Long rid) {
        return User.I.getUserByRole(rid);       
    }
    
    /**
     * 
     * <p>Description: 查询非角色用户</p>
     * @param rid 角色id
     * @return 用户列表
     */
    public List<User> findNotRoleUser(Long rid) {
        return User.I.getNotUserByRole(rid);
    }
    
    /**
     * 
     * <p>Description: 删除角色用户</p>
     * @param rid 角色id
     * @param uid 用户id
     * @return 数量
     */
    public int deleteUser(Long rid, Long uid) {
        return UserRole.I.deleteByRoleIdUserId(rid, uid);
    }
    
    /**
     * 
     * <p>Description:  添加角色用户</p>
     * @param rid 角色id
     * @param uid 用户id
     */
    public void saveUser(Long rid, Long[] uid) {
        UserRole ur = null;
        if (uid != null) {
            for (int i = 0; i < uid.length; i++) {
                ur = new UserRole();
                ur.setRoleId(rid);
                ur.setUserId(uid[i]);
                UserRole.I.save(ur);
            }
        }
    }
}
