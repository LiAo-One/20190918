$(function(){
	// 全部订单按钮
	$(".allOrders").click(function(){
		$("a").removeClass("selecteds");
		
		$(".allOrders").addClass("selecteds");
		
		$("#manager-page").attr("src","allOrder.jsp");
	});
	
	// 待支付按钮
	$(".pendingReceipt").click(function(){
		$("a").removeClass("selecteds");
		
		$(".pendingReceipt").addClass("selecteds");
		
		$("#manager-page").attr("src","pendingReceipt.jsp");
	});
	// 待收货按钮
	$(".pendingPayment").click(function(){
		$("a").removeClass("selecteds");
		
		$(".pendingPayment").addClass("selecteds");
		
		$("#manager-page").attr("src","pendingPayment.jsp");
	});
});

