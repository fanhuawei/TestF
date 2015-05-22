/**
 * WorkDao.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.dao;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.test.dbbean.Work;
import cn.com.mobilereal.test.dbbean.IDaoConst;

/**
 * <p>ClassName: WorkDao</p>
 * <p>Description: 代班Dao类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class WorkDao extends GenericDao<Work> {

    /**
     * <p>Description: 构造方法</p>
     */
    public WorkDao() {
        super(TableEnum.TS_WORK, Work.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TS_WORK_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TS_WORK_U;
    }
}

