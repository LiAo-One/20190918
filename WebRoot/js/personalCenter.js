

$(function(){

	
	// 我的订单按钮
	$(".myOrdes").click(function(){

		$(".personalCenter").removeClass("selecteds");
		
		$(".myOrdes").addClass("selecteds");
		
		$("#manager-page").attr("src","../jsp/user/myOrder/myOrder.jsp");
	});
	
//	 个人中心按钮
	$(".personalCenter").click(function(){
		$(".myOrdes").removeClass("selecteds");
		
		$(".personalCenter").addClass("selecteds");
		
		$("#manager-page").attr("src","../jsp/user/myInformation/modifyInformation.jsp");
	});
	// 评价按钮
	$(".comment").click(function(){
		$("a").removeClass("selecteds");
		
		$(".comment").addClass("selecteds");
		
		$("#manager-page").attr("src","../jsp/user/myOrder/productReview.jsp");
	});
	// 搜索单击事件
	$(".search-btn").click(function () {
		alert("adssdas");
		// 获取搜框文本
		var goodsName = $(".search-text").val();
		// 存入cookie
		util.cookie.set("selectName",goodsName);
		// 编码
		window.location.href = 'AccountList.aspx?dev=' + encodeURIComponent(goodsName);
		// 页面跳转，将数据已键值对的方式存入地址栏
		location.href = "search.jsp?goodsName=" + goodsName;

	});
	
	


});