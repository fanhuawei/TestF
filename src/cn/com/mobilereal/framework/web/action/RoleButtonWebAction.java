/**
 * RoleButtonWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;
import cn.com.mobilereal.framework.dbbean.RoleButton;
import cn.com.mobilereal.framework.service.RoleButtonService;

/**
 * <p>ClassName: RoleButtonWebAction</p>
 * <p>Description: 系统角色到按钮权限管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class RoleButtonWebAction extends BaseCrudWebAction<RoleButton> {

    /**
     * <p>Description: 构造方法</p>
     */
    public RoleButtonWebAction() {
        this.service = RoleButtonService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
