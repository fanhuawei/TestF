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
        <h3>客户管理</h3>
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
          <th width="100px">老系统ID</th>
          <th width="100px">简称</th>
          <th width="100px">名称</th>
          <th width="100px">行业</th>
          <th width="100px">区域</th>
          <th width="100px">省份</th>
          <th width="100px">城市</th>
          <th width="100px">区县</th>
          <th width="100px">地址</th>
          <th width="100px">邮编</th>
          <th width="100px">电话</th>
          <th width="100px">邮箱</th>
          <th width="100px">传真</th>
          <th width="100px">联系人1</th>
          <th width="100px">联系人1电话</th>
          <th width="100px">联系人1邮箱</th>
          <th width="100px">联系人2</th>
          <th width="100px">联系人2电话</th>
          <th width="100px">联系人2邮箱</th>
          <th width="100px">[TITLE1]</th>
          <th width="100px">[TITLE2]</th>
 
          <th width="100px;">操作</th>
        </tr>
        <c:forEach items="${pageBean.list}" var="item" varStatus="st">
        <tr>
          <td>${st.index+1}</td>
          <td>${item.oldId}</td>
          <td>${item.shortName}</td>
          <td>${item.name}</td>
          <td>${item.profession}</td>
          <td>${item.region}</td>
          <td>${item.provinceId}</td>
          <td>${item.cityId}</td>
          <td>${item.countyId}</td>
          <td>${item.address}</td>
          <td>${item.zip}</td>
          <td>${item.tel}</td>
          <td>${item.email}</td>
          <td>${item.fax}</td>
          <td>${item.contact1}</td>
          <td>${item.mobile1}</td>
          <td>${item.email1}</td>
          <td>${item.contact2}</td>
          <td>${item.mobile2}</td>
          <td>${item.email2}</td>
          <td>${item.title1}</td>
          <td>${item.title2}</td>

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