/**
 * ApnsMessageReceiverService.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;

import cn.com.mobilereal.test.dbbean.ApnsMessageReceiver;

/**
 * <p>ClassName: ApnsMessageReceiverService</p>
 * <p>Description: 推送消息接受人业务类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class ApnsMessageReceiverService extends BaseCrudService<ApnsMessageReceiver> {
    /**
     * 实例
     */
    public static final ApnsMessageReceiverService I = ServiceFactory.makeService(ApnsMessageReceiverService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public ApnsMessageReceiverService() {
       super(ApnsMessageReceiver.I, ApnsMessageReceiver.class);
    }
}
