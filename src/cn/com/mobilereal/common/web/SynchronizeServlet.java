package cn.com.mobilereal.common.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.mobilereal.common.action.HttpParameterAnnotation;
import cn.com.mobilereal.common.action.MobileAction;
import cn.com.mobilereal.common.action.MobileActionEnum;
import cn.com.mobilereal.common.bean.LogBean;
import cn.com.mobilereal.common.bean.LogContainer;
import cn.com.mobilereal.common.util.ConfigInfo;
import cn.com.mobilereal.common.util.ThreadLocalBean;

@SuppressWarnings("serial")
@WebServlet(name = "SynchronizeServlet", loadOnStartup = 20, urlPatterns = "/MobileService")
@MultipartConfig(location=".",maxFileSize=100*1024*1024)
public class SynchronizeServlet extends BaseHttpServlet {

	private Map<String, MobileAction> actionMap = new HashMap<String, MobileAction>();
	private MobileActionEnum[] actionList = MobileActionEnum.values();
	@Override
	public void init() throws ServletException {
	    log.info("SynchronizeServlet初始化");
		for (MobileActionEnum actionEnum : actionList) {
			Class<? extends MobileAction> cls = actionEnum.getActionCls();
			if (cls.getAnnotation(HttpParameterAnnotation.class) == null) {
				if (actionMap.get(cls.getName()) == null) {
					try {
					    log.debug("创建Action对象:" + cls.getSimpleName());
						actionMap.put(cls.getName(), cls.newInstance());
					} catch (Exception e) {
						log.error(e);
					}
				}
			}else{
			  log.debug(cls.getSimpleName() + " : HttpParameterAnnotation");
			}
		}
	}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doService(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doService(req, resp);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	protected void doService(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String result = "S";
		String reason = null;
		MobileActionEnum currentAction=null;
		ResponseObject resObj = null;
		String action = req.getParameter("action");
		ThreadLocalBean.setAction(action);
		ThreadLocalBean.setWebAction(false);
		try {			
			boolean isFound = false;
			for (MobileActionEnum actionEnum : actionList) {
				if (action.equalsIgnoreCase(actionEnum.getAction())) {
				    currentAction = actionEnum;
					isFound = true;
					Class<? extends MobileAction> actionCls = actionEnum.getActionCls();
					MobileAction actionObject = null;
					if (actionCls.getAnnotation(HttpParameterAnnotation.class) != null) {
						log.info("创建Action对象:" + actionCls.getSimpleName());
						actionObject = actionCls.newInstance();
						processParameter(actionObject, req);
					} else {
						actionObject = actionMap.get(actionCls.getName());
					}
					resObj = doMobileMethodInTransaction(actionObject, actionEnum);
					if (resObj == null)
						return;
					break;
				}
			}
			if (!isFound) {
			    reason = "请求参数[action]不正确";
				resObj = new ResponseObject(200, reason);
				result = "F";				
			}
		} catch (SynchronizedException e) {
		    result = "F";
		    reason = makeError(e);
		    log.error(reason);
			resObj = new ResponseObject(e.getStatus(), e.getMsg());
		} catch (Throwable thr) {
		    result = "F";
		    reason = makeError(thr);
		    log.error(reason);
			resObj = new ResponseObject(999, "云端有故障,请稍候重试.");
		} finally {
			if (resObj == null)
				return;
			if(action.equalsIgnoreCase("uploadBoxData")){
			    ConfigInfo.$.setDebug(false);
			}
			if (ConfigInfo.$.isDebug()) {
				Map map = new HashMap();
				Map params = req.getParameterMap();
				Iterator iter = params.entrySet().iterator();
				while (iter.hasNext()) {
					Map.Entry item = (Map.Entry) iter.next();
					String[] values = (String[]) item.getValue();
					if (values.length == 1) {
						map.put(item.getKey(), values[0]);
					} else {
						map.put(item.getKey(), Arrays.asList(values));
					}
				}
				resObj.setDebug(map);
			}
            if (ConfigInfo.$.isLog()) {
                if (ThreadLocalBean.getUser() != null) {
                    Long uid = ThreadLocalBean.getUser().getId();
                    Long roleId = ThreadLocalBean.getUser().getRoleId();
                    LogContainer.I.add(new LogBean(uid, roleId, req.getServletPath(), reason, result, req
                            .getParameterMap(), currentAction, ThreadLocalBean.getDevice()));
                }
            }
		}
		if(action.equalsIgnoreCase("uploadBoxData")){
		    res.getWriter().write(resObj.backStatus());
		}else {
		    res.getWriter().write(resObj.toString());
		}
	}
}
