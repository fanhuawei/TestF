/**
 * MenuButton.java
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
import cn.com.mobilereal.framework.dao.MenuButtonDao;


/**
 * 
 * <p>ClassName: MenuButton</p>
 * <p>Description: 系统菜单与按钮对应表Bean</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014-10-16</p>
 */
@SuppressWarnings("serial")
public class MenuButton extends BaseBean {
    /**
     * dao
     */
    public static final MenuButtonDao I = new MenuButtonDao();
    /**
     * [MENU_ID]
     */
    private Long menuId;

    /**
     * 名称
     */
    private String name;

    /**
     * [CODE]
     */
    private String code;

    /**
     * 授权标记
     */
    private String grantFlag;

    /**
     * <p>Description: 设置[MENU_ID]</p>
     * @param newValue [MENU_ID]
     */
    public void setMenuId(Long newValue) {
        this.menuId = newValue;
    }

    /**
     * <p>Description: 获取[MENU_ID]</p>
     * @return [MENU_ID]
     */
    public Long getMenuId() {
        return this.menuId;
    }

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
     * <p>Description: 设置[CODE]</p>
     * @param newValue [CODE]
     */
    public void setCode(String newValue) {
        this.code = newValue;
    }

    /**
     * <p>Description: 获取[CODE]</p>
     * @return [CODE]
     */
    public String getCode() {
        return this.code;
    }

    /**
     * <p>Description: 设置授权标记</p>
     * @param newValue 授权标记
     */
    public void setGrantFlag(String newValue) {
        this.grantFlag = newValue;
    }

    /**
     * <p>Description: 获取授权标记</p>
     * @return 授权标记
     */
    public String getGrantFlag() {
        return this.grantFlag;
    }


    @Override
    protected List<Object> makeArgu() {
        final List<Object> LIST = new ArrayList<Object>();
        LIST.add(this.menuId);
        LIST.add(this.name);
        LIST.add(this.code);
        LIST.add(this.grantFlag);
        return LIST;
    }

    @Override
    public void proceseResultSet(ResultSet rs) throws SQLException {
        this.menuId = makeLongValue(rs, "MENU_ID");
        this.name = rs.getString("NAME");
        this.code = rs.getString("CODE");
        this.grantFlag = rs.getString("GRANT_FLAG");
    }
}

