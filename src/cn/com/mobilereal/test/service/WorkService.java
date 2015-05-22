/**
 * WorkService.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;

import cn.com.mobilereal.test.dbbean.Work;

/**
 * <p>ClassName: WorkService</p>
 * <p>Description: 代班业务类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class WorkService extends BaseCrudService<Work> {
    /**
     * 实例
     */
    public static final WorkService I = ServiceFactory.makeService(WorkService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public WorkService() {
       super(Work.I, Work.class);
    }
}
