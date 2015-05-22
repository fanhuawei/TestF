/**
 * OtherMachineWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.test.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;

import cn.com.mobilereal.test.dbbean.OtherMachine;
import cn.com.mobilereal.test.service.OtherMachineService;

/**
 * <p>ClassName: OtherMachineWebAction</p>
 * <p>Description: 客户其它厂家机器WebAction类管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class OtherMachineWebAction extends BaseCrudWebAction<OtherMachine> {

    /**
     * <p>Description: 构造方法</p>
     */
    public OtherMachineWebAction() {
        this.service = OtherMachineService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
