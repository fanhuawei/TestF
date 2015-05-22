/**
 * BaiduInfoService.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;

import cn.com.mobilereal.test.dbbean.BaiduInfo;

/**
 * <p>ClassName: BaiduInfoService</p>
 * <p>Description: 百度云推送信息业务类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class BaiduInfoService extends BaseCrudService<BaiduInfo> {
    /**
     * 实例
     */
    public static final BaiduInfoService I = ServiceFactory.makeService(BaiduInfoService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public BaiduInfoService() {
       super(BaiduInfo.I, BaiduInfo.class);
    }
}
