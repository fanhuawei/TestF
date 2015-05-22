/**
 * WorkOrderDao.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.dao;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.test.dbbean.WorkOrder;
import cn.com.mobilereal.test.dbbean.IDaoConst;

/**
 * <p>ClassName: WorkOrderDao</p>
 * <p>Description: 工单Dao类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class WorkOrderDao extends GenericDao<WorkOrder> {

    /**
     * <p>Description: 构造方法</p>
     */
    public WorkOrderDao() {
        super(TableEnum.TT_WORK_ORDER, WorkOrder.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TT_WORK_ORDER_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TT_WORK_ORDER_U;
    }
}

