/**
 * MenuFunctionDao.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.dao;

import java.util.List;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.common.util.ConstUtil;
import cn.com.mobilereal.framework.dbbean.IDaoConst;
import cn.com.mobilereal.framework.dbbean.MenuFunction;

/**
 * <p>ClassName: MenuFunctionDao</p>
 * <p>Description: 系统菜单及功能页面Dao</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class MenuFunctionDao extends GenericDao<MenuFunction> {

    /**
     * <p>Description: 构造方法</p>
     */
    public MenuFunctionDao() {
        super(TableEnum.TS_MENU_FUNCTION, MenuFunction.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TS_MENU_FUNCTION_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TS_MENU_FUNCTION_U;
    }
    
    /**
     * 
     * <p>
     * Description: 获取用户菜单
     * </p>
     * 
     * @param userId 用户id
     * @return 用户菜单
     */
    public List<MenuFunction> makeUserMenu(Long userId) {
        final String WH = "JOIN TR_ROLE_MENU B ON A.ID = B.MENU_ID JOIN TR_USER_ROLE C ON B.ROLE_ID=C.ROLE_ID "
                + "WHERE A.DELETE_MARK=? AND B.DELETE_MARK=? AND C.DELETE_MARK=? AND C.USER_ID=? ORDER BY A.ID";
        return findDistinctByWhere(WH, ConstUtil.FLAG.NO, ConstUtil.FLAG.NO, ConstUtil.FLAG.NO, userId);
    }
    
    /**
     * 
     * <p>
     * Description: 获取角色菜单
     * </p>
     * 
     * @param roleId 角色id
     * @return 用户菜单
     */
    public List<MenuFunction> getMenuListByRoleId(Long roleId) {
        final String WH = "JOIN TR_ROLE_MENU B ON A.ID = B.MENU_ID "
                + "WHERE A.DELETE_MARK=? AND B.DELETE_MARK=? AND B.ROLE_ID=? ORDER BY A.ID";
        return findDistinctByWhere(WH, ConstUtil.FLAG.NO, ConstUtil.FLAG.NO, roleId);
    }
}

