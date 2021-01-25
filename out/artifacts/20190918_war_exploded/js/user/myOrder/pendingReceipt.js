/**
 * 待支付
 * @param {Object} args
 * @memberOf {TypeName} 
 * @exception {TypeName} 
 */
function TAL(args) {
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

TAL.prototype.init = function(args) {
	this.renderTo = $("." + args.renderTo);
	this.requData = args.requData;
	//    this.dataSource = args.dataSource;
	//    this.onClik = args.onClik ? args.onClik : function () {
	//    };
	
	if (args.postData) {
		// 传递了请求参数
        if (!args.postData.situation) {
            args.postData.situation = "已收货";
		}
        
    } else {
        // 说明用户没有传递参数
        args.postData = {
            "situation": "已收货"
        };
        // 将参数转成全局变量
    
	}
	this.postData = args.postData;

	this.byDataSource();
};

/**
 * 根据数据源 获取数据
 */
TAL.prototype.byDataSource = function() {
	
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

TAL.prototype.build = function() {
	// 获取渲染区域
	this.renderTo.addClass("J_orderList");
	// 循环创建单个订单
	var v = this;
	$.each(v.requData.rows, function (i, item) {
		var tr = new Array();

		tr.push('<ul goodsid = "'+ item.goodsid +'" class="order-list">');
		tr.push('<li class="uc-order-item uc-order-item-finish">');
		tr.push('<div class="order-remove">');
		tr.push('<i class="fa fa-trash-o"></i>');
		tr.push('</div>');
		tr.push('<div class="order-detail">');
		tr.push('<div class="order-summary">');
		tr.push('<div class="order-status">'+ item.situation +'</div>');
		tr.push('</div>');
		tr.push('<table class="order-detail-table">');
		tr.push('<thead>');
		tr.push('<tr>');
		tr.push('<th class="col-main">');
		tr.push('<p class="caption-info">');
		tr.push('2019年10月03日 20:51');
		tr.push('<span class="sep">|</span>');
		tr.push(''+ item.userName +'');
		tr.push('<span class="sep">|</span>');
//		tr.push('订单号：'+ item.numbering +'');
		tr.push('</p>');
		tr.push('</th>');
		tr.push('<th class="col-sub">');
		tr.push('<p class="caption-price">');
		tr.push('实付金额');
		tr.push('<span class="num">'+ item.pric +'</span>');
		tr.push('元');
		tr.push('</p>');
		tr.push('</th>');
		tr.push('</tr>');
		tr.push('</thead>');
		tr.push('<tbody>');
		tr.push('<tr class="solid">');
		tr.push('<td class="order-items">');
		tr.push('<ul class="goods-list">');
		tr.push('<li>');
		tr.push('<div class="figure figure-thumb">');
		tr.push('<a href="" >');
//		tr.push('<img src="../../../goodsimg/pms_1555075954.81667747.jpg" alt="">');
		tr.push('<img src="../../../goodsimg/'+ item.goodsImg +'" alt="">');
		tr.push('</a>');
		tr.push('</div>');
		tr.push('<p class="name">');
		//  3GB+32GB 亮黑色 32GB
		tr.push('<a href="">'+ item.productName +' </a>');
		tr.push('</p>');
		tr.push('<p class="price">'+ item.pric +' × '+ item.quantity +'</p>');
		tr.push('</li>');
		tr.push('</ul>');
		tr.push('</td>');
		tr.push('<td class="order-actions">');
		tr.push('<a class ="btn btn-small btn-line-gray">订单详情</a>');
		tr.push('<a class ="btn btn-small btn-line-gray pay">去支付</a>');
//		tr.push('<a href="btn btn-small btn-line-gray">申请售后</a>');
		tr.push('</td>');
		tr.push('</tr>');
		tr.push('</tbody>');
		tr.push('</table>');
		tr.push('</div>');
		tr.push('</li>');
		tr.push('</ul>');

		$(tr.join("")).appendTo(v.renderTo);
	});
	v.bindEvent();
}
/**
 * 绑定事件
 */
TAL.prototype.bindEvent = function () {
	// 去支付单击事件
	$(".order-actions").on("click",".pay",function(){
		top.location.href = "confirmOrder.jsp";
	});
	
	
}


















