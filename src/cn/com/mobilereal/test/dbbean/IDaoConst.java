/**
 * IDaoConst.java
 * Created at 2014-12-28
 * Created by 樊华伟
 * Copyright (C) 2014 mobilereal All rights reserved.
 */

package cn.com.mobilereal.test.dbbean;

/**
 * <p>ClassName: IDaoConst</p>
 * <p>Description: 所有的数据库表的插入与更新语句</p>
 * <p>Author: 樊华伟</p>
 * <p>Date: 2014-12-28</p>
 */

public interface IDaoConst {
    /**
     *地区表插入SQL
     */
    String TC_AREA_I = "INSERT INTO tc_area(NAME,CODE,PARENT_ID,FLAG"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?)";

    /**
     *地区表更新SQL
     */
    String TC_AREA_U = "UPDATE tc_area SET NAME=?,CODE=?,PARENT_ID=?,FLAG=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

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
     *用户设备表插入SQL
     */
    String TR_USER_DEVICE_I = "INSERT INTO tr_user_device(DEVICE_ID,USER_ID,USE_TIME"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?)";

    /**
     *用户设备表更新SQL
     */
    String TR_USER_DEVICE_U = "UPDATE tr_user_device SET DEVICE_ID=?,USER_ID=?,USE_TIME=?"
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
     *工单故障类别表插入SQL
     */
    String TR_WORK_ERROR_CATEGORY_I = "INSERT INTO tr_work_error_category(WORK_ORDER_ID,CATEGORY"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?)";

    /**
     *工单故障类别表更新SQL
     */
    String TR_WORK_ERROR_CATEGORY_U = "UPDATE tr_work_error_category SET WORK_ORDER_ID=?,CATEGORY=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *推送消息表插入SQL
     */
    String TS_APNS_MESSAGE_I = "INSERT INTO ts_apns_message(TITLE,CONTENT,CNT,DEVICE_ID,STATUS,USER_ID"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *推送消息表更新SQL
     */
    String TS_APNS_MESSAGE_U = "UPDATE ts_apns_message SET TITLE=?,CONTENT=?,CNT=?,DEVICE_ID=?,STATUS=?,"
            + "USER_ID=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *推送消息接受人表插入SQL
     */
    String TS_APNS_MESSAGE_RECEIVER_I = "INSERT INTO ts_apns_message_receiver(MESSAGE_ID,DEVICE_ID,STATUS,USER_ID"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?)";

    /**
     *推送消息接受人表更新SQL
     */
    String TS_APNS_MESSAGE_RECEIVER_U = "UPDATE ts_apns_message_receiver SET MESSAGE_ID=?,DEVICE_ID=?,STATUS=?,USER_ID=?"
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
     *百度云推送信息表插入SQL
     */
    String TS_BAIDU_INFO_I = "INSERT INTO ts_baidu_info(USER_ID,DEVICE_SN,CLIENT_ID,CHANNEL_ID,APP_ID,"
            + "DEVICE_TYPE"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *百度云推送信息表更新SQL
     */
    String TS_BAIDU_INFO_U = "UPDATE ts_baidu_info SET USER_ID=?,DEVICE_SN=?,CLIENT_ID=?,CHANNEL_ID=?,"
            + "APP_ID=?,DEVICE_TYPE=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *部门表插入SQL
     */
    String TS_DEPT_I = "INSERT INTO ts_dept(CODE,NAME,ADDRESS,ZIP,LEADER_ID,REGION,PROVINCE_ID,"
            + "CITY_ID,COUNTY_ID,TEL,FAX,EMAIL,CONTACT,CONTACT_PHONE,CONTACT_EMAIL,TYPE,SHORT_NAME"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *部门表更新SQL
     */
    String TS_DEPT_U = "UPDATE ts_dept SET CODE=?,NAME=?,ADDRESS=?,ZIP=?,LEADER_ID=?,REGION=?,PROVINCE_ID=?,"
            + "CITY_ID=?,COUNTY_ID=?,TEL=?,FAX=?,EMAIL=?,CONTACT=?,CONTACT_PHONE=?,CONTACT_EMAIL=?,TYPE=?,"
            + "SHORT_NAME=?"
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

    /**
     *代班表插入SQL
     */
    String TS_WORK_I = "INSERT INTO ts_work(USER_ID,COVER_USER_ID,START_TIME,END_TIME,VALID_FLAG"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *代班表更新SQL
     */
    String TS_WORK_U = "UPDATE ts_work SET USER_ID=?,COVER_USER_ID=?,START_TIME=?,END_TIME=?,VALID_FLAG=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *代理商表插入SQL
     */
    String TT_AGENT_I = "INSERT INTO tt_agent(OLD_ID,SHORT_NAME,NAME,PING_YING,GRADE,PROFESSION,"
            + "REGION,PROVINCE_ID,SALE_MANAGER,ADDRESS,ZIP,TEL,EMAIL,FAX,CONTACT1,MOBILE1,CONTACT2,MOBILE2,"
            + "CUSTOMER_SERVICE,CUSTOMER_SERVICE_MOBILE,CUSTOMER_SERVICE_EMAIL,LEADER_ID"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *代理商表更新SQL
     */
    String TT_AGENT_U = "UPDATE tt_agent SET OLD_ID=?,SHORT_NAME=?,NAME=?,PING_YING=?,GRADE=?,PROFESSION=?,"
            + "REGION=?,PROVINCE_ID=?,SALE_MANAGER=?,ADDRESS=?,ZIP=?,TEL=?,EMAIL=?,FAX=?,CONTACT1=?,MOBILE1=?,"
            + "CONTACT2=?,MOBILE2=?,CUSTOMER_SERVICE=?,CUSTOMER_SERVICE_MOBILE=?,CUSTOMER_SERVICE_EMAIL=?,"
            + "LEADER_ID=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *客户表插入SQL
     */
    String TT_CUSTOMER_I = "INSERT INTO tt_customer(OLD_ID,SHORT_NAME,NAME,PROFESSION,REGION,PROVINCE_ID,"
            + "CITY_ID,COUNTY_ID,ADDRESS,ZIP,TEL,EMAIL,FAX,CONTACT1,MOBILE1,EMAIL1,CONTACT2,MOBILE2,EMAIL2,"
            + "TITLE1,TITLE2"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *客户表更新SQL
     */
    String TT_CUSTOMER_U = "UPDATE tt_customer SET OLD_ID=?,SHORT_NAME=?,NAME=?,PROFESSION=?,REGION=?,"
            + "PROVINCE_ID=?,CITY_ID=?,COUNTY_ID=?,ADDRESS=?,ZIP=?,TEL=?,EMAIL=?,FAX=?,CONTACT1=?,MOBILE1=?,"
            + "EMAIL1=?,CONTACT2=?,MOBILE2=?,EMAIL2=?,TITLE1=?,TITLE2=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *机器表插入SQL
     */
    String TT_MACHINE_I = "INSERT INTO tt_machine(AGENT_ID,SERVICE_CENTER_ID,TYPE,MODEL,SERIAL_NO,"
            + "PRODUCT_TIME,OPEN_TIME,SAP_PRODUCT_TIME,WARRANTY_TIME,TERMINAL_ID,CUSTOMER_ID,RUN_STATE_ID,"
            + "LAST_SERVICE_ID,LONGITITUDE,LATITUDE,LOCATION"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *机器表更新SQL
     */
    String TT_MACHINE_U = "UPDATE tt_machine SET AGENT_ID=?,SERVICE_CENTER_ID=?,TYPE=?,MODEL=?,SERIAL_NO=?,"
            + "PRODUCT_TIME=?,OPEN_TIME=?,SAP_PRODUCT_TIME=?,WARRANTY_TIME=?,TERMINAL_ID=?,CUSTOMER_ID=?,"
            + "RUN_STATE_ID=?,LAST_SERVICE_ID=?,LONGITITUDE=?,LATITUDE=?,LOCATION=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *机器采集设备表插入SQL
     */
    String TT_MACHINE_BOX_I = "INSERT INTO tt_machine_box(MACHINE_ID,SERIAL_NO,CONTROLL_MODEL,VALID_FLAG"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?)";

    /**
     *机器采集设备表更新SQL
     */
    String TT_MACHINE_BOX_U = "UPDATE tt_machine_box SET MACHINE_ID=?,SERIAL_NO=?,CONTROLL_MODEL=?,VALID_FLAG=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *机器扩展属性表插入SQL
     */
    String TT_MACHINE_EXTEND_I = "INSERT INTO tt_machine_extend(MACHINE_ID,ACLASS_AIR_TERMINAL_MODEL,ACLASS_AIR_TERMINAL_SN,"
            + "CLASS_AIR_TERMINAL_MODEL,BCLASS_AIR_TERMINAL_SN,CONTROL_BOARD_MODEL,CONTROL_BOARD_SN,MAIN_MOTOR_MODEL,"
            + "MAIN_MOTOR_SN,OIL_COOLER_MODEL,OIL_COOLER_SN,MIDDLE_COOLER_MODEL,MIDDLE_COOLER_SN,AFTER_COOLER_MODEL,"
            + "AFTER_COOLER_SN"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *机器扩展属性表更新SQL
     */
    String TT_MACHINE_EXTEND_U = "UPDATE tt_machine_extend SET MACHINE_ID=?,ACLASS_AIR_TERMINAL_MODEL=?,ACLASS_AIR_TERMINAL_SN=?,"
            + "CLASS_AIR_TERMINAL_MODEL=?,BCLASS_AIR_TERMINAL_SN=?,CONTROL_BOARD_MODEL=?,CONTROL_BOARD_SN=?,"
            + "MAIN_MOTOR_MODEL=?,MAIN_MOTOR_SN=?,OIL_COOLER_MODEL=?,OIL_COOLER_SN=?,MIDDLE_COOLER_MODEL=?,"
            + "MIDDLE_COOLER_SN=?,AFTER_COOLER_MODEL=?,AFTER_COOLER_SN=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *机器运行状态表插入SQL
     */
    String TT_MACHINE_RUN_STATE_I = "INSERT INTO tt_machine_run_state(MACHINE_ID,BOX_ID,WORK_ORDER_ID,COLLECT_TIME,"
            + "DATA_STATUS,RUN_STATUS,CONTENT,WORD_CONTENT"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *机器运行状态表更新SQL
     */
    String TT_MACHINE_RUN_STATE_U = "UPDATE tt_machine_run_state SET MACHINE_ID=?,BOX_ID=?,WORK_ORDER_ID=?,COLLECT_TIME=?,"
            + "DATA_STATUS=?,RUN_STATUS=?,CONTENT=?,WORD_CONTENT=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *机器延保记录表插入SQL
     */
    String TT_MACHINE_WARRANTY_DELAY_I = "INSERT INTO tt_machine_warranty_delay(MACHINE_ID,WARRANTY_TIME,NEW_WARRANTY_TIME,"
            + "USER_ID,COMMENTS"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *机器延保记录表更新SQL
     */
    String TT_MACHINE_WARRANTY_DELAY_U = "UPDATE tt_machine_warranty_delay SET MACHINE_ID=?,WARRANTY_TIME=?,NEW_WARRANTY_TIME=?,"
            + "USER_ID=?,COMMENTS=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *客户其它厂家机器表插入SQL
     */
    String TT_OTHER_MACHINE_I = "INSERT INTO tt_other_machine(CUSTOMER_ID,TYPE,MODEL,SERIAL_NO,SUPPLIER"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *客户其它厂家机器表更新SQL
     */
    String TT_OTHER_MACHINE_U = "UPDATE tt_other_machine SET CUSTOMER_ID=?,TYPE=?,MODEL=?,SERIAL_NO=?,SUPPLIER=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *配件库表插入SQL
     */
    String TT_PART_BASE_I = "INSERT INTO tt_part_base(NAME,CODE,SPEC,CURRENCY,PRICE,UNIT,GRP,AMOUNT"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *配件库表更新SQL
     */
    String TT_PART_BASE_U = "UPDATE tt_part_base SET NAME=?,CODE=?,SPEC=?,CURRENCY=?,PRICE=?,UNIT=?,"
            + "GRP=?,AMOUNT=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *配件使用表插入SQL
     */
    String TT_PART_USAGE_I = "INSERT INTO tt_part_usage(PART_ID,WORK_ORDER_ID,PRICE,AMOUNT"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?)";

    /**
     *配件使用表更新SQL
     */
    String TT_PART_USAGE_U = "UPDATE tt_part_usage SET PART_ID=?,WORK_ORDER_ID=?,PRICE=?,AMOUNT=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *工单流附件表插入SQL
     */
    String TT_WORK_FLOW_ASSET_I = "INSERT INTO tt_work_flow_asset(WORK_FLOW_ID,USER_ID,ATTACHMENT_ID"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?)";

    /**
     *工单流附件表更新SQL
     */
    String TT_WORK_FLOW_ASSET_U = "UPDATE tt_work_flow_asset SET WORK_FLOW_ID=?,USER_ID=?,ATTACHMENT_ID=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *工单表插入SQL
     */
    String TT_WORK_ORDER_I = "INSERT INTO tt_work_order(CODE,USER_ID,AGENT_ID,CUSTOMER_ID,SERVICE_CENTER_ID,"
            + "MACHINE_ID,SERVICE_TYPE,COMMENTS,RUN_STATE_ID,WORK_ORDER_FLOW_ID,LATITUDE,LONGITUDE,ARRIVED_TIME,"
            + "STATUS,CONTACT,CONTACT_TEL,PROVINCE_ID,CITY_ID,COUNTY_ID,ADDRESS"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *工单表更新SQL
     */
    String TT_WORK_ORDER_U = "UPDATE tt_work_order SET CODE=?,USER_ID=?,AGENT_ID=?,CUSTOMER_ID=?,SERVICE_CENTER_ID=?,"
            + "MACHINE_ID=?,SERVICE_TYPE=?,COMMENTS=?,RUN_STATE_ID=?,WORK_ORDER_FLOW_ID=?,LATITUDE=?,"
            + "LONGITUDE=?,ARRIVED_TIME=?,STATUS=?,CONTACT=?,CONTACT_TEL=?,PROVINCE_ID=?,CITY_ID=?,COUNTY_ID=?,"
            + "ADDRESS=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *工单流表插入SQL
     */
    String TT_WORK_ORDER_FLOW_I = "INSERT INTO tt_work_order_flow(WORK_ORDER_ID,ASSET_COUNT,WORK_REPORT_ID,"
            + "WORK_FLAG,OPERATE_TIME,OPERATOR_ID,COMMENTS,RECEIVED_ID,ESTIMATE_ARRIVE_TIME,ESTIMATE_FINISH_TIME"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *工单流表更新SQL
     */
    String TT_WORK_ORDER_FLOW_U = "UPDATE tt_work_order_flow SET WORK_ORDER_ID=?,ASSET_COUNT=?,WORK_REPORT_ID=?,"
            + "WORK_FLAG=?,OPERATE_TIME=?,OPERATOR_ID=?,COMMENTS=?,RECEIVED_ID=?,ESTIMATE_ARRIVE_TIME=?,"
            + "ESTIMATE_FINISH_TIME=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";

    /**
     *工单报告表插入SQL
     */
    String TT_WORK_REPORT_I = "INSERT INTO tt_work_report(WORK_ORDER_ID,REPORTOR_ID,TYPE,CONTENT,JOURNEY_HOUR,"
            + "LIVE_HOUR"
            + ",DELETE_MARK,CREATE_BY,CREATE_TIME,UPDATE_BY,UPDATE_TIME,ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

    /**
     *工单报告表更新SQL
     */
    String TT_WORK_REPORT_U = "UPDATE tt_work_report SET WORK_ORDER_ID=?,REPORTOR_ID=?,TYPE=?,CONTENT=?,"
            + "JOURNEY_HOUR=?,LIVE_HOUR=?"
            + ",UPDATE_BY=?,UPDATE_TIME=? WHERE ID=?";



}
