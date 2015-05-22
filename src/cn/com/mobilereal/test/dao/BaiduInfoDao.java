/**
 * BaiduInfoDao.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.dao;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.test.dbbean.BaiduInfo;
import cn.com.mobilereal.test.dbbean.IDaoConst;

/**
 * <p>ClassName: BaiduInfoDao</p>
 * <p>Description: 百度云推送信息Dao类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class BaiduInfoDao extends GenericDao<BaiduInfo> {

    /**
     * <p>Description: 构造方法</p>
     */
    public BaiduInfoDao() {
        super(TableEnum.TS_BAIDU_INFO, BaiduInfo.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TS_BAIDU_INFO_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TS_BAIDU_INFO_U;
    }
}

