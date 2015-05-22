/**
 * IDaoConst.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.framework.dbbean;

/**
 * <p>ClassName: IDaoConst</p>
 * <p>Description: 所有的数据库表的插入与更新语句</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

public interface IDaoConst {
     /**
     *数据字典明细表表插入SQL
     */
    String TC_CODE_DETAIL_I = "INSERT INTO tc_code_detail(CODE_LIST_ID,PARENT_ID,VALUE,CODE,FLAG,SORT_NO,"
            + "COMMENTS"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *数据字典明细表表更新SQL
     */
    String TC_CODE_DETAIL_U = "UPDATE tc_code_detail SET CODE_LIST_ID=?,PARENT_ID=?,VALUE=?,CODE=?,FLAG=?,"
            + "SORT_NO=?,COMMENTS=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *数据字典主表表插入SQL
     */
    String TC_CODE_LIST_I = "INSERT INTO tc_code_list(CODE,NAME,FLAG,PARENT_ID,COMMENTS"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *数据字典主表表更新SQL
     */
    String TC_CODE_LIST_U = "UPDATE tc_code_list SET CODE=?,NAME=?,FLAG=?,PARENT_ID=?,COMMENTS=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *PAD设备表插入SQL
     */
    String TM_DEVICE_I = "INSERT INTO tm_device(SN,NAME,USE_FLAG,LOST_FLAG"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?)";

    /**
     *PAD设备表更新SQL
     */
    String TM_DEVICE_U = "UPDATE tm_device SET SN=?,NAME=?,USE_FLAG=?,LOST_FLAG=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *快捷方式表插入SQL
     */
    String TM_SHORT_CUT_I = "INSERT INTO tm_short_cut(NAME,LINK,SORT_NO"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?)";

    /**
     *快捷方式表更新SQL
     */
    String TM_SHORT_CUT_U = "UPDATE tm_short_cut SET NAME=?,LINK=?,SORT_NO=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *系统角色到按钮权限表插入SQL
     */
    String TR_ROLE_BUTTON_I = "INSERT INTO tr_role_button(ROLE_ID,MENU_BUTTON_ID"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?)";

    /**
     *系统角色到按钮权限表更新SQL
     */
    String TR_ROLE_BUTTON_U = "UPDATE tr_role_button SET ROLE_ID=?,MENU_BUTTON_ID=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *系统角色权限表插入SQL
     */
    String TR_ROLE_MENU_I = "INSERT INTO tr_role_menu(ROLE_ID,MENU_ID"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?)";

    /**
     *系统角色权限表更新SQL
     */
    String TR_ROLE_MENU_U = "UPDATE tr_role_menu SET ROLE_ID=?,MENU_ID=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *角色的快捷方式信息表插入SQL
     */
    String TR_ROLE_SHORT_CUT_I = "INSERT INTO tr_role_short_cut(ROLE_ID,SHORT_CUT_ID"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?)";

    /**
     *角色的快捷方式信息表更新SQL
     */
    String TR_ROLE_SHORT_CUT_U = "UPDATE tr_role_short_cut SET ROLE_ID=?,SHORT_CUT_ID=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *系统用户角色对应表表插入SQL
     */
    String TR_USER_ROLE_I = "INSERT INTO tr_user_role(USER_ID,ROLE_ID"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?)";

    /**
     *系统用户角色对应表表更新SQL
     */
    String TR_USER_ROLE_U = "UPDATE tr_user_role SET USER_ID=?,ROLE_ID=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *附件表表插入SQL
     */
    String TS_ATTACHMENT_I = "INSERT INTO ts_attachment(FILE_NAME,CONTENT_TYPE,STORE_PATH,FILE_SIZE,CODE"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *附件表表更新SQL
     */
    String TS_ATTACHMENT_U = "UPDATE ts_attachment SET FILE_NAME=?,CONTENT_TYPE=?,STORE_PATH=?,FILE_SIZE=?,"
            + "CODE=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *系统菜单与按钮对应表表插入SQL
     */
    String TS_MENU_BUTTON_I = "INSERT INTO ts_menu_button(MENU_ID,NAME,CODE,GRANT_FLAG"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?)";

    /**
     *系统菜单与按钮对应表表更新SQL
     */
    String TS_MENU_BUTTON_U = "UPDATE ts_menu_button SET MENU_ID=?,NAME=?,CODE=?,GRANT_FLAG=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *系统菜单及功能页面表插入SQL
     */
    String TS_MENU_FUNCTION_I = "INSERT INTO ts_menu_function(NAME,PATH,ACTION_CLASS,PARENT_MENU_ID,FUNCTION_FLAG"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *系统菜单及功能页面表更新SQL
     */
    String TS_MENU_FUNCTION_U = "UPDATE ts_menu_function SET NAME=?,PATH=?,ACTION_CLASS=?,PARENT_MENU_ID=?,"
            + "FUNCTION_FLAG=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *系统操作日志表插入SQL
     */
    String TS_OPERATE_LOG_I = "INSERT INTO ts_operate_log(LOG_ID,PATH,MODULE,PARAMETER,ACTION_NAME,ACTION_CODE,"
            + "REASON,RESULT"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *系统操作日志表更新SQL
     */
    String TS_OPERATE_LOG_U = "UPDATE ts_operate_log SET LOG_ID=?,PATH=?,MODULE=?,PARAMETER=?,ACTION_NAME=?,"
            + "ACTION_CODE=?,REASON=?,RESULT=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *MOBILE操作日志表插入SQL
     */
    String TS_OPERATE_LOG_MOBILE_I = "INSERT INTO ts_operate_log_mobile(USER_ID,ROLE_ID,DEVICE_SN,PATH,PARAMETER,"
            + "ACTION_NAME,ACTION_CODE,REASON,RESULT"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *MOBILE操作日志表更新SQL
     */
    String TS_OPERATE_LOG_MOBILE_U = "UPDATE ts_operate_log_mobile SET USER_ID=?,ROLE_ID=?,DEVICE_SN=?,PATH=?,"
            + "PARAMETER=?,ACTION_NAME=?,ACTION_CODE=?,REASON=?,RESULT=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *WEB操作日志表插入SQL
     */
    String TS_OPERATE_LOG_WEB_I = "INSERT INTO ts_operate_log_web(USER_ID,ROLE_ID,SESSION_ID,CLIENT_IP,LOGIN_TIME,"
            + "LOGOUT_TIME"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *WEB操作日志表更新SQL
     */
    String TS_OPERATE_LOG_WEB_U = "UPDATE ts_operate_log_web SET USER_ID=?,ROLE_ID=?,SESSION_ID=?,CLIENT_IP=?,"
            + "LOGIN_TIME=?,LOGOUT_TIME=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *系统角色表插入SQL
     */
    String TS_ROLE_I = "INSERT INTO ts_role(CODE,NAME,FLAG"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?)";

    /**
     *系统角色表更新SQL
     */
    String TS_ROLE_U = "UPDATE ts_role SET CODE=?,NAME=?,FLAG=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *系统用户表插入SQL
     */
    String TS_USER_I = "INSERT INTO ts_user(NAME,CODE,LOGIN_PASS,AGENT_ID,DEPT_ID,PHONE,EMAIL,ROLE_ID,"
            + "COVER_ACCOUNT_ID,VALID_FLAG,HEAD_IMG,PRIMARY_FLAG"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *系统用户表更新SQL
     */
    String TS_USER_U = "UPDATE ts_user SET NAME=?,CODE=?,LOGIN_PASS=?,AGENT_ID=?,DEPT_ID=?,PHONE=?,"
            + "EMAIL=?,ROLE_ID=?,COVER_ACCOUNT_ID=?,VALID_FLAG=?,HEAD_IMG=?,PRIMARY_FLAG=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

}
