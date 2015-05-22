package cn.com.mobilereal.common.web;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.mobilereal.common.bean.LogBean;
import cn.com.mobilereal.common.bean.LogContainer;
import cn.com.mobilereal.common.ui.ActionTransfer;
import cn.com.mobilereal.common.ui.BaseWebAction;
import cn.com.mobilereal.common.ui.DirectionEnum;
import cn.com.mobilereal.common.ui.MenuEnum;
import cn.com.mobilereal.common.util.ConfigInfo;
import cn.com.mobilereal.common.util.ConstUtil;
import cn.com.mobilereal.common.util.RedirectUtil;
import cn.com.mobilereal.common.util.StringUtil;
import cn.com.mobilereal.common.util.ThreadLocalBean;
import cn.com.mobilereal.framework.dbbean.MenuButton;
import cn.com.mobilereal.framework.dbbean.MenuFunction;


@WebServlet(name = "WebActionServlet", loadOnStartup = 10, urlPatterns = "*.do")
public class WebActionServlet extends BaseHttpServlet {

	private static final long serialVersionUID = 6526182555354636583L;
	
	private MenuEnum[] actionList = MenuEnum.values();
    private Map<Long, List<MenuButton>> menuButtonMap = null;
	
	@SuppressWarnings("unchecked")
    private void checkUserPrivilege(MenuEnum actionEnum,String action,HttpServletRequest req){
       if (!ConfigInfo.$.isCheckRight()) {
         return;
       }
	   if (actionEnum == MenuEnum.SYSTEM) {
	      return;
	   }
	   List<MenuFunction> list = (List<MenuFunction>) req.getSession().getAttribute("userMenu");
	   boolean isOk =false;
	   for (MenuFunction mf : list) {
          if (mf.getId().equals(actionEnum.getId())) {
              isOk = true;
              break;
          }
       }
       if (!isOk) {
         log.error("模块未授权");
         throw new UserPrivilegeException("模块未授权");
       } 
       if ("init".equalsIgnoreCase(action)) {
          return;
       }
       Map<Long, List<MenuButton>> userButtonMap = (Map<Long, List<MenuButton>>) req.getSession().getAttribute("userButton");
        if (menuButtonMap!=null && menuButtonMap.size() > 0 && userButtonMap!=null && userButtonMap.size() > 0) {
            List<MenuButton> mblist = menuButtonMap.get(actionEnum.getId());
            List<MenuButton> umblist = userButtonMap.get(actionEnum.getId());
            if (isInList(action, mblist) && !isInList(action, umblist)) {
                log.error("操作未授权");
                throw new UserPrivilegeException("操作未授权");
            }
        }
	}
	
	private boolean isInList(String action,List<MenuButton> list){
	   for (MenuButton mb : list) {
          if (ConstUtil.FLAG.YES.equalsIgnoreCase(mb.getGrantFlag()) && mb.getCode().equalsIgnoreCase(action)){
            return true;
          } 
       }
       return false;
	}
	
	@Override
    public void init() throws ServletException {
        log.info("WebActionServlet初始化");
	   //menuButtonMap = MenuButtonService.I.getButtonListGroupByMenuId();
    }
    
     
    private Object makeFieldValue(Field field, Object actionObject) throws Exception {
        Field ff = actionObject.getClass().getDeclaredField(field.getName());
        if (ff != null) {
            ActionTransfer at = ff.getAnnotation(ActionTransfer.class);
            if (at != null && (at.value() == DirectionEnum.OUT || at.value() == DirectionEnum.BOTH)) {
                ff.setAccessible(true);
                return ff.get(actionObject);
            }
        }
        return null;
    }
    
    private void processActionTransfer(HttpServletRequest req, Object preAction, BaseWebAction currentAction){
        Field field = null  ;
        ActionTransfer actionTransfer = null;
        Field[] fieldArr = currentAction.getClass().getDeclaredFields();
        for (int i = 0; i < fieldArr.length; i++) {
            field = fieldArr[i];
            actionTransfer = field.getAnnotation(ActionTransfer.class);
            if (actionTransfer!=null && (actionTransfer.value()==DirectionEnum.IN || actionTransfer.value()==DirectionEnum.BOTH)) {
               MenuEnum menu = actionTransfer.menu();
               if (currentAction.getPreMenuEnum() != menu){
                  if (actionTransfer.required()){
                    preAction = req.getSession().getAttribute(menu.getSessionKey());
                  }else{
                    preAction = null;
                  }
               }
               if (preAction == null){
                  return;
               } 
               field.setAccessible(true);
               try {
                  field.set(currentAction, makeFieldValue(field, preAction));
               } catch (Exception e) {
                   log.warn(e); 
               } 
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

    protected void doService(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
		BaseWebAction webAction = null;
		BaseWebAction webAction_session = null;
		String action = null;
		String reason = null;
		String result = "S";
		MenuEnum menu = null;
		String ajaxFlag = req.getParameter("ajaxFlag");
		String popupFlag = req.getParameter("popupFlag");
		try {
		    String path = req.getServletPath();
		    if (DispatcherType.INCLUDE == req.getDispatcherType()) {
		        path = (String)req.getAttribute("javax.servlet.include.servlet_path");
		    }		    
		    action = req.getParameter("action");
		    if (action==null || action.trim().length()==0){
	          action = "init";
		    }
			boolean isFound = false;
			for (MenuEnum actionEnum : actionList) {
				if (actionEnum.getActionCls()!=null && path.equalsIgnoreCase(actionEnum.getPrefixUrl())) {
				    checkUserPrivilege(actionEnum,action, req);
					isFound = true;
					menu = actionEnum;
					String key = actionEnum.getSessionKey();
					webAction_session =(BaseWebAction)req.getSession().getAttribute(key);
				    webAction = webAction_session;
				    log.debug("key=" + key + ",webAction=" + (webAction!=null) +",action=" + action);
				    if ("init".equalsIgnoreCase(action) || webAction==null) {
					     webAction = actionEnum.getActionCls().newInstance();
					     req.getSession().setAttribute(key, webAction);
					     webAction.setMenuEnum(actionEnum);
					}
				    BaseWebAction preWebAction = (BaseWebAction)req.getSession().getAttribute(ConfigInfo.$.getActionKey());
				    if (preWebAction!=null && (preWebAction.getMenuEnum()!=webAction.getMenuEnum() || "init".equalsIgnoreCase(action))) {
				        webAction.setPreMenuEnum(preWebAction.getMenuEnum());
				        processActionTransfer(req,preWebAction, webAction);
				    }
					req.getSession().setAttribute(ConfigInfo.$.getActionKey(), webAction);
					req.getSession().setAttribute(ConfigInfo.$.getFunctionKey(), actionEnum);
					if (actionEnum.isMenu()){
                        req.getSession().setAttribute(ConfigInfo.$.getMenuKey(), actionEnum);
                    }else{
                        if (actionEnum.getParent()!=null && actionEnum.getParent().isMenu()){
                            req.getSession().setAttribute(ConfigInfo.$.getMenuKey(), actionEnum.getParent());
                        }
                    }
					webAction.setResult(null);
					processParameter(webAction, req);					
					webAction.setAction(action);	
					Method method = null;
                    try {
                        method = webAction.getClass().getMethod(action);
                    } catch (Exception e) {
                        if (ConstUtil.FLAG.YES.equalsIgnoreCase(popupFlag)) {
                           break;
                        }else{
                          throw e;
                        }
                    }	
					doWebMethodInTransaction(webAction, method);
					if (webAction.getResult()==null) {
					    log.debug(webAction.getClass().getSimpleName() + "[" + action + "]执行完成");
						webAction.setResult(ResponseObject.SUCCESS_RES);
					}
					break;
				}
			}
			if (!isFound){
			   reason = "请求的路径不正确";
			   res.sendError(404, reason);
			   result = "F";			   
			}
		} catch (UserPrivilegeException be) {
		    result = "F"; 
		    reason = "你没有获得授权,请重新登录";
		    log.error(makeError(be));
            if (webAction!=null){
               webAction.setResult(new ResponseObject(999, reason));
            }            
            RedirectUtil.redirect("/Logout.do");
		} catch (BusinessException be) {
		    result = "F"; 
            reason = makeError(be);
            log.error(reason);
			if (webAction!=null){
			   webAction.setResult(new ResponseObject(1, be.getMessage()));
			}
		} catch (Throwable thr) {
		     result = "F"; 
		     String errorCode = StringUtil.makeErrorCode();
		     log.error("错误代码:" + errorCode);
	         reason = makeError(thr);
	         log.error(reason);
		     req.setAttribute("errorCode", errorCode);
			 req.setAttribute("sysexception", thr);
			 RedirectUtil.forward("/error.jsp");
		} finally {
		    if (ConfigInfo.$.isLog() && !action.startsWith("ajax")){
		        if (ThreadLocalBean.getUser() != null) {
		           Long uid = ThreadLocalBean.getUser().getId();
		           Long roleId = ThreadLocalBean.getUser().getRoleId();
		           LogContainer.I.add(new LogBean(uid, roleId, reason, result, req.getParameterMap(), req.getSession().getId(),  getIpAddr(req), menu, action));
		        }
            }
		    if (Boolean.TRUE.equals(ThreadLocalBean.getGoon())){
		        if (ConstUtil.FLAG.YES.equalsIgnoreCase(popupFlag)) {
		            log.info(menu.getModule() +"/"+ action + ".jsp");
		            req.getRequestDispatcher(menu.getModule() +"/"+ action + ".jsp").forward(req, res);
		            return;
		        }
                if (webAction != null) {
                    String file = webAction.makeNextPage();
                    String realFile = getServletContext().getRealPath(file);
                    if (action.startsWith("ajax")){
                        if (new File(realFile).exists()) {
                            req.getRequestDispatcher(file).include(req, res);
                        } else {
                            if (ConstUtil.FLAG.YES.equalsIgnoreCase(ajaxFlag)) {
                                req.getRequestDispatcher("/Action/AjaxAction.jsp").include(req, res);
                            }else{
                                req.getRequestDispatcher("/Action/CrudAction.jsp").include(req, res);
                            }                            
                        }                        
                    }else{
                        if (new File(realFile).exists()) {
                            req.getRequestDispatcher(file).forward(req, res);
                        } else {                            
                            if (ConstUtil.FLAG.YES.equalsIgnoreCase(ajaxFlag)) {
                                req.getRequestDispatcher("/Action/AjaxAction.jsp").forward(req, res);
                            }else{
                                req.getRequestDispatcher("/Action/CrudAction.jsp").forward(req, res);
                            }
                        }
                    }
                }
		    }
		    
		}
	}
}
