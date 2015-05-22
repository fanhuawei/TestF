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
          <ui:FormField label="编码" name="filter.code" mode="filter" />
          <ui:FormField label="名称" name="filter.name" mode="filter" />
          <ui:FormField label="地址" name="filter.address" mode="filter" />
          <ui:FormField label="邮编" name="filter.zip" mode="filter" />
          <ui:FormField label="主管ID" name="filter.leaderId" mode="filter" />
          <ui:FormField label="大区" name="filter.region" mode="filter" />
          <ui:FormField label="省份" name="filter.provinceId" mode="filter" />
          <ui:FormField label="城市" name="filter.cityId" mode="filter" />
          <ui:FormField label="区县" name="filter.countyId" mode="filter" />
          <ui:FormField label="电话" name="filter.tel" mode="filter" />
          <ui:FormField label="传真" name="filter.fax" mode="filter" />
          <ui:FormField label="邮箱" name="filter.email" mode="filter" />
          <ui:FormField label="联系人" name="filter.contact" mode="filter" />
          <ui:FormField label="联系人电话" name="filter.contactPhone" mode="filter" />
          <ui:FormField label="联系人邮箱" name="filter.contactEmail" mode="filter" />
          <ui:FormField label="类型 T:公司IT,C:公司服务中心 S:区域服务中心" name="filter.type" mode="filter" />
          <ui:FormField label="[SHORT_NAME]" name="filter.shortName" mode="filter" />
            <div class="clear"></div>
        </dl>
      </div>
        <div class="modal-footer">
        <ui:Link className="common_btn major_btn biger_btn" action="search" label="确认查询"/> 
        <a href="#" class="common_btn biger_btn" data-dismiss="modal" >取消</a> 
        </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
