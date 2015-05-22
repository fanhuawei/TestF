/**
 * MenuButtonService.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ConstUtil;
import cn.com.mobilereal.common.util.ServiceFactory;
import cn.com.mobilereal.framework.dbbean.MenuButton;

/**
 * 
 * <p>ClassName: MenuButtonService</p>
 * <p>Description: 系统菜单与按钮对应表管理的业务类</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date:2014-10-16</p>
 */
@SuppressWarnings("serial")
public class MenuButtonService extends BaseCrudService<MenuButton> {
    /**
     * 实例
     */
    public static final MenuButtonService I = ServiceFactory.makeService(MenuButtonService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public MenuButtonService() {
       super(MenuButton.I, MenuButton.class);
    }
    
    /**
     * <p>Description: 查询页面的按钮列表</p>
     * @return 页面的按钮列表
     */
    public Map<Long, List<MenuButton>> getButtonListGroupByMenuId() {        
        final List<MenuButton> LIST = MenuButton.I.findByWhere("ORDER BY ID");
        return toMenuMap(LIST);
    }

    /**
     * <p>Description: 转换成以菜单功能为分组列表</p>
     * @param list 按钮列表
     * @return 以菜单功能为分组列表
     */
    public Map<Long, List<MenuButton>> toMenuMap(List<MenuButton> list) {
        final Map<Long, List<MenuButton>> RET = new HashMap<Long, List<MenuButton>>();
        Long menuId = null;
        List<MenuButton> subList = null;
        for (MenuButton mb : list) {
            menuId = mb.getMenuId();
            subList = RET.get(menuId);
            if (subList == null) {
                subList = new ArrayList<MenuButton>();
                RET.put(menuId, subList);
            }
            if (ConstUtil.FLAG.YES.equalsIgnoreCase(mb.getGrantFlag())){
               subList.add(mb);
            }
        }
        return RET;
    }
    
    /**
     * <p>Description: 根据用户获取权限按钮</p>
     * @param uid 用户id
     * @return 权限按钮
     */
    public Map<Long, List<MenuButton>> getMenuButtonByUserId(Long uid) {
        final List<MenuButton> LIST = MenuButton.I.getMenuButtonByUserId(uid);
        return toMenuMap(LIST);
    }
}
