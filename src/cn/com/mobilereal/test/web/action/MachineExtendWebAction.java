/**
 * MachineExtendWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.test.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;

import cn.com.mobilereal.test.dbbean.MachineExtend;
import cn.com.mobilereal.test.service.MachineExtendService;

/**
 * <p>ClassName: MachineExtendWebAction</p>
 * <p>Description: 机器扩展属性WebAction类管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class MachineExtendWebAction extends BaseCrudWebAction<MachineExtend> {

    /**
     * <p>Description: 构造方法</p>
     */
    public MachineExtendWebAction() {
        this.service = MachineExtendService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
