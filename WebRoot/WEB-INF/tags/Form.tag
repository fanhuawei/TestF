<form id="frm" method="post" action="${menuEnum.path};jsessionid=${pageContext.request.session.id}">
  <input name="action" id="action" type="hidden" value="init"/>
  <input name="pageNo" id="pageNo" type="hidden" value="${pageNo}"/>
  <input name="pageSize" id="pageSize" type="hidden" value="${pageSize}"/>
  <input name="chk" id="chk" type="hidden" value="${chk[0]}"/>
  <input name="ajaxFlag" id="ajaxFlag" type="hidden" value=""/>
  <jsp:doBody/>
</form>
<iframe name="actionFrame" id="actionFrame" style="display:none;" />

