/**
 * AttachmentWebAction.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal, All rights reserved.
 */
package cn.com.mobilereal.framework.web.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.com.mobilereal.common.ui.BaseCrudWebAction;
import cn.com.mobilereal.common.util.ConstUtil;
import cn.com.mobilereal.common.util.JSPFunction;
import cn.com.mobilereal.framework.dbbean.Attachment;
import cn.com.mobilereal.framework.service.AttachmentService;


/**
 * <p>ClassName: AttachmentWebAction</p>
 * <p>Description: 附件表管理用</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class AttachmentWebAction extends BaseCrudWebAction<Attachment> {

    /**
     * <p>Description: 构造方法</p>
     */
    public AttachmentWebAction() {
        this.service = AttachmentService.I;
    }

    @Override
    public void search() {
        this.pageBean = service.searchByWhere(pageNo, pageSize, "WHERE DELETE_MARK=? ORDER BY ID DESC",
                ConstUtil.FLAG.NO);
        List<Attachment> list = makeSearchList();
        Set<Long> idList = new HashSet<Long>();
        for (Attachment bean : list) {
            idList.add(bean.getFunctionId());
        }
        JSPFunction.initRequest("FUNCTION", idList.toArray());
    }

    /**
     * 画面初始化
     */
    @Override
    public void init() {
        super.init();
    }

}
