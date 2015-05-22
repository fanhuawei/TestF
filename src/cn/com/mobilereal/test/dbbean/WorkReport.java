/**
 * WorkReport.java
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

import cn.com.mobilereal.test.dao.WorkReportDao;

/**
 * <p>ClassName: WorkReport</p>
 * <p>Description: 工单报告Bean类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class WorkReport extends BaseBean {
    /**
     * dao
     */
    public static final WorkReportDao I = new WorkReportDao();
    /**
     * 工单ID
     */
    private Long workOrderId;

    /**
     * 报告人员
     */
    private Long reportorId;

    /**
     * 类型 D: 开机报告，S：服务报告
     */
    private String type;

    /**
     * 内容
     */
    private String content;

    /**
     * 路途工时
     */
    private Long journeyHour;

    /**
     * 现场工时
     */
    private Long liveHour;

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
     * <p>Description: 设置报告人员</p>
     * @param newValue 报告人员
     */
    public void setReportorId(Long newValue) {
        this.reportorId = newValue;
    }

    /**
     * <p>Description: 获取报告人员</p>
     * @return 报告人员
     */
    public Long getReportorId() {
        return this.reportorId;
    }

    /**
     * <p>Description: 设置类型 D: 开机报告，S：服务报告</p>
     * @param newValue 类型 D: 开机报告，S：服务报告
     */
    public void setType(String newValue) {
        this.type = newValue;
    }

    /**
     * <p>Description: 获取类型 D: 开机报告，S：服务报告</p>
     * @return 类型 D: 开机报告，S：服务报告
     */
    public String getType() {
        return this.type;
    }

    /**
     * <p>Description: 设置内容</p>
     * @param newValue 内容
     */
    public void setContent(String newValue) {
        this.content = newValue;
    }

    /**
     * <p>Description: 获取内容</p>
     * @return 内容
     */
    public String getContent() {
        return this.content;
    }

    /**
     * <p>Description: 设置路途工时</p>
     * @param newValue 路途工时
     */
    public void setJourneyHour(Long newValue) {
        this.journeyHour = newValue;
    }

    /**
     * <p>Description: 获取路途工时</p>
     * @return 路途工时
     */
    public Long getJourneyHour() {
        return this.journeyHour;
    }

    /**
     * <p>Description: 设置现场工时</p>
     * @param newValue 现场工时
     */
    public void setLiveHour(Long newValue) {
        this.liveHour = newValue;
    }

    /**
     * <p>Description: 获取现场工时</p>
     * @return 现场工时
     */
    public Long getLiveHour() {
        return this.liveHour;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.workOrderId);
        LIST.add(this.reportorId);
        LIST.add(this.type);
        LIST.add(this.content);
        LIST.add(this.journeyHour);
        LIST.add(this.liveHour);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.workOrderId = makeLongValue(rs, "WORK_ORDER_ID");
        this.reportorId = makeLongValue(rs, "REPORTOR_ID");
        this.type = rs.getString("TYPE");
        this.content = rs.getString("CONTENT");
        this.journeyHour = makeLongValue(rs, "JOURNEY_HOUR");
        this.liveHour = makeLongValue(rs, "LIVE_HOUR");

    }
}

