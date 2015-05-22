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
          <ui:FormField label="单号" name="filter.code" mode="filter" />
          <ui:FormField label="客服人员" name="filter.userId" mode="filter" />
          <ui:FormField label="代理商ID" name="filter.agentId" mode="filter" />
          <ui:FormField label="客户" name="filter.customerId" mode="filter" />
          <ui:FormField label="区域服务中心" name="filter.serviceCenterId" mode="filter" />
          <ui:FormField label="机器ID" name="filter.machineId" mode="filter" />
          <ui:FormField label="服务类型" name="filter.serviceType" mode="filter" />
          <ui:FormField label="故障描述" name="filter.comments" mode="filter" />
          <ui:FormField label="机器运行状态ID" name="filter.runStateId" mode="filter" />
          <ui:FormField label="最近工单流ID" name="filter.workOrderFlowId" mode="filter" />
          <ui:FormField label="纬度" name="filter.latitude" mode="filter" />
          <ui:FormField label="经度" name="filter.longitude" mode="filter" />
          <ui:FormField label="到达现场时间" format="yyyy-MM-dd" name="filter.arrivedTime" mode="filter" />
          <ui:FormField label="工单状态" name="filter.status" mode="filter" />
          <ui:FormField label="联系人" name="filter.contact" mode="filter" />
          <ui:FormField label="联系电话" name="filter.contactTel" mode="filter" />
          <ui:FormField label="省份" name="filter.provinceId" mode="filter" />
          <ui:FormField label="城市" name="filter.cityId" mode="filter" />
          <ui:FormField label="区县" name="filter.countyId" mode="filter" />
          <ui:FormField label="地址" name="filter.address" mode="filter" />
            <div class="clear"></div>
        </dl>
      </div>
        <div class="modal-footer">
        <ui:Link className="common_btn major_btn biger_btn" action="search" label="确认查询"/> 
        <a href="#" class="common_btn biger_btn" data-dismiss="modal" >取消</a> 
        </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
