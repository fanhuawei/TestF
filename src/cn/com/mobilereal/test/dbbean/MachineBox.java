/**
 * MachineBox.java
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

import cn.com.mobilereal.test.dao.MachineBoxDao;

/**
 * <p>ClassName: MachineBox</p>
 * <p>Description: 机器采集设备Bean类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class MachineBox extends BaseBean {
    /**
     * dao
     */
    public static final MachineBoxDao I = new MachineBoxDao();
    /**
     * 机器ID
     */
    private Long machineId;

    /**
     * 系列号
     */
    private String serialNo;

    /**
     * 控制器型号
     */
    private String controllModel;

    /**
     * 有效标记
     */
    private String validFlag;

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
     * <p>Description: 设置系列号</p>
     * @param newValue 系列号
     */
    public void setSerialNo(String newValue) {
        this.serialNo = newValue;
    }

    /**
     * <p>Description: 获取系列号</p>
     * @return 系列号
     */
    public String getSerialNo() {
        return this.serialNo;
    }

    /**
     * <p>Description: 设置控制器型号</p>
     * @param newValue 控制器型号
     */
    public void setControllModel(String newValue) {
        this.controllModel = newValue;
    }

    /**
     * <p>Description: 获取控制器型号</p>
     * @return 控制器型号
     */
    public String getControllModel() {
        return this.controllModel;
    }

    /**
     * <p>Description: 设置有效标记</p>
     * @param newValue 有效标记
     */
    public void setValidFlag(String newValue) {
        this.validFlag = newValue;
    }

    /**
     * <p>Description: 获取有效标记</p>
     * @return 有效标记
     */
    public String getValidFlag() {
        return this.validFlag;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.machineId);
        LIST.add(this.serialNo);
        LIST.add(this.controllModel);
        LIST.add(this.validFlag);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.machineId = makeLongValue(rs, "MACHINE_ID");
        this.serialNo = rs.getString("SERIAL_NO");
        this.controllModel = rs.getString("CONTROLL_MODEL");
        this.validFlag = rs.getString("VALID_FLAG");

    }
}

