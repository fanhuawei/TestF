<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="mf" uri="/WEB-INF/mf.tld" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><jsp:include page="/common/header.jsp"/></head>
<body class="page_form"><ui:Form><input type="hidden" name="bean.id" value="${bean.id}" />
<jsp:include page="/common/menu.jsp"></jsp:include>
<div class="page_righter onetable">
  <div class="wraper">
  <!--标准模块-表格列表 开始-->
  <div class="model_iTable">
      <div class="header">
      <div class="header_left">
        <h3>个人信息</h3>
         </div>
      <div class="header_right">
        
       </div>
        <div class="clear"></div>
    </div>
    <div class="tableview_section" style="width:60%;margin:auto;">
      <table cellspacing="0" cellpadding="0" >
        <tr>
          <td class="t_name">姓名</td>
          <td>${bean.name}</td>
        </tr>
        <tr>
          <td colspan="2"></td>
        </tr>
        <tr>
          <td class="t_name">登录名</td>
          <td>${bean.code}</td>
         </tr>
                 <tr>
          <td colspan="2"></td>
        </tr>
        <tr>
          <td class="t_name">电话</td>
          <td>${bean.phone}</td>
        </tr>
                <tr>
          <td colspan="2"></td>
        </tr>
        <tr>
          <td class="t_name">邮箱</td>
          <td>${bean.email}</td>
        </tr>
                <tr>
          <td colspan="2"></td>
        </tr>
        <tr>
          <td class="t_name">角色</td>
          <td>${mf:makeNameById(bean.roleId,"ROLE")}</td>
        </tr>
                        <tr>
          <td colspan="2"></td>
        </tr>
        <tr>
          <td class="t_name">部门</td>
          <td>${mf:makeNameById(bean.deptId,"DEPT")}</td>
        </tr>
      </table>
    </div>
  </div>
  <!--标准模块-表单展示及编辑 结束--> 
  </div>
</div>
<jsp:include page="/common/footer.jsp"></jsp:include>
</ui:Form>
</body>
</html>