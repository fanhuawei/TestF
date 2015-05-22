/**
 * WorkErrorCategoryService.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;

import cn.com.mobilereal.test.dbbean.WorkErrorCategory;

/**
 * <p>ClassName: WorkErrorCategoryService</p>
 * <p>Description: 工单故障类别业务类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class WorkErrorCategoryService extends BaseCrudService<WorkErrorCategory> {
    /**
     * 实例
     */
    public static final WorkErrorCategoryService I = ServiceFactory.makeService(WorkErrorCategoryService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public WorkErrorCategoryService() {
       super(WorkErrorCategory.I, WorkErrorCategory.class);
    }
}
