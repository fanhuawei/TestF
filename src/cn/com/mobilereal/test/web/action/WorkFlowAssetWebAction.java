/**
 * WorkFlowAssetWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.test.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;

import cn.com.mobilereal.test.dbbean.WorkFlowAsset;
import cn.com.mobilereal.test.service.WorkFlowAssetService;

/**
 * <p>ClassName: WorkFlowAssetWebAction</p>
 * <p>Description: 工单流附件WebAction类管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class WorkFlowAssetWebAction extends BaseCrudWebAction<WorkFlowAsset> {

    /**
     * <p>Description: 构造方法</p>
     */
    public WorkFlowAssetWebAction() {
        this.service = WorkFlowAssetService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
