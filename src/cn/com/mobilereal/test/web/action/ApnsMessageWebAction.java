/**
 * ApnsMessageWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.test.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;

import cn.com.mobilereal.test.dbbean.ApnsMessage;
import cn.com.mobilereal.test.service.ApnsMessageService;

/**
 * <p>ClassName: ApnsMessageWebAction</p>
 * <p>Description: 推送消息WebAction类管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class ApnsMessageWebAction extends BaseCrudWebAction<ApnsMessage> {

    /**
     * <p>Description: 构造方法</p>
     */
    public ApnsMessageWebAction() {
        this.service = ApnsMessageService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
