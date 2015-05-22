/**
 * DeptDao.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.dao;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.test.dbbean.Dept;
import cn.com.mobilereal.test.dbbean.IDaoConst;

/**
 * <p>ClassName: DeptDao</p>
 * <p>Description: 部门Dao类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class DeptDao extends GenericDao<Dept> {

    /**
     * <p>Description: 构造方法</p>
     */
    public DeptDao() {
        super(TableEnum.TS_DEPT, Dept.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TS_DEPT_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TS_DEPT_U;
    }
}

