package cn.com.mobilereal.common.web;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import cn.com.mobilereal.common.ui.WebAction;
import cn.com.mobilereal.common.util.ConfigInfo;
import cn.com.mobilereal.common.util.ThreadLocalBean;

public class CustomHttpServletRequest extends HttpServletRequestWrapper {
    private ThreadLocalBean bean;

    public CustomHttpServletRequest(HttpServletRequest request) {
        super(request);
        bean = new ThreadLocalBean();
        ThreadLocalBean.setRequest(this);
    }
    
    public CustomHttpServletRequest() {
        this(null);
    }

    public ThreadLocalBean getBean() {
        return bean;
    }

    @Override
	public Object getAttribute(String name) {
		Object ret = super.getAttribute(name);
		if (ret == null) {
		   HttpSession ss = getSession(false);
		   if (ss==null) return null;
			WebAction action = (WebAction) ss.getAttribute(ConfigInfo.$.getActionKey());
			return makePropertyValue(action,name);
		} else {
			return ret;
		}
	}

    public Object makePropertyValue(Object bean, String name){
        try {
            return bean.getClass().getMethod("get" + name.substring(0,1).toUpperCase() + name.substring(1)).invoke(bean);
        } catch (Exception e) {
            Field field = null;
            try {
                field = bean.getClass().getDeclaredField(name);
                field.setAccessible(true);
                return field.get(bean);
            } catch (Exception e1) {
               return null;
            } 
        }
    }

	@Override
    public String[] getParameterValues(String name) {
	   String[] ret = super.getParameterValues(name);
	   if (ret==null) return null;
	   for (int i = 0; i < ret.length; i++) {
	     if (ret[i]!=null){
           ret[i] = ret[i].trim();
	     }
       }
       return ret;
    }

    @Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if (value!=null) return value.trim();
		return value;
	}
}
