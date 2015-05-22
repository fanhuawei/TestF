<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mf" uri="/WEB-INF/mf.tld" %>
<div class="page_header">
  <a href="Main.do" class="logo">GD</a>
  <ul class="main_nav">
     <c:forEach var="item" items="${userMenu}" begin="0" end="6"><c:if test="${not empty item.path and item.functionFlag=='N' and empty item.parentMenuId}">
       <li><a href="${item.path}" ${(item.id==currentMenu.id)?"class=\"cur\"":""}>${item.name}</a></li></c:if></c:forEach>
  </ul>
  <ul class="right_area">
  <c:if test="${mf:checkMenu(9000)}">
    <li class="system_setting submenu_hover"><a href="javascript:void(0);">系统设置</a>
      <div class="submenu">
<c:forEach items="${leftMenu}" var="item"><a href="${item.path}">${item.name}</a></c:forEach>
      </div>
    </li>
  </c:if>  
    <li class="user_setting submenu_hover"><a href="javascript:void(0);">【${userRole.name}】&nbsp;${UserInfo.name}</a>
      <div class="submenu">
<c:forEach items="${personalMenu}" var="item"><a href="${item.path}">${item.name}</a></c:forEach>
      </div>
    </li>
  </ul>
  <div class="clear"></div>
</div>