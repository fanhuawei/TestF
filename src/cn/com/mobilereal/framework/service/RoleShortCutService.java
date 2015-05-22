/**
 * RoleShortCutService.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;
import cn.com.mobilereal.framework.dbbean.RoleShortCut;


/**
 * 
 * <p>ClassName: RoleShortCutService</p>
 * <p>Description: 角色的快捷方式信息管理的业务类</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date:2014-10-16</p>
 */
@SuppressWarnings("serial")
public class RoleShortCutService extends BaseCrudService<RoleShortCut> {
    /**
     * 实例
     */
    public static final RoleShortCutService I = ServiceFactory.makeService(RoleShortCutService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public RoleShortCutService() {
       super(RoleShortCut.I, RoleShortCut.class);
    }
}
