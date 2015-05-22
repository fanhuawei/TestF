/**
 * MenuButtonDao.java
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
import cn.com.mobilereal.framework.dbbean.MenuButton;

/**
 * <p>ClassName: MenuButtonDao</p>
 * <p>Description: 系统菜单与按钮对应表Dao</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class MenuButtonDao extends GenericDao<MenuButton> {

    /**
     * <p>Description: 构造方法</p>
     */
    public MenuButtonDao() {
        super(TableEnum.TS_MENU_BUTTON, MenuButton.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TS_MENU_BUTTON_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TS_MENU_BUTTON_U;
    }
    
    /**
     * <p>
     * Description: 根据用户获取权限按钮
     * </p>
     * 
     * @param uid 用户id
     * @return 权限按钮
     */
    public List<MenuButton> getMenuButtonByUserId(Long uid) {
        final String WH = "JOIN TR_ROLE_BUTTON B ON A.ID = B.MENU_BUTTON_ID JOIN TR_USER_ROLE C ON B.ROLE_ID=C.ROLE_ID "
                + "WHERE A.DELETE_MARK=? AND B.DELETE_MARK=? AND C.DELETE_MARK=? AND C.USER_ID=? ORDER BY A.ID";
        return findDistinctByWhere(WH, ConstUtil.FLAG.NO, ConstUtil.FLAG.NO, ConstUtil.FLAG.NO, uid);
    }
}

