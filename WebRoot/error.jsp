<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="mf" uri="/WEB-INF/mf.tld" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/common/header.jsp"></jsp:include></head>
<body id="sys_error">
<div class="theheader">
	<div class="inner"><a href="#"><img src="images/sys_error_logo.png" /></a></div>
</div>
<div class="themain">
	<div class="inner">
    	<div class="thecontent">
        	<p class="notice_title">Sorry！这个页面有点问题…</p>
            <p class="decrption">服务器出现异常，请稍后再试，或联系系统管理员。</p>
            <p class="error_code">错误编码：<span>${errorCode}</span></p>
            <div style="display: none;">
            ${mf:printError(sysexception)}
            </div>
            <a href="Main.do" class="backhome" title="返回系统首页">返回首页</a>
        </div>
    </div>
</div>
<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>