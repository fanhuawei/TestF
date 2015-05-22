<%@ page pageEncoding="UTF-8"%>
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
        <h3>机器运行状态信息</h3>
         </div>
      <div class="header_right">
          <ui:Link action="cancel" label="取消并返回" className="common_btn biger_btn"></ui:Link>
       </div>
        <div class="clear"></div>
    </div>
    <div class="form_main">
    	<div class="form_section">
        	<div class="title">
            	<h4>机器运行状态资料</h4>
                <p>包括机器运行状态的基本信息及系统使用功能设定</p>
            </div>
            <div class="content">
          <ui:FormField label="机器ID" name="bean.machineId"  required="true" maxlength="11" mode="edit"/>
          <ui:FormField label="采集设备" name="bean.boxId"  required="true" maxlength="11" mode="edit"/>
          <ui:FormField label="工单ID" name="bean.workOrderId"  required="true" maxlength="11" mode="edit"/>
          <ui:FormField label="采集时间" format="yyyy-MM-dd" name="bean.collectTime" required="true" mode="edit" />
          <ui:FormField label="数据状态 A：正常 B：警告 C：停机" name="bean.dataStatus"  required="false" maxlength="3" mode="edit"/>
          <ui:FormField label="运行状态 A：正常  C：停机" name="bean.runStatus"  required="false" maxlength="3" mode="edit"/>
          <ui:FormField label="采集内容" name="bean.content"  required="false" maxlength="9000" mode="edit"/>
          <ui:FormField label="文字内容" name="bean.wordContent"  required="false" maxlength="9000" mode="edit"/>

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