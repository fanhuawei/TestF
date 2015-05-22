/**
 * CodeDetailDao.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.dao;

import java.util.List;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.common.util.ConstUtil;
import cn.com.mobilereal.common.util.PageBean;
import cn.com.mobilereal.framework.dbbean.CodeDetail;
import cn.com.mobilereal.framework.dbbean.IDaoConst;

/**
 * <p>ClassName: CodeDetailDao</p>
 * <p>Description: 数据字典明细表Dao</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class CodeDetailDao extends GenericDao<CodeDetail> {

    /**
     * <p>Description: 构造方法</p>
     */
    public CodeDetailDao() {
        super(TableEnum.TC_CODE_DETAIL, CodeDetail.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TC_CODE_DETAIL_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TC_CODE_DETAIL_U;
    }
    
    /**
     * <p>
     * Description: 查询字典
     * </p>
     * 
     * @param pageNo 页号
     * @param pageSize 页面数据记录数
     * @param id 数据id
     * @return 数据列表
     */
    public PageBean findByCodeListId(int pageNo, int pageSize, Long id) {
        final String WH = "WHERE A.CODE_LIST_ID=? AND A.DELETE_MARK=? ORDER BY A.PARENT_ID,A.SORT_NO";
        return doPageQuery(pageNo, pageSize, WH, id, ConstUtil.FLAG.NO);
    }
    
    /**
     * <p>
     * Description: 查询字典
     * </p>
     * 
     * @param code 数据编码
     * @return 数据列表
     */
    public List<CodeDetail> searchByParentCode(String code) {
        return findByWhere("JOIN TC_CODE_LIST B ON B.ID=A.CODE_LIST_ID WHERE B.CODE=? AND A.DELETE_MARK=? ORDER BY A.SORT_NO", code, ConstUtil.FLAG.NO);
    }
}

