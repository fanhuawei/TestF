/**
 * DeviceDao.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.dao;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.framework.dbbean.Device;
import cn.com.mobilereal.framework.dbbean.IDaoConst;

/**
 * <p>ClassName: DeviceDao</p>
 * <p>Description: PAD设备Dao</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class DeviceDao extends GenericDao<Device> {

    /**
     * <p>Description: 构造方法</p>
     */
    public DeviceDao() {
        super(TableEnum.TM_DEVICE, Device.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TM_DEVICE_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TM_DEVICE_U;
    }
}

