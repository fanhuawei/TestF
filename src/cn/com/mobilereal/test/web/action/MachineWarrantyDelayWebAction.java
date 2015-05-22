/**
 * MachineWarrantyDelayWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.test.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;

import cn.com.mobilereal.test.dbbean.MachineWarrantyDelay;
import cn.com.mobilereal.test.service.MachineWarrantyDelayService;

/**
 * <p>ClassName: MachineWarrantyDelayWebAction</p>
 * <p>Description: 机器延保记录WebAction类管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class MachineWarrantyDelayWebAction extends BaseCrudWebAction<MachineWarrantyDelay> {

    /**
     * <p>Description: 构造方法</p>
     */
    public MachineWarrantyDelayWebAction() {
        this.service = MachineWarrantyDelayService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
