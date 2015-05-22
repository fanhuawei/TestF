/**
 * CodeListWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.web.action;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;
import cn.com.mobilereal.framework.dbbean.CodeList;
import cn.com.mobilereal.framework.service.CodeListService;


/**
 * <p>ClassName: CodeListWebAction</p>
 * <p>Description: 数据字典主表管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class CodeListWebAction extends BaseCrudWebAction<CodeList> {

    /**
     * <p>Description: 构造方法</p>
     */
    public CodeListWebAction() {
        this.service = CodeListService.I;
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
