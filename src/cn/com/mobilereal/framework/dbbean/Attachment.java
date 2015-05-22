/**
 * Attachment.java
 * Created at 2014-12-30
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.framework.dbbean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.com.mobilereal.common.dao.BaseBean;
import cn.com.mobilereal.framework.dao.AttachmentDao;

/**
 * <p>ClassName: Attachment</p>
 * <p>Description: 附件表Bean类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-30</p>
 */

@SuppressWarnings("serial")
public class Attachment extends BaseBean {
    /**
     * dao
     */
    public static final AttachmentDao I = new AttachmentDao();
    /**
     * 功能ID
     */
    private Long functionId;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 类型
     */
    private String contentType;

    /**
     * 存储路径
     */
    private String storePath;

    /**
     *  文件大小
     */
    private Long fileSize;

    /**
     * 编码
     */
    private String code;

    /**
     * <p>Description: 设置功能ID</p>
     * @param newValue 功能ID
     */
    public void setFunctionId(Long newValue) {
        this.functionId = newValue;
    }

    /**
     * <p>Description: 获取功能ID</p>
     * @return 功能ID
     */
    public Long getFunctionId() {
        return this.functionId;
    }

    /**
     * <p>Description: 设置文件名</p>
     * @param newValue 文件名
     */
    public void setFileName(String newValue) {
        this.fileName = newValue;
    }

    /**
     * <p>Description: 获取文件名</p>
     * @return 文件名
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     * <p>Description: 设置类型</p>
     * @param newValue 类型
     */
    public void setContentType(String newValue) {
        this.contentType = newValue;
    }

    /**
     * <p>Description: 获取类型</p>
     * @return 类型
     */
    public String getContentType() {
        return this.contentType;
    }

    /**
     * <p>Description: 设置存储路径</p>
     * @param newValue 存储路径
     */
    public void setStorePath(String newValue) {
        this.storePath = newValue;
    }

    /**
     * <p>Description: 获取存储路径</p>
     * @return 存储路径
     */
    public String getStorePath() {
        return this.storePath;
    }

    /**
     * <p>Description: 设置 文件大小</p>
     * @param newValue  文件大小
     */
    public void setFileSize(Long newValue) {
        this.fileSize = newValue;
    }

    /**
     * <p>Description: 获取 文件大小</p>
     * @return  文件大小
     */
    public Long getFileSize() {
        return this.fileSize;
    }

    /**
     * <p>Description: 设置编码</p>
     * @param newValue 编码
     */
    public void setCode(String newValue) {
        this.code = newValue;
    }

    /**
     * <p>Description: 获取编码</p>
     * @return 编码
     */
    public String getCode() {
        return this.code;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.functionId);
        LIST.add(this.fileName);
        LIST.add(this.contentType);
        LIST.add(this.storePath);
        LIST.add(this.fileSize);
        LIST.add(this.code);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.functionId = makeLongValue(rs, "FUNCTION_ID");
        this.fileName = rs.getString("FILE_NAME");
        this.contentType = rs.getString("CONTENT_TYPE");
        this.storePath = rs.getString("STORE_PATH");
        this.fileSize = makeLongValue(rs, "FILE_SIZE");
        this.code = rs.getString("CODE");

    }
}

