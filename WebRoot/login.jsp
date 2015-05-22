<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/common/header.jsp"></jsp:include></head>
<body class="login_page">
<form name="frm" id="frm" action="System.do"> <input name="action" type="hidden" value="login" id="action"/>
<div class="login_header">
</div>
<div class="login_wraper">
	<div class="thelogo">
    	<img src="theme/default/images/logo2.png" />
    </div>
    <div class="login_main">
        	<p class="input_title">用户名</p>
            <input type="text" name="loginCode" id="loginCode" value="admin" class="common_input" placeholder="请输入用户名…" />
            <p class="input_title">密码</p>
            <input type="password" name="loginPass"  id="loginPass" value="666666" class="common_input" placeholder="请输入密码…" />
            <div class="checkbox_wraper">               
                <input type="checkbox" name="autoLogin" checked="checked" id="status1"  value="Y"/>
                <label for="status1" class="thelabel checkbox_label">下次自动登录</label>
                 <input type="hidden" name="autoLogin" value="N"/>
            </div>
            <a href="javascript:onLogin();" class="login_btn common_btn">登 录</a>
    </div>
</div>
<jsp:include page="/common/footer.jsp" /></form>
</body>
<script>
function onPassEnter(e){
	 e=e||event; 
     if (e.keyCode == 13){ 
    	 onAction("login","");
     }
}
function onLogin(){
	if ($("#loginCode").val()=="" || $("#loginCode").val()=="用户名") {
		showMsg("请输入用户名");
		return;
	}
	if ($("#loginPass").val()=="" || $("#loginPass").val()=="*******") {
		showMsg("请输入密码");
		return;
	}
	onAction("login","");
	
}
$(document).ready(function(){
	$("#remAutoLoginTxt").mouseover(function(){
		$(".thetips").show(0);
	});
	$("#remAutoLoginTxt").mouseleave(function(){
		$(".thetips").hide(0);
	});	
	$("#loginCode").keydown(onPassEnter);
	$("#loginPass").keydown(onPassEnter);
});
</script>
</html>