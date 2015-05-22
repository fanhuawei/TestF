/**
 * MachineBoxWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.test.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;

import cn.com.mobilereal.test.dbbean.MachineBox;
import cn.com.mobilereal.test.service.MachineBoxService;

/**
 * <p>ClassName: MachineBoxWebAction</p>
 * <p>Description: 机器采集设备WebAction类管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class MachineBoxWebAction extends BaseCrudWebAction<MachineBox> {

    /**
     * <p>Description: 构造方法</p>
     */
    public MachineBoxWebAction() {
        this.service = MachineBoxService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
