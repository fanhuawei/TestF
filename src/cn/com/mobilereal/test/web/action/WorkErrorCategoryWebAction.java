/**
 * WorkErrorCategoryWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.test.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;

import cn.com.mobilereal.test.dbbean.WorkErrorCategory;
import cn.com.mobilereal.test.service.WorkErrorCategoryService;

/**
 * <p>ClassName: WorkErrorCategoryWebAction</p>
 * <p>Description: 工单故障类别WebAction类管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class WorkErrorCategoryWebAction extends BaseCrudWebAction<WorkErrorCategory> {

    /**
     * <p>Description: 构造方法</p>
     */
    public WorkErrorCategoryWebAction() {
        this.service = WorkErrorCategoryService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
