/**
 * OperateLogService.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.PageBean;
import cn.com.mobilereal.common.util.ServiceFactory;
import cn.com.mobilereal.framework.dbbean.OperateLog;


/**
 * 
 * <p>ClassName: OperateLogService</p>
 * <p>Description: 系统操作日志管理的业务类</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date:2014-10-16</p>
 */
@SuppressWarnings("serial")
public class OperateLogService extends BaseCrudService<OperateLog> {
    /**
     * 实例
     */
    public static final OperateLogService I = ServiceFactory.makeService(OperateLogService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public OperateLogService() {
       super(OperateLog.I, OperateLog.class);
    }
    
    public PageBean searchByCondition(int pageNo, int pageSize, String flag, Long userId) {
        StringBuilder sb = new StringBuilder("WHERE ");
        if ("W".equalsIgnoreCase(flag)){
           sb.append("MODULE<>'APP'");
        }else{
           sb.append("MODULE='APP'");
        }
        if (userId!=null){
            sb.append("AND USER_ID=").append(userId);
        }
        sb.append(" ORDER BY ID DESC");
        return dao.doPageQuery(pageNo, pageSize, sb.toString());
    }
}
