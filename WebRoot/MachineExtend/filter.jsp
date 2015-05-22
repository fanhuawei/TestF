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
          <ui:FormField label="一级空气端型号" name="filter.aclassAirTerminalModel" mode="filter" />
          <ui:FormField label="一级空气端系列号" name="filter.aclassAirTerminalSn" mode="filter" />
          <ui:FormField label="二级空气端型号" name="filter.classAirTerminalModel" mode="filter" />
          <ui:FormField label="二级空气端系列号" name="filter.bclassAirTerminalSn" mode="filter" />
          <ui:FormField label="电脑板型号" name="filter.controlBoardModel" mode="filter" />
          <ui:FormField label="电脑板系列号" name="filter.controlBoardSn" mode="filter" />
          <ui:FormField label="主电机型号" name="filter.mainMotorModel" mode="filter" />
          <ui:FormField label="主电机系列号" name="filter.mainMotorSn" mode="filter" />
          <ui:FormField label="油冷却器型号" name="filter.oilCoolerModel" mode="filter" />
          <ui:FormField label="油冷却器系列号" name="filter.oilCoolerSn" mode="filter" />
          <ui:FormField label="中级冷却器型号" name="filter.middleCoolerModel" mode="filter" />
          <ui:FormField label="中级冷却器系列号" name="filter.middleCoolerSn" mode="filter" />
          <ui:FormField label="后冷却器型号" name="filter.afterCoolerModel" mode="filter" />
          <ui:FormField label="后冷却器系列号" name="filter.afterCoolerSn" mode="filter" />
            <div class="clear"></div>
        </dl>
      </div>
        <div class="modal-footer">
        <ui:Link className="common_btn major_btn biger_btn" action="search" label="确认查询"/> 
        <a href="#" class="common_btn biger_btn" data-dismiss="modal" >取消</a> 
        </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
