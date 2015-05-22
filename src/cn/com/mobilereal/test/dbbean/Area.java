/**
 * Area.java
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

import cn.com.mobilereal.test.dao.AreaDao;

/**
 * <p>ClassName: Area</p>
 * <p>Description: 地区Bean类</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

@SuppressWarnings("serial")
public class Area extends BaseBean {
    /**
     * dao
     */
    public static final AreaDao I = new AreaDao();
    /**
     * 名称
     */
    private String name;

    /**
     * 编码
     */
    private String code;

    /**
     * 上级ID
     */
    private Long parentId;

    /**
     * 标记 P:省份 C:城市 D:区县
     */
    private String flag;

    /**
     * <p>Description: 设置名称</p>
     * @param newValue 名称
     */
    public void setName(String newValue) {
        this.name = newValue;
    }

    /**
     * <p>Description: 获取名称</p>
     * @return 名称
     */
    public String getName() {
        return this.name;
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

    /**
     * <p>Description: 设置上级ID</p>
     * @param newValue 上级ID
     */
    public void setParentId(Long newValue) {
        this.parentId = newValue;
    }

    /**
     * <p>Description: 获取上级ID</p>
     * @return 上级ID
     */
    public Long getParentId() {
        return this.parentId;
    }

    /**
     * <p>Description: 设置标记 P:省份 C:城市 D:区县</p>
     * @param newValue 标记 P:省份 C:城市 D:区县
     */
    public void setFlag(String newValue) {
        this.flag = newValue;
    }

    /**
     * <p>Description: 获取标记 P:省份 C:城市 D:区县</p>
     * @return 标记 P:省份 C:城市 D:区县
     */
    public String getFlag() {
        return this.flag;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.name);
        LIST.add(this.code);
        LIST.add(this.parentId);
        LIST.add(this.flag);

        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.name = rs.getString("NAME");
        this.code = rs.getString("CODE");
        this.parentId = makeLongValue(rs, "PARENT_ID");
        this.flag = rs.getString("FLAG");

    }
}

