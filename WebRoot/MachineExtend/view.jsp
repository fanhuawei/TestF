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
        <h3>机器扩展属性信息</h3>
         </div>
      <div class="header_right">
          <ui:Link action="cancel" label="取消并返回" className="common_btn biger_btn"></ui:Link>
       </div>
        <div class="clear"></div>
    </div>
    <div class="form_main">
    	<div class="form_section">
        	<div class="title">
            	<h4>机器扩展属性资料</h4>
                <p>包括机器扩展属性的基本信息及系统使用功能设定</p>
            </div>
            <div class="content info_view">
          <ui:FormField label="机器ID" name="bean.machineId" mode="view" />
          <ui:FormField label="一级空气端型号" name="bean.aclassAirTerminalModel" mode="view" />
          <ui:FormField label="一级空气端系列号" name="bean.aclassAirTerminalSn" mode="view" />
          <ui:FormField label="二级空气端型号" name="bean.classAirTerminalModel" mode="view" />
          <ui:FormField label="二级空气端系列号" name="bean.bclassAirTerminalSn" mode="view" />
          <ui:FormField label="电脑板型号" name="bean.controlBoardModel" mode="view" />
          <ui:FormField label="电脑板系列号" name="bean.controlBoardSn" mode="view" />
          <ui:FormField label="主电机型号" name="bean.mainMotorModel" mode="view" />
          <ui:FormField label="主电机系列号" name="bean.mainMotorSn" mode="view" />
          <ui:FormField label="油冷却器型号" name="bean.oilCoolerModel" mode="view" />
          <ui:FormField label="油冷却器系列号" name="bean.oilCoolerSn" mode="view" />
          <ui:FormField label="中级冷却器型号" name="bean.middleCoolerModel" mode="view" />
          <ui:FormField label="中级冷却器系列号" name="bean.middleCoolerSn" mode="view" />
          <ui:FormField label="后冷却器型号" name="bean.afterCoolerModel" mode="view" />
          <ui:FormField label="后冷却器系列号" name="bean.afterCoolerSn" mode="view" />

                <div class="clear"></div>
             </div>
             <div class="form_action">
               <ui:Link action="edit" label="编辑" className="common_btn major_btn biger_btn" />
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