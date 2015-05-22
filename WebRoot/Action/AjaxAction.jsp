<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
<c:if test="${not empty result.msg}">
parent.showMsg("${result.msg}");
</c:if>
<c:if test="${empty result.msg}">
<c:if test="${result.status eq 0}">
parent.location.reload();
</c:if>
<c:if test="${result.status ne 0}">
  parent.showMsg("${result.msg}");
</c:if>
</c:if>
</script>