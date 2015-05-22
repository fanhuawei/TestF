package cn.com.mobilereal.common.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import cn.com.mobilereal.common.util.ConfigInfo;
import cn.com.mobilereal.common.util.ThreadLocalBean;
import cn.com.mobilereal.framework.dbbean.User;

@WebFilter({ "*.do", "*.jsp", "/MobileService" })
public class SystemFilter implements Filter {

    private String encoding = "UTF-8";
 
    private transient Logger log = Logger.getLogger(getClass());

    public void destroy() {
        log.info("系统过滤器销毁");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        CustomHttpServletRequest req = new CustomHttpServletRequest((HttpServletRequest)request);
        String spath = req.getServletPath();
        req.setCharacterEncoding(encoding);
        res.setContentType("text/html;charset=" + encoding);
        res.setCharacterEncoding(encoding);
        res.setHeader("Pragma", "no-cache");
        res.setHeader("Cache-Control", "no-cache");
        res.setDateHeader("Expires", 0);
        printParameter(req);
        if (spath.endsWith("/MobileService") || spath.endsWith("/login.jsp")) {
            try {
                chain.doFilter(req, response);
            } catch (Exception e) {
                log.error(e.getMessage(), e.getCause());
            }
        } else if (spath.endsWith("Logout.do")) {
            log.info("退出系统，进入登录页面");
            req.getSession().invalidate();
            Cookie codeCook = new Cookie("autoLogin", null);
            codeCook.setMaxAge(0);
            codeCook.setPath(req.getContextPath() + "/System.do");
            res.addCookie(codeCook);
            res.sendRedirect(req.getContextPath() + "/login.jsp");
        } else {
            User user = (User) req.getSession().getAttribute(ConfigInfo.$.getUserKey());
            if (user != null) {
                log.info("Session用户:" + user.getCode());
                try {                   
                    ThreadLocalBean.setUser(user);
                    chain.doFilter(req, response);
                } catch (Exception e) {
                    log.error(e.getMessage(), e.getCause());
                }
            } else {
                log.info("用户没有登录");
                if (spath.endsWith(".do")) {
                    if (ConfigInfo.$.isLoginAccess()) {
                        if (!spath.endsWith("/System.do")) {
                            log.info("用户没有登录");
                            res.sendRedirect(req.getContextPath() + "/System.do");
                            return;
                        }
                    }
                } else if (spath.endsWith(".jsp")) {
                    String[] pathArr = spath.split("/");
                    if (pathArr.length > 2) {
                        res.sendRedirect(req.getContextPath() + "/login.jsp");
                        return;
                    }
                }                
                try {
                    chain.doFilter(req, response);
                } catch (Exception e) {
                    log.error(makeError(e));
                }
            }
        }
    }
    protected String makeError(Throwable thr){
        StringWriter sw = new StringWriter();
        thr.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
    public void init(FilterConfig config) throws ServletException {
        log.info("系统过滤器启动");
    }
    

    @SuppressWarnings("rawtypes")
    private void printParameter(HttpServletRequest req) {
        String servletPath = req.getServletPath();
        StringBuilder sb = new StringBuilder();
        sb.append("The accessed Servlet Path is : " + servletPath);
        Map map = req.getParameterMap();
        if (null != map && map.size() > 0) {
            Set set = map.keySet();
            Object[] obj = set.toArray();
            if (obj.length > 0) {
                sb.append("\n Request Parameter:{");
                for (int i = 0; i < obj.length; i++) {
                    String[] pars = req.getParameterValues((String) obj[i]);
                    if (pars != null && pars.length > 1) {
                        sb.append(obj[i] + ":[");
                        for (int j = 0; j < pars.length; j++) {
                            sb.append(pars[j]);
                            if (j < pars.length - 1) {
                                sb.append(",");
                            }
                        }
                        sb.append("]");
                    } else {
                        if (pars[0].length() == 0)
                            continue;
                        sb.append(obj[i] + ":'" + pars[0] + "'");
                    }
                    if (i < obj.length - 1) {
                        sb.append(",");
                    }
                    if (sb.length()>200){
                      sb.setLength(200);
                      break;
                    }
                }
                sb.append("}");
            }
        }
        log.info(sb);
    }
}
