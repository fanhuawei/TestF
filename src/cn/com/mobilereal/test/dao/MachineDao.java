/**
 * MachineDao.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.dao;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.test.dbbean.Machine;
import cn.com.mobilereal.test.dbbean.IDaoConst;

/**
 * <p>ClassName: MachineDao</p>
 * <p>Description: 机器Dao类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class MachineDao extends GenericDao<Machine> {

    /**
     * <p>Description: 构造方法</p>
     */
    public MachineDao() {
        super(TableEnum.TT_MACHINE, Machine.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TT_MACHINE_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TT_MACHINE_U;
    }
}

