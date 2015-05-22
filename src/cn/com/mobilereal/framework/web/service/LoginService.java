/**
 * LoginService.java
 * Created at 2014-07-12
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.web.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.com.mobilereal.common.service.BaseService;
import cn.com.mobilereal.common.ui.MenuEnum;
import cn.com.mobilereal.common.util.ConfigInfo;
import cn.com.mobilereal.common.util.MD5Util;
import cn.com.mobilereal.common.util.ServiceFactory;
import cn.com.mobilereal.common.util.ThreadLocalBean;
import cn.com.mobilereal.common.web.BusinessException;
import cn.com.mobilereal.framework.dbbean.MenuFunction;
import cn.com.mobilereal.framework.dbbean.User;
import cn.com.mobilereal.framework.service.MenuButtonService;
import cn.com.mobilereal.framework.service.RoleService;
import cn.com.mobilereal.framework.service.ShortCutService;
import cn.com.mobilereal.test.service.DeptService;


/**
 * <p>ClassName: LoginService</p>
 * <p>Description: 登录用的Service</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014年7月12日</p>
 */
@SuppressWarnings("serial")
public class LoginService extends BaseService {
   /**
    * 实例
    */
    public static final LoginService I = ServiceFactory.makeService(LoginService.class);
    /**
     * 系统管理菜单id
     */
    static final int SYSTEM_MENU_ID = 9000;
   /**
    * 
    * <p>Description: 登录操作</p>
    * @param loginCode 登录名
    * @param loginPass 登录密码
    */
    public void login(String loginCode, String loginPass) {
        final User US = User.I.getUserByCode(loginCode);
        if (US == null) {
            throw new BusinessException("登录名不对");
        } else {
            if (!loginPass.equals(US.getLoginPass())) {
                throw new BusinessException("登录密码不对");
            } else {
                loginSucess(US);
            }
        }
    }
    
    /**
     * <p>Description: 工号登录</p>
     * @param code 工号
     * @return 是否成功
     */
    public boolean loginByCode(String code) {
        final User USER = User.I.getUserByCode(code);
        if (USER != null) {
            loginSucess(USER);
            return true;
        }
        return false;
    }
    
    /**
     * 
     * <p>Description: 登录成功后处理</p>
     * @param user 用户
     */
    public void loginSucess(User user) {
        final HttpSession SS = ThreadLocalBean.getRequest().getSession();
        final List<MenuFunction> ALL = MenuFunction.I.makeUserMenu(user.getId());
        if (ALL.size() == 0) {
            throw new BusinessException("用户没有被授权");
        }
        SS.setAttribute(ConfigInfo.$.getUserKey(), user);
        ThreadLocalBean.setUser(user);
        SS.setAttribute("userRole", RoleService.I.findById(user.getRoleId()));
        SS.setAttribute("userDept", DeptService.I.findById(user.getDeptId()));
        SS.setAttribute("userShortCut", ShortCutService.I.findByRoleId(user.getRoleId()));
        SS.setAttribute("userMenu", ALL);
        SS.setAttribute("userButton", MenuButtonService.I.getMenuButtonByUserId(user.getId()));
        SS.setAttribute("leftMenu", makeSystemMenu(ALL));
        SS.setAttribute("personalMenu", makePersonalMenu(ALL));
        
        
    }
    
    /**
     * 
     * <p>Description: 自动登录操作</p>
     * @param loginCode 登录名
     * @param time 过期时间
     * @param md 加密后的值
     */
    public void autoLogin(String loginCode, String time, String md) {
        final User US = User.I.getUserByCode(loginCode);
        if (US == null) {
            throw new BusinessException("自动登录失败");
        } else {
            if (!md.equalsIgnoreCase(MD5Util.md5(loginCode + ":" + time + ":" + US.getLoginPass()))) {
                throw new BusinessException("自动登录失败");
            } else {
                loginSucess(US);
            }
        }
    }
    
    /**
     * 
     * <p>Description: 获得系统配置子菜单</p>
     * @param all 用户所有菜单
     * @return 系统配置子菜单　
     */
    private List<MenuEnum> makeSystemMenu(List<MenuFunction> all) {
        List<MenuEnum> list = MenuEnum.makeSystemSubMenu();
        int size = list.size();
        for (int i = size -1 ;i>=0 ;i--){
            MenuEnum me = list.get(i);
            boolean hasRight = false;
            for (MenuFunction menuFunction : all) {
               if (me.getId().equals(menuFunction.getId())){
                  hasRight = true;
                  break;
               }
            }
            if (!hasRight){
               list.remove(i);
            }
        }
        return list;
    }
    
    /**
     * 
     * <p>Description: 获得个性化子菜单</p>
     * @param all 用户所有菜单
     * @return 系统配置子菜单　
     */
    private List<MenuEnum> makePersonalMenu(List<MenuFunction> all) {
        List<MenuEnum> list = MenuEnum.makePersonalMenu();
        int size = list.size();
        for (int i = size -1 ;i>=0 ;i--){
            MenuEnum me = list.get(i);
            boolean hasRight = false;
            for (MenuFunction menuFunction : all) {
               if (me.getId().equals(menuFunction.getId())){
                  hasRight = true;
                  break;
               }
            }
            if (!hasRight){
               list.remove(i);
            }
        }
        return list;
    }
}
