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
        <h3>部门信息</h3>
         </div>
      <div class="header_right">
          <ui:Link action="cancel" label="取消并返回" className="common_btn biger_btn"></ui:Link>
       </div>
        <div class="clear"></div>
    </div>
    <div class="form_main">
    	<div class="form_section">
        	<div class="title">
            	<h4>部门资料</h4>
                <p>包括部门的基本信息及系统使用功能设定</p>
            </div>
            <div class="content info_view">
          <ui:FormField label="编码" name="bean.code" mode="view" />
          <ui:FormField label="名称" name="bean.name" mode="view" />
          <ui:FormField label="地址" name="bean.address" mode="view" />
          <ui:FormField label="邮编" name="bean.zip" mode="view" />
          <ui:FormField label="主管ID" name="bean.leaderId" mode="view" />
          <ui:FormField label="大区" name="bean.region" mode="view" />
          <ui:FormField label="省份" name="bean.provinceId" mode="view" />
          <ui:FormField label="城市" name="bean.cityId" mode="view" />
          <ui:FormField label="区县" name="bean.countyId" mode="view" />
          <ui:FormField label="电话" name="bean.tel" mode="view" />
          <ui:FormField label="传真" name="bean.fax" mode="view" />
          <ui:FormField label="邮箱" name="bean.email" mode="view" />
          <ui:FormField label="联系人" name="bean.contact" mode="view" />
          <ui:FormField label="联系人电话" name="bean.contactPhone" mode="view" />
          <ui:FormField label="联系人邮箱" name="bean.contactEmail" mode="view" />
          <ui:FormField label="类型 T:公司IT,C:公司服务中心 S:区域服务中心" name="bean.type" mode="view" />
          <ui:FormField label="[SHORT_NAME]" name="bean.shortName" mode="view" />

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