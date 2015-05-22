package cn.com.mobilereal.common.web;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import cn.com.mobilereal.common.action.MobileAction;
import cn.com.mobilereal.common.action.MobileActionEnum;
import cn.com.mobilereal.common.dao.BaseBean;
import cn.com.mobilereal.common.ui.WebAction;
import cn.com.mobilereal.common.util.ConfigInfo;
import cn.com.mobilereal.common.util.JDBCUtil;
import cn.com.mobilereal.common.util.StringUtil;
import cn.com.mobilereal.common.util.ThreadLocalBean;
import cn.com.mobilereal.framework.dbbean.User;

public class BaseHttpServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 821435791131800154L;

	protected transient Logger log = Logger.getLogger(getClass());
  
	protected String makeError(Throwable thr){
        StringWriter sw = new StringWriter();
        thr.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }

	@Override
    final protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    if (!req.getClass().equals(CustomHttpServletRequest.class)) {
            req = new CustomHttpServletRequest(req);           
        }
        ThreadLocalBean.setResponse(res);
        HttpSession sess = req.getSession(false);
        if (sess!=null) {
          User user = (User)sess.getAttribute(ConfigInfo.$.getUserKey());
          if (user!=null){
            ThreadLocalBean.setUser(user);
          }
        }
        super.service(req, res);
    }

    protected ResponseObject doMobileMethodInTransaction(
			MobileAction actionObj, MobileActionEnum action) {
		JDBCUtil.beginTransaction();
		try {
	        actionObj.check();
			ResponseObject res = actionObj.execute(action);
			JDBCUtil.commit();
			return res;
		} catch (SynchronizedException e) {
			JDBCUtil.rollback();
			throw e;
		} catch (Exception e) {
		    log.error(makeError(e));
			JDBCUtil.rollback();
			return new ResponseObject(1, action.getComment() + "失败");
		}
	}
	
	protected void doWebMethodInTransaction(
			WebAction actionObj, Method method) {
		JDBCUtil.beginTransaction();
		try {
		    log.debug("开始执行Action类的方法:" + method);
		    method.invoke(actionObj);
			log.debug("结束执行Action类的方法:" + method);
			JDBCUtil.commit();
		} catch (BusinessException e) {
			JDBCUtil.rollback();
			throw e;
		} catch (InvocationTargetException e) {
			JDBCUtil.rollback();
			Throwable ee = e.getTargetException();
			if (ee instanceof BusinessException){
			   throw (BusinessException)ee;
			}else if (ee instanceof RuntimeException){
				throw (RuntimeException)ee;
			}else{
			    throw new RuntimeException(ee.getMessage(),ee.getCause());
			}
		}catch(Throwable e){
			JDBCUtil.rollback();
			throw new RuntimeException(e.getMessage(),e.getCause());
		}
	}

	private Field makeField(Class<?> cls, String name) {
		Field field = null;
		try {
			field = cls.getDeclaredField(name);
		} catch (Exception e) {

		}
		if (field == null) {
			if (cls.getSuperclass() == null) {
				return null;
			}
			return makeField(cls.getSuperclass(), name);
		} else {
			return field;
		}
	}

	private void processFieldValue(HttpServletRequest req, Object actionObject,
			String name, String[] values) {
		Field field = makeField(actionObject.getClass(), name);
		if (field == null)
			return;
		if (!field.isAccessible()) {
			field.setAccessible(true);
		}
		if (field.getType() == PartInfo.class) {
			Part part = null;
			try {
				part = req.getPart(field.getName());
			} catch (Exception e) {

			}
			if (part == null) {
				return;
			}
			try {
				field.set(actionObject, new PartInfo(part));
			} catch (Exception e) {
			}
		}
		if (values == null || values.length == 0)
			return;
		if (field.getType().isArray()) {
			Class<?> componentType = field.getType().getComponentType();
			if (componentType.equals(PartInfo.class)){
			 try {
                Collection<Part> parts = req.getParts();
                int size = parts.size();
                PartInfo[] partList = new PartInfo[size];
                int idx = 0;
                for (Part part : parts) {
                    partList[idx] = new PartInfo(part);
                    idx++;
                }
                field.set(actionObject, partList);             
            } catch (Exception e) {
                throw new RuntimeException(e);
            } 
			}
			PropertyEditor pe = PropertyEditorManager.findEditor(componentType);
			if (pe != null) {
			    List<String> vaList = new ArrayList<String>();
			    for (String str : values) {
                    if (StringUtil.isEmpty(str)){
                      continue;
                    }
                    vaList.add(str.trim());
                }
                int size = vaList.size();
                Object obj = null;
                if (size>0){
                    obj = Array.newInstance(componentType, size);
                    for (int j=0;j<size;j++) {
                        pe.setAsText(vaList.get(j));
                        Array.set(obj, j, pe.getValue());
                    }
                }			    
				try {
					field.set(actionObject, obj);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			} else {
				log.warn(actionObject.getClass().getSimpleName() + ":["
						+ field.getName() + "]属性值不能注入");
			}
		} else {
			String pvalue = values[0];
			if (pvalue == null)
				return;
			if (pvalue.length() == 0) {
				try {
					field.set(actionObject, null);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				return;
			}
			PropertyEditor pe = PropertyEditorManager.findEditor(field.getType());
			if (pe != null && pvalue != null) {				
				try {
				    pe.setAsText(pvalue);
					field.set(actionObject, pe.getValue());
				} catch (Exception e) {
					//throw new RuntimeException(e);
					try {
                        field.set(actionObject, null);
                    } catch (IllegalArgumentException e1) {
                    } catch (IllegalAccessException e1) {
                    }
				}
			} else {
				log.warn(actionObject.getClass().getSimpleName() + ":["
						+ field.getName() + "]属性值不能注入");
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
    protected void processParameter(Object actionObject, HttpServletRequest req)
			throws Exception {
	    log.debug("开始处理Web参数");
		Map<String, String[]> params = req.getParameterMap();		
		for (Map.Entry<String, String[]> item : params.entrySet()) {
            String name = item.getKey();
            String[] value = item.getValue();
            int idx = name.indexOf(".");
            int index = -1;
            Class<?> beanCls = null;
            if (idx > 0) {
                String name1 = name.substring(0, idx);
                String name2 = name.substring(idx + 1);
                if (name1.endsWith("]")){
                   int preidx = name1.indexOf("[");
                   index = new Integer(name1.substring(preidx+ 1,name1.length()-1));
                   name1 = name1.substring(0, preidx);                 
                }
                Field field = makeField(actionObject.getClass(), name1);
                if (field == null)
                    return;
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                Type type = field.getGenericType();
                if (type instanceof ParameterizedType){
                    ParameterizedType pt =(ParameterizedType)type;
                    beanCls =(Class<?>) pt.getActualTypeArguments()[0];
                }
                Object bean = field.get(actionObject);          
                if (bean == null) {         
                        if (beanCls!=null){
                            bean = new ArrayList();
                        }else{
                        if (field.getType().equals(BaseBean.class)){
                           ParameterizedType pt = (ParameterizedType)actionObject.getClass().getGenericSuperclass();
                           Class<?> cls= (Class<?>)pt.getActualTypeArguments()[0];
                           bean = cls.newInstance();
                        }else{
                           bean = field.getType().newInstance();
                        }
                        }
                    field.set(actionObject, bean);
                }
                if (index >= 0){
                  List beanList = (List)bean;
                  if (beanList.size()>index){
                    bean = beanList.get(index);
                  }else{
                    bean = beanCls.newInstance();
                    beanList.add(bean);
                  }              
                }
                processFieldValue(req, bean, name2, value);
                continue;
            }
            processFieldValue(req, actionObject, name, value);
        }
		String contentType = req.getContentType();
        if (!StringUtil.isEmpty(contentType) && contentType.contains("multipart/form-data")) {
            Collection<Part> partList = req.getParts();
            if (partList != null && partList.size() > 0) {
                List<PartInfo> partInfoList = new ArrayList<PartInfo>();
                for (Part part : partList) {
                    if (!StringUtil.isEmpty(part.getContentType()) && part.getSize()>0) {
                        partInfoList.add(new PartInfo(part));
                    }
                }
                if (partInfoList.size() > 0) {
                    Field[] flist = actionObject.getClass().getDeclaredFields();
                    for (Field field : flist) {
                        if (field.getType().equals(PartInfo.class)) {
                            if (!field.isAccessible()) {
                                field.setAccessible(true);
                            }
                            field.set(actionObject, partInfoList.get(0));
                        }
                        if (field.getType().isArray()) {
                            Class<?> componentType = field.getType().getComponentType();
                            if (componentType.equals(PartInfo.class)) {
                                try {
                                    if (!field.isAccessible()) {
                                        field.setAccessible(true);
                                    }
                                    field.set(actionObject, partInfoList.toArray(new PartInfo[0]));
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    }
                }
            }
        }
	}
	
	protected String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    } 
}
