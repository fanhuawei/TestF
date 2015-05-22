/**
 * RoleMenuDao.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.dao;

import java.util.List;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.common.util.ConstUtil;
import cn.com.mobilereal.common.util.JDBCUtil;
import cn.com.mobilereal.framework.dbbean.IDaoConst;
import cn.com.mobilereal.framework.dbbean.RoleMenu;

/**
 * <p>ClassName: RoleMenuDao</p>
 * <p>Description: 系统角色权限Dao</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class RoleMenuDao extends GenericDao<RoleMenu> {

    /**
     * <p>Description: 构造方法</p>
     */
    public RoleMenuDao() {
        super(TableEnum.TR_ROLE_MENU, RoleMenu.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TR_ROLE_MENU_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TR_ROLE_MENU_U;
    }
    
    /**
     * 
     * <p>
     * Description: 根据角色获得权限id列表
     * </p>
     * @param rid 角色id
     * @return 权限id列表
     */
    public List<Long> getMenuListByRoleId(Long rid) {
        final String WH = "SELECT MENU_ID FROM TR_ROLE_MENU WHERE ROLE_ID=? AND DELETE_MARK=?";
        return JDBCUtil.doQueryLongValueList(WH, rid, ConstUtil.FLAG.NO);
    }
    

    /**
     * 
     * <p>
     * Description: 删除角色权限
     * </p>
     * 
     * @param rid 角色id
     */
    public void deleteByRoleId(Long rid) {
        final String WH = "WHERE ROLE_ID=?";
        deleteByWhere(WH, rid);
    }
}

