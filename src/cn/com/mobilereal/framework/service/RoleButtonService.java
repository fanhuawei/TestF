/**
 * RoleButtonService.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.service;

import java.util.List;

import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.PKUtil;
import cn.com.mobilereal.common.util.ServiceFactory;
import cn.com.mobilereal.framework.dbbean.RoleButton;

/**
 * 
 * <p>ClassName: RoleButtonService</p>
 * <p>Description: 系统角色到按钮权限管理的业务类</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date:2014-10-16</p>
 */
@SuppressWarnings("serial")
public class RoleButtonService extends BaseCrudService<RoleButton> {
    /**
     * 实例
     */
    public static final RoleButtonService I = ServiceFactory.makeService(RoleButtonService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public RoleButtonService() {
       super(RoleButton.I, RoleButton.class);
    }
    
    /**
     * 
     * <p>Description: 根据角色获得按钮id列表</p>
     * @param rid 角色id
     * @return 按钮id列表
     */
    public List<Long> getButtonListByRoleId(Long rid) {
        return RoleButton.I.getButtonListByRoleId(rid);
    }
    
    /**
     * 
     * <p>Description: 更新角色所有按钮</p>
     * @param rid 角色id
     * @param buttons 按钮id
     */ 
    public void updateRoleButton(Long rid, List<Long> buttons) {
        RoleButton.I.deleteByRoleId(rid);
        RoleButton rm = null;
        Long[] pks = PKUtil.$.getPKs(TableEnum.TR_ROLE_BUTTON, buttons.size());
        int idx = 0;
        for (Long bid : buttons) {
            rm = new RoleButton();
            rm.setId(pks[idx++]);
            rm.setMenuButtonId(bid);
            rm.setRoleId(rid);
            RoleButton.I.insert(rm);
        }
    }
}
