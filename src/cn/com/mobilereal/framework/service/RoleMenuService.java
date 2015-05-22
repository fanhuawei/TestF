/**
 * RoleMenuService.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.service;

import java.util.List;








import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.ui.MenuEnum;
import cn.com.mobilereal.common.util.PKUtil;
import cn.com.mobilereal.common.util.ServiceFactory;
import cn.com.mobilereal.framework.dbbean.MenuFunction;
import cn.com.mobilereal.framework.dbbean.RoleButton;
import cn.com.mobilereal.framework.dbbean.RoleMenu;
/**
 * 
 * <p>ClassName: RoleMenuService</p>
 * <p>Description: 系统角色权限管理的业务类</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date:2014-10-16</p>
 */
@SuppressWarnings("serial")
public class RoleMenuService extends BaseCrudService<RoleMenu> {
    /**
     * 实例
     */
    public static final RoleMenuService I = ServiceFactory.makeService(RoleMenuService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public RoleMenuService() {
       super(RoleMenu.I, RoleMenu.class);
    }
    
    /**
     * 
     * <p>Description: 根据角色获得权限id列表</p>
     * @param rid 角色id
     * @return 权限id列表
     */
    public List<MenuFunction> getMenuListByRoleId(Long rid) {
        return MenuFunction.I.getMenuListByRoleId(rid);
    }
    
    /**
     * 
     * <p>Description: 更新角色所有权限</p>
     * @param rid 角色id
     * @param menuIdList 菜单id
     */ 
    public void updateRoleMenu(Long rid, List<Long> menuIdList) {
        RoleMenu.I.deleteByRoleId(rid);
        RoleMenu rm = null;
        List<Long> menuIdList_db =  RoleButton.I.getMenuIdByRoleId(rid);
        if (menuIdList_db != null && menuIdList_db.size()>0){
           for (Long id : menuIdList_db) {
             if (!menuIdList.contains(id)){
                 menuIdList.add(id);
             }
           }
        }
        if (!menuIdList.contains(MenuEnum.LOGOUT.getId())){
            menuIdList.add(MenuEnum.LOGOUT.getId());
        }
        Long[] pks = PKUtil.$.getPKs(TableEnum.TR_ROLE_MENU, menuIdList.size());
        int idx = 0;
        for (Long mid : menuIdList) {
            rm = new RoleMenu();
            rm.setId(pks[idx++]);
            rm.setMenuId(mid);
            rm.setRoleId(rid);
            RoleMenu.I.insert(rm);
        }
        return;
    }
}
