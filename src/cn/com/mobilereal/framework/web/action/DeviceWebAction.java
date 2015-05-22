/**
 * DeviceWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;
import cn.com.mobilereal.framework.dbbean.Device;
import cn.com.mobilereal.framework.service.DeviceService;


/**
 * <p>ClassName: DeviceWebAction</p>
 * <p>Description: PAD设备管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class DeviceWebAction extends BaseCrudWebAction<Device> {

    /**
     * <p>Description: 构造方法</p>
     */
    public DeviceWebAction() {
        this.service = DeviceService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
