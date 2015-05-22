<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><jsp:include page="/common/header.jsp"/></head>
<body>
<jsp:include page="/common/menu.jsp"></jsp:include>
<ui:Form>
<div class="page_inner">
  <jsp:include page="/common/leftMenu.jsp"></jsp:include>
   <div class="right_main">
    <div class="common_header border_bottom">
      <div class="actions_btn"></div>
      <h3>用户分配权限</h3>
    </div><div>
    <dl class="form_edit">
        <dt><span class="item_title">角色名称：</span></dt>
        <dd><span>${parentBean.name}</span></dd>
        <dt><span class="star"></span><span class="item_title">已分配用户：</span></dt>
        <dd>
        	<div class="authed_projects">
        	<table cellspacing="0" cellpadding="0" class=" authed_projects_header">
              <tbody>
                <tr class="con_table_title">
                  <th width="150px;">姓名</th>
                  <th width="150px;">工号</th>
                  <th width="150px;">部门</th>
                  <th>操作</th>
                </tr>
              </tbody>
            </table>
            <div class="authed_projects_body">
            <table cellspacing="0" cellpadding="0" class="main_tablestyle ">
              <tbody><c:forEach items="${roleUsers}" var="item">
                <tr>
                  <td width="150px;">${item.name}</td>
                  <td width="150px;">${item.code}</td>
                  <td width="150px;">${item.dept}</td>
                  <td>
                  <ui:Link action="delete" label="取消授权" id="${item.id}" />
                  </td>
                </tr></c:forEach>
              </tbody>
    		</table>
            </div>
        	</div>
        </dd>
        
        <dt>&nbsp;</dt>
        <dd>
        <a href="#" class="common_btn btn_large common_btn_add" title=""  data-toggle="modal" data-target="#add_authproject">关联新用户</a>
        </dd>
      </dl>
  <div class="clear"></div>
</div></div>
  <div class="clear"></div>
</div>
<jsp:include page="/common/footer.jsp"></jsp:include>
<div class="modal fade" id="add_authproject" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">关闭</button>
        <h4 class="modal-title" id="myModalLabel">关联新用户</h4>
      </div>
      <div class="modal-body">
        <div class="authed_projects">
        	<table cellspacing="0" cellpadding="0" class=" authed_projects_header">
              <tbody>
                <tr class="con_table_title">
                  <th width="30px;"></th>
                  <th width="150px;">姓名</th>
                  <th width="150px;">工号</th>
                  <th>部门</th>
                </tr>
              </tbody>
            </table>
            <div class="authed_projects_body">
            <table cellspacing="0" cellpadding="0" class="main_tablestyle ">
              <tbody><c:forEach items="${users}" var="item" varStatus="st">
                <tr>
                	<td width="30px;"><input type="checkbox"  name="userId" id="user_${st.index+1}" onclick="check_selectditem();" value="${item.id}"></td>
                  <td width="150px;"><label for="user_${st.index+1}" onclick="check_selectditem();">${item.name}</label></td>
                  <td width="150px;">${item.code}</td>
                  <td>${item.dept}</td>
                </tr></c:forEach>
                
              </tbody>
    		</table>
            </div>
        	</div>
      </div>
      <div class="modal-footer">
      <ui:Link action="save" label="确认添加" className="common_btn btn_large common_btn_add"></ui:Link>
      <a href="#" class="common_btn btn_large common_btn_normal" data-dismiss="modal">取消</a>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script>
function check_selectditem(){
	$('input:checkbox[name="user_list"]').parent().parent().css("background-color","transparent");
	$('input:checkbox[name="user_list"]:checked').parent().parent().css("background-color","#fffbb5");
}
$(document).ready(function(){
	  $("tr[class!='con_table_title']:even").addClass("background_color_even");
		$("tr[class!='con_table_title']:odd").addClass("background_color_odd");
		$("tr[class!='con_table_title']").mouseover(function(){
			$(this).addClass("background_color_hover");
		});
		$("tr[class!='con_table_title']").mouseleave(function(){
			$(this).removeClass("background_color_hover");
		});
});

</script>
</ui:Form>
</body>
</html>