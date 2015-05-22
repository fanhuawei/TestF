/**
 * ShortCutWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.web.action;

import java.util.List;

import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.common.ui.BaseCrudWebAction;
import cn.com.mobilereal.common.util.ConstUtil;
import cn.com.mobilereal.common.util.PKUtil;
import cn.com.mobilereal.common.util.StringUtil;
import cn.com.mobilereal.common.web.BusinessException;
import cn.com.mobilereal.framework.dbbean.ShortCut;
import cn.com.mobilereal.framework.service.ShortCutService;

/**
 * <p>ClassName: ShortCutWebAction</p>
 * <p>Description: 快捷方式管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class ShortCutWebAction extends BaseCrudWebAction<ShortCut> {

    private int idx;
    /**
     * <p>Description: 构造方法</p>
     */
    public ShortCutWebAction() {
        this.service = ShortCutService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

    @Override
    public void search() {
        this.pageBean = this.service.searchByWhere(pageNo, pageSize, "WHERE DELETE_MARK=? ORDER BY SORT_NO",
                ConstUtil.FLAG.NO);
    }

    public void sortUp(){
       List<ShortCut> list = makeSearchList();
       ShortCut sc = list.get(idx);
       ShortCut sc1 = list.get(idx-1);
       Long sortNo = sc1.getSortNo();
       sc1.setSortNo(sc.getSortNo());
       sc.setSortNo(sortNo);
       service.save(sc);
       service.save(sc1);
       setAction("save");
    }
    
    @SuppressWarnings("unchecked")
    public void sortDown(){        
        List<ShortCut> list = (List<ShortCut>)pageBean.getList();
        ShortCut sc = list.get(idx);
        ShortCut sc1 = list.get(idx+1);
        Long sortNo = sc1.getSortNo();
        sc1.setSortNo(sc.getSortNo());
        sc.setSortNo(sortNo);
        service.save(sc);
        service.save(sc1);
        setAction("save");
    }

    @Override
    public void save() {
        if (StringUtil.isEmpty(bean.getName())) {
            throw new BusinessException("请输入名称");
        }
        if (StringUtil.isEmpty(bean.getLink())) {
            throw new BusinessException("请输入链接");
        }
        if (bean.getId() == null) {
            Long pk = PKUtil.$.getPK(TableEnum.TM_SHORT_CUT);
            bean.setSortNo(pk);
            bean.setId(pk);
        }
        super.save();
    }

}
