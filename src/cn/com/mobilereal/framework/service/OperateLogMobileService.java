/**
 * OperateLogMobileService.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;
import cn.com.mobilereal.framework.dbbean.OperateLogMobile;


/**
 * 
 * <p>ClassName: OperateLogMobileService</p>
 * <p>Description: MOBILE操作日志管理的业务类</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date:2014-10-16</p>
 */
@SuppressWarnings("serial")
public class OperateLogMobileService extends BaseCrudService<OperateLogMobile> {
    /**
     * 实例
     */
    public static final OperateLogMobileService I = ServiceFactory.makeService(OperateLogMobileService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public OperateLogMobileService() {
       super(OperateLogMobile.I, OperateLogMobile.class);
    }
}
