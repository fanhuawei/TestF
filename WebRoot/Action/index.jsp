<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>系统测试</title>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="upload/jquery.uploadify.min.js"></script>
<link href="upload/uploadify.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div><a href="MobileService?action=login&userName=gsc&pass=gsc&sn=DN6GN6ZNDFJ0">登录</a></div>
<div><a href="MobileService?action=modifyUserInfo&userName=gsc&pass=gsc&sn=DN6GN6ZNDFJ0&newPass=gsc">修改用户信息</a></div>
<div><a href="MobileService?action=enableHelper&userName=gsc&pass=gsc&sn=DN6GN6ZNDFJ0&enable=1">开启代班</a></div>
<div><a href="MobileService?action=queryWorkForm&userName=gsc&pass=gsc&sn=DN6GN6ZNDFJ0&lastId=100211&cnt=10">获取待办工单列表</a></div>
<div><a href="MobileService?action=queryHistoryWorkForm&userName=gsc&pass=gsc&sn=DN6GN6ZNDFJ0&cnt=10">获取历史工单列表</a></div>
<div><a href="MobileService?action=queryWorkFormDetail&userName=gsc&pass=gsc&sn=DN6GN6ZNDFJ0&workId=10000025">获取工单详情</a></div>
<div><a href="MobileService?action=finishWorkForm&userName=gsc&pass=gsc&sn=DN6GN6ZNDFJ0&workId=10000025
data:{"workTime":"1","nature":"1","latitude":"123.1033","longitude":"30.9893","asset":"附件","assetcnt":"1","runType":"1","pressure":"100","temperature":"70","runHours":"300","oilBrand":"长城","science":"","oilT":"","oilFirstAirOut":"","oilFinalAirOut":"","waterInT":"","waterSecondAirOut":"","waterAirIn":"","waterOutT":"","waterOutSecondAirOut":"","te":"","faultDesc":"","reasonDesc":"","repakirMethod":"","workStatus":"1","part":[{"pid":"100001","pcnt":"1"}],"customerOpinion":""}">提交工单</a></div>
<div><a href="MobileService?action=returnWorkForm&userName=gsc&pass=gsc&sn=DN6GN6ZNDFJ0&workId=10000025&remark=无法处理">退回</a></div>
<div><a href="MobileService?action=assignWorkForm&userName=gsc&pass=gsc&sn=DN6GN6ZNDFJ0&workId=10000025&recevierId=100009">分发</a></div>
<div><a href="MobileService?action=closeWorkForm&userName=gsc&pass=gsc&sn=DN6GN6ZNDFJ0&workId=10000025">关闭</a></div>
<div><a href="MobileService?action=checkin&userName=engine001&pass=123213&sn=DN6GN6ZNDFJ0&workId=100020&time=20120908090201&arriveTime=20120908090201&finishTime=20120908090201">工程师收到工单</a></div>
<div><a href="MobileService?action=checkin&userName=gsc&pass=gsc&sn=DN6GN6ZNDFJ0&workId=10000025">到达现场</a></div>
<div><a href="MobileService?action=queryMBasicInfo&userName=gsc&pass=gsc&sn=DN6GN6ZNDFJ0&machineId=10008">获取机器基本信息</a></div>
<div><a href="MobileService?action=queryMRealTimeInfo&userName=gsc&pass=gsc&sn=DN6GN6ZNDFJ0&machineId=10008">获取机器实时数据</a></div>
<div><a href="MobileService?action=queryMHWorkFormInfo&userName=gsc&pass=gsc&sn=DN6GN6ZNDFJ0&machineId=10008">查询机器维修保养历史</a></div>
<div><a href="MobileService?action=queryMRHInfo&userName=gsc&pass=gsc&sn=DN6GN6ZNDFJ0&machineId=10008&beginTime=20141001&endTime=20151010&cnt=10">查询机器历史数据</a></div>
<div><a href="MobileService?action=queryClientBasicInfo&userName=gsc&pass=gsc&sn=DN6GN6ZNDFJ0&customerId=10037">查询客户基础信息</a></div>
<div><a href="MobileService?action=queryAgentInfo&userName=gsc&pass=gsc&sn=DN6GN6ZNDFJ0&agentId=10000047">查询代理商信息</a></div>
<div><a href="MobileService?action=queryMessage&userName=gsc&pass=gsc&sn=DN6GN6ZNDFJ0&type=0&lastId=11111&cnt=10">获取系统通知</a></div>
<div><a href="MobileService?action=checkVersion&userName=gsc&pass=gsc&sn=DN6GN6ZNDFJ0">检查更新</a></div>
<div><a href="MobileService?action=uploadBaiduInfo&userName=gsc&pass=gsc&sn=DN6GN6ZNDFJ0&clientId=cid&appId=aid&channelId=chid&dt=A">Android上传百度数据</a></div>
<div><a href="MobileService?action=uploadBaiduInfo&userName=gsc&pass=gsc&sn=DN6GN6ZNDFJ0&clientId=cid&appId=aid&channelId=chid&dt=I">IOS上传百度数据</a></div>

<div><a href="MobileService?action=makeManagerList&userName=gsc&pass=gsc&sn=DN6GN6ZNDFJ0&workId=10000025">获取区域服务中心主管列表</a></div>
<div><a href="MobileService?action=makeManagerList&userName=huabei&pass=huabei&sn=DN6GN6ZNDFJ0&workId=10000025">获取代理商主管列表</a></div>
<div><a href="MobileService?action=makeEngineerList&userName=huabei&pass=huabei&sn=DN6GN6ZNDFJ0&workId=10000025">获取服务中心工程师列表</a></div>
<div><a href="MobileService?action=makeEngineerList&userName=m002&pass=m002&sn=DN6GN6ZNDFJ0&workId=10000025">获取代理商工程师列表</a></div>

<form action="MobileService" enctype="multipart/form-data" method="post" >
　　<input type="hidden" name="action" value="checkin"/> 
<input type="hidden" name="userName" value="dongbei"/>
<input type="hidden" name="pass" value="dongbei"/>
<input type="hidden" name="sn" value="DN6GN6ZNDFJ0"/>
<input type="hidden" name="workId" value="10000034"/>
<input type="file" name="file1" >
<input type="file" name="file2" >
<button type="submit">到达现场</button>
</form>
<jsp:include page="/common/uploadFile.jsp">
 <jsp:param value="img" name="fileType"/>
</jsp:include>
</body>
</html>