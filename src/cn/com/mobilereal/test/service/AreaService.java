/**
 * AreaService.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;

import cn.com.mobilereal.test.dbbean.Area;

/**
 * <p>ClassName: AreaService</p>
 * <p>Description: 地区业务类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class AreaService extends BaseCrudService<Area> {
    /**
     * 实例
     */
    public static final AreaService I = ServiceFactory.makeService(AreaService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public AreaService() {
       super(Area.I, Area.class);
    }
}
