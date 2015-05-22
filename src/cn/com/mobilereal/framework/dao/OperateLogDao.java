/**
 * OperateLogDao.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.dao;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.framework.dbbean.IDaoConst;
import cn.com.mobilereal.framework.dbbean.OperateLog;

/**
 * <p>ClassName: OperateLogDao</p>
 * <p>Description: 系统操作日志Dao</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class OperateLogDao extends GenericDao<OperateLog> {

    /**
     * <p>Description: 构造方法</p>
     */
    public OperateLogDao() {
        super(TableEnum.TS_OPERATE_LOG, OperateLog.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TS_OPERATE_LOG_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TS_OPERATE_LOG_U;
    }
}

