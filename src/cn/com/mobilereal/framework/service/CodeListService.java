/**
 * CodeListService.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.service;

import cn.com.mobilereal.common.service.BaseCrudService;
import cn.com.mobilereal.common.util.ServiceFactory;
import cn.com.mobilereal.framework.dbbean.CodeList;


/**
 * 
 * <p>ClassName: CodeListService</p>
 * <p>Description: 数据字典主表管理的业务类</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date:2014-10-16</p>
 */
@SuppressWarnings("serial")
public class CodeListService extends BaseCrudService<CodeList> {
    /**
     * 实例
     */
    public static final CodeListService I = ServiceFactory.makeService(CodeListService.class);
    
       /**
     * <p>Description: 构造方法</p>
     */
    public CodeListService() {
       super(CodeList.I, CodeList.class);
    }
}
