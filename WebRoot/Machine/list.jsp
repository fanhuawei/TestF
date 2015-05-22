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
        <h3>机器管理</h3>
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
          <th width="100px">代理商ID</th>
          <th width="100px">区域服务中心</th>
          <th width="100px">类型</th>
          <th width="100px">型号</th>
          <th width="100px">系列号</th>
          <th width="100px">出厂时间</th>
          <th width="100px">开机时间</th>
          <th width="100px">SAP出厂时间</th>
          <th width="100px">质保期</th>
          <th width="100px">数据终端ID</th>
          <th width="100px">客户ID</th>
          <th width="100px">最新运行状态</th>
          <th width="100px">最近服务记录</th>
          <th width="100px">经度</th>
          <th width="100px">纬度</th>
          <th width="100px">安装位置</th>
 
          <th width="100px;">操作</th>
        </tr>
        <c:forEach items="${pageBean.list}" var="item" varStatus="st">
        <tr>
          <td>${st.index+1}</td>
          <td>${item.agentId}</td>
          <td>${item.serviceCenterId}</td>
          <td>${item.type}</td>
          <td>${item.model}</td>
          <td>${item.serialNo}</td>
          <td><fmt:formatDate value="${item.productTime}" pattern="yyyy-MM-dd"/></td>
          <td><fmt:formatDate value="${item.openTime}" pattern="yyyy-MM-dd"/></td>
          <td><fmt:formatDate value="${item.sapProductTime}" pattern="yyyy-MM-dd"/></td>
          <td><fmt:formatDate value="${item.warrantyTime}" pattern="yyyy-MM-dd"/></td>
          <td>${item.terminalId}</td>
          <td>${item.customerId}</td>
          <td>${item.runStateId}</td>
          <td>${item.lastServiceId}</td>
          <td><fmt:formatNumber value="${item.longititude}" pattern="#,###.#"/></td>
          <td><fmt:formatNumber value="${item.latitude}" pattern="#,###.#"/></td>
          <td>${item.location}</td>

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