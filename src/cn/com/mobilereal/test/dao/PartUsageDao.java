/**
 * PartUsageDao.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.dao;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.test.dbbean.PartUsage;
import cn.com.mobilereal.test.dbbean.IDaoConst;

/**
 * <p>ClassName: PartUsageDao</p>
 * <p>Description: 配件使用Dao类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class PartUsageDao extends GenericDao<PartUsage> {

    /**
     * <p>Description: 构造方法</p>
     */
    public PartUsageDao() {
        super(TableEnum.TT_PART_USAGE, PartUsage.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TT_PART_USAGE_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TT_PART_USAGE_U;
    }
}

