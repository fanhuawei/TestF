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
        <h3>推送消息信息</h3>
         </div>
      <div class="header_right">
          <ui:Link action="cancel" label="取消并返回" className="common_btn biger_btn"></ui:Link>
       </div>
        <div class="clear"></div>
    </div>
    <div class="form_main">
    	<div class="form_section">
        	<div class="title">
            	<h4>推送消息资料</h4>
                <p>包括推送消息的基本信息及系统使用功能设定</p>
            </div>
            <div class="content">
          <ui:FormField label="标题" name="bean.title"  required="true" maxlength="600" mode="edit"/>
          <ui:FormField label="内容" name="bean.content"  required="true" maxlength="9000" mode="edit"/>
          <ui:FormField label="接受人数量" name="bean.cnt"  required="true" maxlength="11" mode="edit"/>
          <ui:FormField label="设备ID" name="bean.deviceId"  required="false" maxlength="11" mode="edit"/>
          <ui:FormField label="状态：N:未发送 F:发送失败 S：发送成功" name="bean.status"  required="false" maxlength="3" mode="edit"/>
          <ui:FormField label="用户ID" name="bean.userId"  required="false" maxlength="11" mode="edit"/>

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