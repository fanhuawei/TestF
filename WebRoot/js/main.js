$(document).ready(function(){
//左侧菜单栏目高度设定
if($(".page_sidemenu").length>0){
	function sideheight(){
		var sideheight = $(window).height()-78;
		$(".page_sidemenu").css("height",sideheight);
	}
	sideheight();
	$(window).resize(function() {
		sideheight();
	});
}

$(".submenu_hover").mouseover(function(){
	$(this).find(".submenu").css("display","block");
})
$(".submenu_hover").mouseleave(function(){
	$(this).find(".submenu").css("display","none");
})

$(".data_fliter dl dd input.data_input").parent().css("width","370px");
$("input[readonly]").addClass("readonly");

if($(".common_table").length>0){
	//表格奇偶数变色及悬停变色
	$(".common_table").each(function(){
		$(this).find("tr[class!='m_table_title']:even").addClass("background_color_even");
		$(this).find("tr[class!='m_table_title']:odd").addClass("background_color_odd");
		$(this).find("tr[class!='m_table_title']").mouseover(function(){
			 $(this).addClass("background_color_hover");
		});
		$(this).find("tr[class!='m_table_title']").mouseleave(function(){
			 $(this).removeClass("background_color_hover");
		});
	});
	//选中表格高亮显示
	$("tr td input:checkbox[name='dataid']").on('ifClicked', function(event){
		$(this).on('ifChecked', function(event){
			$(this).parent().parent().parent().addClass("background_color_check");
		})
		$(this).on('ifUnchecked', function(event){
			$(this).parent().parent().parent().removeClass("background_color_check");
		})
	});
	
	//表格操作栏动作
	if($(".common_table .action_list").length>0){
		$(".common_table .action_list").each(function() {
			$(this).parent().addClass("noborderbottom");
			if($(this).find("li a").length>1){
				$(this).addClass("action_list_arrow");
			}
			$(this).find("li:first").css("display","block");
			$(this).mouseover(function(){
				$(this).find("li").css("display","block");
				$(this).addClass("action_list_hover");
				$(this).css("z-index","888");
			});
			$(this).mouseleave(function(){
				$(this).find("li").css("display","none");
				$(this).find("li:first").css("display","block");
				$(this).removeClass("action_list_hover");
				$(this).css("z-index","777");
			});
		});
	}
}
 $('input').iCheck({
    checkboxClass: 'icheckbox_square-red',
    radioClass: 'iradio_square-red',
	increaseArea: '20%' 
  });
  
if($("#photoview").length>0){
	$("#photoview .carousel .item").css("height",$(window).height());
	
	$('#photoview').on('shown.bs.modal', function (e) {
  		$(".modal-backdrop").addClass("moredark");
	})
	$('#photoview').on('hiden.bs.modal', function (e) {
  		$(".modal-backdrop").removeClass("moredark");
	})
}


if($(".select_item").length>0){
	$(".select_item").select2({ placeholder: "请选择…"});
}
});

function ImgAuto(i){
 var MaxW=950;
 var MaxH=$(window).height()-40;
 var o=new Image();o.src=i.src;var w=o.width;var h=o.height;var t;if (w>MaxW){t=MaxW;}else{t=w;}
 if ((h*t/w)>MaxH){i.height=MaxH;i.width=MaxH/h*w;}else{i.width=t;i.height=t/w*h;}
}