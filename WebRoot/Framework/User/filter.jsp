<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %> 
<%@ taglib prefix="mf" uri="/WEB-INF/mf.tld" %>
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header"> <a href="javascript:(null);" class="close" data-dismiss="modal" aria-hidden="true">关闭</a>
        <h4 class="modal-title" id="myModalLabel">数据筛选</h4>
      </div>
        <div class="modal-body">
          <dl class="form_edit">
            <dt><span class="item_title">关键字：</span></dt>
            <dd>
              <input type="text" name="filter.keyword" value="${filter.keyword}" class="common_input" placeholder="请输入关键字…" />
            </dd>
            <dt><span class="item_title">角色：</span></dt>
            <dd>
              <select name="filter.roleId" class="select_item" >
              　　　　　　　<option value="">所有角色</option>
                   <c:forEach items="${roleList}" var="item">
                       <ui:Option curValue="${filter.roleId}" label="${item.name}" value="${item.id}"/>
                   </c:forEach>
              </select>
            </dd>           
            <div class="clear"></div>
          </dl>
        </div>
        <div class="modal-footer"><ui:Link className="common_btn major_btn biger_btn" action="search" label="确认查询"/> <a href="#" class="common_btn biger_btn" data-dismiss="modal" >取消</a> </div>
    </div>
    <!-- /.modal-content --> 
  </div>