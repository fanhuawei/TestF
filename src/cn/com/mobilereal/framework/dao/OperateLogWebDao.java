/**
 * OperateLogWebDao.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.dao;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.framework.dbbean.IDaoConst;
import cn.com.mobilereal.framework.dbbean.OperateLogWeb;

/**
 * <p>ClassName: OperateLogWebDao</p>
 * <p>Description: WEB操作日志Dao</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class OperateLogWebDao extends GenericDao<OperateLogWeb> {

    /**
     * <p>Description: 构造方法</p>
     */
    public OperateLogWebDao() {
        super(TableEnum.TS_OPERATE_LOG_WEB, OperateLogWeb.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TS_OPERATE_LOG_WEB_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TS_OPERATE_LOG_WEB_U;
    }
    
    /**
     * 
     * <p>Description: 根据会话id查询</p>
     * @param sid 会话id
     * @return 日志对象
     */
    public OperateLogWeb findOneBySessionId(String sid) {
        return OperateLogWeb.I.findOneByWhere("WHERE SESSION_ID=?",sid);
    }
}

