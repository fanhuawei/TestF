<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><jsp:include page="/common/header.jsp"/>
<script>
  function onAssignShortCut(id){
	  $("#chk").val(id);
	  $("#ajaxPopup").load("Role.do?action=ajaxPopup&chk=" + id);	  
  }
</script>
</head>
<body>
<ui:Form>
<jsp:include page="/common/menu.jsp"></jsp:include>
<jsp:include page="/common/leftMenu.jsp"></jsp:include>
<div class="page_righter"> 
	<div class="wraper">
  <!--标准模块-表格列表 开始-->
  <div class="model_iTable">
    <div class="header">
      <div class="header_left"><h3>角色管理</h3></div>
      <div class="header_right">
          <ui:GrantLink action="add" className="common_btn major_btn biger_btn" />
       </div>
       <div class="clear"></div>
    </div>
    <div class="table_main">
      <table cellspacing="0" cellpadding="0" class="common_table">
      <tbody>
        <tr class="m_table_title">
          <th width="50px;">序号</th>
          <th width="250px;">角色编码</th>
          <th >角色名称</th>
          <th width="250px;">角色类型</th>
          <th width="100px">操作</th>
        </tr>
        <c:forEach items="${pageBean.list}" var="item" varStatus="st">
        <tr>
          <td>${st.index+1}</td>
          <td>${item.code}</td>
          <td>${item.name}</td>
          <td>
          <c:if test="${item.flag=='Y'}">系统角色</c:if>
          <c:if test="${item.flag=='N'}">业务角色</c:if>
          </td>
          <td><ul class="action_list">
          <c:if test="${item.id>=10000}">
          <li><ui:GrantLink action="edit" id="${item.id}"/></li>
          </c:if>          
          <li><ui:GrantLink action="assignRight" label="分配权限" href="RoleMenu.do?pid=${item.id}" /></li>  
          <li><ui:GrantLink action="assignShortCut" label="分配快捷方式" href="javascript:onAssignShortCut(${item.id});" /></li>         
          <c:if test="${item.id>=10000}">
          <li><ui:GrantLink action="delete" id="${item.id}"/>  </li>   
          </c:if>
          </ul></td>
        </tr>
        </c:forEach>
       </tbody>
      </table>
    </div>
    <jsp:include page="/common/pageable.jsp"></jsp:include>
  </div>
  </div>
</div>
<jsp:include page="/common/footer.jsp"></jsp:include></ui:Form>
</body>
</html>
