/**
 * BaiduInfoWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.test.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;

import cn.com.mobilereal.test.dbbean.BaiduInfo;
import cn.com.mobilereal.test.service.BaiduInfoService;

/**
 * <p>ClassName: BaiduInfoWebAction</p>
 * <p>Description: 百度云推送信息WebAction类管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class BaiduInfoWebAction extends BaseCrudWebAction<BaiduInfo> {

    /**
     * <p>Description: 构造方法</p>
     */
    public BaiduInfoWebAction() {
        this.service = BaiduInfoService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
