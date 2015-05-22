/**
 * PartBaseService.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;

import cn.com.mobilereal.test.dbbean.PartBase;

/**
 * <p>ClassName: PartBaseService</p>
 * <p>Description: 配件库业务类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class PartBaseService extends BaseCrudService<PartBase> {
    /**
     * 实例
     */
    public static final PartBaseService I = ServiceFactory.makeService(PartBaseService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public PartBaseService() {
       super(PartBase.I, PartBase.class);
    }
}
