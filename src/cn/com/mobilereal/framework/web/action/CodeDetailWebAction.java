/**
 * CodeDetailWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.web.action;

import java.util.List;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;
import cn.com.mobilereal.framework.dbbean.CodeDetail;
import cn.com.mobilereal.framework.service.CodeDetailService;
import cn.com.mobilereal.framework.service.CodeListService;

/**
 * <p>ClassName: CodeDetailWebAction</p>
 * <p>Description: 数据字典明细表管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class CodeDetailWebAction extends BaseCrudWebAction<CodeDetail> {
    private int idx;
    private List<CodeDetail> list;
    /**
     * <p>Description: 构造方法</p>
     */
    public CodeDetailWebAction() {
        this.service = CodeDetailService.I;
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
        parentBean = CodeListService.I.findById(pid);
        pageBean = CodeDetailService.I.searchByPid(pageNo, pageSize, pid);
        list = makeSearchList();
    }
    
    public void saveAll(){
        for (CodeDetail bean : list){
            CodeDetailService.I.save(bean);
        }
        setAction("save");
    }
    

    public void sortUp(){
       List<CodeDetail> list1 = makeSearchList();
       CodeDetail sc = list1.get(idx);
       CodeDetail sc1 = list1.get(idx-1);
       Long sortNo = sc1.getSortNo();
       sc1.setSortNo(sc.getSortNo());
       sc.setSortNo(sortNo);
       service.save(sc);
       service.save(sc1);
       setAction("save");
    }
    
    public void sortDown(){        
        List<CodeDetail> list1 = makeSearchList();
        CodeDetail sc = list1.get(idx);
        CodeDetail sc1 = list1.get(idx+1);
        Long sortNo = sc1.getSortNo();
        sc1.setSortNo(sc.getSortNo());
        sc.setSortNo(sortNo);
        service.save(sc);
        service.save(sc1);
        setAction("save");
    }

}
