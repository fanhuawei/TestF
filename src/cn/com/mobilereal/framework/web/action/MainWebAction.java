/**
 * MainWebAction.java
 * Created at 2014-06-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.web.action;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import cn.com.mobilereal.common.ui.ActionTransfer;
import cn.com.mobilereal.common.ui.BaseWebAction;
import cn.com.mobilereal.common.ui.DirectionEnum;
import cn.com.mobilereal.common.util.DateUtil;
import cn.com.mobilereal.common.util.PageBean;
import cn.com.mobilereal.common.util.StringUtil;
import cn.com.mobilereal.common.web.BusinessException;


/**
 * 
 * <p>ClassName: MainWebAction</p>
 * <p>Description: 登录用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014年6月17日</p>
 */
@SuppressWarnings("serial")
public class MainWebAction extends BaseWebAction {
    /**
     * 搜索类型
     */
    private String searchType; //c,s,d,o
    
    /**
     * 关键字
     */
    @ActionTransfer(DirectionEnum.OUT)
    private String keyword;
    
    private PageBean pageBean;
    private Number numOrderCreate;
    private Number numOrderProcess;
    private Number numOrderFinish;
    private Number numOrderClose;
    
    private Number numAgent;
    private Number numCustomer;
    private Number numMachine;
    private Number numEngineer;
    
    private Timestamp today;
    private List<Map<String,Object>> chartList;
       
    @Override
    public void init() {
        today = DateUtil.getSystemTimestamp();
        if (log.isDebugEnabled()){
          log.debug(numOrderCreate);
          log.debug(numOrderProcess);
          log.debug(numOrderFinish);
          log.debug(numOrderClose);
          log.debug(numMachine);
          log.debug(numCustomer);
          log.debug(numEngineer);
          log.debug(numAgent);
          log.debug(chartList);
          log.debug(pageBean);
          log.debug(searchType);   
          log.debug(keyword);
          log.debug(today);          
        }
    }
    
    public void search(){
        if (StringUtil.isEmpty(keyword)) {
           throw new BusinessException("关键字不能为空");
        }
    }
}
