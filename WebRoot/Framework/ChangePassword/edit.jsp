<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><jsp:include page="/common/header.jsp"/>
</head>
<body class="page_form"><ui:Form>
<jsp:include page="/common/menu.jsp"></jsp:include>
<div class="page_righter onetable">
  <div class="wraper">
  <!--标准模块-表格列表 开始-->
  <div class="model_iTable">
      <div class="header">
      <div class="header_left">
        <h3>密码修改</h3>
         </div>
        <div class="clear"></div>
    </div>
    <div class="form_main">
    	<div class="form_section">
        	<div class="title">
            	<h4></h4>
                <p></p>
            </div>
            <div class="content">
                <div class="col col_full">
                    <label class="name" for="oldPass">原密码<span class="must">*</span></label>
                    <input type="password" maxlength="30" style="width:250px;" name="oldPass" id="oldPass" value="${oldPass}" class="common_input" placeholder="请输入原密码…" />
                </div>
                <div class="col col_full">
                    <label class="name" for="newPass">新密码<span class="must">*</span></label>
                    <input type="password" maxlength="30" style="width:250px;" name="newPass" id="newPass" value="${newPass}" class="common_input" placeholder="请输入新密码…" />
                </div>
                <div class="col col_full">
                    <label class="name" for="newPass1">确认新密码<span class="must">*</span></label>
                    <input type="password" maxlength="30" style="width:250px;" name="newPass1" id="newPass1" value="${newPass1}" class="common_input" placeholder="请输入新密码…" />
                </div>                
                <div class="clear"></div>
             </div>
             <div class="form_action">
               <ui:Link action="save" label="确认提交" className="common_btn major_btn biger_btn"></ui:Link>
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