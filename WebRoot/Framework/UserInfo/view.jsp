<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="mf" uri="/WEB-INF/mf.tld" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><jsp:include page="/common/header.jsp"/></head>
<body class="page_form"><ui:Form><input type="hidden" name="bean.id" value="${bean.id}" />
<jsp:include page="/common/menu.jsp"></jsp:include>
<div class="page_righter onetable">
  <div class="wraper">
    <div class="model_iTable"> 
      <!--头部开始-->
      <div class="header">
        <div class="header_left">
          <h3>个人信息</h3>
        </div>
        <div class="header_right"><ui:GrantLink action="edit" className="common_btn biger_btn major_btn" label="编辑资料"/></div>
        <div class="clear"></div>
      </div>
      <!--详情展示主体部分开始-->
      <div class="form_main">
    	
        <div class="form_section">
        	<div class="title">
            	<h4>查看个人信息</h4>
                <p>这里展示的是您的个人基本信息。</p>
            </div>
            <div class="content info_view">
            	<div class="col col_half">
                	<label class="name">姓名:</label><span class="info_value">${bean.name}</span>
                </div>
                <div class="col col_half">
                	<label class="name">登录名:</label><span class="info_value">${bean.code}</span>
                </div>
                <div class="col col_half">
                	<label class="name">联系电话:</label><span class="info_value">${bean.phone}</span>
                </div>
                <div class="col col_half">
                	<label class="name">个人邮箱:</label><span class="info_value">${bean.email}</span>
                </div>
                <div class="col col_half">
                	<label class="name">角色:</label><span class="info_value">${mf:makeNameById(bean.roleId,"ROLE")}</span>
                </div>
                <div class="col col_half">
                 <c:if test="${not empty bean.deptId}">
                	<label class="name">部门:</label><span class="info_value">${mf:makeNameById(bean.deptId,"DEPT")}</span>
                 </c:if>
                 <c:if test="${not empty bean.agentId}">
                	<label class="name">公司:</label><span class="info_value">${mf:makeNameById(bean.agentId,"AGENT")}</span>
                 </c:if>
                </div>
                
                <div class="clear"></div>
                
            </div>
        </div>
        
    </div>
    </div>
  </div>
</div>
<jsp:include page="/common/footer.jsp"></jsp:include>
</ui:Form>
</body>
</html>