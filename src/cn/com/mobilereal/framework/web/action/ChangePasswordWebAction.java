/**
 * ChangePasswordWebAction.java
 * Created at 2014-06-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.web.action;

import cn.com.mobilereal.common.ui.BaseWebAction;
import cn.com.mobilereal.common.util.StringUtil;
import cn.com.mobilereal.common.web.BusinessException;
import cn.com.mobilereal.common.web.ResponseObject;
import cn.com.mobilereal.framework.dbbean.User;
import cn.com.mobilereal.framework.service.UserService;

/**
 * 
 * <p>ClassName: ChangePasswordWebAction</p>
 * <p>Description: 修改密码用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014年6月17日</p>
 */
@SuppressWarnings("serial")
public class ChangePasswordWebAction extends BaseWebAction {
    /**
     * 老密码
     */
    private String oldPass;
    /**
     * 新密码
     */
    private String newPass;    
    /**
     * 确认密码
     */
    private String newPass1;

    @Override
    public void init() {

    }

    public void save() {
        User user = (User) getCurrentUser();
        if (StringUtil.isEmpty(oldPass)) {
            throw new BusinessException("请输入原密码");
        }
        if (!oldPass.equals(user.getLoginPass())) {
            throw new BusinessException("原密码输入不正确.");
        }
        if (StringUtil.isEmpty(newPass)) {
            throw new BusinessException("请输入新密码");
        }
        if (StringUtil.isEmpty(newPass1)) {
            throw new BusinessException("请输入确认密码");
        } else {
            if (!newPass.equals(newPass1)) {
                throw new BusinessException("确认密码输入不正确");
            }
        }
        user.setLoginPass(newPass);
        UserService.I.save(user);
        setResult(new ResponseObject(0, "密码修改成功"));
    }
}
