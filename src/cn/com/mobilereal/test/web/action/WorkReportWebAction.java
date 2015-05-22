/**
 * WorkReportWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.test.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;

import cn.com.mobilereal.test.dbbean.WorkReport;
import cn.com.mobilereal.test.service.WorkReportService;

/**
 * <p>ClassName: WorkReportWebAction</p>
 * <p>Description: 工单报告WebAction类管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class WorkReportWebAction extends BaseCrudWebAction<WorkReport> {

    /**
     * <p>Description: 构造方法</p>
     */
    public WorkReportWebAction() {
        this.service = WorkReportService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
