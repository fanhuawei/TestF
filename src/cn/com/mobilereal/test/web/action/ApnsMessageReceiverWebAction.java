/**
 * ApnsMessageReceiverWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.test.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;

import cn.com.mobilereal.test.dbbean.ApnsMessageReceiver;
import cn.com.mobilereal.test.service.ApnsMessageReceiverService;

/**
 * <p>ClassName: ApnsMessageReceiverWebAction</p>
 * <p>Description: 推送消息接受人WebAction类管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class ApnsMessageReceiverWebAction extends BaseCrudWebAction<ApnsMessageReceiver> {

    /**
     * <p>Description: 构造方法</p>
     */
    public ApnsMessageReceiverWebAction() {
        this.service = ApnsMessageReceiverService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
