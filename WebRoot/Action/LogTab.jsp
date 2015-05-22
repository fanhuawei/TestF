<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %> 
<ul class="iTab">
    <li class="nor"><a href="OperateLogWeb.do" ${(currentFunction.id==9092 or currentFunction.id==9094)?"class=\"cur\"":""}>云端日志</a></li>
    <li class="nor"><a href="OperateLogMobile.do" ${(currentFunction.id==9093 or currentFunction.id==9095)?"class=\"cur\"":""}>移动端日志</a></li>
</ul>