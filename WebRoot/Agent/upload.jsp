<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %> 
<%@ taglib prefix="mf" uri="/WEB-INF/mf.tld" %>
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
       <a href="javascript:(null);" class="close" data-dismiss="modal" aria-hidden="true">关闭</a>
        <h4 class="modal-title" id="myModalLabel">导入代理商数据</h4>
      </div>
        <div class="modal-body">
        <dl class="form_edit">
          <dt><!-- <span class="star">*</span> -->
          <span class="item_title">数据来源：</span></dt>
          <dd class="importexl">
          <jsp:include page="/common/uploadFile.jsp">
            <jsp:param value="excel" name="fileType"/>
            <jsp:param value="" name="assetId"/>
          </jsp:include>
          </dd>
          <div class="clear"></div>
        </dl>
        <c:if test="${not empty errorList }">
        <div class="check_data" id="importError">
        <div class="error_notice">上传的数据存在<span>${fn:length(errorList)}处</span>错误，请检查后重新选择上传。</div>
        <table cellspacing="0" cellpadding="0" id="check_table" class="main_tablestyle">
          <tr class="con_table_title">
            <th width="50px;">行</th>
            <th width="50px;">列</th>
            <th width="240px;">数据</th>
            <th width="400px;">错误描述</th>
          </tr>
        </table>
        <div class="table_body">
          <table cellspacing="0" cellpadding="0" id="check_table" class="main_tablestyle">
            <!--循环开始-->
            <c:forEach var="showData" items="${errorList}" varStatus="vs">
            <tr>
              <td width="50px;" class="check_hang">${showData.row }</td>
              <td width="50px;" class="check_lie">${showData.cell }</td>
              <td width="240px;" class="oiginal_data">${showData.value }</td>
              <td width="400px;">${showData.errorMessage }</td>
            </tr>
            </c:forEach>
          </table>
        </div>
        </div>
        </c:if>
        </div>
        <div class="modal-footer"> 
        <ui:Link href="javascript:onImportData();"  action="import" className="common_btn major_btn biger_btn" label="导入"/>
        <a href="#" class="common_btn biger_btn" data-dismiss="modal" >取消</a>
        </div>
    </div>
    <!-- /.modal-content --> 
  </div>