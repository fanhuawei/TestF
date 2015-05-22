/**
 * WorkFlowAssetService.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;

import cn.com.mobilereal.test.dbbean.WorkFlowAsset;

/**
 * <p>ClassName: WorkFlowAssetService</p>
 * <p>Description: 工单流附件业务类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class WorkFlowAssetService extends BaseCrudService<WorkFlowAsset> {
    /**
     * 实例
     */
    public static final WorkFlowAssetService I = ServiceFactory.makeService(WorkFlowAssetService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public WorkFlowAssetService() {
       super(WorkFlowAsset.I, WorkFlowAsset.class);
    }
}
