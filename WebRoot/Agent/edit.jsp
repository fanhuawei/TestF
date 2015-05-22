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
        <h3>代理商信息</h3>
         </div>
      <div class="header_right">
          <ui:Link action="cancel" label="取消并返回" className="common_btn biger_btn"></ui:Link>
       </div>
        <div class="clear"></div>
    </div>
    <div class="form_main">
    	<div class="form_section">
        	<div class="title">
            	<h4>代理商资料</h4>
                <p>包括代理商的基本信息及系统使用功能设定</p>
            </div>
            <div class="content">
          <ui:FormField label="老系统ID" name="bean.oldId"  required="false" maxlength="11" mode="edit"/>
          <ui:FormField label="简称" name="bean.shortName"  required="false" maxlength="60" mode="edit"/>
          <ui:FormField label="名称" name="bean.name"  required="true" maxlength="300" mode="edit"/>
          <ui:FormField label="简称拼音" name="bean.pingYing"  required="false" maxlength="30" mode="edit"/>
          <ui:FormField label="等级" name="bean.grade"  required="false" maxlength="15" mode="edit"/>
          <ui:FormField label="行业" name="bean.profession"  required="false" maxlength="300" mode="edit"/>
          <ui:FormField label="区域" name="bean.region"  required="false" maxlength="30" mode="edit"/>
          <ui:FormField label="省份" name="bean.provinceId"  required="false" maxlength="11" mode="edit"/>
          <ui:FormField label="责任销售" name="bean.saleManager"  required="false" maxlength="30" mode="edit"/>
          <ui:FormField label="地址" name="bean.address"  required="false" maxlength="600" mode="edit"/>
          <ui:FormField label="邮编" name="bean.zip"  required="false" maxlength="18" mode="edit"/>
          <ui:FormField label="电话" name="bean.tel"  required="false" maxlength="150" mode="edit"/>
          <ui:FormField label="邮箱" name="bean.email"  required="false" maxlength="300" mode="edit"/>
          <ui:FormField label="传真" name="bean.fax"  required="false" maxlength="150" mode="edit"/>
          <ui:FormField label="联系人1" name="bean.contact1"  required="false" maxlength="150" mode="edit"/>
          <ui:FormField label="联系人1电话" name="bean.mobile1"  required="false" maxlength="150" mode="edit"/>
          <ui:FormField label="联系人2" name="bean.contact2"  required="false" maxlength="150" mode="edit"/>
          <ui:FormField label="联系人2电话" name="bean.mobile2"  required="false" maxlength="150" mode="edit"/>
          <ui:FormField label="售后联系人" name="bean.customerService"  required="false" maxlength="300" mode="edit"/>
          <ui:FormField label="售后联系人电话" name="bean.customerServiceMobile"  required="false" maxlength="300" mode="edit"/>
          <ui:FormField label="售后联系邮箱" name="bean.customerServiceEmail"  required="false" maxlength="300" mode="edit"/>
          <ui:FormField label="主管ID" name="bean.leaderId"  required="false" maxlength="11" mode="edit"/>

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