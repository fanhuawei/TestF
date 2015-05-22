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
          <ui:FormField label="工单ID" name="filter.workOrderId" mode="filter" />
          <ui:FormField label="附件数" name="filter.assetCount" mode="filter" />
          <ui:FormField label="报告ID" name="filter.workReportId" mode="filter" />
          <ui:FormField label="工单操作" name="filter.workFlag" mode="filter" />
          <ui:FormField label="操作时间" format="yyyy-MM-dd" name="filter.operateTime" mode="filter" />
          <ui:FormField label="操作人" name="filter.operatorId" mode="filter" />
          <ui:FormField label="描述" name="filter.comments" mode="filter" />
          <ui:FormField label="接收人" name="filter.receivedId" mode="filter" />
          <ui:FormField label="预计到达现场时间" format="yyyy-MM-dd" name="filter.estimateArriveTime" mode="filter" />
          <ui:FormField label="预计完成时间" format="yyyy-MM-dd" name="filter.estimateFinishTime" mode="filter" />
            <div class="clear"></div>
        </dl>
      </div>
        <div class="modal-footer">
        <ui:Link className="common_btn major_btn biger_btn" action="search" label="确认查询"/> 
        <a href="#" class="common_btn biger_btn" data-dismiss="modal" >取消</a> 
        </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
