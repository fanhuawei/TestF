<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${action=='init' or action=='search'}">
   <jsp:include page="/Framework/Role/function.jsp"></jsp:include>
</c:if>
<c:if test="${action=='save'}">
   <c:if test="${result.status ne 0}">
   <jsp:include page="/Framework/Role/function.jsp"></jsp:include>
  </c:if>
  <c:if test="${result.status eq 0}">
   <c:redirect url="/Role.do?action=search"/>
  </c:if>
</c:if>
<c:if test="${action=='cancel'}">
   <c:redirect url="/Role.do?action=search"/>
</c:if>
