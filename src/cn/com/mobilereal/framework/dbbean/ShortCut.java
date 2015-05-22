/**
 * ShortCut.java
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
import cn.com.mobilereal.framework.dao.ShortCutDao;

/**
 * 
 * <p>ClassName: ShortCut</p>
 * <p>Description: 快捷方式Bean</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class ShortCut extends BaseBean {
    /**
     * dao
     */
    public static final ShortCutDao I = new ShortCutDao();
    /**
     * 名称
     */
    private String name;

    /**
     * 链接
     */
    private String link;

    /**
     * 排序号
     */
    private Long sortNo;

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
     * <p>Description: 设置链接</p>
     * @param newValue 链接
     */
    public void setLink(String newValue) {
        this.link = newValue;
    }

    /**
     * <p>Description: 获取链接</p>
     * @return 链接
     */
    public String getLink() {
        return this.link;
    }

    /**
     * <p>Description: 设置排序号</p>
     * @param newValue 排序号
     */
    public void setSortNo(Long newValue) {
        this.sortNo = newValue;
    }

    /**
     * <p>Description: 获取排序号</p>
     * @return 排序号
     */
    public Long getSortNo() {
        return this.sortNo;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.name);
        LIST.add(this.link);
        LIST.add(this.sortNo);
        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.name = rs.getString("NAME");
        this.link = rs.getString("LINK");
        this.sortNo = makeLongValue(rs, "SORT_NO");
    }
}

