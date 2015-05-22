/**
 * OtherMachineDao.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.dao;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.test.dbbean.OtherMachine;
import cn.com.mobilereal.test.dbbean.IDaoConst;

/**
 * <p>ClassName: OtherMachineDao</p>
 * <p>Description: 客户其它厂家机器Dao类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class OtherMachineDao extends GenericDao<OtherMachine> {

    /**
     * <p>Description: 构造方法</p>
     */
    public OtherMachineDao() {
        super(TableEnum.TT_OTHER_MACHINE, OtherMachine.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TT_OTHER_MACHINE_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TT_OTHER_MACHINE_U;
    }
}

