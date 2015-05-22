/**
 * WorkOrderFlow.java
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

import cn.com.mobilereal.test.dao.WorkOrderFlowDao;

/**
 * <p>ClassName: WorkOrderFlow</p>
 * <p>Description: 工单流Bean类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class WorkOrderFlow extends BaseBean {
    /**
     * dao
     */
    public static final WorkOrderFlowDao I = new WorkOrderFlowDao();
    /**
     * 工单ID
     */
    private Long workOrderId;

    /**
     * 附件数
     */
    private Long assetCount;

    /**
     * 报告ID
     */
    private Long workReportId;

    /**
     * 工单操作
     */
    private String workFlag;

    /**
     * 操作时间
     */
    private java.sql.Timestamp operateTime;

    /**
     * 操作人
     */
    private Long operatorId;

    /**
     * 描述
     */
    private String comments;

    /**
     * 接收人
     */
    private Long receivedId;

    /**
     * 预计到达现场时间
     */
    private java.sql.Timestamp estimateArriveTime;

    /**
     * 预计完成时间
     */
    private java.sql.Timestamp estimateFinishTime;

    /**
     * <p>Description: 设置工单ID</p>
     * @param newValue 工单ID
     */
    public void setWorkOrderId(Long newValue) {
        this.workOrderId = newValue;
    }

    /**
     * <p>Description: 获取工单ID</p>
     * @return 工单ID
     */
    public Long getWorkOrderId() {
        return this.workOrderId;
    }

    /**
     * <p>Description: 设置附件数</p>
     * @param newValue 附件数
     */
    public void setAssetCount(Long newValue) {
        this.assetCount = newValue;
    }

    /**
     * <p>Description: 获取附件数</p>
     * @return 附件数
     */
    public Long getAssetCount() {
        return this.assetCount;
    }

    /**
     * <p>Description: 设置报告ID</p>
     * @param newValue 报告ID
     */
    public void setWorkReportId(Long newValue) {
        this.workReportId = newValue;
    }

    /**
     * <p>Description: 获取报告ID</p>
     * @return 报告ID
     */
    public Long getWorkReportId() {
        return this.workReportId;
    }

    /**
     * <p>Description: 设置工单操作</p>
     * @param newValue 工单操作
     */
    public void setWorkFlag(String newValue) {
        this.workFlag = newValue;
    }

    /**
     * <p>Description: 获取工单操作</p>
     * @return 工单操作
     */
    public String getWorkFlag() {
        return this.workFlag;
    }

    /**
     * <p>Description: 设置操作时间</p>
     * @param newValue 操作时间
     */
    public void setOperateTime(java.sql.Timestamp newValue) {
        this.operateTime = newValue;
    }

    /**
     * <p>Description: 获取操作时间</p>
     * @return 操作时间
     */
    public java.sql.Timestamp getOperateTime() {
        return this.operateTime;
    }

    /**
     * <p>Description: 设置操作人</p>
     * @param newValue 操作人
     */
    public void setOperatorId(Long newValue) {
        this.operatorId = newValue;
    }

    /**
     * <p>Description: 获取操作人</p>
     * @return 操作人
     */
    public Long getOperatorId() {
        return this.operatorId;
    }

    /**
     * <p>Description: 设置描述</p>
     * @param newValue 描述
     */
    public void setComments(String newValue) {
        this.comments = newValue;
    }

    /**
     * <p>Description: 获取描述</p>
     * @return 描述
     */
    public String getComments() {
        return this.comments;
    }

    /**
     * <p>Description: 设置接收人</p>
     * @param newValue 接收人
     */
    public void setReceivedId(Long newValue) {
        this.receivedId = newValue;
    }

    /**
     * <p>Description: 获取接收人</p>
     * @return 接收人
     */
    public Long getReceivedId() {
        return this.receivedId;
    }

    /**
     * <p>Description: 设置预计到达现场时间</p>
     * @param newValue 预计到达现场时间
     */
    public void setEstimateArriveTime(java.sql.Timestamp newValue) {
        this.estimateArriveTime = newValue;
    }

    /**
     * <p>Description: 获取预计到达现场时间</p>
     * @return 预计到达现场时间
     */
    public java.sql.Timestamp getEstimateArriveTime() {
        return this.estimateArriveTime;
    }

    /**
     * <p>Description: 设置预计完成时间</p>
     * @param newValue 预计完成时间
     */
    public void setEstimateFinishTime(java.sql.Timestamp newValue) {
        this.estimateFinishTime = newValue;
    }

    /**
     * <p>Description: 获取预计完成时间</p>
     * @return 预计完成时间
     */
    public java.sql.Timestamp getEstimateFinishTime() {
        return this.estimateFinishTime;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.workOrderId);
        LIST.add(this.assetCount);
        LIST.add(this.workReportId);
        LIST.add(this.workFlag);
        LIST.add(this.operateTime);
        LIST.add(this.operatorId);
        LIST.add(this.comments);
        LIST.add(this.receivedId);
        LIST.add(this.estimateArriveTime);
        LIST.add(this.estimateFinishTime);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.workOrderId = makeLongValue(rs, "WORK_ORDER_ID");
        this.assetCount = makeLongValue(rs, "ASSET_COUNT");
        this.workReportId = makeLongValue(rs, "WORK_REPORT_ID");
        this.workFlag = rs.getString("WORK_FLAG");
        this.operateTime = rs.getTimestamp("OPERATE_TIME");
        this.operatorId = makeLongValue(rs, "OPERATOR_ID");
        this.comments = rs.getString("COMMENTS");
        this.receivedId = makeLongValue(rs, "RECEIVED_ID");
        this.estimateArriveTime = rs.getTimestamp("ESTIMATE_ARRIVE_TIME");
        this.estimateFinishTime = rs.getTimestamp("ESTIMATE_FINISH_TIME");

    }
}

