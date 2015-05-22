/**
 * UserWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.web.action;


import cn.com.mobilereal.common.ui.BaseCrudWebAction;
import cn.com.mobilereal.framework.dbbean.User;
import cn.com.mobilereal.framework.service.UserService;

/**
 * <p>ClassName: UserWebAction</p>
 * <p>Description: 系统用户管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class UserInfoWebAction extends BaseCrudWebAction<User> {


    /**
     * <p>Description: 构造方法</p>
     */
    public UserInfoWebAction() {
        this.service = UserService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {        
         view();
         setAction("view");      
    }
    @Override
    public void edit() {
        setChk(new Long[]{getCurrentUser().getId()});
        super.edit();
    }
    
    @Override
    public void view() {
        setChk(new Long[]{getCurrentUser().getId()});
        super.view();
    }
    @Override
    public void save() {
        super.save();
        setAction("view");
    }
    
    @Override
    public void cancel() {
        view();
        setAction("view");
    }
}
