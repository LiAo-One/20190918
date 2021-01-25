var userType;

$(function () {
    var goodsName = util.cookie.get("goodsname");
    $(".nav-bar h2").text(goodsName);
    $(".J-proName .name").text(goodsName);
    $(".pro-chose .steo-title").text("请选择  " + goodsName + " 版本");
    $(".J-proName .name").text(goodsName);
    $(".pro-list .totleName").text(goodsName + " 3G + 32GB");

    var goodsPrice = util.cookie.get("goodsprice");
    $(".por-price .price").text(goodsPrice + " 元");
    $(".pro-list .totlePrice").text(goodsPrice + " 元");

    var goodsId = util.cookie.get("goodsid");
    
    $(".byn-biglarge").click(function(){
    	
    	shoppingCart();
    })
    
    var gooddimg = util.cookie.get("img");
    
    $(".container img").attr("src","goodsimg/"+ gooddimg +"")

});

/**
 * 购物车添加事件
 */
function shoppingCart (){
	var goodsId = util.cookie.get("goodsid");
	
	var goodsPrice = util.cookie.get("goodsprice");
	
	
	$.post("manager/servlet/AddShoppingCart.action", {
        "goodsId": goodsId,
        "goodsPrice": goodsPrice,
    }, function (res) {
        // 定义提示信息样式
        var tipsStyle;

        if (res.isSuccess == "true") {
            alert(res.message);
            // 刷新表格
//            top.goodsGird.reload(1, 10);

            // 隐藏对话框
            top.dialog.hide();
            // 设置信息样式为 success
            tipsStyle = "tips-success";

            top.editBtn.addClass("btn-disable");
            top.removeBtn.addClass("btn-disable");
        } else {
//				alert(res.message);
            // 设置信息样式为 success
            tipsStyle = "tips-success";
        }
        // 显示提示信息组件
        top.dialogTips.show({
            "message": "",
            "message": res.message,
            "tipsStyle": tipsStyle
        });
        // 一段时间之后，提示信息隐藏
        setTimeout(function () {
            top.dialogTips.hide();
        }, 2000);
    }, "json");
}

