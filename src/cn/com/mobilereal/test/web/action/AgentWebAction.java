/**
 * AgentWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.test.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;

import cn.com.mobilereal.test.dbbean.Agent;
import cn.com.mobilereal.test.service.AgentService;

/**
 * <p>ClassName: AgentWebAction</p>
 * <p>Description: 代理商WebAction类管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class AgentWebAction extends BaseCrudWebAction<Agent> {

    /**
     * <p>Description: 构造方法</p>
     */
    public AgentWebAction() {
        this.service = AgentService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
