<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><jsp:include page="/common/header.jsp"/></head>
<body class="page_form"><ui:Form>
<input type="hidden" name="bean.codeListId" value="${parentBean.id}" />
<input type="hidden" name="bean.flag" value="${empty bean.flag?'N':bean.flag}" />
<input type="hidden" name="bean.id" value="${bean.id}" />
<jsp:include page="/common/menu.jsp"></jsp:include>
<jsp:include page="/common/leftMenu.jsp"></jsp:include>
<div class="page_righter">
  <div class="wraper">
  <!--标准模块-表格列表 开始-->
  <div class="model_iTable">
      <div class="header">
      <div class="header_left">
        <h3>${parentBean.name}</h3>
         </div>
      <div class="header_right">
          <ui:Link action="cancel" label="取消并返回" className="common_btn biger_btn"></ui:Link>
       </div>
        <div class="clear"></div>
    </div>
    <div class="form_main">
    	<div class="form_section">
        	<div class="title">
            	<h4>${parentBean.name}资料</h4>
                <p>包括${parentBean.name}的基本信息及系统使用功能设定</p>
            </div>
            <div class="content">
            	<div class="col col_half">
                	<label class="name" for="code">编码<span class="must">*</span></label>
                	<input type="text" maxlength="20"  name="bean.code" id="code" class="common_input" value="${bean.code}" placeholder="请输入编码…" />
                </div>
                <div class="col col_half">
                	<label class="name" for="name">名称<span class="must">*</span></label>
                    <input type="text" maxlength="20"  name="bean.value" id="value" class="common_input" value="${bean.value}" placeholder="请输入名称…" />
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