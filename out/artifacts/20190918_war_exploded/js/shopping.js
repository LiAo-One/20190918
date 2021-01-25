$(function(){
	// 添加数量点击事件
	$(".change-goods").on("click", ".J-plus", function() {
		// 获取当数量对象
			currPage = $(".J-goods-num", $(this).parent());
			// 获取当数量
			var currNum = currPage.val();
			currNum++;
			// 回填数量
			currPage.val(currNum);
			// 计算小计
			// 获取父元素中单价
			var price = $(this).parent().parent().prev().text();
			var total = price * currNum;
			sum = Math.round(total * 100) / 100;
			// 将小计存入
			$(this).parent().parent().next().text(sum);
			// 获取购物车ID
			var goodID = $(this).parent().parent().parent().attr("shoppingid");
			//购物车修改方法
			shoppCart(currNum, sum, goodID);
		});

	// 减少按钮点击事件
	$(".change-goods").on("click", ".J-minus", function() {
		// 获取当数量对象
			currPage = $(".J-goods-num", $(this).parent());
			// 获取当数量
			var currNum = currPage.val();
			// 判断当数量是否为最小值
			if (currNum == 1) {
				currPage.val(1);
			} else {
				currNum--;
				// 回填数量
				currPage.val(currNum);
				// 计算小计
				// 获取父元素中单价
				var price = $(this).parent().parent().prev().text();

				var total = price * currNum;

				sum = Math.round(total * 100) / 100;
				// 将小计存入
				$(this).parent().parent().next().text(sum);
			}
		});

	// 删除单击事件
	$(".col-action").on("click", ".fa", function() {

		var shoppId = $(this).parent().parent().attr("shoppingid");
		console.log(shoppId);

	});
})

function shoppCart(currNum, total, goodID) {
$.post("asdasdasd",{
		"currNum":currNum,
		"total":total,
		"goodID":goodID
	},function(res){
		
	},"json");css
}