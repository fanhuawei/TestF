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
<body>
<ui:Form>
<jsp:include page="/common/menu.jsp"></jsp:include>
<jsp:include page="/common/leftMenu.jsp"></jsp:include>
<div class="page_righter"> 
	<div class="wraper">
  <!--标准模块-表格列表 开始-->
  <div class="model_iTable">
      <div class="header">
      <div class="header_left">
      <h3>操作日志</h3>
    </div>
      <div class="header_right">
       </div>
        <div class="clear"></div>
    </div>
    <div class="table_main">
      <table cellspacing="0" cellpadding="0" class="common_table">
      <tbody>
        <tr class="m_table_title">
          <th width="50px;">序号</th>
          <th width="100px">用户</th>
          <th width="100px">操作模块</th>          
          <th width="100px">操作动作</th>
          <th >会话ID</th>         
          <th width="150px">客户机IP</th>
          <th width="150px">操作时间</th>
          <th width="100px">结果</th>
        </tr>
        <c:forEach items="${pageBean.list}" var="item" varStatus="st">
        <tr>
          <td>${st.index+1}</td>
          <td>
          <c:if test="${empty item.userId}">未登录</c:if>
          <c:if test="${not empty item.userId}">${mf:makeNameById(item.userId,"USER")}</c:if>
          </td>
          <td>${item.module}</td>
          <td>${item.actionName}</td>
          <td>${item.sessionId}</td>
          <td>${item.clientIp}</td>
          <td><fmt:formatDate value="${item.createTime }" pattern="yyyy-MM-dd HH:mm"/></td>
          
          <td title="${item.reason}"><c:if test="${item.result=='S'}">成功</c:if>
          <c:if test="${item.result=='F'}">失败</c:if>
          </td>
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