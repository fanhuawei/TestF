/**
 * WorkErrorCategoryDao.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.dao;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.test.dbbean.WorkErrorCategory;
import cn.com.mobilereal.test.dbbean.IDaoConst;

/**
 * <p>ClassName: WorkErrorCategoryDao</p>
 * <p>Description: 工单故障类别Dao类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class WorkErrorCategoryDao extends GenericDao<WorkErrorCategory> {

    /**
     * <p>Description: 构造方法</p>
     */
    public WorkErrorCategoryDao() {
        super(TableEnum.TR_WORK_ERROR_CATEGORY, WorkErrorCategory.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TR_WORK_ERROR_CATEGORY_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TR_WORK_ERROR_CATEGORY_U;
    }
}

