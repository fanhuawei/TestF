/**
 * DeptWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.test.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;

import cn.com.mobilereal.test.dbbean.Dept;
import cn.com.mobilereal.test.service.DeptService;

/**
 * <p>ClassName: DeptWebAction</p>
 * <p>Description: 部门WebAction类管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class DeptWebAction extends BaseCrudWebAction<Dept> {

    /**
     * <p>Description: 构造方法</p>
     */
    public DeptWebAction() {
        this.service = DeptService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
