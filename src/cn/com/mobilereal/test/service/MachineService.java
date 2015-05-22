/**
 * MachineService.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;

import cn.com.mobilereal.test.dbbean.Machine;

/**
 * <p>ClassName: MachineService</p>
 * <p>Description: 机器业务类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class MachineService extends BaseCrudService<Machine> {
    /**
     * 实例
     */
    public static final MachineService I = ServiceFactory.makeService(MachineService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public MachineService() {
       super(Machine.I, Machine.class);
    }
}
