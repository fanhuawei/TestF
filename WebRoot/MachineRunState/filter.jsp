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
          <ui:FormField label="机器ID" name="filter.machineId" mode="filter" />
          <ui:FormField label="采集设备" name="filter.boxId" mode="filter" />
          <ui:FormField label="工单ID" name="filter.workOrderId" mode="filter" />
          <ui:FormField label="采集时间" format="yyyy-MM-dd" name="filter.collectTime" mode="filter" />
          <ui:FormField label="数据状态 A：正常 B：警告 C：停机" name="filter.dataStatus" mode="filter" />
          <ui:FormField label="运行状态 A：正常  C：停机" name="filter.runStatus" mode="filter" />
          <ui:FormField label="采集内容" name="filter.content" mode="filter" />
          <ui:FormField label="文字内容" name="filter.wordContent" mode="filter" />
            <div class="clear"></div>
        </dl>
      </div>
        <div class="modal-footer">
        <ui:Link className="common_btn major_btn biger_btn" action="search" label="确认查询"/> 
        <a href="#" class="common_btn biger_btn" data-dismiss="modal" >取消</a> 
        </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
