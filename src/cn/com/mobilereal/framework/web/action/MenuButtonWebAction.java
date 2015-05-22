/**
 * MenuButtonWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;
import cn.com.mobilereal.framework.dbbean.MenuButton;
import cn.com.mobilereal.framework.service.MenuButtonService;

/**
 * <p>ClassName: MenuButtonWebAction</p>
 * <p>Description: 系统菜单与按钮对应表管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class MenuButtonWebAction extends BaseCrudWebAction<MenuButton> {

    /**
     * <p>Description: 构造方法</p>
     */
    public MenuButtonWebAction() {
        this.service = MenuButtonService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
