/**
 * WorkReportService.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;

import cn.com.mobilereal.test.dbbean.WorkReport;

/**
 * <p>ClassName: WorkReportService</p>
 * <p>Description: 工单报告业务类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class WorkReportService extends BaseCrudService<WorkReport> {
    /**
     * 实例
     */
    public static final WorkReportService I = ServiceFactory.makeService(WorkReportService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public WorkReportService() {
       super(WorkReport.I, WorkReport.class);
    }
}
