/**
 * LogUtil.java
 * Created at 2014年11月27日
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.common.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

import cn.com.mobilereal.common.action.MobileActionEnum;
import cn.com.mobilereal.common.ui.MenuEnum;
import cn.com.mobilereal.framework.dbbean.OperateLog;
import cn.com.mobilereal.framework.dbbean.OperateLogMobile;
import cn.com.mobilereal.framework.dbbean.OperateLogWeb;

/**
 * <p>ClassName: LogUtil</p>
 * <p>Description: 日志工具类</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014年11月27日</p>
 */
public class LogUtil {
    /**
     * 
     * <p>Description: 记录移动端日志</p>
     * @param path 路径
     * @param parameter 参数
     * @param action action对象
     * @param result 结果
     * @param reason 原因
     */
    public static void logMobile(Long uid, Long roleId, String sn,String path, Map<String,String[]> parameter, MobileActionEnum action, String result, String reason) {
        OperateLogMobile log = new OperateLogMobile();
        log.setDeviceSn(sn);
        log.setUserId(uid);
        log.setRoleId(roleId);
        log.setActionCode(action.getAction());
        log.setParameter(makeParam(parameter));
        log.setActionName(action.getComment());
        log.setPath(path);
        if (reason!=null && reason.length()>1500){
            reason = reason.substring(0,1500);
        }
        log.setReason(reason);
        log.setResult(result);
        OperateLogMobile.I.save(log);
    }
    
    /**
     * 
     * <p>Description: 记录移动端日志</p>
     * @param path 路径
     * @param parameter 参数
     * @param action action对象
     * @param result 结果
     * @param reason 原因
     */
    public static void logWeb(Long uid, Long roleId,String sid, String clientIp,Map<String,String[]> parameter, MenuEnum menu, String action, String result, String reason) {
        
        if (menu == MenuEnum.MOBILE_LOG || menu == MenuEnum.WEB_LOG || menu == MenuEnum.WEB_LOG_DETAIL) {
          return;
        }
        OperateLogWeb webLog = OperateLogWeb.I.findOneBySessionId(sid);
        if (menu == MenuEnum.SYSTEM && (("login".equalsIgnoreCase(action) && "S".equalsIgnoreCase(result)) || ("init".equalsIgnoreCase(action) && uid!=null))) {
           if (webLog == null) {
             webLog = new OperateLogWeb();
             webLog.setSessionId(sid);
           }
           webLog.setRoleId(roleId);
           webLog.setLoginTime(DateUtil.getSystemTimestamp());
           webLog.setUserId(uid);
           webLog.setClientIp(clientIp);
           OperateLogWeb.I.save(webLog);
        }
        OperateLog olog = new OperateLog();
        olog.setActionCode(action);
        if (webLog!=null){
          olog.setLogId(webLog.getId());
        }              
        olog.setParameter(makeParam(parameter));
        olog.setActionName(JSPFunction.makeActionName(action));
        olog.setModule(menu.getName());
        olog.setPath(menu.getPath());
        if (reason!=null && reason.length()>1500){
          reason = reason.substring(0,1500);
        }
        olog.setReason(reason);
        olog.setResult(result);
        OperateLog.I.save(olog);
    }
    
    public static String makeParam(Map<String,String[]> paramMap){
        StringBuilder sb = new StringBuilder("{");
        Iterator<Map.Entry<String,String[]>> iter = paramMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String,String[]> item = iter.next();
            String[] values = (String[]) item.getValue();
            sb.append(item.getKey()).append(":");
            if (values.length == 1) {
                sb.append(values[0]);
            } else {
                sb.append(Arrays.toString(values));
            }
        }
        if (sb.length()>1500){
          sb.setLength(1500);
        }
        return sb.toString();    
    }

}
