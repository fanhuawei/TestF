/**
 * MachineExtendDao.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.dao;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.test.dbbean.MachineExtend;
import cn.com.mobilereal.test.dbbean.IDaoConst;

/**
 * <p>ClassName: MachineExtendDao</p>
 * <p>Description: 机器扩展属性Dao类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class MachineExtendDao extends GenericDao<MachineExtend> {

    /**
     * <p>Description: 构造方法</p>
     */
    public MachineExtendDao() {
        super(TableEnum.TT_MACHINE_EXTEND, MachineExtend.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TT_MACHINE_EXTEND_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TT_MACHINE_EXTEND_U;
    }
}

