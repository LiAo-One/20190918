// 定义全局变量
var dialog;

$(function(){
	
	
	
	$(".user-card").on("click","a",function(){
		top.dialog.show({
            "text": "添加用户",
            "add": "Add/userAdd.jsp",
            "width": 24,
            "height": 24.25
        });
	});
});