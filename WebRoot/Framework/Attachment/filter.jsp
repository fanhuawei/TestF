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
          <dt><span class="item_title">文件名</span></dt>
          <dd><input type="text" class="common_input_text" id="fileName"  name="filter.fileName" value="${filter.fileName}" /</dd>
          <dt><span class="item_title">类型
</span></dt>
          <dd><input type="text" class="common_input_text" id="contentType"  name="filter.contentType" value="${filter.contentType}" /</dd>
          <dt><span class="item_title">存储路径</span></dt>
          <dd><input type="text" class="common_input_text" id="storePath"  name="filter.storePath" value="${filter.storePath}" /</dd>
          <dt><span class="item_title"> 文件大小</span></dt>
          <dd><input type="text" class="common_input_text" id="fileSize"  name="filter.fileSize" value="${filter.fileSize}" /</dd>
          <dt><span class="item_title">编码</span></dt>
          <dd><input type="text" class="common_input_text" id="code"  name="filter.code" value="${filter.code}" /</dd>
            <div class="clear"></div>
        </dl>
      </div>
      <div class="modal-footer">
      <ui:Link action="search" className="common_btn btn_large common_btn_add" label="确认筛选"/>
      <ui:Link href="Attachment.do?action=init" action="init" className="common_btn btn_large common_btn_normal" label="清空条件"/>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->