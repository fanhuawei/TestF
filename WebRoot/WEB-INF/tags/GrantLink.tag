<%@ attribute name="action" required="true"  rtexprvalue="true" %><%@ attribute name="className" required="false" rtexprvalue="true" %><%@ attribute name="label" required="false" rtexprvalue="true" %><%@ attribute name="href" required="false" rtexprvalue="true" %><%@ attribute name="title" required="false" rtexprvalue="true" %><%@ attribute name="id" required="false" rtexprvalue="true" %><%@ attribute name="name" required="false" rtexprvalue="true" %> <%@ attribute name="target" required="false" rtexprvalue="true" %><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="mf" uri="/WEB-INF/mf.tld" %>
<c:if test="${empty label}"><c:set var="label" value="${mf:makeActionName(action)}"></c:set></c:if>
${mf:saveButton(currentFunction.id,action, (empty title)?label:title, "Y")}
<c:if test="${mf:checkButton(action)}" >
<c:if test="${empty href}"><a id="lnk_${action}" href="javascript:onAction('${action}','${id}');" title="${title}" class="${className}">${label}</a></c:if>
<c:if test="${not empty href}"><a id="lnk_${action}" href="${href}" class="${className}" title="${title}">${label}</a></c:if>
</c:if>