/**
 * BaseService.java
 * Created at 2014-08-25
 * Created by Fanhuawei
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package cn.com.mobilereal.common.service;

import org.apache.log4j.Logger;

/**
 * <p>ClassName: ServiceWithLog</p>
 * <p>Description: 所有Service的父类</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014年8月25日</p>
 */
public class ServiceWithLog implements Service {
    /**
     * 日志对象
     */
    protected Logger log;

    /**
     * <p>Description: 构造方法</p>
     */
    public ServiceWithLog() {
        this.log = Logger.getLogger(getClass());
    }
}
