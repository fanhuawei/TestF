/**
 * OtherMachineService.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;

import cn.com.mobilereal.test.dbbean.OtherMachine;

/**
 * <p>ClassName: OtherMachineService</p>
 * <p>Description: 客户其它厂家机器业务类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class OtherMachineService extends BaseCrudService<OtherMachine> {
    /**
     * 实例
     */
    public static final OtherMachineService I = ServiceFactory.makeService(OtherMachineService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public OtherMachineService() {
       super(OtherMachine.I, OtherMachine.class);
    }
}
