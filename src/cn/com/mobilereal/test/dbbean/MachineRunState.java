/**
 * MachineRunState.java
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

import cn.com.mobilereal.test.dao.MachineRunStateDao;

/**
 * <p>ClassName: MachineRunState</p>
 * <p>Description: 机器运行状态Bean类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class MachineRunState extends BaseBean {
    /**
     * dao
     */
    public static final MachineRunStateDao I = new MachineRunStateDao();
    /**
     * 机器ID
     */
    private Long machineId;

    /**
     * 采集设备
     */
    private Long boxId;

    /**
     * 工单ID
     */
    private Long workOrderId;

    /**
     * 采集时间
     */
    private java.sql.Timestamp collectTime;

    /**
     * 数据状态 A：正常 B：警告 C：停机
     */
    private String dataStatus;

    /**
     * 运行状态 A：正常  C：停机
     */
    private String runStatus;

    /**
     * 采集内容
     */
    private String content;

    /**
     * 文字内容
     */
    private String wordContent;

    /**
     * <p>Description: 设置机器ID</p>
     * @param newValue 机器ID
     */
    public void setMachineId(Long newValue) {
        this.machineId = newValue;
    }

    /**
     * <p>Description: 获取机器ID</p>
     * @return 机器ID
     */
    public Long getMachineId() {
        return this.machineId;
    }

    /**
     * <p>Description: 设置采集设备</p>
     * @param newValue 采集设备
     */
    public void setBoxId(Long newValue) {
        this.boxId = newValue;
    }

    /**
     * <p>Description: 获取采集设备</p>
     * @return 采集设备
     */
    public Long getBoxId() {
        return this.boxId;
    }

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
     * <p>Description: 设置采集时间</p>
     * @param newValue 采集时间
     */
    public void setCollectTime(java.sql.Timestamp newValue) {
        this.collectTime = newValue;
    }

    /**
     * <p>Description: 获取采集时间</p>
     * @return 采集时间
     */
    public java.sql.Timestamp getCollectTime() {
        return this.collectTime;
    }

    /**
     * <p>Description: 设置数据状态 A：正常 B：警告 C：停机</p>
     * @param newValue 数据状态 A：正常 B：警告 C：停机
     */
    public void setDataStatus(String newValue) {
        this.dataStatus = newValue;
    }

    /**
     * <p>Description: 获取数据状态 A：正常 B：警告 C：停机</p>
     * @return 数据状态 A：正常 B：警告 C：停机
     */
    public String getDataStatus() {
        return this.dataStatus;
    }

    /**
     * <p>Description: 设置运行状态 A：正常  C：停机</p>
     * @param newValue 运行状态 A：正常  C：停机
     */
    public void setRunStatus(String newValue) {
        this.runStatus = newValue;
    }

    /**
     * <p>Description: 获取运行状态 A：正常  C：停机</p>
     * @return 运行状态 A：正常  C：停机
     */
    public String getRunStatus() {
        return this.runStatus;
    }

    /**
     * <p>Description: 设置采集内容</p>
     * @param newValue 采集内容
     */
    public void setContent(String newValue) {
        this.content = newValue;
    }

    /**
     * <p>Description: 获取采集内容</p>
     * @return 采集内容
     */
    public String getContent() {
        return this.content;
    }

    /**
     * <p>Description: 设置文字内容</p>
     * @param newValue 文字内容
     */
    public void setWordContent(String newValue) {
        this.wordContent = newValue;
    }

    /**
     * <p>Description: 获取文字内容</p>
     * @return 文字内容
     */
    public String getWordContent() {
        return this.wordContent;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.machineId);
        LIST.add(this.boxId);
        LIST.add(this.workOrderId);
        LIST.add(this.collectTime);
        LIST.add(this.dataStatus);
        LIST.add(this.runStatus);
        LIST.add(this.content);
        LIST.add(this.wordContent);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.machineId = makeLongValue(rs, "MACHINE_ID");
        this.boxId = makeLongValue(rs, "BOX_ID");
        this.workOrderId = makeLongValue(rs, "WORK_ORDER_ID");
        this.collectTime = rs.getTimestamp("COLLECT_TIME");
        this.dataStatus = rs.getString("DATA_STATUS");
        this.runStatus = rs.getString("RUN_STATUS");
        this.content = rs.getString("CONTENT");
        this.wordContent = rs.getString("WORD_CONTENT");

    }
}

