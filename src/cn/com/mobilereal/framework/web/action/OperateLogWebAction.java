/**
 * OperateLogWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.web.action;

import cn.com.mobilereal.common.ui.ActionTransfer;
import cn.com.mobilereal.common.ui.BaseCrudWebAction;
import cn.com.mobilereal.common.ui.DirectionEnum;
import cn.com.mobilereal.common.ui.MenuEnum;
import cn.com.mobilereal.framework.dbbean.OperateLog;
import cn.com.mobilereal.framework.dbbean.OperateLogWeb;
import cn.com.mobilereal.framework.service.OperateLogService;

/**
 * <p>ClassName: OperateLogWebAction</p>
 * <p>Description: 系统操作日志管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class OperateLogWebAction extends BaseCrudWebAction<OperateLog> {

   
    @ActionTransfer(value=DirectionEnum.IN,required=true, menu=MenuEnum.WEB_LOG)
    private OperateLogWeb webLog;
   
    /**
     * <p>Description: 构造方法</p>
     */
    public OperateLogWebAction() {
        this.service = OperateLogService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }
    
    @Override
    public void search() {
        if (filter == null) {
           filter = new OperateLog();
        }
        if (webLog!=null){            
            filter.setLogId(webLog.getId()); 
        }
        super.search();
    }

}
