/**
 * CodeDetailService.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.service;

import java.util.List;

import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.PKUtil;
import cn.com.mobilereal.common.util.PageBean;
import cn.com.mobilereal.common.util.ServiceFactory;
import cn.com.mobilereal.framework.dbbean.CodeDetail;

/**
 * 
 * <p>ClassName: CodeDetailService</p>
 * <p>Description: 数据字典明细表管理的业务类</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date:2014-10-16</p>
 */
@SuppressWarnings("serial")
public class CodeDetailService extends BaseCrudService<CodeDetail> {
    /**
     * 实例
     */
    public static final CodeDetailService I = ServiceFactory.makeService(CodeDetailService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public CodeDetailService() {
       super(CodeDetail.I, CodeDetail.class);
    }
    
    @Override
    public void save(CodeDetail t) {
        if (t.getId() == null) {
            Long id = PKUtil.$.getPK(TableEnum.TC_CODE_DETAIL);
            t.setId(id);
            t.setSortNo(id);
            dao.insert(t);
            return;
        }
        super.save(t);
    }

    /**
     * 
     * <p>Description: 查询数据字典id对应的数据列表</p>
     * @param pageNo 页号
     * @param pageSize 页面大小
     * @param pid  数据字典id
     * @return 数据字典id对应的数据列表
     */
    public PageBean searchByPid(int pageNo, int pageSize, Long pid) {
        return CodeDetail.I.findByCodeListId(pageNo, pageSize, pid) ;
    }   
    
    /**
     * 
     * <p>Description: 查询数据字典编码对应的数据列表</p>
     * @param parentCode  数据字典编码
     * @return 数据字典id对应的数据列表
     */
    public List<CodeDetail> searchByParentCode(String parentCode) {
        return CodeDetail.I.searchByParentCode(parentCode);
    }
}
