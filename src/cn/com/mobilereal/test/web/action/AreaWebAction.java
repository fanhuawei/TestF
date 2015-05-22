/**
 * AreaWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.test.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;

import cn.com.mobilereal.test.dbbean.Area;
import cn.com.mobilereal.test.service.AreaService;

/**
 * <p>ClassName: AreaWebAction</p>
 * <p>Description: 地区WebAction类管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class AreaWebAction extends BaseCrudWebAction<Area> {

    /**
     * <p>Description: 构造方法</p>
     */
    public AreaWebAction() {
        this.service = AreaService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
