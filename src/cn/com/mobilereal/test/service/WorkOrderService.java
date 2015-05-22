/**
 * WorkOrderService.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;

import cn.com.mobilereal.test.dbbean.WorkOrder;

/**
 * <p>ClassName: WorkOrderService</p>
 * <p>Description: 工单业务类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class WorkOrderService extends BaseCrudService<WorkOrder> {
    /**
     * 实例
     */
    public static final WorkOrderService I = ServiceFactory.makeService(WorkOrderService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public WorkOrderService() {
       super(WorkOrder.I, WorkOrder.class);
    }
}
