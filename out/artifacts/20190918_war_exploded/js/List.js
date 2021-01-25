function LIST(args) {

    this.init(args);
    
    
};

/**
 * 数据初始化
 * @param {Object} args
 */
LIST.prototype.init = function (args) {
    this.renderTo = $("#" + args.renderTo);
    this.requData = args.requData;
    this.onClick = args.onClick ? args.onClick : function () {
    };

    if (args.postData) {
		// 传递了请求参数
        if (!args.postData.pageNum) {
            args.postData.pageNum = 1;
        }

        if (!args.postData.pageSize) {
            args.postData.pageSize = 8;
        }
    } else {
        // 说明用户没有传递参数
        args.postData = {
            "pageNum": 1,
            "pageSize": 8
        };
    }

	// 将参数转成全局变量
    this.postData = args.postData;
	// 数据缓存
    this.renderTo.data("args", args);
    // 获取数据
    this.byDataSource();
};


//刷新数据
LIST.prototype.reload = function (pageNum, pageSize) {
    // 获取缓存数据
    var args = this.renderTo.data("args");

    // 将调用时传递的pageNum和pageSize赋值给用户传递的args数据
    if (pageNum) {
        args.postData.pageNum = pageNum;
    }

    if (pageSize) {
        args.postData.pageSize = pageSize;
    }

    // 重新渲染数据
    this.init(args);

};

/**
 * 根据数据源获取数据
 */
LIST.prototype.byDataSource = function () {
    var v = this;
    if (typeof this.requData == 'string') {
        $.post(this.requData, v.postData, function (res) {
            console.log(res);
            v.requData = res;
            v.build();

        }, "json");
    } else {
        v.build();
    }
};


/**
 * 创建页面元素
 */
LIST.prototype.build = function () {
    // 清空当前渲染区域
    this.renderTo.html("");
    // 获取渲染区域
    this.renderTo.addClass("goods");
    var v = this;
    $.each(v.requData.rows, function (i, items) {
        console.log(items.length);
        v.goods = $('<div goodsx = ' + v.requData + ' goodsid = ' + items.id + ' goodsname = ' + items.productName + ' goodsprice = ' + items.price + ' img = ' + items.img + ' class="goods-lab"> </div>').appendTo(v.renderTo);
		// 图片
        v.img = $('<img alt="" src="goodsimg/' + items.img + '">').appendTo(v.goods);

        v.ul = $('<ul></ul>').appendTo(v.goods);
		// 名称
        v.name = $('<li class="name">' + items.productName + '</li>').appendTo(v.ul);

        v.names = $('<li class="desc">6400万全场景四摄</li>').appendTo(v.ul);
		// 价格
        v.price = $('<li class="price">' + items.price + '</li>').appendTo(v.ul);
        
        
        
        $(".totalNum").text(Math.ceil(v.requData.total/8));
    });


    v.bindEvent();
};

/**
 * 绑定事件
 */
LIST.prototype.bindEvent = function () {
    var v = this;
    // 单击商品，跳转到商品详情页
    $("#table").on("click", ".goods-lab", function () {
        var ul = $(this);
        var goodsId = $(this).attr("goodsid");
        util.cookie.set("goodsid", goodsId);

        var goodsImg = $(this).attr("img");
        util.cookie.set("img", goodsImg);

        var goodsName = $(this).attr("goodsname");
        util.cookie.set("goodsname", goodsName);

        var goodsPriceame = $(this).attr("goodsprice");
        util.cookie.set("goodsprice", goodsPriceame);

        window.location.href = "jsp/details.jsp";
    });
    
    
    // 下一页单击事件
    $(".pagination").on("click","#nextPage",function(){
    	// 获取当前页
        var currPage = $(".pageNum").text();
        // 获取最大页数
        var totalPage = $(".totalNum").text();
        // 判断当前页数是否为最大值
         if (currPage >= totalPage ) {
             alert("当前已经是最大页");
         } else {
        currPage++;
        pageSize = 8;
            // 回填当前页
            $(".pageNum").text(currPage);;
            // 刷新表格
            v.reload(currPage, pageSize);
            return;
         }
         
    });
    
    
    // 上一页单击事件
    $(".pagination").on("click","#previousPage",function(){
    	// 获取当前页
        var currPage = $(".pageNum").text();
        // 获取最大页数
        var totalPage = $(".totalNum").text();
        
        // 判断当前页数是否为最大值
         if (currPage <= 1 ) {
             alert("当前已经是第一页");
         } else {
        currPage--;
        pageSize = 8;
            // 回填当前页
            $(".pageNum").text(currPage);
            // 刷新表格
            v.reload(currPage, pageSize);
         }
    });
    


};









































