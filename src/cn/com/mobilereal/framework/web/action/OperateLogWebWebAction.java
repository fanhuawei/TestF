/**
 * OperateLogWebWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.web.action;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.com.mobilereal.common.ui.ActionTransfer;
import cn.com.mobilereal.common.ui.BaseCrudWebAction;
import cn.com.mobilereal.common.ui.DirectionEnum;
import cn.com.mobilereal.common.ui.MenuEnum;
import cn.com.mobilereal.common.util.ConstUtil;
import cn.com.mobilereal.common.util.DateUtil;
import cn.com.mobilereal.common.util.JSPFunction;
import cn.com.mobilereal.common.util.SQLUtil;
import cn.com.mobilereal.framework.dbbean.OperateLogWeb;
import cn.com.mobilereal.framework.service.OperateLogWebService;

/**
 * <p>ClassName: OperateLogWebWebAction</p>
 * <p>Description: WEB操作日志管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class OperateLogWebWebAction extends BaseCrudWebAction<OperateLogWeb> {

    private String keyword;
    private Timestamp startTime;
    private Timestamp endTime;

    @ActionTransfer(DirectionEnum.OUT)
    private OperateLogWeb webLog;
    /**
     * <p>Description: 构造方法</p>
     */
    public OperateLogWebWebAction() {
        this.service = OperateLogWebService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }
    
    @Override
    public void view() {
        super.view();
        webLog = bean;
        sendRedirect(MenuEnum.WEB_LOG_DETAIL);
    }
    
    @Override
    public void search() {
        SQLUtil util = SQLUtil.start("LEFT JOIN TS_USER U ON A.USER_ID=U.ID WHERE A.DELETE_MARK=?",ConstUtil.FLAG.NO);
        util.like("U.NAME", keyword);
        util.ge("A.CREATE_TIME", DateUtil.convertToStartTime(startTime));
        util.lt("A.CREATE_TIME", DateUtil.convertToEndTime(endTime));
        util.appendSQL("ORDER BY ID DESC");
        this.pageBean = service.searchByWhere(pageNo, pageSize, util.getSql(), util.getArgu().toArray());
        @SuppressWarnings("unchecked")
        List<OperateLogWeb> beanList = (List<OperateLogWeb>)pageBean.getList();
        Set<Long> uidList = new HashSet<Long>();
        Set<Long> ridList = new HashSet<Long>();
        for (OperateLogWeb bean : beanList) {
            if (bean.getUserId()!=null){
              uidList.add(bean.getUserId());
            }
            if (bean.getRoleId()!=null){
                ridList.add(bean.getRoleId());
            }
        }
        JSPFunction.initRequest("USER", uidList.toArray());
        JSPFunction.initRequest("ROLE", ridList.toArray());         
    }

}
