<%@ attribute name="label" required="true"  rtexprvalue="true" %>
<%@ attribute name="name" required="true" rtexprvalue="true" %>
<%@ attribute name="mode" required="true" rtexprvalue="true" %>
<%@ attribute name="required" required="false" rtexprvalue="true" %>
<%@ attribute name="maxlength" required="false" rtexprvalue="true" %>
<%@ attribute name="format" required="false"  rtexprvalue="true" %>
<%@ tag pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="mf" uri="/WEB-INF/mf.tld" %>
<c:if test="${mode eq 'edit'}">
	<div class="col col_half">
		<label class="name" for="${fn:split(name,'.')[1]}">${label}<span class="must">${required eq 'true'?"*":""}</span></label>
<c:if test="${not empty format and fn:substring(format,0,1) ne '#' }">
<input type="text" name="${name}" id="${fn:split(name,'.')[1]}" class="common_input data_input"  style="width: 200px;" value="${mf:makeDisplayValue(name,format)}" onClick="WdatePicker({dateFmt:'${format}'})" readonly="readonly" placeholder="请输入${label}" />
</c:if>
<c:if test="${empty format or fn:substring(format,0,1) eq '#' }">
<c:if test="${maxlength <= 100}"><input type="text" name="${name}" id="${fn:split(name,'.')[1]}" class="common_input"  maxlength="${maxlength}" value="${mf:makeDisplayValue(name,format)}" placeholder="请输入${label}" /></c:if>
<c:if test="${empty maxlength or maxlength > 100}"><input type="text" name="${name}" id="${fn:split(name,'.')[1]}" class="common_input" value="${mf:makeDisplayValue(name,format)}" placeholder="请输入${label}" /></c:if>
</c:if>
	</div>
</c:if>
<c:if test="${mode eq 'view'}">
<div class="col col_half">
   <label class="name">${label}:</label><span class="info_value">${mf:makeDisplayValue(name,format)}</span>
</div>
</c:if>
<c:if test="${mode eq 'filter'}">
<dt><span class="item_title">${label}</span></dt>
<dd>
  <input type="text" name="${name}" value="${mf:makeDisplayValue(name,format)}" class="common_input" placeholder="请输入${label}" />
</dd>              
</c:if>