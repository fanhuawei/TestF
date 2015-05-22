/**
 * MachineWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.test.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;

import cn.com.mobilereal.test.dbbean.Machine;
import cn.com.mobilereal.test.service.MachineService;

/**
 * <p>ClassName: MachineWebAction</p>
 * <p>Description: 机器WebAction类管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class MachineWebAction extends BaseCrudWebAction<Machine> {

    /**
     * <p>Description: 构造方法</p>
     */
    public MachineWebAction() {
        this.service = MachineService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
