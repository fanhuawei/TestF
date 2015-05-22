<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><jsp:include page="/common/header.jsp"/></head>
<body class="page_form"><ui:Form><input type="hidden" name="bean.id" value="${bean.id}" />
<jsp:include page="/common/menu.jsp"></jsp:include>
<div class="page_righter onetable">
  <div class="wraper">
    <div class="model_iTable"> 
      <!--头部开始-->
      <div class="header">
        <div class="header_left">
          <h3>个人信息</h3>
        </div>
        <div class="header_right"></div>
        <div class="clear"></div>
      </div>
      <!--详情展示主体部分开始-->
      <div class="form_main">
    	
        <div class="form_section">
        	<div class="title">
            	<h4>编辑个人信息</h4>
                <p>如有需要，请在这里修改您的个人基本信息。</p>
            </div>
            <div class="content">
            	<div class="col col_half">
                	<label class="name">姓名<span class="must">*</span></label>
                    <input type="text" maxlength="30"  name="bean.name" class="common_input" value="${bean.name}" placeholder="请输入用户姓名…" />
                </div>
                <div class="col col_half">
                	<label class="name">登录名<span class="must">*</span><span class="tips">5~18个字符，需以字母开头</span></label>
                    <input type="text" maxlength="10"  name="bean.code" class="common_input" value="${bean.code}" placeholder="请输入用户登录名…" />
                </div>
                <div class="col col_half">
                	<label class="name">联系电话<span class="must">*</span><span class="tips">请输入个人手机号码</span></label>
                    <input type="text" maxlength="20"  name="bean.phone" class="common_input" value="${bean.phone}" placeholder="请输入联系电话…" />
                </div>
                <div class="col col_half">
                	<label class="name">个人邮箱</label>
                    <input type="text" maxlength="100"  name="bean.email" class="common_input" value="${bean.email}" placeholder="请输入电子邮箱地址…" />
                </div>
                
                <div class="clear"></div>
                
            </div>
        </div>
        <div class="form_action">
            <ui:Link action="save" className="common_btn major_btn biger_btn" label="确认提交"></ui:Link>
            <ui:Link action="cancel" className="common_btn biger_btn" label="取消"></ui:Link>
        </div>
    </div>
    </div>
  </div>
</div>
<jsp:include page="/common/footer.jsp"></jsp:include>
</ui:Form>
</body>
</html>