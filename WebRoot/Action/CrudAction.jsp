<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${action=='init' or action=='search'}">
   <jsp:include page="${menuEnum.module}/list.jsp"></jsp:include>
</c:if>
<c:if test="${action=='add' or action=='edit'}">
  <c:if test="${result.status eq 0}">
   <jsp:include page="${menuEnum.module}/edit.jsp"></jsp:include>
  </c:if>
  <c:if test="${result.status ne 0}">
   <jsp:include page="${menuEnum.module}/list.jsp"></jsp:include>
  </c:if>

</c:if>
<c:if test="${action=='view'}">
  <c:if test="${result.status eq 0}">
   <jsp:include page="${menuEnum.module}/view.jsp"></jsp:include>
  </c:if>
  <c:if test="${result.status ne 0}">
   <jsp:include page="${menuEnum.module}/list.jsp"></jsp:include>
  </c:if>

</c:if>
<c:if test="${action=='save'}">
  <c:if test="${result.status eq 0}">
   <c:redirect url="${menuEnum.refreshUrl}"/>
  </c:if>
   <c:if test="${result.status ne 0}">
   <jsp:include page="${menuEnum.module}/edit.jsp"></jsp:include>
  </c:if>

</c:if>
<c:if test="${action=='cancelLost' or action=='markLost' or action=='cancel' || action=='delete' || action=='clear' || action=='back' || action=='close'}">
  <c:if test="${result.status eq 0}">
   <c:redirect url="${menuEnum.refreshUrl}"/>
  </c:if>
    <c:if test="${result.status ne 0}">
   <jsp:include page="${menuEnum.module}/list.jsp"></jsp:include>
  </c:if>
</c:if>

<c:if test="${action=='ajaxSelect'}">
  <jsp:include page="${menuEnum.module}/ajaxSelect.jsp"></jsp:include>
</c:if>
<c:if test="${action=='ajaxDiv'}">
  <jsp:include page="${menuEnum.module}/ajaxDiv.jsp"></jsp:include>
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

<c:if test="${action=='importData'}">
  <c:if test="${fn:length(errorList)>0}">
   <jsp:include page="${menuEnum.module}/list.jsp"></jsp:include>
   	<script>
		$("#import_file").modal();
	</script>
  </c:if>
  <c:if test="${fn:length(errorList)==0}">
   <c:redirect url="${menuEnum.refreshUrl}"/>
  </c:if>
</c:if>

<c:if test="${action=='saveLeader'}">
  <c:if test="${result.status eq 0}">
   <c:redirect url="${menuEnum.refreshUrl}"/>
  </c:if>
  <c:if test="${result.status ne 0}">
   <jsp:include page="${menuEnum.module}/list.jsp"></jsp:include>
   <script>
		$("#ajaxPopup").load("${menuEnum.filePath}/ajaxPopup.jsp");
		$("#ajaxPopup").modal();
	</script>
  </c:if>
</c:if>
