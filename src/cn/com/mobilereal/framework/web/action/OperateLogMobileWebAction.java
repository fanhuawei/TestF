/**
 * OperateLogMobileWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.web.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;
import cn.com.mobilereal.common.util.ConstUtil;
import cn.com.mobilereal.common.util.DateUtil;
import cn.com.mobilereal.common.util.JSPFunction;
import cn.com.mobilereal.common.util.SQLUtil;
import cn.com.mobilereal.framework.dbbean.OperateLogMobile;
import cn.com.mobilereal.framework.service.OperateLogMobileService;

/**
 * <p>ClassName: OperateLogMobileWebAction</p>
 * <p>Description: MOBILE操作日志管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class OperateLogMobileWebAction extends BaseCrudWebAction<OperateLogMobile> {

    private String keyword;
    private String deviceSn;
    private Timestamp startTime;
    private Timestamp endTime;
  
    /**
     * <p>Description: 构造方法</p>
     */
    public OperateLogMobileWebAction() {
        this.service = OperateLogMobileService.I;
    }

    @Override
    public void search() {
        SQLUtil util = SQLUtil.start("LEFT JOIN TS_USER U ON A.USER_ID=U.ID WHERE A.DELETE_MARK=?",ConstUtil.FLAG.NO);
        util.like("U.NAME", keyword);
        util.like("A.DEVICE_SN", deviceSn);
        util.ge("A.CREATE_TIME", DateUtil.convertToStartTime(startTime));
        util.lt("A.CREATE_TIME", DateUtil.convertToEndTime(endTime));
        util.appendSQL("ORDER BY ID DESC");
        log.info(util.getSql());
        log.info(util.getArgu());
        this.pageBean = service.searchByWhere(pageNo, pageSize, util.getSql(), util.getArgu().toArray());
        @SuppressWarnings("unchecked")
        List<OperateLogMobile> beanList = (List<OperateLogMobile>)pageBean.getList();
        List<Long> uidList = new ArrayList<Long>();
        List<Long> ridList = new ArrayList<Long>();
        for (OperateLogMobile bean : beanList) {
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

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }
}
