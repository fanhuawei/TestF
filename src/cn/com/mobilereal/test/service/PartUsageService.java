/**
 * PartUsageService.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;

import cn.com.mobilereal.test.dbbean.PartUsage;

/**
 * <p>ClassName: PartUsageService</p>
 * <p>Description: 配件使用业务类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class PartUsageService extends BaseCrudService<PartUsage> {
    /**
     * 实例
     */
    public static final PartUsageService I = ServiceFactory.makeService(PartUsageService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public PartUsageService() {
       super(PartUsage.I, PartUsage.class);
    }
}
