/**
 * RoleDao.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.dao;

import java.util.ArrayList;
import java.util.List;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.common.util.ConstUtil;
import cn.com.mobilereal.framework.dbbean.IDaoConst;
import cn.com.mobilereal.framework.dbbean.Role;

/**
 * <p>ClassName: RoleDao</p>
 * <p>Description: 系统角色Dao</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class RoleDao extends GenericDao<Role> {

    /**
     * <p>Description: 构造方法</p>
     */
    public RoleDao() {
        super(TableEnum.TS_ROLE, Role.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TS_ROLE_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TS_ROLE_U;
    }
    
    /**
     * <p>
     * Description: 根据id和角色编号查询角色是否存在
     * </p>
     * 
     * @param code 角色编码
     * @param id 角色id
     * @return 角色列表
     */
    public List<Role> getRoleByCode(String code, Long id) {
        final ArrayList<Object> ARGU = new ArrayList<Object>();
        final StringBuffer SB = new StringBuffer("WHERE A.DELETE_MARK=? AND A.CODE=?");
        ARGU.add(ConstUtil.FLAG.NO);
        ARGU.add(code);
        if (id != null) {
            SB.append(" AND A.ID !=?");
            ARGU.add(id);
        } 
        return Role.I.findByWhere(SB.toString(), ARGU.toArray());
    }
    
    /**
     * <p>Description: 根据用户id查询角色 </p>
     * @param uid 用户id
     * @return 角色列表
     */
    public List<Role> getRoleByUid(Long uid) {
        final String WH = "JOIN TR_USER_ROLE B ON A.ID = B.ROLE_ID WHERE B.USER_ID=? AND B.DELETE_MARK=? "
                + "AND A.DELETE_MARK=?";
        return findByWhere(WH, uid, ConstUtil.FLAG.NO, ConstUtil.FLAG.NO);
    }

    /**
     * <p>
     * Description: 查询未删除的角色
     * </p>
     * 
     * @return 角色列表
     */
    public List<Role> findRoleList() {
        final String WH = " WHERE A.DELETE_MARK = ? ";
        return Role.I.findByWhere(WH, ConstUtil.FLAG.NO);
    }
}

