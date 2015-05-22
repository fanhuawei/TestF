package cn.com.mobilereal.common.web;

import java.beans.PropertyEditorManager;
import java.math.BigDecimal;
import java.util.Timer;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import cn.com.mobilereal.common.bean.LogContainer;
import cn.com.mobilereal.common.ui.MenuEnum;
import cn.com.mobilereal.common.util.ConfigInfo;
import cn.com.mobilereal.common.util.JDBCUtil;
import cn.com.mobilereal.common.util.JSPFunction;
import cn.com.mobilereal.common.util.PKUtil;
import cn.com.mobilereal.framework.service.ShortCutService;

/**
 * Application Lifecycle Listener implementation class SystemListener
 *
 */
@WebListener
public class SystemListener implements ServletContextListener,HttpSessionListener {

    @Resource(name = "jdbc/systemDS")
    private DataSource dataSource;

    private Timer timer;
    private transient Logger log = Logger.getLogger(getClass());
    /**
     * Default constructor. 
     */
    public SystemListener() {
    }
    
    public void contextInitialized(ServletContextEvent event) {
        String contextPath = event.getServletContext().getContextPath();
        event.getServletContext().setAttribute("ctx", contextPath);
        log.info("Web应用[" + contextPath + "]启动");
        ConfigInfo.$.setContextPath(contextPath);
        ConfigInfo.$.setContextRealPath(event.getServletContext().getRealPath("/"));
        if (dataSource != null) {
            JDBCUtil.setDataSource(dataSource);
        }
        PropertyEditorManager.registerEditor(BigDecimal.class, BigDecimalPropertyEditor.class);
        PropertyEditorManager.registerEditor(java.sql.Timestamp.class, TimestampPropertyEditor.class);
        PKUtil.$.initPK();
        JSPFunction.init();
        event.getServletContext().setAttribute("leftMenu", MenuEnum.makeSystemSubMenu());
        event.getServletContext().setAttribute("userMenu", MenuEnum.makeTopDisplayMenu());
        event.getServletContext().setAttribute("personalMenu", MenuEnum.makePersonalMenu());
        event.getServletContext().setAttribute("userShortCut", ShortCutService.I.findAll());
        if (ConfigInfo.$.isLog()){
          LogContainer.I.init();
        }
    }
   

    public void contextDestroyed(ServletContextEvent event) {
        if (timer != null) {
            timer.cancel();
        }
        if (ConfigInfo.$.isLog()){
            LogContainer.I.destroy();
        }
    }
    
    public void sessionCreated(HttpSessionEvent event) {
        log.info("session create. id=" + event.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        
    }   
	
}
