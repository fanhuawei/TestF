/**
 * CustomerService.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;

import cn.com.mobilereal.test.dbbean.Customer;

/**
 * <p>ClassName: CustomerService</p>
 * <p>Description: 客户业务类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class CustomerService extends BaseCrudService<Customer> {
    /**
     * 实例
     */
    public static final CustomerService I = ServiceFactory.makeService(CustomerService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public CustomerService() {
       super(Customer.I, Customer.class);
    }
}
