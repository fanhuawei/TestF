/**
 * MenuFunctionService.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;
import cn.com.mobilereal.framework.dbbean.MenuFunction;


/**
 * 
 * <p>ClassName: MenuFunctionService</p>
 * <p>Description: 系统菜单及功能页面管理的业务类</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date:2014-10-16</p>
 */
@SuppressWarnings("serial")
public class MenuFunctionService extends BaseCrudService<MenuFunction> {
    /**
     * 实例
     */
    public static final MenuFunctionService I = ServiceFactory.makeService(MenuFunctionService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public MenuFunctionService() {
       super(MenuFunction.I, MenuFunction.class);
    }
}
