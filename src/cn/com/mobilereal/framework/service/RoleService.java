/**
 * RoleService.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.service;

import java.util.List;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ConstUtil;
import cn.com.mobilereal.common.util.ServiceFactory;
import cn.com.mobilereal.framework.dbbean.Role;


/**
 * 
 * <p>ClassName: RoleService</p>
 * <p>Description: 系统角色管理的业务类</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date:2014-10-16</p>
 */
@SuppressWarnings("serial")
public class RoleService extends BaseCrudService<Role> {
    /**
     * 实例
     */
    public static final RoleService I = ServiceFactory.makeService(RoleService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public RoleService() {
       super(Role.I, Role.class);
    }
    
    /**
     * <p>Description: 根据id和角色编号查询角色是否存在 </p>
     * @param code 角色编码
     * @param id 角色id
     * @return 角色列表
     */
    public List<Role> getRoleByCode(String code , Long id) {
        return Role.I.getRoleByCode(code, id);
    }
    
    /**
     * <p>Description: 根据用户id查询角色 </p>
     * @param uid 用户id
     * @return 角色列表
     */
    public List<Role> getRoleByUid(Long uid) {
        return Role.I.getRoleByUid(uid);
    }
    
    /**
     * <p>Description: 查询未删除的角色</p>
     * @return 角色列表
     */
    public List<Role> findRoleList() {
        return Role.I.findRoleList();
    }
    
    /**
     * <p>Description: 查询用户管理的角色</p>
     * @return 角色列表
     */
    public List<Role> findCustomRoleList() {
        return Role.I.findByWhere("WHERE DELETE_MARK=? AND CODE NOT IN(?,?,?,?,?,?) ORDER BY CODE", ConstUtil.FLAG.NO,
            ConstUtil.USER_ROLE_CODE.AGENT_MANAGER,
            ConstUtil.USER_ROLE_CODE.ENGINEER,
            ConstUtil.USER_ROLE_CODE.REGIONAL_REPAIR_MANAGER,
            ConstUtil.USER_ROLE_CODE.REPAIR_SHOP_MANAGER,
            ConstUtil.USER_ROLE_CODE.SERVICE_CENTER_MANAGER,
            ConstUtil.USER_ROLE_CODE.SERVICE_CENTER_EMP);
    }
    /**
     * <p>Description: 根据角色id查询角色code </p>
     * @param rid 角色id
     * @return 角色code
     */
    public String makeRoleCode(Long rid){
       if (rid !=null) {
         Role role = findById(rid);
         if (role!=null) {
           return role.getCode();
         }
       }
       return null;
    }
    
    /**
     * <p>Description: 根据角色编码查询角色id </p>
     * @param code 角色编码
     * @return 角色Id
     */
    public Long makeRoleIdByCode(String code){
         Role role = findOneByWhere("WHERE DELETE_MARK=? AND CODE=?", ConstUtil.FLAG.NO, code);
         if (role == null) return null;
         return role.getId();
    }
}
