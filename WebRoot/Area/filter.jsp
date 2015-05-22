<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="mf" uri="/WEB-INF/mf.tld" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %> 
<!-- 筛选Modal -->
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <a href="javascript:(null);" class="close" data-dismiss="modal" aria-hidden="true">关闭</a>
        <h4 class="modal-title" id="myModalLabel">数据筛选</h4>
      </div>
      <div class="modal-body">
        <dl class="form_edit">
          <ui:FormField label="名称" name="filter.name" mode="filter" />
          <ui:FormField label="编码" name="filter.code" mode="filter" />
          <ui:FormField label="上级ID" name="filter.parentId" mode="filter" />
          <ui:FormField label="标记 P:省份 C:城市 D:区县" name="filter.flag" mode="filter" />
            <div class="clear"></div>
        </dl>
      </div>
        <div class="modal-footer">
        <ui:Link className="common_btn major_btn biger_btn" action="search" label="确认查询"/> 
        <a href="#" class="common_btn biger_btn" data-dismiss="modal" >取消</a> 
        </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
