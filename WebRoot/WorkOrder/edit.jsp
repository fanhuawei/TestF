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
        <h3>工单信息</h3>
         </div>
      <div class="header_right">
          <ui:Link action="cancel" label="取消并返回" className="common_btn biger_btn"></ui:Link>
       </div>
        <div class="clear"></div>
    </div>
    <div class="form_main">
    	<div class="form_section">
        	<div class="title">
            	<h4>工单资料</h4>
                <p>包括工单的基本信息及系统使用功能设定</p>
            </div>
            <div class="content">
          <ui:FormField label="单号" name="bean.code"  required="true" maxlength="60" mode="edit"/>
          <ui:FormField label="客服人员" name="bean.userId"  required="true" maxlength="11" mode="edit"/>
          <ui:FormField label="代理商ID" name="bean.agentId"  required="false" maxlength="11" mode="edit"/>
          <ui:FormField label="客户" name="bean.customerId"  required="false" maxlength="11" mode="edit"/>
          <ui:FormField label="区域服务中心" name="bean.serviceCenterId"  required="false" maxlength="11" mode="edit"/>
          <ui:FormField label="机器ID" name="bean.machineId"  required="true" maxlength="11" mode="edit"/>
          <ui:FormField label="服务类型" name="bean.serviceType"  required="true" maxlength="15" mode="edit"/>
          <ui:FormField label="故障描述" name="bean.comments"  required="false" maxlength="1500" mode="edit"/>
          <ui:FormField label="机器运行状态ID" name="bean.runStateId"  required="false" maxlength="11" mode="edit"/>
          <ui:FormField label="最近工单流ID" name="bean.workOrderFlowId"  required="false" maxlength="11" mode="edit"/>
          <ui:FormField label="纬度" name="bean.latitude"  required="false" maxlength="8" mode="edit"/>
          <ui:FormField label="经度" name="bean.longitude"  required="false" maxlength="8" mode="edit"/>
          <ui:FormField label="到达现场时间" format="yyyy-MM-dd" name="bean.arrivedTime" required="false" mode="edit" />
          <ui:FormField label="工单状态" name="bean.status"  required="true" maxlength="3" mode="edit"/>
          <ui:FormField label="联系人" name="bean.contact"  required="false" maxlength="150" mode="edit"/>
          <ui:FormField label="联系电话" name="bean.contactTel"  required="false" maxlength="150" mode="edit"/>
          <ui:FormField label="省份" name="bean.provinceId"  required="false" maxlength="11" mode="edit"/>
          <ui:FormField label="城市" name="bean.cityId"  required="false" maxlength="11" mode="edit"/>
          <ui:FormField label="区县" name="bean.countyId"  required="false" maxlength="11" mode="edit"/>
          <ui:FormField label="地址" name="bean.address"  required="false" maxlength="600" mode="edit"/>

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