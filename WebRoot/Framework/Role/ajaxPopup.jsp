<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %> 
<%@ taglib prefix="mf" uri="/WEB-INF/mf.tld" %>
<div class="modal-dialog shortcut">
    <div class="modal-content">
      <div class="modal-header"> <a href="javascript:(null);" class="close" data-dismiss="modal" aria-hidden="true">关闭</a>
        <h4 class="modal-title" id="myModalLabel">设置快捷方式</h4>
      </div>
        <div class="modal-body">
          <dl class="form_edit">            
            <dd>
              <div class="checkbox_wraper">
<c:forEach items="${shortCutList}" var="item" varStatus="st">
    <input type="checkbox" ${mf:makeCheckState(item.id,roleShortCut)} name="roleShortCut" id="sc${st.index+1}" value="${item.id}"/>
    <label for="sc${st.index+1}" class="thelabel checkbox_label">${item.name}</label>
</c:forEach>              
              </div>
            </dd>
            <div class="clear"></div>
          </dl>
        </div>
        <div class="modal-footer"> <ui:Link className="common_btn major_btn biger_btn" action="saveShortCut" label="确认提交"/> <a href="#" class="common_btn biger_btn" data-dismiss="modal" >取消</a> </div>
    </div>
    <!-- /.modal-content --> 
  </div>