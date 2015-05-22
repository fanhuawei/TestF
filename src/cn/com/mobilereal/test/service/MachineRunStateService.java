/**
 * MachineRunStateService.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;

import cn.com.mobilereal.test.dbbean.MachineRunState;

/**
 * <p>ClassName: MachineRunStateService</p>
 * <p>Description: 机器运行状态业务类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class MachineRunStateService extends BaseCrudService<MachineRunState> {
    /**
     * 实例
     */
    public static final MachineRunStateService I = ServiceFactory.makeService(MachineRunStateService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public MachineRunStateService() {
       super(MachineRunState.I, MachineRunState.class);
    }
}
