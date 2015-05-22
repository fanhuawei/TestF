/**
 * ShortCutDao.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.dao;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.framework.dbbean.IDaoConst;
import cn.com.mobilereal.framework.dbbean.ShortCut;

/**
 * <p>ClassName: ShortCutDao</p>
 * <p>Description: 快捷方式Dao</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class ShortCutDao extends GenericDao<ShortCut> {

    /**
     * <p>Description: 构造方法</p>
     */
    public ShortCutDao() {
        super(TableEnum.TM_SHORT_CUT, ShortCut.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TM_SHORT_CUT_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TM_SHORT_CUT_U;
    }
}

