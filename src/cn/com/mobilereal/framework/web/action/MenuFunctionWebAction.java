/**
 * MenuFunctionWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;
import cn.com.mobilereal.framework.dbbean.MenuFunction;
import cn.com.mobilereal.framework.service.MenuFunctionService;

/**
 * <p>ClassName: MenuFunctionWebAction</p>
 * <p>Description: 系统菜单及功能页面管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class MenuFunctionWebAction extends BaseCrudWebAction<MenuFunction> {

    /**
     * <p>Description: 构造方法</p>
     */
    public MenuFunctionWebAction() {
        this.service = MenuFunctionService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
