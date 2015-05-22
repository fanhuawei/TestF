package cn.com.mobilereal.common.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectUtil {

	public static void forward(String url) {
		HttpServletRequest req = ThreadLocalBean.getRequest();
		HttpServletResponse res = ThreadLocalBean.getResponse();
		try {
		    if (url.startsWith("/")){
			   req.getRequestDispatcher(url).forward(req, res);
			   ThreadLocalBean.setGoon(false);
		    } else{
		    	throw new RuntimeException("[" + url + "]必须以[/]开头");
		    }
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("[" + url + "]跳转失败");
		}

	}
	public static void print(Object value) {
        HttpServletResponse res = ThreadLocalBean.getResponse();
        try {
            res.getWriter().print(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ThreadLocalBean.setGoon(false);
     
    }
	public static void include(String url) {
        HttpServletRequest req = ThreadLocalBean.getRequest();
        HttpServletResponse res = ThreadLocalBean.getResponse();
        try {
            if (url.startsWith("/")){
               req.getRequestDispatcher(url).include(req, res);
               ThreadLocalBean.setGoon(false);
            } else{
                throw new RuntimeException("[" + url + "]必须以[/]开头");
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("[" + url + "]跳转失败");
        }

    }

	public static void redirect(String url) {
		HttpServletRequest req = ThreadLocalBean.getRequest();
		HttpServletResponse res = ThreadLocalBean.getResponse();
		try {
			if (url.startsWith("/")){
			   res.sendRedirect(req.getContextPath() + url);
			   ThreadLocalBean.setGoon(false);
			} else if (url.toLowerCase().startsWith("http")){
				res.sendRedirect(url);
				 ThreadLocalBean.setGoon(false);
			}else{
				throw new RuntimeException("[" + url + "]必须以[/]或[http]开头");
			}
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("[" + url + "]跳转失败");
		}

	}
}
