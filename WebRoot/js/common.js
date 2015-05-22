  function onSubmitButton(action){
	  $("#action").val(action);
	  return true;
  }
  
  function onTextEnter(){
	    if(event.keyCode==13) {
	    	onAction("search");
	        return false;
	    }
  }
  function renderSelectAndRadio(divId){
	  $('input',$(divId)).iCheck({
		    checkboxClass: 'icheckbox_square-red',
		    radioClass: 'iradio_square-red',
			increaseArea: '20%' 
	   });
	  if($(".select_item",$(divId)).length>0){
			$(".select_item").select2({ placeholder: "请选择…"});
	  }
  }
  function onFilterEnter(){
	  var x = $("div[filter='true']");
	  if (x){
		  $("input",x).each(function(){
		   if (!this.onkeypress){
		    $(this).keypress(function(){
		    	onTextEnter();
		    });	
			 }
		  });		  
	  }	  
  }
  
  function onAjaxPopup(url) {
	  $('#ajaxPopup').load(url,function(){
		  $('#ajaxPopup').modal();			  
	  });	    
  }
  
  function onAjaxAction(action,id){
	  $("#frm").attr("target","actionFrame");
	  $("#ajaxFlag").val("Y");
	  $("#action").val(action);
	  $("#frm").submit();
  }
  function onAction(action,id){
	  $("#frm").attr("target","_self");
	  $("#ajaxFlag").val("N");
	  if (action == "delete"){
		 if (!confirm("确认删除吗？")){
			 return;
		 }
	  }
	  if (action=="markLost") {
		  if (!confirm("确认挂失设备吗？")){
		     return;
		  }
	  }
	  if (action=="close") {
		  if (!confirm("确认关闭工单吗？")){
			 return;
		  }
	  }
	  if (action=="ajaxFilter") {
		$("#ajaxPopup").load(id + "?action=ajaxFilter");
		return;
	  }
	  if (id){
	     $("#chk").val(id);
      }

	  if ("search"==action){
	    $("#pageNo").val("1");
	  }
	  if ("export"==action){
		  $("#frm").attr("method","get");
	  }else{
		  $("#frm").attr("method","post");
		  $("#lnk_" + action).attr("href","javascript:void(0);");
	  }
	  $("#action").val(action);
	  $("#frm").submit();
  }  
  function showMsg(msg){
	  $("#pop_notice_msg").html(msg);
	  $("#pop_notice").modal();	  
  }

  function SlyarErrors() {
	  return true;
  }
  window.onerror = SlyarErrors;

  
  function onPageTo(pageNo){
	  $("#action").val("search");
	  $("#pageNo").val(pageNo);
	  $("#frm").submit();
  }
  
  function onPageSizeTo(pageSize){
	  $("#action").val("search");
	  $("#pageNo").val("1");
	  $("#pageSize").val(pageSize);
	  $("#frm").submit();
  }
  
  function ImgAuto(i,MaxW,MaxH){	
	  var o=new Image();
	  o.src=i.src;
	  var w=o.width;
	  var h=o.height;
	  var t;
	  if (w>MaxW){t=MaxW;}else{t=w;}
	  if ((h*t/w)>MaxH){i.height=MaxH;i.width=MaxH/h*w;}
	  else{i.width=t;i.height=t/w*h;}
  }
  function insertEnter(str,n){
	  var len = str.length;
	  var strTemp = '';
	  if(len > n){
	   strTemp = str.substring(0,n);
	   str = str.substring(n,len);
	   return strTemp+'\n'+insertEnter(str,n);
	  }else{
	   return str;
	  }
	 }
