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
          <ui:FormField label="用户ID" name="filter.userId" mode="filter" />
          <ui:FormField label="设备序列号" name="filter.deviceSn" mode="filter" />
          <ui:FormField label="客户端ID" name="filter.clientId" mode="filter" />
          <ui:FormField label="通道ID" name="filter.channelId" mode="filter" />
          <ui:FormField label="应用ID" name="filter.appId" mode="filter" />
          <ui:FormField label="设备类型 A:android I :ios" name="filter.deviceType" mode="filter" />
            <div class="clear"></div>
        </dl>
      </div>
        <div class="modal-footer">
        <ui:Link className="common_btn major_btn biger_btn" action="search" label="确认查询"/> 
        <a href="#" class="common_btn biger_btn" data-dismiss="modal" >取消</a> 
        </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
