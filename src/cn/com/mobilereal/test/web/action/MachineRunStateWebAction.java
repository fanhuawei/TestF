/**
 * MachineRunStateWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.test.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;

import cn.com.mobilereal.test.dbbean.MachineRunState;
import cn.com.mobilereal.test.service.MachineRunStateService;

/**
 * <p>ClassName: MachineRunStateWebAction</p>
 * <p>Description: 机器运行状态WebAction类管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class MachineRunStateWebAction extends BaseCrudWebAction<MachineRunState> {

    /**
     * <p>Description: 构造方法</p>
     */
    public MachineRunStateWebAction() {
        this.service = MachineRunStateService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
