/**
 * 订单列表封装
 */
// 商品总价
var goodsNum = 0;
// 用户地址
var userAddress = "";
// 用户姓名
var addName = "";
// 手机
var phone = "";

function ORDER(args) {
	try {
		if (!args.renderTo) {
			throw ("组件加载失败，renderTo值为空");
		}
		if (!args.requData) {
			throw ("组件加载失败，data值为空");
		}
		this.init(args);
		//	捕获异常，弹出
	} catch (e) {
		alert(e);
	}
};

ORDER.prototype.init = function(args) {
	this.renderTo = $("." + args.renderTo);
	this.requData = args.requData;
	//    this.dataSource = args.dataSource;
	//    this.onClik = args.onClik ? args.onClik : function () {
	//    };

	if (args.postData) {
		// 传递了请求参数
		if (!args.postData.situation) {
			args.postData.situation = "结算";
		}

	} else {
		// 说明用户没有传递参数
		args.postData = {
			"situation" : "结算"
		};
		// 将参数转成全局变量

	}
	this.postData = args.postData;

	this.byDataSource();
};

ORDER.prototype.byDataSource = function() {
	var v = this;
	if (typeof this.requData == 'string') {
		$.post(this.requData, v.postData, function(res) {
			console.log(res);
			v.requData = res;
			v.build();

		}, "json");

	} else {
		v.build();
	}
};

ORDER.prototype.build = function() {
	// 获取渲染区域
	this.renderTo.addClass("goods-list");
	this.renderTo.addClass("clearfix");
	// 循环创建单个订单
	var v = this;
	$.each(v.requData.rows, function(i, item) {
		var add = new Array();

		add.push('<li class="clearfix" id = "'+ item.id +'">');
		add.push('<div class="col col-img">');
		add.push('<img src="../../../goodsimg/'+ item.goodsImg +'" alt="">');
		add.push('</div>');
		add.push('<div class="col col-name">');
		add.push('<a href="">');
		add.push(''+ item.productName +'');
		add.push('</a>');
		add.push('</div>');
		add.push('<div class="col col-price">');
		add.push(''+ item.pric +'元 x '+ item.quantity +'');
		add.push('</div>');
		add.push('<div class="col col-status">');
		add.push('&nbsp;');
		add.push('</div>');
		add.push('<div class="col col-total">');
		add.push(''+ item.totalPric +'元');
		goodsNum = goodsNum +  parseFloat(item.totalPric);
		add.push('</div>');
		add.push('<div class="col col-remove">');
		add.push('<i class="fa fa-times" aria-hidden="true"></i>');
		add.push('</div>');
		add.push('</li>');

		$(add.join("")).appendTo(v.renderTo);
		
	});
	
	v.bindEvent();
}

/**
 * 事件绑定
 * @memberOf {TypeName} 
 */
ORDER.prototype.bindEvent = function() {
	var v = this;
	// 为商品数量赋值
	$(".clearfix .shuliang").text(v.requData.total+"件");
	// 为商品总价赋值
	$(".clearfix .priceGoods").text(goodsNum + "元");
	// 存入cookie
	util.cookie.set("primaryPrice",goodsNum);
	// 为应付金额赋值
	$(".total-price span em").text(goodsNum);
	// 去结算按钮单击事件
	$(".fr").on("click",".btn-primary",function(){
		console.log("<<<<<");
		// 判断用户有没有选择地址
		if(userAddress.length == 0){
			alert("请选择地址");
		}else{
			// 页面跳转
			window.location.href = "paymentPage.jsp";
		}
		
		
	})
	
	// 选择地址单击事件
	$(".section-body").on("click",".J_addressItem",function(){
		//获取当前单击地址，并存入cookie
		userAddress = $(this).attr("userAdd");
		util.cookie.set("address",userAddress);
		// 姓名
		addName = $(this).attr("addname")
		util.cookie.set("addname",addName);
		//获取电话
		phone = $(this).attr("phone")
		util.cookie.set("phone",phone);
		
		$(".J_addressItem").removeClass("headit");
		$(this).addClass("headit");
	})
	
	// 删除按钮单击事件
	$(".col-remove").on("click",".fa-times",function(){
		var id = $(this).parent().parent().attr("id");
		$.post("../../../manager/servlet/removeShoppingCartOrders.action", {
            "shoppid": id
        }, function (res) {
            if (res.isSuccess == "true") {
                // 成功
                console.log(">>>>");
                // 删除当前购物车元素

            } else {
                // 失败
                console.log("<<<<");
            }
        }, "json");
		$(this).parent().parent().remove();
	})
}




















