/**
 * MachineRunStateDao.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.dao;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.test.dbbean.MachineRunState;
import cn.com.mobilereal.test.dbbean.IDaoConst;

/**
 * <p>ClassName: MachineRunStateDao</p>
 * <p>Description: 机器运行状态Dao类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class MachineRunStateDao extends GenericDao<MachineRunState> {

    /**
     * <p>Description: 构造方法</p>
     */
    public MachineRunStateDao() {
        super(TableEnum.TT_MACHINE_RUN_STATE, MachineRunState.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TT_MACHINE_RUN_STATE_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TT_MACHINE_RUN_STATE_U;
    }
}

