﻿<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="mf" uri="/WEB-INF/mf.tld" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><jsp:include page="/common/header.jsp"/></head>
<body class="page_form">
<ui:Form>
<input type="hidden" name="bean.id" value="${bean.id}" />
<jsp:include page="/common/menu.jsp"/>
<div class="page_righter onetable">
  <div class="wraper">
  <!--标准模块-表格列表 开始-->
  <div class="model_iTable">
      <div class="header">
      <div class="header_left">
        <h3>工单流信息</h3>
         </div>
      <div class="header_right">
          <ui:Link action="cancel" label="取消并返回" className="common_btn biger_btn"></ui:Link>
       </div>
        <div class="clear"></div>
    </div>
    <div class="form_main">
    	<div class="form_section">
        	<div class="title">
            	<h4>工单流资料</h4>
                <p>包括工单流的基本信息及系统使用功能设定</p>
            </div>
            <div class="content">
          <ui:FormField label="工单ID" name="bean.workOrderId"  required="true" maxlength="11" mode="edit"/>
          <ui:FormField label="附件数" name="bean.assetCount"  required="true" maxlength="11" mode="edit"/>
          <ui:FormField label="报告ID" name="bean.workReportId"  required="false" maxlength="11" mode="edit"/>
          <ui:FormField label="工单操作" name="bean.workFlag"  required="true" maxlength="3" mode="edit"/>
          <ui:FormField label="操作时间" format="yyyy-MM-dd" name="bean.operateTime" required="false" mode="edit" />
          <ui:FormField label="操作人" name="bean.operatorId"  required="true" maxlength="11" mode="edit"/>
          <ui:FormField label="描述" name="bean.comments"  required="false" maxlength="300" mode="edit"/>
          <ui:FormField label="接收人" name="bean.receivedId"  required="false" maxlength="11" mode="edit"/>
          <ui:FormField label="预计到达现场时间" format="yyyy-MM-dd" name="bean.estimateArriveTime" required="false" mode="edit" />
          <ui:FormField label="预计完成时间" format="yyyy-MM-dd" name="bean.estimateFinishTime" required="false" mode="edit" />

                <div class="clear"></div>
             </div>
             <div class="form_action">
               <ui:Link action="save" label="确认提交" className="common_btn major_btn biger_btn" />
               <ui:Link action="cancel" label="取消" className="common_btn biger_btn" />
              </div>
        </div>
        <div class="clear"></div>
     </div>
  </div>
  <!--标准模块-表单展示及编辑 结束--> 
  </div>
</div>
<jsp:include page="/common/footer.jsp" />
</ui:Form>
</body>
</html>