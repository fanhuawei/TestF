/**
 * MachineExtend.java
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

import cn.com.mobilereal.test.dao.MachineExtendDao;

/**
 * <p>ClassName: MachineExtend</p>
 * <p>Description: 机器扩展属性Bean类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class MachineExtend extends BaseBean {
    /**
     * dao
     */
    public static final MachineExtendDao I = new MachineExtendDao();
    /**
     * 机器ID
     */
    private Long machineId;

    /**
     * 一级空气端型号
     */
    private String aclassAirTerminalModel;

    /**
     * 一级空气端系列号
     */
    private String aclassAirTerminalSn;

    /**
     * 二级空气端型号
     */
    private String classAirTerminalModel;

    /**
     * 二级空气端系列号
     */
    private String bclassAirTerminalSn;

    /**
     * 电脑板型号
     */
    private String controlBoardModel;

    /**
     * 电脑板系列号
     */
    private String controlBoardSn;

    /**
     * 主电机型号
     */
    private String mainMotorModel;

    /**
     * 主电机系列号
     */
    private String mainMotorSn;

    /**
     * 油冷却器型号
     */
    private String oilCoolerModel;

    /**
     * 油冷却器系列号
     */
    private String oilCoolerSn;

    /**
     * 中级冷却器型号
     */
    private String middleCoolerModel;

    /**
     * 中级冷却器系列号
     */
    private String middleCoolerSn;

    /**
     * 后冷却器型号
     */
    private String afterCoolerModel;

    /**
     * 后冷却器系列号
     */
    private String afterCoolerSn;

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
     * <p>Description: 设置一级空气端型号</p>
     * @param newValue 一级空气端型号
     */
    public void setAclassAirTerminalModel(String newValue) {
        this.aclassAirTerminalModel = newValue;
    }

    /**
     * <p>Description: 获取一级空气端型号</p>
     * @return 一级空气端型号
     */
    public String getAclassAirTerminalModel() {
        return this.aclassAirTerminalModel;
    }

    /**
     * <p>Description: 设置一级空气端系列号</p>
     * @param newValue 一级空气端系列号
     */
    public void setAclassAirTerminalSn(String newValue) {
        this.aclassAirTerminalSn = newValue;
    }

    /**
     * <p>Description: 获取一级空气端系列号</p>
     * @return 一级空气端系列号
     */
    public String getAclassAirTerminalSn() {
        return this.aclassAirTerminalSn;
    }

    /**
     * <p>Description: 设置二级空气端型号</p>
     * @param newValue 二级空气端型号
     */
    public void setClassAirTerminalModel(String newValue) {
        this.classAirTerminalModel = newValue;
    }

    /**
     * <p>Description: 获取二级空气端型号</p>
     * @return 二级空气端型号
     */
    public String getClassAirTerminalModel() {
        return this.classAirTerminalModel;
    }

    /**
     * <p>Description: 设置二级空气端系列号</p>
     * @param newValue 二级空气端系列号
     */
    public void setBclassAirTerminalSn(String newValue) {
        this.bclassAirTerminalSn = newValue;
    }

    /**
     * <p>Description: 获取二级空气端系列号</p>
     * @return 二级空气端系列号
     */
    public String getBclassAirTerminalSn() {
        return this.bclassAirTerminalSn;
    }

    /**
     * <p>Description: 设置电脑板型号</p>
     * @param newValue 电脑板型号
     */
    public void setControlBoardModel(String newValue) {
        this.controlBoardModel = newValue;
    }

    /**
     * <p>Description: 获取电脑板型号</p>
     * @return 电脑板型号
     */
    public String getControlBoardModel() {
        return this.controlBoardModel;
    }

    /**
     * <p>Description: 设置电脑板系列号</p>
     * @param newValue 电脑板系列号
     */
    public void setControlBoardSn(String newValue) {
        this.controlBoardSn = newValue;
    }

    /**
     * <p>Description: 获取电脑板系列号</p>
     * @return 电脑板系列号
     */
    public String getControlBoardSn() {
        return this.controlBoardSn;
    }

    /**
     * <p>Description: 设置主电机型号</p>
     * @param newValue 主电机型号
     */
    public void setMainMotorModel(String newValue) {
        this.mainMotorModel = newValue;
    }

    /**
     * <p>Description: 获取主电机型号</p>
     * @return 主电机型号
     */
    public String getMainMotorModel() {
        return this.mainMotorModel;
    }

    /**
     * <p>Description: 设置主电机系列号</p>
     * @param newValue 主电机系列号
     */
    public void setMainMotorSn(String newValue) {
        this.mainMotorSn = newValue;
    }

    /**
     * <p>Description: 获取主电机系列号</p>
     * @return 主电机系列号
     */
    public String getMainMotorSn() {
        return this.mainMotorSn;
    }

    /**
     * <p>Description: 设置油冷却器型号</p>
     * @param newValue 油冷却器型号
     */
    public void setOilCoolerModel(String newValue) {
        this.oilCoolerModel = newValue;
    }

    /**
     * <p>Description: 获取油冷却器型号</p>
     * @return 油冷却器型号
     */
    public String getOilCoolerModel() {
        return this.oilCoolerModel;
    }

    /**
     * <p>Description: 设置油冷却器系列号</p>
     * @param newValue 油冷却器系列号
     */
    public void setOilCoolerSn(String newValue) {
        this.oilCoolerSn = newValue;
    }

    /**
     * <p>Description: 获取油冷却器系列号</p>
     * @return 油冷却器系列号
     */
    public String getOilCoolerSn() {
        return this.oilCoolerSn;
    }

    /**
     * <p>Description: 设置中级冷却器型号</p>
     * @param newValue 中级冷却器型号
     */
    public void setMiddleCoolerModel(String newValue) {
        this.middleCoolerModel = newValue;
    }

    /**
     * <p>Description: 获取中级冷却器型号</p>
     * @return 中级冷却器型号
     */
    public String getMiddleCoolerModel() {
        return this.middleCoolerModel;
    }

    /**
     * <p>Description: 设置中级冷却器系列号</p>
     * @param newValue 中级冷却器系列号
     */
    public void setMiddleCoolerSn(String newValue) {
        this.middleCoolerSn = newValue;
    }

    /**
     * <p>Description: 获取中级冷却器系列号</p>
     * @return 中级冷却器系列号
     */
    public String getMiddleCoolerSn() {
        return this.middleCoolerSn;
    }

    /**
     * <p>Description: 设置后冷却器型号</p>
     * @param newValue 后冷却器型号
     */
    public void setAfterCoolerModel(String newValue) {
        this.afterCoolerModel = newValue;
    }

    /**
     * <p>Description: 获取后冷却器型号</p>
     * @return 后冷却器型号
     */
    public String getAfterCoolerModel() {
        return this.afterCoolerModel;
    }

    /**
     * <p>Description: 设置后冷却器系列号</p>
     * @param newValue 后冷却器系列号
     */
    public void setAfterCoolerSn(String newValue) {
        this.afterCoolerSn = newValue;
    }

    /**
     * <p>Description: 获取后冷却器系列号</p>
     * @return 后冷却器系列号
     */
    public String getAfterCoolerSn() {
        return this.afterCoolerSn;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.machineId);
        LIST.add(this.aclassAirTerminalModel);
        LIST.add(this.aclassAirTerminalSn);
        LIST.add(this.classAirTerminalModel);
        LIST.add(this.bclassAirTerminalSn);
        LIST.add(this.controlBoardModel);
        LIST.add(this.controlBoardSn);
        LIST.add(this.mainMotorModel);
        LIST.add(this.mainMotorSn);
        LIST.add(this.oilCoolerModel);
        LIST.add(this.oilCoolerSn);
        LIST.add(this.middleCoolerModel);
        LIST.add(this.middleCoolerSn);
        LIST.add(this.afterCoolerModel);
        LIST.add(this.afterCoolerSn);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.machineId = makeLongValue(rs, "MACHINE_ID");
        this.aclassAirTerminalModel = rs.getString("ACLASS_AIR_TERMINAL_MODEL");
        this.aclassAirTerminalSn = rs.getString("ACLASS_AIR_TERMINAL_SN");
        this.classAirTerminalModel = rs.getString("CLASS_AIR_TERMINAL_MODEL");
        this.bclassAirTerminalSn = rs.getString("BCLASS_AIR_TERMINAL_SN");
        this.controlBoardModel = rs.getString("CONTROL_BOARD_MODEL");
        this.controlBoardSn = rs.getString("CONTROL_BOARD_SN");
        this.mainMotorModel = rs.getString("MAIN_MOTOR_MODEL");
        this.mainMotorSn = rs.getString("MAIN_MOTOR_SN");
        this.oilCoolerModel = rs.getString("OIL_COOLER_MODEL");
        this.oilCoolerSn = rs.getString("OIL_COOLER_SN");
        this.middleCoolerModel = rs.getString("MIDDLE_COOLER_MODEL");
        this.middleCoolerSn = rs.getString("MIDDLE_COOLER_SN");
        this.afterCoolerModel = rs.getString("AFTER_COOLER_MODEL");
        this.afterCoolerSn = rs.getString("AFTER_COOLER_SN");

    }
}

