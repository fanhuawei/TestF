/**
 * WorkOrderWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.test.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;

import cn.com.mobilereal.test.dbbean.WorkOrder;
import cn.com.mobilereal.test.service.WorkOrderService;

/**
 * <p>ClassName: WorkOrderWebAction</p>
 * <p>Description: 工单WebAction类管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class WorkOrderWebAction extends BaseCrudWebAction<WorkOrder> {

    /**
     * <p>Description: 构造方法</p>
     */
    public WorkOrderWebAction() {
        this.service = WorkOrderService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
