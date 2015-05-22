<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags" %> 
<%@ taglib prefix="mf" uri="/WEB-INF/mf.tld" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="refresh" content="30"> 
<jsp:include page="/common/header.jsp"/>
<script>
$(function(){
	$("#keyword").keydown(function(e){
		e=e||event; 
	    if (e.keyCode == 13){ 
	    	onAction("search");
	    }
	});	
});
</script>
</head>
<body class="page_form"><ui:Form>
<jsp:include page="/common/menu.jsp"/>
<div class="page_righter onetable indexpage">
  <div class="wraper">
    <div class="model_iTable"> 
      <!--头部开始-->
      <div class="header">
        <div class="header_left">
          <h3>仪表盘</h3>
        </div>
        <div class="header_right">
          <div class="search_input">
            <select class="select_item select_searchcate" name="searchType">
              <c:if test="${mf:checkMenu(5000)}"><option selected="selected" value="c">客户</option></c:if>
              <c:if test="${mf:checkMenu(3000)}"><option value="s">设备序列号</option></c:if>
              <c:if test="${mf:checkMenu(3000)}"><option value="v">设备类型</option></c:if>
              <c:if test="${mf:checkMenu(4000)}"><option value="o">工单编号</option></c:if>
            </select>
            <input type="text" maxlength="20" class="input_search" id="keyword" name="keyword" placeholder="请输入关键字…"  />
            <ui:Link action="search" className="btn_search" label="关键字查询"></ui:Link>
            </div>
        </div>
        <div class="clear"></div>
      </div>
      <div class="index_main">
<c:if test="${userDept.type eq 'S' or userRole.code eq 'Service_Center_Manager' or not empty UserInfo.agentId}">   
        <div class="widget_item">
          <div class="widget_title"></span><a href="Main.do" class="reflash_btn" style="color: black;">上次刷新时间：<fmt:formatDate pattern="HH:mm" value="${today}"/></a>
            <h3>待办工单<span class="num">${pageBean.totalRecord}</span></h3>
          </div>
          <div class="widget_body">
            <div class="model_iTable">
              <div class="table_title_area">
                <table cellspacing="0" cellpadding="0" class="common_table user_table ">
                  <tbody>
                    <tr class="m_table_title">
                      <th width="130px">工单号</th>
                      <th width="80px">机器类型</th>
                      <th width="100px">机器型号</th>
                      <th width="60px">服务类型</th>
                      <th width="80px">时间</th>
                      <th width="50px">操作</th>
                    </tr>
                    <c:forEach var="item" items="${pageBean.list}" varStatus="st">
                    <tr>
                    <td>${item.code}</td>
          <td>${mf:makeValueByCode(macMap[item.machineId].type,"MACHINE_TYPE")}</td>
          <td>${macMap[item.machineId].model}</td>
          <td>${mf:makeValueByCode(item.serviceType,"SERVICE_TYPE")}</td>
          <td width="80px"><fmt:formatDate pattern="MM-dd HH:mm" value="${item.updateTime}"/></td>
                      <td width="60px"><ul class="action_list">
                          <li><ui:Link action="view" href="WorkOrder.do?action=view&chk=${item.id}" label="详情" /></li>
                        </ul></td>
                    </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
            <c:if test="${pageBean.totalRecord>5}">
            <div class="yichang_more">
            <ui:Link action="viewAll" href="WorkOrder.do?flag=T" label="查看全部待办工单" />
            </div>
            </c:if>
          </div>
        </div>
</c:if>   
<c:if test="${userDept.type ne 'S' and userRole.code ne 'Service_Center_Manager' and empty UserInfo.agentId}">   
        <div class="widget_item">
          <div class="widget_title"> <a href="Main.do" class="reflash_btn" style="color: black;">上次刷新时间：<fmt:formatDate pattern="HH:mm" value="${today}"/></a>
            <h3>机器异常预警<span class="num">${pageBean.totalRecord}</span></h3>
          </div>
          <div class="widget_body">
            <div class="model_iTable">
              <div class="table_title_area">
                <table cellspacing="0" cellpadding="0" class="common_table user_table ">
                  <tbody>
                    <tr class="m_table_title">
                      <th width="90px">机器型号</th>
                      <th>客户</th>
                      <th width="60px">异常类型</th>
                      <th width="100px">报警时间</th>
                      <th width="60px">操作</th>
                    </tr>
                    <c:forEach var="item" items="${pageBean.list}" varStatus="st">
                    <tr>
                      <td width="90px">${macMap[item.machineId].model}</td>
                      <td>${mf:makeNameById(macMap[item.machineId].customerId,"CUSTOMER")}</td>
                      <td width="60px">${mf:makeValueByCode(item.runStatus,"RUN_STATE")}</td>
                      <td width="80px"><fmt:formatDate pattern="MM-dd HH:mm" value="${item.collectTime}"/></td>
                      <td width="60px"><ul class="action_list">
                          <li><ui:Link action="view" href="Machine.do?action=view&chk=${item.machineId}" label="详情" /></li>
                        </ul></td>
                    </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
            <c:if test="${pageBean.totalRecord>5}">
            <div class="yichang_more">
            <ui:Link action="viewAll" href="Machine.do?runStatus=C" label="查看全部异常机器" />
            </div>
            </c:if>
          </div>
        </div>
</c:if>      
        <!--第二个插件开始-->
        <div class="widget_item">
          <div class="widget_title">
            <h3>大区设备分布</h3>
          </div>
          <div class="widget_body">
          	<div class="chart" id="pieChart" style="height:250px;background-color: white;">
          	<script src="js/echarts-all.js"></script>
          	<script type="text/javascript">
          	var myChart = echarts.init(document.getElementById('pieChart'));
          	var option = {	    
          			tooltip : {
          		        trigger: 'item',
          		        formatter: "{b} : {c}"
          		    },
          		    legend: {
          		        orient : 'vertical',
          		        x : 'left',
          		        data:[<c:forEach items="${chartList}" var="row" varStatus="st">
	    					'${row.VALUE}'<c:if test='${!st.last}'>,</c:if>
		    					</c:forEach>]
          		    },
          					    	    textStyle : 'auto',
          					    	    series : [
          					    	        {
          					    	            name:'设备分布',
          					    	            type:'pie',
          					    	            radius : '125',    
          					    	          itemStyle : {
          				    	                normal : {
          				    	                    label : {
          				    	                        position : 'inner',
          				    	                        textStyle : {fontSize:12},
          				    	                        formatter : function (a,b,c,d) {
          				    	                        	if((d - 0).toFixed(0)>0){
          					    	                        	return (d - 0).toFixed(0) + '%'
          				    	                        	}else{
          				    	                        		return '';
          				    	                        	}
          				    	                        }
          				    	                    },
          				    	                    labelLine : {
          				    	                        show : false
          				    	                    }
          				    	                },
          				    	                emphasis : {
          				    	                    label : {
          				    	                        show : true,
          				    	                        formatter : function (a,b,c,d) {return (d - 0).toFixed(0) + '%'}
          				    	                    }
          				    	                }
          				    	            },
          					    	            data:[
          						    				<c:forEach items="${chartList}" var="row" varStatus="st">
          				    					{value:'${row.CNT}',name:'${row.VALUE}'}<c:if test='${!st.last}'>,</c:if>
          					    					</c:forEach>	
          					    				]
          					    	        }
          					    	    ]
          					    	};
          					    myChart.setOption(option);
          	</script>
          	</div>
          </div>
        </div>
        <!--第三个插件开始-->
        <div class="widget_item">
          <div class="widget_title">
            <h3>快捷入口</h3>
          </div>
          <div class="widget_body">
          	<ul class="quick_links">
<c:forEach items="${userShortCut}" var="item">
            	<li><a href="${item.link}">${item.name}</a></li>
</c:forEach>          	
            </ul>
          </div>
        </div>
        <!--第四个插件开始-->
        <div class="widget_item">
          <div class="widget_title">
            <h3>数据统计</h3>
          </div>
          <div class="widget_body">
          	<ul class="tongji">
            	<li><span class="tj_name">待审核工单：</span>${numOrderCreate}条</li>
                <li><span class="tj_name">机器总数：</span>${numMachine}台</li>
                <li><span class="tj_name">执行中工单：</span>${numOrderProcess}条</li>
                <li><span class="tj_name">客户：</span>${numCustomer}家</li>
                <li><span class="tj_name">已完成工单：</span>${numOrderFinish}条</li>
                <li><span class="tj_name">代理商：</span>${numAgent}家</li>
                <li><span class="tj_name">已关闭工单：</span>${numOrderClose}条</li>
                <li><span class="tj_name">维修工程师：</span>${numEngineer}位</li>
            </ul>
          </div>
        </div>
        <div class="clear"></div>
      </div>
    </div>
  </div>
</div>
<jsp:include page="/common/footer.jsp"/></ui:Form>
</body>
</html>
<script>
$(document).ready(function(){
	$(".widget_item:odd").addClass("right_widget");
	$(".quick_links li").eq(3).addClass("rightli");
});
</script>