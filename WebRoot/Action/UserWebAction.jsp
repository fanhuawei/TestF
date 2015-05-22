<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${action=='init' or action=='search'}">
   <jsp:include page="${menuEnum.module}/list.jsp"></jsp:include>
</c:if>
<c:if test="${action=='add' or action=='edit'}">
  <c:if test="${result.status ne 0}">
   <jsp:include page="${menuEnum.module}/list.jsp"></jsp:include>
  </c:if>
  <c:if test="${result.status eq 0}">
   <jsp:include page="${menuEnum.module}/edit.jsp"></jsp:include>
  </c:if>
</c:if>
<c:if test="${action=='view'}">
  <c:if test="${result.status eq 0}">
   <jsp:include page="/User/view.jsp"></jsp:include>
  </c:if>
</c:if>
<c:if test="${action=='save' or action=='cancel'}">
   <c:if test="${result.status ne 0}">
   <jsp:include page="${menuEnum.module}/edit.jsp"></jsp:include>
  </c:if>
  <c:if test="${result.status eq 0}">
   <c:redirect url="${menuEnum.refreshUrl}"/>
  </c:if>
</c:if>
<c:if test="${action=='delete' or action=='updateRole'}">
  <c:if test="${result.status ne 0}">
   <jsp:include page="${menuEnum.module}/list.jsp"></jsp:include>
  </c:if>
  <c:if test="${result.status eq 0}">
   <c:redirect url="${menuEnum.refreshUrl}"/>
  </c:if>
</c:if>
<c:if test="${action=='assignRole'}">
   <jsp:include page="${menuEnum.module}/list.jsp"></jsp:include>
   <script>
   $("#role_edit").modal();
   </script>
</c:if>
<c:if test="${action=='ajaxFilter'}">
  <jsp:include page="${menuEnum.module}/filter.jsp"></jsp:include>
  <script>
  renderSelectAndRadio('#ajaxPopup');
  $("#ajaxPopup").modal();
  </script>
</c:if>
<c:if test="${action=='ajaxPopup'}">
  <jsp:include page="${menuEnum.module}/ajaxPopup.jsp"></jsp:include>
  <script>
  renderSelectAndRadio('#ajaxPopup');
  $("#ajaxPopup").modal();
  </script>
</c:if>