/**
 * RoleWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.web.action;

import java.util.List;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;
import cn.com.mobilereal.common.util.ConstUtil;
import cn.com.mobilereal.common.util.StringUtil;
import cn.com.mobilereal.common.web.BusinessException;
import cn.com.mobilereal.framework.dbbean.Role;
import cn.com.mobilereal.framework.dbbean.RoleShortCut;
import cn.com.mobilereal.framework.dbbean.ShortCut;
import cn.com.mobilereal.framework.service.RoleService;
import cn.com.mobilereal.framework.service.RoleShortCutService;
import cn.com.mobilereal.framework.service.ShortCutService;

/**
 * <p>ClassName: RoleWebAction</p>
 * <p>Description: 系统角色管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class RoleWebAction extends BaseCrudWebAction<Role> {

    /**
     * 所有的快捷方式
     */
    private List<ShortCut> shortCutList;
    
    /**
     * 角色的快捷方式
     */
    private Long[] roleShortCut;

    /**
     * <p>Description: 构造方法</p>
     */
    public RoleWebAction() {
        this.service = RoleService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
        if (log.isDebugEnabled()){
          log.debug(shortCutList);
        }
    }

    @Override
    public void ajaxPopup() {
        shortCutList = ShortCutService.I.findByWhere("WHERE DELETE_MARK=? ORDER BY SORT_NO", ConstUtil.FLAG.NO);
        List<ShortCut> list = ShortCutService.I.findByRoleId(chk[0]);
        if (list!=null && list.size()>0){
          roleShortCut = new Long[list.size()];
          int idx = 0;
          for (ShortCut shortCut : list) {
            roleShortCut[idx] = shortCut.getId();
            idx++;
          }
        }        
    }
    
    @Override
    public void save() {
        if (StringUtil.isEmpty(bean.getCode())){
          throw new BusinessException("请输入编码");
        }
        if (StringUtil.isEmpty(bean.getName())){
            throw new BusinessException("请输入名称");
         }
        List<Role> list = RoleService.I.getRoleByCode(bean.getCode(), bean.getId());
        if (list.size()>0){
          throw new BusinessException("角色编码已存在，不能提交");
        }
        super.save();
    }

    public void saveShortCut(){
      RoleShortCutService.I.deleteByWhere("WHERE ROLE_ID=?", chk[0]);
      if (roleShortCut!=null){
        for (int i = 0; i < roleShortCut.length; i++) {
            RoleShortCut rsc = new RoleShortCut();
            rsc.setRoleId(chk[0]);
            rsc.setShortCutId(roleShortCut[i]);
            RoleShortCutService.I.save(rsc);
        } 
      } 
      setAction("save");   
    }

}
