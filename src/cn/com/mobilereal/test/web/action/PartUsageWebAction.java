/**
 * PartUsageWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.test.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;

import cn.com.mobilereal.test.dbbean.PartUsage;
import cn.com.mobilereal.test.service.PartUsageService;

/**
 * <p>ClassName: PartUsageWebAction</p>
 * <p>Description: 配件使用WebAction类管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class PartUsageWebAction extends BaseCrudWebAction<PartUsage> {

    /**
     * <p>Description: 构造方法</p>
     */
    public PartUsageWebAction() {
        this.service = PartUsageService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
