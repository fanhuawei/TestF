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
          <ui:FormField label="代理商ID" name="filter.agentId" mode="filter" />
          <ui:FormField label="区域服务中心" name="filter.serviceCenterId" mode="filter" />
          <ui:FormField label="类型" name="filter.type" mode="filter" />
          <ui:FormField label="型号" name="filter.model" mode="filter" />
          <ui:FormField label="系列号" name="filter.serialNo" mode="filter" />
          <ui:FormField label="出厂时间" format="yyyy-MM-dd" name="filter.productTime" mode="filter" />
          <ui:FormField label="开机时间" format="yyyy-MM-dd" name="filter.openTime" mode="filter" />
          <ui:FormField label="SAP出厂时间" format="yyyy-MM-dd" name="filter.sapProductTime" mode="filter" />
          <ui:FormField label="质保期" format="yyyy-MM-dd" name="filter.warrantyTime" mode="filter" />
          <ui:FormField label="数据终端ID" name="filter.terminalId" mode="filter" />
          <ui:FormField label="客户ID" name="filter.customerId" mode="filter" />
          <ui:FormField label="最新运行状态" name="filter.runStateId" mode="filter" />
          <ui:FormField label="最近服务记录" name="filter.lastServiceId" mode="filter" />
          <ui:FormField label="经度" name="filter.longititude" mode="filter" />
          <ui:FormField label="纬度" name="filter.latitude" mode="filter" />
          <ui:FormField label="安装位置" name="filter.location" mode="filter" />
            <div class="clear"></div>
        </dl>
      </div>
        <div class="modal-footer">
        <ui:Link className="common_btn major_btn biger_btn" action="search" label="确认查询"/> 
        <a href="#" class="common_btn biger_btn" data-dismiss="modal" >取消</a> 
        </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
