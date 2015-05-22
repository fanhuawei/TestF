/**
 * OperateLogWebService.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.PageBean;
import cn.com.mobilereal.common.util.ServiceFactory;
import cn.com.mobilereal.framework.dbbean.OperateLogWeb;


/**
 * 
 * <p>ClassName: OperateLogWebService</p>
 * <p>Description: WEB操作日志管理的业务类</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date:2014-10-16</p>
 */
@SuppressWarnings("serial")
public class OperateLogWebService extends BaseCrudService<OperateLogWeb> {
    /**
     * 实例
     */
    public static final OperateLogWebService I = ServiceFactory.makeService(OperateLogWebService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public OperateLogWebService() {
       super(OperateLogWeb.I, OperateLogWeb.class);
    }

    @Override
    public PageBean searchByExample(int pageNo, int pageSize, OperateLogWeb filter) {
        
        return super.searchByWhere(pageNo, pageSize, "ORDER BY CREATE_TIME DESC,ID");
    }
    
    
    
    
    
}
