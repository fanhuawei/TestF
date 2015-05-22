<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${action=='test'}">
  <jsp:include page="/Action/index.jsp"></jsp:include>
</c:if>
<c:if test="${action ne 'test'}">
<c:if test="${empty UserInfo}">
  <jsp:include page="/login.jsp"></jsp:include>
</c:if>
<c:if test="${not empty UserInfo}">
  <c:redirect url="/Main.do" />
</c:if>
</c:if>