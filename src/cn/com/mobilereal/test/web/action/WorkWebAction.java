/**
 * WorkWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.test.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;

import cn.com.mobilereal.test.dbbean.Work;
import cn.com.mobilereal.test.service.WorkService;

/**
 * <p>ClassName: WorkWebAction</p>
 * <p>Description: 代班WebAction类管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class WorkWebAction extends BaseCrudWebAction<Work> {

    /**
     * <p>Description: 构造方法</p>
     */
    public WorkWebAction() {
        this.service = WorkService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
