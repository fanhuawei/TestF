/**
 * CustomerDao.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.dao;

import cn.com.mobilereal.common.dao.GenericDao;
import cn.com.mobilereal.common.dao.TableEnum;
import cn.com.mobilereal.test.dbbean.Customer;
import cn.com.mobilereal.test.dbbean.IDaoConst;

/**
 * <p>ClassName: CustomerDao</p>
 * <p>Description: 客户Dao类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class CustomerDao extends GenericDao<Customer> {

    /**
     * <p>Description: 构造方法</p>
     */
    public CustomerDao() {
        super(TableEnum.TT_CUSTOMER, Customer.class);
    }

    @Override
    protected String makeInsert() {
        return IDaoConst.TT_CUSTOMER_I;
    }

    @Override
    protected String makeUpdate() {
        return IDaoConst.TT_CUSTOMER_U;
    }
}

