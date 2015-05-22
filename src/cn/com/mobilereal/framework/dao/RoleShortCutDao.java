/**
 * RoleShortCutDao.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.dao;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.framework.dbbean.IDaoConst;
import cn.com.mobilereal.framework.dbbean.RoleShortCut;

/**
 * <p>ClassName: RoleShortCutDao</p>
 * <p>Description: 角色的快捷方式信息Dao</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class RoleShortCutDao extends GenericDao<RoleShortCut> {

    /**
     * <p>Description: 构造方法</p>
     */
    public RoleShortCutDao() {
        super(TableEnum.TR_ROLE_SHORT_CUT, RoleShortCut.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TR_ROLE_SHORT_CUT_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TR_ROLE_SHORT_CUT_U;
    }
}

