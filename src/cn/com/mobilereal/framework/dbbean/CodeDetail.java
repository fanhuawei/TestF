/**
 * CodeDetail.java
 * Created at 2014-10-16
 * Created by Fanhuawei
 * Copyright (C) 2014 MobileReal All rights reserved.
 */
package cn.com.mobilereal.framework.dbbean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.mobilereal.common.dao.BaseBean;
import cn.com.mobilereal.framework.dao.CodeDetailDao;

/**
 * 
 * <p>ClassName: CodeDetail</p>
 * <p>Description: 数据字典明细表Bean</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class CodeDetail extends BaseBean {
    /**
     * dao
     */
    public static final CodeDetailDao I = new CodeDetailDao();
    /**
     * 数据字典主表ID
     */
    private Long codeListId;

    /**
     * 上一级数据ID
     */
    private Long parentId;

    /**
     * 数据显示值
     */
    private String value;

    /**
     * 数据存储值
     */
    private String code;

    /**
     * 是否系统配置Y:是，N：否
     */
    private String flag;

    /**
     * 描述
     */
    private String comments;

    /**
     * 排序
     */
    private Long sortNo;

    /**
     * <p>Description: 设置数据字典主表ID</p>
     * @param newValue 数据字典主表ID
     */
    public void setCodeListId(Long newValue) {
        this.codeListId = newValue;
    }

    /**
     * <p>Description: 获取数据字典主表ID</p>
     * @return 数据字典主表ID
     */
    public Long getCodeListId() {
        return this.codeListId;
    }

    /**
     * <p>Description: 设置上一级数据ID</p>
     * @param newValue 上一级数据ID
     */
    public void setParentId(Long newValue) {
        this.parentId = newValue;
    }

    /**
     * <p>Description: 获取上一级数据ID</p>
     * @return 上一级数据ID
     */
    public Long getParentId() {
        return this.parentId;
    }

    /**
     * <p>Description: 设置数据显示值</p>
     * @param newValue 数据显示值
     */
    public void setValue(String newValue) {
        this.value = newValue;
    }

    /**
     * <p>Description: 获取数据显示值</p>
     * @return 数据显示值
     */
    public String getValue() {
        return this.value;
    }

    /**
     * <p>Description: 设置数据存储值</p>
     * @param newValue 数据存储值
     */
    public void setCode(String newValue) {
        this.code = newValue;
    }

    /**
     * <p>Description: 获取数据存储值</p>
     * @return 数据存储值
     */
    public String getCode() {
        return this.code;
    }

    /**
     * <p>Description: 设置是否系统配置Y:是，N：否</p>
     * @param newValue 是否系统配置Y:是，N：否
     */
    public void setFlag(String newValue) {
        this.flag = newValue;
    }

    /**
     * <p>Description: 获取是否系统配置Y:是，N：否</p>
     * @return 是否系统配置Y:是，N：否
     */
    public String getFlag() {
        return this.flag;
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
     * <p>Description: 设置排序</p>
     * @param newValue 排序
     */
    public void setSortNo(Long newValue) {
        this.sortNo = newValue;
    }

    /**
     * <p>Description: 获取排序</p>
     * @return 排序
     */
    public Long getSortNo() {
        return this.sortNo;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.codeListId);
        LIST.add(this.parentId);
        LIST.add(this.value);
        LIST.add(this.code);
        LIST.add(this.flag);
        LIST.add(this.comments);
        LIST.add(this.sortNo);
        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.codeListId = makeLongValue(rs, "CODE_LIST_ID");
        this.parentId = makeLongValue(rs, "PARENT_ID");
        this.value = rs.getString("VALUE");
        this.code = rs.getString("CODE");
        this.flag = rs.getString("FLAG");
        this.comments = rs.getString("COMMENTS");
        this.sortNo = makeLongValue(rs, "SORT_NO");
    }
}

