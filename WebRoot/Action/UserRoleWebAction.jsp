<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${action=='init' or action=='search'}">
   <jsp:include page="${menuEnum.module}/users.jsp"></jsp:include>
</c:if>
<c:if test="${action=='save' or action=='delete'}">
  <c:if test="${result.status ne 0}">
   <jsp:include page="${menuEnum.module}/users.jsp"></jsp:include>
　 </c:if>
  <c:if test="${result.status eq 0}">
   <c:redirect url="/RoleUser.do?action=search"/>
  </c:if>
</c:if>
