/**
 * CodeListDao.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.dao;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.framework.dbbean.CodeList;
import cn.com.mobilereal.framework.dbbean.IDaoConst;

/**
 * <p>ClassName: CodeListDao</p>
 * <p>Description: 数据字典主表Dao</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class CodeListDao extends GenericDao<CodeList> {

    /**
     * <p>Description: 构造方法</p>
     */
    public CodeListDao() {
        super(TableEnum.TC_CODE_LIST, CodeList.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TC_CODE_LIST_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TC_CODE_LIST_U;
    }
}

