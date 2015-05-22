/**
 * ApnsMessageService.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;

import cn.com.mobilereal.test.dbbean.ApnsMessage;

/**
 * <p>ClassName: ApnsMessageService</p>
 * <p>Description: 推送消息业务类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class ApnsMessageService extends BaseCrudService<ApnsMessage> {
    /**
     * 实例
     */
    public static final ApnsMessageService I = ServiceFactory.makeService(ApnsMessageService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public ApnsMessageService() {
       super(ApnsMessage.I, ApnsMessage.class);
    }
}
