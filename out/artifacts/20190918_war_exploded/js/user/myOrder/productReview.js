$(function(){
	// 获取 ID
	var oid = util.cookie.get("oid");
	// 获取名称
	var oName = util.cookie.get("oName");
	// 获取名称
	var oImg = "../../../goodsimg/"+util.cookie.get("oImg");
	
	// 为图片赋值
	$(".common-left img").attr("src",oImg);
	// 为商品名称赋值
	$(".common-left .title").text(oName);
	
	// 评价按钮
	$(".right-bot").on("click",".btn-primary",function(){
		// 评论
		$.post("../../../manager/servlet/usreAddCommernt.action",{
			// 参数
			"goodsId":oid,
			"feel":$(".right-middle textarea").val()
		},function(res){
			// 判断结果
			if (res.isSuccess == "true") {
			// 成功
			console.log(">>>>");
			$(".right-middle textarea").val("");
			alert("感谢您对小米的支持");
		} else {
			// 失败
			console.log("<<<<");
		}
		},"json")
	});
	// 用户反馈按钮
	
	$(".top-r").on("click",".btn-primary",function(){
		$(".right-text #comment").val("");
		alert("感谢您对小米的支持");
	});
})