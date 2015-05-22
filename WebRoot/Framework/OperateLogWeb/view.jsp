<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><jsp:include page="/common/header.jsp"/></head>
<body>
<jsp:include page="/common/menu.jsp"></jsp:include>
<div class="page_inner">
  <jsp:include page="/common/leftMenu.jsp"></jsp:include>

  <div class="right_main">
    <div class="common_header border_bottom">
      <div class="actions_btn"></div>
      <h3>WEB操作日志信息</h3>
    </div>
    <ui:Form>
      <dl class="form_edit">
          <dt><span class="item_title">用户ID</span></dt>
          <dd>${bean.userId}</dd>
          <dt><span class="item_title">会话ID</span></dt>
          <dd>${bean.sessionId}</dd>
          <dt><span class="item_title">客户端IP</span></dt>
          <dd>${bean.clientIp}</dd>
          <dt><span class="item_title">登录时间</span></dt>
          <dd><fmt:formatDate value="${bean.loginTime}" pattern="yyyy-MM-dd"/>
          <dt><span class="item_title">退出时间</span></dt>
          <dd><fmt:formatDate value="${bean.logoutTime}" pattern="yyyy-MM-dd"/>
          <dt>&nbsp;</dt>
        <dd>
          <ui:Link id="${bean.id}"  className="common_btn btn_large common_btn_normal" action="edit" />
          <ui:Link action="cancel"  className="common_btn btn_large common_btn_normal" />
        </dd>
</dl>
      </ui:Form>
  </div>
  <div class="clear"></div>
</div>
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>