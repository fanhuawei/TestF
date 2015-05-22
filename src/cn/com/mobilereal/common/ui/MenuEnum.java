/**
 * MenuEnum.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.common.ui;

import java.util.ArrayList;
import java.util.List;

import cn.com.mobilereal.common.util.ConstUtil;
import cn.com.mobilereal.common.util.JDBCUtil;
import cn.com.mobilereal.framework.dbbean.MenuButton;
import cn.com.mobilereal.framework.dbbean.MenuFunction;
import cn.com.mobilereal.framework.dbbean.RoleMenu;
import cn.com.mobilereal.framework.web.action.AttachmentWebAction;
import cn.com.mobilereal.framework.web.action.ChangePasswordWebAction;
import cn.com.mobilereal.framework.web.action.CodeDetailWebAction;
import cn.com.mobilereal.framework.web.action.CodeListWebAction;
import cn.com.mobilereal.framework.web.action.DeviceWebAction;
import cn.com.mobilereal.framework.web.action.LoginWebAction;
import cn.com.mobilereal.framework.web.action.MainWebAction;
import cn.com.mobilereal.framework.web.action.OperateLogMobileWebAction;
import cn.com.mobilereal.framework.web.action.OperateLogWebAction;
import cn.com.mobilereal.framework.web.action.OperateLogWebWebAction;
import cn.com.mobilereal.framework.web.action.RoleMenuWebAction;
import cn.com.mobilereal.framework.web.action.RoleWebAction;
import cn.com.mobilereal.framework.web.action.ShortCutWebAction;
import cn.com.mobilereal.framework.web.action.UserInfoWebAction;
import cn.com.mobilereal.framework.web.action.UserRoleWebAction;
import cn.com.mobilereal.framework.web.action.UserWebAction;

import cn.com.mobilereal.test.web.action.AgentWebAction;
import cn.com.mobilereal.test.web.action.CustomerWebAction;
import cn.com.mobilereal.test.web.action.MachineBoxWebAction;
import cn.com.mobilereal.test.web.action.MachineExtendWebAction;
import cn.com.mobilereal.test.web.action.MachineRunStateWebAction;
import cn.com.mobilereal.test.web.action.MachineWarrantyDelayWebAction;
import cn.com.mobilereal.test.web.action.MachineWebAction;
import cn.com.mobilereal.test.web.action.OtherMachineWebAction;
import cn.com.mobilereal.test.web.action.PartBaseWebAction;
import cn.com.mobilereal.test.web.action.PartUsageWebAction;
import cn.com.mobilereal.test.web.action.WorkFlowAssetWebAction;
import cn.com.mobilereal.test.web.action.WorkOrderFlowWebAction;
import cn.com.mobilereal.test.web.action.WorkOrderWebAction;
import cn.com.mobilereal.test.web.action.WorkReportWebAction;




/**
 * <p>ClassName: MenuEnum</p>
 * <p>Description: 所有的菜单及功能页面</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

public enum MenuEnum
 {
    SYSTEM(1000, "系统登录", "/System.do", LoginWebAction.class,"Y",null), 
    MAIN(2000, "首页", "/Main.do", MainWebAction.class), 
	TT_AGENT(2010,"代理商管理","/Agent.do", AgentWebAction.class),
	TT_CUSTOMER(2020,"客户管理","/Customer.do", CustomerWebAction.class),
	TT_MACHINE(2040,"机器管理","/Machine.do", MachineWebAction.class),
	TT_MACHINE_BOX(2060,"机器采集设备管理","/MachineBox.do", MachineBoxWebAction.class),
	TT_MACHINE_EXTEND(2080,"机器扩展属性管理","/MachineExtend.do", MachineExtendWebAction.class),
	TT_MACHINE_RUN_STATE(2100,"机器运行状态管理","/MachineRunState.do", MachineRunStateWebAction.class),
	TT_MACHINE_WARRANTY_DELAY(2120,"机器延保记录管理","/MachineWarrantyDelay.do", MachineWarrantyDelayWebAction.class),
	TT_OTHER_MACHINE(2140,"客户其它厂家机器管理","/OtherMachine.do", OtherMachineWebAction.class),
	TT_PART_BASE(2160,"配件库管理","/PartBase.do", PartBaseWebAction.class),
	TT_PART_USAGE(2180,"配件使用管理","/PartUsage.do", PartUsageWebAction.class),
	TT_WORK_FLOW_ASSET(2200,"工单流附件管理","/WorkFlowAsset.do", WorkFlowAssetWebAction.class),
	TT_WORK_ORDER(2220,"工单管理","/WorkOrder.do", WorkOrderWebAction.class),
	TT_WORK_ORDER_FLOW(2240,"工单流管理","/WorkOrderFlow.do", WorkOrderFlowWebAction.class),
	TT_WORK_REPORT(2260,"工单报告管理","/WorkReport.do", WorkReportWebAction.class),

	SYSTEM_MANAGER(9000, "系统管理"), 
     USER_MANAGER(9010, "用户管理", "/User.do", UserWebAction.class, SYSTEM_MANAGER), 
     ROLE_MANAGER(9020, "角色管理", "/Role.do", null, SYSTEM_MANAGER), 
       ROLE_LIST(9021, "角色管理", "/Role.do", RoleWebAction.class, "Y", ROLE_MANAGER), 
       ROLE_RIGHT(9023, "分配角色权限", "/RoleMenu.do", RoleMenuWebAction.class, "Y", ROLE_MANAGER), 
       ROLE_USER(9025, "分配角色用户", "/RoleUser.do", UserRoleWebAction.class, "Y", ROLE_MANAGER), 
     DICT_MANAGER(9070, "数据字典","/Dict.do", null, SYSTEM_MANAGER), 
       DICT_LIST(9071, "数据字典", "/Dict.do", CodeListWebAction.class, "Y", DICT_MANAGER), 
       DICT_DETAIL(9073, "数据字典明细", "/DictList.do", CodeDetailWebAction.class, "Y", DICT_MANAGER), 
     DEVICE_MANAGER(9080, "设备管理", "/Device.do", DeviceWebAction.class, SYSTEM_MANAGER),
     LOG_MANAGER(9090, "操作日志", "/OperateLogWeb.do", null, SYSTEM_MANAGER),
       WEB_LOG(9092, "云端日志", "/OperateLogWeb.do", OperateLogWebWebAction.class, "Y", LOG_MANAGER), 
       MOBILE_LOG(9093, "移动端日志", "/OperateLogMobile.do", OperateLogMobileWebAction.class, "Y", LOG_MANAGER), 
       WEB_LOG_DETAIL(9094, "云端日志明细", "/OperateLogWebDetail.do", OperateLogWebAction.class, "Y", LOG_MANAGER), 
     ASSET_MANAGER(9100, "附件管理", "/Attachment.do", AttachmentWebAction.class, SYSTEM_MANAGER),
     SHORTCUT_MANAGER(9150, "快捷方式", "/ShortCut.do", ShortCutWebAction.class, SYSTEM_MANAGER),
  PERSONAL_MANAGER(9500, "个性管理"),
    PERSON_INFO(9510, "个人信息",  "/UserInfo.do",  UserInfoWebAction.class,  PERSONAL_MANAGER), 
    PASSWORD_MANAGER(9530, "密码修改", "/ChangePassword.do", ChangePasswordWebAction.class, PERSONAL_MANAGER),
    LOGOUT(9540, "退出登录", "/Logout.do",null, PERSONAL_MANAGER);
       
    private Integer id;
    private String prefixUrl;
    private String name;
    private MenuEnum parent;
    private Class<? extends BaseWebAction> actionCls;
    private String functionFlag = "N";

    private MenuEnum(Integer id, String desc) {
        this.name = desc;
        this.id = id;
    }

    private MenuEnum(Integer id, String desc, String prefixUrl, Class<? extends BaseWebAction> actionCls) {
        this.prefixUrl = prefixUrl;
        this.name = desc;
        this.id = id;
        this.actionCls = actionCls;
    }

    private MenuEnum(Integer id, String desc, String prefixUrl, Class<? extends BaseWebAction> actionCls, MenuEnum parent) {
        this(id, desc, prefixUrl, actionCls);
        this.parent = parent;
    }

    private MenuEnum(Integer id, String desc, String prefixUrl, Class<? extends BaseWebAction> actionCls, String isMenu,
            MenuEnum parent) {
        this(id, desc, prefixUrl, actionCls);
        this.parent = parent;
        this.functionFlag = isMenu;
    }

    public String getPrefixUrl() {
        return prefixUrl;
    }
    public Long getParentMenuId() {
        MenuEnum me = getParent();
        if (me == null) {
          return null;
        }else{
          return me.getId();
        }
    }
    public String getName() {
        return name;
    }

    public MenuEnum getParent() {
        return parent;
    }

    public boolean isMenu(){
      return ConstUtil.FLAG.NO.equalsIgnoreCase(getFunctionFlag());
    }
    public List<MenuEnum> getChildren() {
        List<MenuEnum> list = new ArrayList<MenuEnum>();
        MenuEnum[] menus = MenuEnum.values();
        for (MenuEnum menuEnum : menus) {
            if (menuEnum.getParent() == this) {
                list.add(menuEnum);
            }
        }
        return list;
    }

    public Class<? extends BaseWebAction> getActionCls() {
        return actionCls;
    }

    public Long getId() {
        return new Long(id);
    }

    public String getFunctionFlag() {
        return functionFlag;
    }

    public String getModule() {
        if (prefixUrl != null && prefixUrl.endsWith(".do")) {
           if (getParent()==MenuEnum.SYSTEM_MANAGER || getParent()==MenuEnum.PERSONAL_MANAGER || 
              (getParent()!=null && (getParent().getParent()==MenuEnum.SYSTEM_MANAGER 
                      || getParent().getParent()==MenuEnum.PERSONAL_MANAGER))){
               return "/Framework" + prefixUrl.substring(0, prefixUrl.length() - 3);
           }else{
               return prefixUrl.substring(0, prefixUrl.length() - 3);
           }
        }
        return null;
    }

    public static List<MenuEnum> makeTopMenu() {
        List<MenuEnum> list = new ArrayList<MenuEnum>();
        MenuEnum[] menus = MenuEnum.values();
        for (MenuEnum menuEnum : menus) {
            if (menuEnum.getParent() == null && menuEnum.isMenu()) {
                list.add(menuEnum);
            }
        }
        return list;
    }
    
    public static List<MenuEnum> makeTopDisplayMenu() {
        List<MenuEnum> list = new ArrayList<MenuEnum>();
        MenuEnum[] menus = MenuEnum.values();
        for (MenuEnum menuEnum : menus) {
            if (menuEnum.getParent() == null && !menuEnum.equals(MenuEnum.SYSTEM_MANAGER) && menuEnum.isMenu()) {
                list.add(menuEnum);
            }
        }
        return list;
    }

    public static MenuEnum makeMenu(Long id) {
        MenuEnum[] menus = MenuEnum.values();
        for (MenuEnum menuEnum : menus) {
            if (menuEnum.getId().equals(id)) {
                return menuEnum;
            }
        }
        return null;
    }
    
    public static List<MenuEnum> makeSystemSubMenu() {
        MenuEnum[] list1 = MenuEnum.values();
        List<MenuEnum> list = new ArrayList<MenuEnum>();
        for (MenuEnum menu : list1) {
            if (menu.getParent() == MenuEnum.SYSTEM_MANAGER && menu.isMenu()) {
                list.add(menu);
            }
        }
        return list;
    }
    public static List<MenuEnum> makePersonalMenu() {        
        return MenuEnum.PERSONAL_MANAGER.getChildren();
    }
    public String getFilePath() {
        if (prefixUrl!=null && prefixUrl.startsWith("/") && prefixUrl.endsWith(".do")) {
            return prefixUrl.substring(1,prefixUrl.length()-3);
        }
        return prefixUrl;
    }
    public String getPath() {
        if (prefixUrl!=null && prefixUrl.startsWith("/")) {
            return prefixUrl.substring(1);
        }
        return prefixUrl;
    }

    public String getRefreshUrl() {
        return prefixUrl + "?action=search";
    }
    
    public String getSessionKey(){
      if (getPrefixUrl() == null || getActionCls()==null) return "";
      return getPrefixUrl() + ":" + getActionCls().getName();
    }

    public static void initMenuFunction() {
        JDBCUtil.beginTransaction();
        MenuFunction.I.deleteByWhere(null);
        MenuButton.I.deleteByWhere(null);
        MenuEnum[] menus = MenuEnum.values();
        for (int i = 0; i < menus.length; i++) {
            MenuFunction mf = new MenuFunction();
            mf.setId(menus[i].getId());
            mf.setName(menus[i].getName());
            mf.setPath(menus[i].getPath());
            if (menus[i].getActionCls() != null) {
                mf.setActionClass(menus[i].getActionCls().getName());
            }
            if (menus[i].getParent() != null) {
                mf.setParentMenuId(menus[i].getParent().getId());
            }
            mf.setFunctionFlag(menus[i].getFunctionFlag());
            mf.setRemark(menus[i].name());
            MenuFunction.I.save(mf);
            if (mf.getActionClass() != null) {
                MenuButton mb = new MenuButton();
                mb.setMenuId(mf.getId());
                mb.setCode("init");
                mb.setGrantFlag(ConstUtil.FLAG.YES);
                mb.setName("初始化");
                MenuButton.I.save(mb);
            }
        }
        JDBCUtil.commit();
    }

    public static void initRoleMenuFunction() {
        RoleMenu.I.deleteByWhere(null);
        Long rid = 8901l;
        MenuEnum[] menus = MenuEnum.values();
        for (int i = 0; i < menus.length; i++) {
            RoleMenu rm = new RoleMenu();
            rm.setRoleId(rid);
            rm.setMenuId(menus[i].getId());
            RoleMenu.I.save(rm);
        }
    }

    public static void main(String[] args) {
        System.out.println(MenuEnum.USER_MANAGER.getModule());
    }

}
