/**
 * OperateLogMobileDao.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.dao;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.framework.dbbean.IDaoConst;
import cn.com.mobilereal.framework.dbbean.OperateLogMobile;

/**
 * <p>ClassName: OperateLogMobileDao</p>
 * <p>Description: MOBILE操作日志Dao</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class OperateLogMobileDao extends GenericDao<OperateLogMobile> {

    /**
     * <p>Description: 构造方法</p>
     */
    public OperateLogMobileDao() {
        super(TableEnum.TS_OPERATE_LOG_MOBILE, OperateLogMobile.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TS_OPERATE_LOG_MOBILE_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TS_OPERATE_LOG_MOBILE_U;
    }
    
    /**
     * 
     * <p>Description: 根据用户和设备查询日志</p>
     * @param uid 用户ID
     * @param deviceSN 设备
     * @return 操作日志
     */
    public OperateLogMobile findOneByUserIdAndDevice(Long uid, String deviceSN) {
       return findOneByWhere("WHERE USER_ID=? AND DEVICE_SN=?", uid, deviceSN);
    }
}

