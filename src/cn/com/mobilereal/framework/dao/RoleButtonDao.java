/**
 * RoleButtonDao.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.common.ui.MenuEnum;
import cn.com.mobilereal.common.util.ConstUtil;
import cn.com.mobilereal.common.util.JDBCUtil;
import cn.com.mobilereal.framework.dbbean.IDaoConst;
import cn.com.mobilereal.framework.dbbean.RoleButton;

/**
 * <p>ClassName: RoleButtonDao</p>
 * <p>Description: 系统角色到按钮权限Dao</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class RoleButtonDao extends GenericDao<RoleButton> {

    /**
     * <p>Description: 构造方法</p>
     */
    public RoleButtonDao() {
        super(TableEnum.TR_ROLE_BUTTON, RoleButton.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TR_ROLE_BUTTON_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TR_ROLE_BUTTON_U;
    }
    /**
     * 
     * <p>
     * Description: 根据角色获得按钮id列表
     * </p>
     * 
     * @param rid 角色id
     * @return 按钮id列表
     */
    public List<Long> getButtonListByRoleId(Long rid) {
        final String WH = "SELECT MENU_BUTTON_ID FROM TR_ROLE_BUTTON WHERE ROLE_ID=? AND DELETE_MARK=?";
        return JDBCUtil.doQueryLongValueList(WH, rid, ConstUtil.FLAG.NO);
    }

    /**
     * 
     * <p>
     * Description: 根据角色获得菜单id列表
     * </p>
     * 
     * @param rid 角色id
     * @return 菜单id列表
     */
    public List<Long> getMenuIdByRoleId(Long rid) {
        final String WH = "SELECT DISTINCT A.MENU_ID FROM TS_MENU_BUTTON A JOIN TR_ROLE_BUTTON B "
                + "ON B.MENU_BUTTON_ID = A.ID WHERE B.ROLE_ID=? AND B.DELETE_MARK=? AND A.DELETE_MARK=?";
        final List<Long> RET = JDBCUtil.doQueryLongValueList(WH, rid, ConstUtil.FLAG.NO, ConstUtil.FLAG.NO);
        MenuEnum me = null;
        final Set<Long> PPID = new HashSet<Long>();
        for (Long mid : RET) {
            me = MenuEnum.makeMenu(mid);
            if (me != null) {
                if (me.getParent() != null) {
                    PPID.add(me.getParent().getId());
                    if (me.getParent().getParent() != null) {
                        PPID.add(me.getParent().getParent().getId());
                    }
                }
            }
        }
        RET.addAll(PPID);
        return RET;
        
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

