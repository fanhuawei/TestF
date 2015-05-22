/**
 * MachineWarrantyDelayService.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;

import cn.com.mobilereal.test.dbbean.MachineWarrantyDelay;

/**
 * <p>ClassName: MachineWarrantyDelayService</p>
 * <p>Description: 机器延保记录业务类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class MachineWarrantyDelayService extends BaseCrudService<MachineWarrantyDelay> {
    /**
     * 实例
     */
    public static final MachineWarrantyDelayService I = ServiceFactory.makeService(MachineWarrantyDelayService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public MachineWarrantyDelayService() {
       super(MachineWarrantyDelay.I, MachineWarrantyDelay.class);
    }
}
