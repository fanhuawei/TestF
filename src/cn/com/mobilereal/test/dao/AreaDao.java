/**
 * AreaDao.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.dao;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.test.dbbean.Area;
import cn.com.mobilereal.test.dbbean.IDaoConst;

/**
 * <p>ClassName: AreaDao</p>
 * <p>Description: 地区Dao类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class AreaDao extends GenericDao<Area> {

    /**
     * <p>Description: 构造方法</p>
     */
    public AreaDao() {
        super(TableEnum.TC_AREA, Area.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TC_AREA_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TC_AREA_U;
    }
}

