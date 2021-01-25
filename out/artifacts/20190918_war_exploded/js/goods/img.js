var goodsid = util.cookie.get("goodsid");
// 商品详情图片封装
function IMG(args) {
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

IMG.prototype.init = function(args) {
	this.renderTo = $("." + args.renderTo);
	this.requData = args.requData;

	if (args.postData) {
		// 传递了请求参数
		if (!args.postData.situation) {
			args.postData.goodsImgId = goodsid;
		}

	} else {
		// 说明用户没有传递参数
		args.postData = {
			"goodsImgId" : goodsid
		};
		// 将参数转成全局变量

	}
	this.postData = args.postData;

	this.byDataSource();
};

IMG.prototype.byDataSource = function() {
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

IMG.prototype.build = function() {
	// 获取渲染区域
	this.renderTo.addClass("section-body");
	var v = this;
	$('<img class="img" src="goodsimg/'+ util.cookie.get("img") +'" alt=""/>').appendTo(v.renderTo);
	var ul = $('<ul></ul>').appendTo(v.renderTo);
	
	// 循环创建单个图片
	$.each(v.requData.rows, function(i, item) {
		var li = $('<li></li>').appendTo(ul);
		var img = $('<img src="goodsimg/' + item.name + '" alt=""/>').appendTo(li);
		
	});
}











