/**
 * WorkFlowAsset.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.dbbean;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.mobilereal.common.dao.BaseBean;

import cn.com.mobilereal.test.dao.WorkFlowAssetDao;

/**
 * <p>ClassName: WorkFlowAsset</p>
 * <p>Description: 工单流附件Bean类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class WorkFlowAsset extends BaseBean {
    /**
     * dao
     */
    public static final WorkFlowAssetDao I = new WorkFlowAssetDao();
    /**
     * 工单流ID
     */
    private Long workFlowId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 附件ID
     */
    private Long attachmentId;

    /**
     * <p>Description: 设置工单流ID</p>
     * @param newValue 工单流ID
     */
    public void setWorkFlowId(Long newValue) {
        this.workFlowId = newValue;
    }

    /**
     * <p>Description: 获取工单流ID</p>
     * @return 工单流ID
     */
    public Long getWorkFlowId() {
        return this.workFlowId;
    }

    /**
     * <p>Description: 设置用户ID</p>
     * @param newValue 用户ID
     */
    public void setUserId(Long newValue) {
        this.userId = newValue;
    }

    /**
     * <p>Description: 获取用户ID</p>
     * @return 用户ID
     */
    public Long getUserId() {
        return this.userId;
    }

    /**
     * <p>Description: 设置附件ID</p>
     * @param newValue 附件ID
     */
    public void setAttachmentId(Long newValue) {
        this.attachmentId = newValue;
    }

    /**
     * <p>Description: 获取附件ID</p>
     * @return 附件ID
     */
    public Long getAttachmentId() {
        return this.attachmentId;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.workFlowId);
        LIST.add(this.userId);
        LIST.add(this.attachmentId);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.workFlowId = makeLongValue(rs, "WORK_FLOW_ID");
        this.userId = makeLongValue(rs, "USER_ID");
        this.attachmentId = makeLongValue(rs, "ATTACHMENT_ID");

    }
}

