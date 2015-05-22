/**
 * PartBaseWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.test.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;

import cn.com.mobilereal.test.dbbean.PartBase;
import cn.com.mobilereal.test.service.PartBaseService;

/**
 * <p>ClassName: PartBaseWebAction</p>
 * <p>Description: 配件库WebAction类管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class PartBaseWebAction extends BaseCrudWebAction<PartBase> {

    /**
     * <p>Description: 构造方法</p>
     */
    public PartBaseWebAction() {
        this.service = PartBaseService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
