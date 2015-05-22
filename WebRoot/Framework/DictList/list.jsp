<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %> 
<%@ taglib prefix="mf" uri="/WEB-INF/mf.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><jsp:include page="/common/header.jsp"/></head>
<body>
<ui:Form>
<jsp:include page="/common/menu.jsp"></jsp:include>
<jsp:include page="/common/leftMenu.jsp"></jsp:include>
<div class="page_righter"> 
	<div class="wraper">
  <!--标准模块-表格列表 开始-->
  <div class="model_iTable">
      <div class="header">
      <div class="header_left">
      <h3>${parentBean.name}</h3>
    </div>
      <div class="header_right">
          <ui:GrantLink action="add" className="common_btn major_btn biger_btn" />
          <ui:Link action="saveAll" label="全部保存" className="common_btn major_btn biger_btn" />
          <ui:Link action="cancel" href="Dict.do" label="返回" className="common_btn biger_btn"></ui:Link>
       </div>
        <div class="clear"></div>
    </div>
    <div class="table_main">
      <table cellspacing="0" cellpadding="0" class="common_table">
      <tbody>
        <tr class="m_table_title">
          <th width="50px;">序号</th>
          <th width="250px;">编码</th>
          <th >名称</th>
          <th width="100px;">系统配置</th>
          <th width="100px;">操作</th>
        </tr>
        <c:forEach items="${pageBean.list}" var="item" varStatus="st">
        <tr>
          <td>${st.index+1}</td>
          <td>${item.code}</td>
          <td><input class="common_input" name="list[${st.index}].value" value="${item.value}"></input></td>
          <td>${mf:makeValueByCode(item.flag,"YES_NO")}</td>
          <td>           
           <ul class="action_list">
             <c:if test="${item.flag=='N'}">
             <li><ui:GrantLink action="edit" id="${item.id}"/></li>
             <li><ui:GrantLink action="delete" id="${item.id}"/></li>
             </c:if>
             <c:if test="${not st.first}">
              <li><ui:GrantLink href="DictList.do?action=sortUp&idx=${st.index}" action="sortUp" label="上移"/></li>
              </c:if>
              <c:if test="${not st.last}">
              <li><ui:GrantLink href="DictList.do?action=sortDown&idx=${st.index}" action="sortDown" label="下移"/></li>
              </c:if>             
           </ul>            
          </td>
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