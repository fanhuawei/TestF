/**
 * UserRoleDao.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.dao;

import java.util.List;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.framework.dbbean.IDaoConst;
import cn.com.mobilereal.framework.dbbean.UserRole;

/**
 * <p>ClassName: UserRoleDao</p>
 * <p>Description: 系统用户角色对应表Dao</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class UserRoleDao extends GenericDao<UserRole> {

    /**
     * <p>Description: 构造方法</p>
     */
    public UserRoleDao() {
        super(TableEnum.TR_USER_ROLE, UserRole.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TR_USER_ROLE_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TR_USER_ROLE_U;
    }
    
    /**
     * <p>
     * Description: 根据用户id删除数据
     * </p>
     * 
     * @param id 用户id
     */
    public void deleteByUserId(Long id) {
        deleteByWhere("WHERE USER_ID=?", id);
    }

    /**
     * <p>
     * Description: 根据用户id角色id删除数据
     * </p>
     * 
     * @param rid 角色id
     * @param uid 用户id
     * @return 数量
     */
    public int deleteByRoleIdUserId(Long rid, Long uid) {
        return deleteByWhere("WHERE ROLE_ID=? AND USER_ID=?", rid, uid);
    }

    /**
     * <p>
     * Description: 根据用户id查询角色id
     * </p>
     * 
     * @param id 用户id
     * @return 角色id
     */
    public Long[] findIdByUserId(Long id) {
        final List<UserRole> LIST = UserRole.I.findByWhere("WHERE USER_ID=?", id);
        final Long[] RET = new Long[LIST.size()];
        for (int i = 0; i < RET.length; i++) {
            RET[i] = LIST.get(i).getRoleId();
        }
        return RET;
    }
}

