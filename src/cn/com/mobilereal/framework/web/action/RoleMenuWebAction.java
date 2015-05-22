/**
 * RoleMenuWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;
import cn.com.mobilereal.common.ui.MenuEnum;
import cn.com.mobilereal.common.util.StringUtil;
import cn.com.mobilereal.framework.dbbean.MenuButton;
import cn.com.mobilereal.framework.dbbean.MenuFunction;
import cn.com.mobilereal.framework.dbbean.RoleMenu;
import cn.com.mobilereal.framework.service.MenuButtonService;
import cn.com.mobilereal.framework.service.RoleButtonService;
import cn.com.mobilereal.framework.service.RoleMenuService;
import cn.com.mobilereal.framework.service.RoleService;

/**
 * <p>ClassName: RoleMenuWebAction</p>
 * <p>Description: 系统角色权限管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class RoleMenuWebAction extends BaseCrudWebAction<RoleMenu> {
    /**
     * 一级菜单
     */
    private List<MenuEnum> topMenuList;    
    
    /**
     * 所有按钮
     */
    private Map<Long, List<MenuButton>> menuButtonMap;

    /**
     * 角色的按钮id
     */
    private List<Long> roleButtonId;
    
    /**
     * 角色的菜单id
     */
    private List<Long> roleMenuId;
    
    /**
     * 角色的菜单
     */
    private List<MenuFunction> roleMenuList;
    
    /**
     * 提交的菜单id，以，分隔
     */
    private String menuIds;
    
    /**
     * <p>Description: 构造方法</p>
     */
    public RoleMenuWebAction() {
        this.service = RoleMenuService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
        this.topMenuList = MenuEnum.makeTopMenu();
        this.menuButtonMap = MenuButtonService.I.getButtonListGroupByMenuId();
        if (log.isDebugEnabled()) {
            log.debug(this.topMenuList);
            log.debug(this.menuButtonMap);
            log.debug(this.roleMenuList);
        }
    }

    @Override
    public void search() {
        setParentBean(RoleService.I.findById(this.pid));
        this.roleButtonId = RoleButtonService.I.getButtonListByRoleId(this.pid);
        this.roleMenuList = RoleMenuService.I.getMenuListByRoleId(this.pid);
    }
    
    @Override
    public void save() {
        log.info(menuIds);
        this.roleButtonId = new ArrayList<Long>();
        this.roleMenuId = new ArrayList<Long>();
        if (!StringUtil.isEmpty(this.menuIds)) {
            final String[] MMM = this.menuIds.split(",");
            for (String m : MMM) {
                if (m.startsWith("b")) {
                    this.roleButtonId.add(new Long(m.substring(1)));
                }else if (m.startsWith("m")) {
                    this.roleMenuId.add(new Long(m.substring(1)));
                }
            }
        }        
        if (this.roleButtonId!=null && this.roleButtonId.size()>0){
            RoleButtonService.I.updateRoleButton(getPid(), this.roleButtonId);
            RoleMenuService.I.updateRoleMenu(getPid(),roleMenuId);
        }else{
            RoleMenuService.I.updateRoleMenu(getPid(), this.roleMenuId);
        }
    }
    /**
     * <p>Description: 取消操作</p>
     */
    public void cancel() {
    }

}
