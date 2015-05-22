/**
 * LoginWebAction.java
 * Created at 2014-06-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.web.action;

import javax.servlet.http.Cookie;

import cn.com.mobilereal.common.ui.BaseWebAction;
import cn.com.mobilereal.common.util.ConfigInfo;
import cn.com.mobilereal.common.util.ConstUtil;
import cn.com.mobilereal.common.util.MD5Util;
import cn.com.mobilereal.common.util.StringUtil;
import cn.com.mobilereal.common.util.ThreadLocalBean;
import cn.com.mobilereal.common.web.BusinessException;
import cn.com.mobilereal.framework.web.service.LoginService;


/**
 * 
 * <p>ClassName: LoginWebAction</p>
 * <p>Description: 登录用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014年6月17日</p>
 */
@SuppressWarnings("serial")
public class LoginWebAction extends BaseWebAction {
    /**
     * 自动登录的有效时间
     */
    final int days = 3;
    
    /**
     * Cookie的分段数
     */
    final int cookieLen = 3;

    /**
     * 登录名
     */
    private String loginCode;
    
    /**
     * 登录密码
     */
    private String loginPass;
    
    /**
     * 自动登录
     */
    private String autoLogin;
    
    /**
     * 员工工号直接登录
     */
    private String hack;
    
    @Override
    public void init() {
        if (!StringUtil.isEmpty(this.hack)) {
            LoginService.I.loginByCode(this.hack);
            return;
        }
        if (ThreadLocalBean.getUser() != null) {
            log.info("用户已登录：" + ThreadLocalBean.getUser().getName());
            return;
        }
        String userCode = ThreadLocalBean.getRequest().getHeader("iv-user");
        if (!StringUtil.isEmpty(userCode) && !"null".equals(userCode)){
            log.info("LDAP的单点登录请求:iv-user=" + userCode);            
            LoginService.I.loginByCode(userCode);            
        } else {
           autoLogin();
        }
    }
    /**
     * <p>Description: 异常测试</p>
     */
    public void exception() {
        throw new BusinessException("用户名不对");
    }
    /**
     * <p>Description: 异常测试</p>
     */
    public void sysext() {
        throw new RuntimeException("系统错误");
    }
    /**
     * <p>Description: 登录操作</p>
     */
    public void autoLogin() {
        log.info("开始自动登录");
        Cookie autoLoginCookie = null;
        final Cookie[] CS = getRequest().getCookies();
        if (CS == null) {
            return;
        }
        for (int i = 0; i < CS.length; i++) {
            if ("autoLogin".equals(CS[i].getName())) {
                autoLoginCookie = CS[i];
                final String[] XX = autoLoginCookie.getValue().split(":");
                if (XX.length == this.cookieLen) {
                    log.info(String.format("auto login: %s,%s,%s", XX[0], XX[1], XX[this.cookieLen - 1]));
                    //过期判断
                    if (new Long(XX[1]) < System.currentTimeMillis()) {
                        return;
                    } else {
                        LoginService.I.autoLogin(XX[0], XX[1], XX[this.cookieLen - 1]);
                    }
                }
                return;
            }
        }
    
    }
    
    
    /**
     * <p>Description: 登录操作</p>
     */
    public void login() {
        LoginService.I.login(this.loginCode, this.loginPass);
        Cookie autoLoginCookie = null;
        if (ConstUtil.FLAG.YES.equalsIgnoreCase(this.autoLogin)) {
            autoLoginCookie = new Cookie("autoLogin", null);
            autoLoginCookie.setMaxAge(ConstUtil.NUM.SECOND_PER_DAY * this.days);
            autoLoginCookie.setPath(getRequest().getContextPath() + "/System.do");
            final Long TS = System.currentTimeMillis() + this.days * ConstUtil.NUM.MI_SECOND_PER_DAY;
            autoLoginCookie.setValue(this.loginCode + ":" + TS + ":"
                    + MD5Util.md5(this.loginCode + ":" + TS + ":" + this.loginPass));
            getResponse().addCookie(autoLoginCookie);
        }
        if (ConstUtil.FLAG.NO.equalsIgnoreCase(this.autoLogin)) {
            autoLoginCookie = new Cookie("autoLogin", null);
            autoLoginCookie.setMaxAge(0);
            autoLoginCookie.setPath(getRequest().getContextPath() + "/System.do");
            getResponse().addCookie(autoLoginCookie);
        }
    }
    
    /**
     * 
     * <p>Description: 收集button.</p>
     */
    public void collectButton() {
        if (ConfigInfo.$.isCollectButton()) {
            ConfigInfo.$.setCollectButton(false);
        } else {
            ConfigInfo.$.setCollectButton(true);
        }
    }
    
    /**
     * 
     * <p>Description: 进入测试页.</p>
     */
    public void test() {
        
    }
    
    /**
     * 
     * <p>Description: 检查权限.</p>
     */
    public void checkRight() {
        if (ConfigInfo.$.isCheckRight()) {
            ConfigInfo.$.setCheckRight(false);
        } else {
            ConfigInfo.$.setCheckRight(true);
        }
    }
}
