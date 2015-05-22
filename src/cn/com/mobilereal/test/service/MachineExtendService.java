/**
 * MachineExtendService.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;

import cn.com.mobilereal.test.dbbean.MachineExtend;

/**
 * <p>ClassName: MachineExtendService</p>
 * <p>Description: 机器扩展属性业务类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class MachineExtendService extends BaseCrudService<MachineExtend> {
    /**
     * 实例
     */
    public static final MachineExtendService I = ServiceFactory.makeService(MachineExtendService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public MachineExtendService() {
       super(MachineExtend.I, MachineExtend.class);
    }
}
