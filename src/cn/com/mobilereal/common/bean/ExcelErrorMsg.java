/**
 * ExcelErrorMsg.java
 * Created at 2014-07-22
 * Created by Fanhuawei
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */
package cn.com.mobilereal.common.bean;

import java.io.Serializable;

/**
 * <p>ClassName: ExcelErrorMsg</p>
 * <p>Description: 上传Excel错误对象</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014年7月22日</p>
 */
@SuppressWarnings("serial")
public class ExcelErrorMsg implements Serializable {
    /**
     * <p>Description: excel值</p>
     */
    private String value;
    /**
     * <p>Description: 错误描述</p>
     */
    private String errorMessage;
    /**
     * <p>Description: excel行</p>
     */
    private Integer row;
    /**
     * <p>Description: excel列</p>
     */
    private String cell ; 
    /**
     * <p>Description: 构造方法</p>
     */
    public ExcelErrorMsg() {

    }
    /**
     * <p>Description: 构造方法</p>
     * @param value excel的值
     * @param errorMessage 错误描述
     * @param row excel行
     * @param cell excel列
     */
    public ExcelErrorMsg(String value,  String errorMessage, Integer row, String cell) {
        this.value = value;
        this.errorMessage = errorMessage;
        this.row = row ;
        this.cell = cell;
    }
    
    
    public String getValue() {
        return this.value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getErrorMessage() {
        return this.errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public Integer getRow() {
        return this.row;
    }
    public void setRow(Integer row) {
        this.row = row;
    }
    public String getCell() {
        return this.cell;
    }
    public void setCell(String cell) {
        this.cell = cell;
    }
    

   
    
}
