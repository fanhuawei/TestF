/**
 * LogContainer.java
 * Created at 2014年12月3日
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.common.bean;

import java.sql.Timestamp;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.log4j.Logger;

import cn.com.mobilereal.common.util.DateUtil;
import cn.com.mobilereal.common.util.JDBCUtil;
import cn.com.mobilereal.common.util.LogUtil;
import cn.com.mobilereal.framework.service.OperateLogMobileService;
import cn.com.mobilereal.framework.service.OperateLogService;
import cn.com.mobilereal.framework.service.OperateLogWebService;

/**
 * <p>
 * ClassName: LogContainer
 * </p>
 * <p>
 * Description: 日志容器
 * </p>
 * <p>
 * Author: Fanhuawei
 * </p>
 * <p>
 * Date: 2014年12月3日
 * </p>
 */
 
public class LogContainer extends Thread {
    private Logger log = Logger.getLogger(LogContainer.class);

    private ConcurrentLinkedQueue<LogBean> list = new ConcurrentLinkedQueue<LogBean>();
    public static LogContainer I = new LogContainer();

    private boolean goon = true;

    private LogContainer() {

    }

    public void init() {
        long monthBySecond = 30 * 24 *3600 * 1000l;
        Timestamp timeBeforeMonth = DateUtil.getSystemTimestampBeforeSecond(monthBySecond);
        OperateLogService.I.deleteByWhere("WHERE CREATE_TIME<?", timeBeforeMonth);
        OperateLogWebService.I.deleteByWhere("WHERE USER_ID IS NULL OR CREATE_TIME<?", timeBeforeMonth);
        OperateLogMobileService.I.deleteByWhere("WHERE CREATE_TIME<?", timeBeforeMonth);
    }
    public synchronized void destroy() {
        goon = false;
        notifyAll();
    }

    public synchronized void add(LogBean bean) {
        list.add(bean);
        notifyAll();
    }

    public LogBean get() {
        return list.poll();
    }

    public void run() {
        while (goon) {
            LogBean bean = get();
            if (bean == null) {
                try {
                    wait();
                } catch (Exception e) {
                }
            } else {
                JDBCUtil.beginTransaction();
                try {
                    if (bean.getMenu() != null) {
                        LogUtil.logWeb(bean.getUserId(), bean.getRoleId(), bean.getSessionId(), bean.getClientIp(),
                                bean.getParameter(), bean.getMenu(), bean.getAction(), bean.getResult(), bean.getReason());
                    } else {
                        LogUtil.logMobile(bean.getUserId(), bean.getRoleId(), bean.getSn(), bean.getPath(),
                                bean.getParameter(), bean.getMobileAction(), bean.getResult(), bean.getReason());
                    }
                    JDBCUtil.commit();
                } catch (Exception e) {
                    log.error(e.getMessage(), e.getCause());
                    JDBCUtil.rollback();
                }                
            }
        }
    }
}
