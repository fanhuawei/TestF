<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><jsp:include page="/common/header.jsp"/>
<script>
function onSave(){
	var nodes=$("#jstree01").jstree("get_selected"); //使用get_checked方法 
    $("#menuIds").val(nodes);
	onAction("save");
}
$(document).ready(function(){	
    $('#jstree01').jstree({
    	"checkbox" : { "keep_selected_style" : true},
		"plugins" : [ "checkbox" ]
  	});	    
	$('#jstree01').on('open_node.jstree', function (e, data) {
			$(".jstree-closed").each(function(){
				$(this).find("a:eq(0) .jstree-themeicon").css("background-position","-260px -69px");
			});
	  }).on('close_node.jstree', function (e, data) {
			$(".jstree-closed").each(function(){
				$(this).find("a:eq(0) .jstree-themeicon").css("background-position","-260px -69px")
			});
	  })
	  .bind("loaded.jstree", function (e, data) { 
            data.inst.open_all(-1);
    });
	<c:forEach items="${roleButtonId}" var="i">	
	$('#jstree01').jstree(true).select_node('b${i}');
	</c:forEach>
	$('#jstree01').jstree(true).select_node('m9540');
});
</script>
</head>
<body>
<ui:Form><input type="hidden" id="menuIds" name="menuIds" />
<jsp:include page="/common/menu.jsp" />
<jsp:include page="/common/leftMenu.jsp" />
<div class="page_righter">
  <div class="wraper">
  <!--标准模块-表格列表 开始-->
  <div class="model_iTable">
      <div class="header">
      <div class="header_left">
        <h3>配置角色权限</h3>
         </div>
      <div class="header_right">
          <ui:Link action="cancel" label="取消并返回" className="common_btn biger_btn"></ui:Link>
       </div>
       <div class="clear"></div>
      </div>
      <div class="form_main">
    	<div class="form_section">
        	<div class="title">
            	<h4>名称：${parentBean.name}</h4>
            </div>
            <div class="content">
                <dd class="auth_tree">
          <div class="area_tree" id="jstree01">
            <ul>
            <c:forEach items="${topMenuList}" var="top">
               <li id="m${top.id}" class="menu">${top.name}
               <ul>
                   <c:forEach items="${top.children}" var="sub">
                      <li class="menu" id="m${sub.id}">${sub.name}
                      <ul>
                        <c:forEach items="${sub.children}" var="ssub">
                          <li class="menu" id="m${ssub.id}">${ssub.name}
                          <ul>
                          <c:forEach items="${menuButtonMap[ssub.id]}" var="ssubb">
                            <li class="menuButton" id="b${ssubb.id}">${ssubb.name}</li>
                          </c:forEach>
                          </ul>
                          </li>
                        </c:forEach>
                        <c:forEach items="${menuButtonMap[sub.id]}" var="subb">
                          <li class="menuButton" id="b${subb.id}">${subb.name}</li>
                        </c:forEach>
                      </ul>  
                      </li>                    
                   </c:forEach>
                   <c:forEach items="${menuButtonMap[top.id]}" var="sub">
                        <li class="menuButton" id="b${sub.id}">${sub.name}</li>
                   </c:forEach>
               </ul> 
             </li>
            </c:forEach>
            </ul>  
          </div>
        </dd>

                <div class="clear"></div>
             </div>
             <div class="form_action">
               <ui:Link action="save" href="javascript:onSave();" label="确认提交" className="common_btn major_btn biger_btn"></ui:Link>
               <ui:Link action="cancel" label="取消" className="common_btn biger_btn"></ui:Link>
              </div>
        </div>
        <div class="clear"></div>
     </div>
</div></div>
</div>
<jsp:include page="/common/footer.jsp" />
</ui:Form>
</body>
</html>