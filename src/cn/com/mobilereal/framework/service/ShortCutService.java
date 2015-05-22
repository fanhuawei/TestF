/**
 * ShortCutService.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.service;

import java.util.List;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ConstUtil;
import cn.com.mobilereal.common.util.ServiceFactory;
import cn.com.mobilereal.framework.dbbean.ShortCut;

/**
 * 
 * <p>ClassName: ShortCutService</p>
 * <p>Description: 快捷方式管理的业务类</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date:2014-10-16</p>
 */
@SuppressWarnings("serial")
public class ShortCutService extends BaseCrudService<ShortCut> {
    /**
     * 实例
     */
    public static final ShortCutService I = ServiceFactory.makeService(ShortCutService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public ShortCutService() {
       super(ShortCut.I, ShortCut.class);
    }
    
    /**
     * 
     * <p>Description: 查询角色的快捷方式列表</p>
     * @param roleId 角色id
     * @return 快捷方式列表
     */
    public List<ShortCut> findByRoleId(Long roleId){
       String wh = "JOIN TR_ROLE_SHORT_CUT B ON A.ID=B.SHORT_CUT_ID WHERE A.DELETE_MARK=? AND B.ROLE_ID=? ORDER BY A.SORT_NO";
       return ShortCut.I.findByWhere(wh, ConstUtil.FLAG.NO, roleId);
    }
    /**
     * 
     * <p>Description: 查询快捷方式列表</p>
     * @return 快捷方式列表
     */
    public List<ShortCut> findAll(){
       String wh = "WHERE A.DELETE_MARK=? ORDER BY A.SORT_NO";
       return ShortCut.I.findByWhere(wh, ConstUtil.FLAG.NO);
    }
    
}
