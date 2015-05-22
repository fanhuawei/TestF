<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page_sidemenu">
  <ul><c:forEach items="${leftMenu}" var="item">
     <li><a href="${item.path}" ${(item.id==currentMenu.id)?"class=\"cur\"":""}>${item.name}</a></li></c:forEach>
  </ul>
</div>