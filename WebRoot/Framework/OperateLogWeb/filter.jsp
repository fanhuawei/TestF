<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="mf" uri="/WEB-INF/mf.tld"%>
<!-- 筛选Modal -->
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header"> <a href="javascript:(null);" class="close" data-dismiss="modal" aria-hidden="true">关闭</a>
        <h4 class="modal-title" id="myModalLabel">数据筛选</h4>
      </div>
        <div class="modal-body">
          <dl class="form_edit">
            <dt><span class="item_title">用户：</span></dt>
            <dd>
              <input type="text" name="keyword" value="${keyword}" class="common_input" placeholder="请输入用户关键字…" />
            </dd>  
            <dt><span class="item_title">时间段</span></dt>
          <dd><fmt:formatDate value="${startTime}" var="startTime1" pattern="yyyy-MM-dd"/>
          <fmt:formatDate value="${endTime}" var="endTime1" pattern="yyyy-MM-dd"/>
          <dd><input style="width: 150px;" maxlength="10" name="startTime" type="text" class="common_input Wdate" value="${startTime1}" onClick="WdatePicker()" placeholder="请输入开始时间…" readonly="readonly"/>
          <input style="width: 150px;" maxlength="10" name="endTime" type="text" class="common_input Wdate" value="${endTime1}" onClick="WdatePicker()" placeholder="请输入结束时间…" readonly="readonly"/>
          </dd>      
            <div class="clear"></div>
          </dl>
        </div>
        <div class="modal-footer"><ui:Link className="common_btn major_btn biger_btn" action="search" label="确认查询"/> <a href="#" class="common_btn biger_btn" data-dismiss="modal" >取消</a> </div>
    </div>
    <!-- /.modal-content --> 
  </div>
