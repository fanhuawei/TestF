<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 筛选Modal -->
<div class="modal fade" data-backdrop="static" id="filterDiv" filter="true" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">关闭</button>
        <h4 class="modal-title" id="myModalLabel">数据筛选</h4>
      </div>
      <div class="modal-body">
        <dl class="form_edit">
          <dt><span class="item_title">设备序列号</span></dt>
          <dd><input type="text" class="common_input_text" id="sn"  name="filter.sn" value="${filter.sn}" /></dd>
          <dt><span class="item_title">设备名</span></dt>
          <dd><input type="text" class="common_input_text" id="name"  name="filter.name" value="${filter.name}" /></dd>
          <dt><span class="item_title">使用状态Y：使用中 N:空闲</span></dt>
          <dd><input type="text" class="common_input_text" id="useFlag"  name="filter.useFlag" value="${filter.useFlag}" /></dd>
          <dt><span class="item_title">挂失标记Y:挂失 N:未挂失</span></dt>
          <dd><input type="text" class="common_input_text" id="lostFlag"  name="filter.lostFlag" value="${filter.lostFlag}" /></dd>
            <div class="clear"></div>
        </dl>
      </div>
      <div class="modal-footer">
      <ui:Link action="search" className="common_btn btn_large common_btn_add" label="确认筛选"/>
      <ui:Link action="init" className="common_btn btn_large common_btn_normal" label="清空条件"/>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->