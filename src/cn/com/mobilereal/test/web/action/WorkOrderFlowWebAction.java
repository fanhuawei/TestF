/**
 * WorkOrderFlowWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.test.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;

import cn.com.mobilereal.test.dbbean.WorkOrderFlow;
import cn.com.mobilereal.test.service.WorkOrderFlowService;

/**
 * <p>ClassName: WorkOrderFlowWebAction</p>
 * <p>Description: 工单流WebAction类管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class WorkOrderFlowWebAction extends BaseCrudWebAction<WorkOrderFlow> {

    /**
     * <p>Description: 构造方法</p>
     */
    public WorkOrderFlowWebAction() {
        this.service = WorkOrderFlowService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
