<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="mf" uri="/WEB-INF/mf.tld" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/common/header.jsp"/>
</head>
<body><ui:Form>
<jsp:include page="/common/menu.jsp"></jsp:include>
<div class="page_righter onetable"> 
	<div class="wraper">
  <!--标准模块-表格列表 开始-->
  <div class="model_iTable">
      <div class="header">
      <div class="header_left">
        <h3>工单流管理</h3>
        <ui:PopupLink action="filter" className="common_btn biger_btn btn_filter" label="筛选"/>
      </div>
      <div class="header_right">
         <div class="search_input">
            <input type="text" class="input_search" name="filter.keyword" value="${filter.keyword}" placeholder="请输入关键字…"  />
            <ui:Link action="search" className="btn_search"></ui:Link>
          </div>
          <ui:GrantLink action="add" className="common_btn major_btn biger_btn" />
       </div>
        <div class="clear"></div>
    </div>
    <div class="table_main">
      <table cellspacing="0" cellpadding="0" class="common_table">
      <tbody>
        <tr class="m_table_title">
          <th width="50px;">序号</th>
          <th width="100px">工单ID</th>
          <th width="100px">附件数</th>
          <th width="100px">报告ID</th>
          <th width="100px">工单操作</th>
          <th width="100px">操作时间</th>
          <th width="100px">操作人</th>
          <th width="100px">描述</th>
          <th width="100px">接收人</th>
          <th width="100px">预计到达现场时间</th>
          <th width="100px">预计完成时间</th>
 
          <th width="100px;">操作</th>
        </tr>
        <c:forEach items="${pageBean.list}" var="item" varStatus="st">
        <tr>
          <td>${st.index+1}</td>
          <td>${item.workOrderId}</td>
          <td>${item.assetCount}</td>
          <td>${item.workReportId}</td>
          <td>${item.workFlag}</td>
          <td><fmt:formatDate value="${item.operateTime}" pattern="yyyy-MM-dd"/></td>
          <td>${item.operatorId}</td>
          <td>${item.comments}</td>
          <td>${item.receivedId}</td>
          <td><fmt:formatDate value="${item.estimateArriveTime}" pattern="yyyy-MM-dd"/></td>
          <td><fmt:formatDate value="${item.estimateFinishTime}" pattern="yyyy-MM-dd"/></td>

          <td><ul class="action_list">
            <li><ui:GrantLink action="view" id="${item.id}"/></li>
             <li><ui:GrantLink action="edit" id="${item.id}"/></li>
             <li><ui:GrantLink action="delete" id="${item.id}"/></li>
          </ul></td>
        </tr>
        </c:forEach>
       </tbody>
      </table>
    </div>
    <jsp:include page="/common/pageable.jsp"/>
  </div>
  </div>
</div>
<jsp:include page="/common/footer.jsp"/>
</ui:Form>
</body>
</html>