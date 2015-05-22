<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="mf" uri="/WEB-INF/mf.tld" %> 
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %> 
<div class="modal fade" id="role_edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">关闭</button>
        <h4 class="modal-title" id="myModalLabel">角色分配</h4>
      </div>
      <div class="modal-body">
        <dl class="form_edit">            
            <dt><span class="star"></span><span class="item_title">当前用户：</span></dt>
            <dd>${bean.name}</dd>
            <dt><span class="star"></span><span class="item_title">角色分配：</span></dt>
            <dd>
            	<div class="role_checkbox"><input type="checkbox" name="roleIdList" value="-1" checked="checked" style="display: none;">
            	<c:forEach items="${roleList}" var="item" varStatus="st">
                    <span><input type="checkbox" name="roleIdList" id="role${st.index}" value="${item.id}" ${mf:makeCheckState(item.id,roleIdList)}><label for="role${st.index}">${item.name}</label></span>
                </c:forEach>
                <div class="clear"></div>
                </div>
            </dd>            
            <div class="clear"></div>
        </dl>
      </div>
      <div class="modal-footer">
      <ui:Link action="updateRole" className="common_btn btn_large common_btn_add" label="确认"></ui:Link>
      <a href="#" class="common_btn btn_large common_btn_normal" data-dismiss="modal">取消</a>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->