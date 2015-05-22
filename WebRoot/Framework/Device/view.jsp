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
      <h3>设备信息</h3>
    </div>
    <ui:Form>
      <dl class="form_edit">
          <dt><span class="item_title">设备序列号</span></dt>
          <dd>${bean.sn}</dd>
          <dt><span class="item_title">设备名</span></dt>
          <dd>${bean.name}</dd>
          <dt><span class="item_title">使用状态</span></dt>
          <dd>${bean.useFlag}</dd>
          <dt><span class="item_title">挂失标记</span></dt>
          <dd>${bean.lostFlag}</dd>
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