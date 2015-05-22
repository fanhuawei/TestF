<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><jsp:include page="/common/header.jsp"/></head>
<body class="page_form"><ui:Form><input type="hidden" name="bean.id" value="${bean.id}" />
<jsp:include page="/common/menu.jsp"></jsp:include>
<jsp:include page="/common/leftMenu.jsp"></jsp:include>
<div class="page_righter">
  <div class="wraper">
  <!--标准模块-表格列表 开始-->
  <div class="model_iTable">
      <div class="header">
      <div class="header_left">
        <h3>WEB操作日志信息</h3>
         </div>
      <div class="header_right">
          <ui:Link action="cancel" label="取消并返回" className="common_btn biger_btn"></ui:Link>
       </div>
        <div class="clear"></div>
    </div>
    <div class="form_main">
    	<div class="form_section">
        	<div class="title">
            	<h4>WEB操作日志资料</h4>
                <p>包括WEB操作日志的基本信息及系统使用功能设定</p>
            </div>
            <div class="content">
                <div class="col col_half">
                    <label class="name" for="userId">用户ID<span class="must"></span></label>
                    <input type="text"  name="bean.userId" id="userId" class="common_input" value="${bean.userId}" placeholder="请输入用户ID…" />
                </div>
                <div class="col col_half">
                    <label class="name" for="sessionId">会话ID<span class="must"></span></label>
                    <input type="text"  name="bean.sessionId" id="sessionId" class="common_input" value="${bean.sessionId}" placeholder="请输入会话ID…" />
                </div>
                <div class="col col_half">
                    <label class="name" for="clientIp">客户端IP<span class="must"></span></label>
                    <input type="text"  name="bean.clientIp" id="clientIp" class="common_input" value="${bean.clientIp}" placeholder="请输入客户端IP…" />
                </div>
                <div class="col col_half">
                    <label class="name" for="loginTime">登录时间<span class="must"></span></label>
                    <fmt:formatDate value="${bean.loginTime}"  pattern="yyyy-MM-dd" var="loginTime"/>
                    <input type="text"  name="bean.loginTime" id="loginTime" style="width: 150px;" class="common_input Wdate" value="${loginTime}" placeholder="请输入登录时间…"  onClick="WdatePicker()" readonly="readonly"/>
                </div>
                <div class="col col_half">
                    <label class="name" for="logoutTime">退出时间<span class="must"></span></label>
                    <fmt:formatDate value="${bean.logoutTime}"  pattern="yyyy-MM-dd" var="logoutTime"/>
                    <input type="text"  name="bean.logoutTime" id="logoutTime" style="width: 150px;" class="common_input Wdate" value="${logoutTime}" placeholder="请输入退出时间…"  onClick="WdatePicker()" readonly="readonly"/>
                </div>

                <div class="clear"></div>
             </div>
             <div class="form_action">
               <ui:Link action="save" label="确认提交" className="common_btn major_btn biger_btn"></ui:Link>
               <ui:Link action="cancel" label="取消" className="common_btn biger_btn"></ui:Link>
              </div>
        </div>
        <div class="clear"></div>
     </div>
  </div>
  <!--标准模块-表单展示及编辑 结束--> 
  </div>
</div>
<jsp:include page="/common/footer.jsp"></jsp:include>
</ui:Form>
</body>
</html>