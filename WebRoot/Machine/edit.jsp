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
        <h3>机器信息</h3>
         </div>
      <div class="header_right">
          <ui:Link action="cancel" label="取消并返回" className="common_btn biger_btn"></ui:Link>
       </div>
        <div class="clear"></div>
    </div>
    <div class="form_main">
    	<div class="form_section">
        	<div class="title">
            	<h4>机器资料</h4>
                <p>包括机器的基本信息及系统使用功能设定</p>
            </div>
            <div class="content">
          <ui:FormField label="代理商ID" name="bean.agentId"  required="false" maxlength="11" mode="edit"/>
          <ui:FormField label="区域服务中心" name="bean.serviceCenterId"  required="false" maxlength="11" mode="edit"/>
          <ui:FormField label="类型" name="bean.type"  required="true" maxlength="150" mode="edit"/>
          <ui:FormField label="型号" name="bean.model"  required="true" maxlength="150" mode="edit"/>
          <ui:FormField label="系列号" name="bean.serialNo"  required="false" maxlength="150" mode="edit"/>
          <ui:FormField label="出厂时间" format="yyyy-MM-dd HH:mm" name="bean.productTime" required="false" mode="edit" />
          <ui:FormField label="开机时间" format="yyyy-MM-dd" name="bean.openTime" required="false" mode="edit" />
          <ui:FormField label="SAP出厂时间" format="yyyy-MM-dd" name="bean.sapProductTime" required="false" mode="edit" />
          <ui:FormField label="质保期" format="yyyy-MM-dd" name="bean.warrantyTime" required="false" mode="edit" />
          <ui:FormField label="数据终端ID" name="bean.terminalId"  required="false" maxlength="11" mode="edit"/>
          <ui:FormField label="客户ID" name="bean.customerId"  required="false" maxlength="11" mode="edit"/>
          <ui:FormField label="最新运行状态" name="bean.runStateId"  required="false" maxlength="11" mode="edit"/>
          <ui:FormField label="最近服务记录" name="bean.lastServiceId"  required="false" maxlength="11" mode="edit"/>
          <ui:FormField label="经度" name="bean.longititude"  required="false" maxlength="8" mode="edit"/>
          <ui:FormField label="纬度" name="bean.latitude"  required="false" maxlength="8" mode="edit"/>
          <ui:FormField label="安装位置" name="bean.location"  required="false" maxlength="300" mode="edit"/>

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