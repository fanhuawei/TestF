<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="mf" uri="/WEB-INF/mf.tld" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/common/header.jsp"/>
</head>
<body><ui:Form>
<jsp:include page="/common/menu.jsp"></jsp:include>
<jsp:include page="/common/leftMenu.jsp"></jsp:include>
<div class="page_righter"> 
<jsp:include page="/Action/LogTab.jsp" />
	<div class="wraper">
  <!--标准模块-表格列表 开始-->
  <div class="model_iTable">
      <div class="header">
      <div class="header_left">
        <h3>云端操作日志</h3>
        <ui:Link action="ajaxFilter" id="${menuEnum.path}" className="common_btn biger_btn btn_filter" label="筛选"></ui:Link>
      </div>
      <div class="header_right">
          <ui:GrantLink action="clear" className="common_btn major_btn biger_btn" label="全部清空" />
       </div>
        <div class="clear"></div>
    </div>
    <div class="table_main">
      <table cellspacing="0" cellpadding="0" class="common_table">
      <tbody>
        <tr class="m_table_title">
          <th width="50px;">序号</th>
          <th width="150px">用户</th>
          <th width="150px">角色</th>
          <th>客户端IP</th>
          <th width="150px">登录时间</th>
          <th width="150px">退出时间</th>
          <th width="150px">创建时间</th>
          <th width="80px">操作</th>
        </tr>
        <c:forEach items="${pageBean.list}" var="item" varStatus="st">
        <tr>
          <td width="50px;">${st.index+1}</td>
          <td>${mf:makeNameById(item.userId,"USER")}</td>
           <td>${mf:makeNameById(item.roleId,"ROLE")}</td>
          <td>${item.clientIp}</td>
          <td><fmt:formatDate value="${item.loginTime}"  pattern="yyyy-MM-dd HH:mm"/></td>
          <td><fmt:formatDate value="${item.logoutTime}" pattern="yyyy-MM-dd HH:mm"/></td>
          <td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm"/></td>
          <td><ul class="action_list">
             <li><ui:Link action="view" id="${item.id}"/></li>
             <li><ui:GrantLink action="delete" id="${item.id}"/></li>
          </ul></td>
        </tr>
        </c:forEach>
       </tbody>
      </table>
    </div>
    <jsp:include page="/common/pageable.jsp"></jsp:include>
  </div>
  </div>
</div>
<jsp:include page="/common/footer.jsp"></jsp:include></ui:Form>
</body>
</html>