/**
 * MachineBoxService.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;

import cn.com.mobilereal.test.dbbean.MachineBox;

/**
 * <p>ClassName: MachineBoxService</p>
 * <p>Description: 机器采集设备业务类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class MachineBoxService extends BaseCrudService<MachineBox> {
    /**
     * 实例
     */
    public static final MachineBoxService I = ServiceFactory.makeService(MachineBoxService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public MachineBoxService() {
       super(MachineBox.I, MachineBox.class);
    }
}
