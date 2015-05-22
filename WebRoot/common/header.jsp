<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>GD系统</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/select2.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="upload/jquery.uploadify.min.js"></script>
<script type="text/javascript" src="js/jstree.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/icheck.min.js"></script>
<link href="upload/uploadify.css" rel="stylesheet" type="text/css" />
<link href="theme/default/css/main.css" rel="stylesheet" type="text/css" />
<link href="DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function onPopup(action, params){
	if (params){
	  $.post("${menuEnum.path}?popupFlag=Y&action=" + action,params,
		function(result) {
		  $("#ajaxPopup").html(result);
		  renderSelectAndRadio('#ajaxPopup');
		  $("#ajaxPopup").modal();
		});	
	} else {		
		$("#ajaxPopup").load("${menuEnum.path}?popupFlag=Y&action=" + action,function(){
			renderSelectAndRadio('#ajaxPopup');
			$(this).modal();				
		});
	}
}
$(document).ready(function(){
  	<c:if test="${not empty result.msg}">
	showMsg('${result.msg}');
  	</c:if> 
});
</script>
