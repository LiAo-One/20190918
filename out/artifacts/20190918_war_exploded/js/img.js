function IMG(args) {
    this.init(args);
}

IMG.prototype.init = function (args) {
    this.renderTo = $("#" + args.renderTo);
    this.requData = args.requData;
    this.onClick = args.onClick ? args.onClick : function () {
    };

    if (args.postData) {
        // 传递了请求参数
        if (!args.postData.goodsId) {
            args.postData.goodsId = util.cookie.get("goodsid");
        }
    } else {
        // 说明用户没有传递参数
        args.postData = {
            "goodsId": util.cookie.get("goodsid")
        };
    }

    // 将参数转成全局变量
    this.postData = args.postData;
    // 数据缓存
    this.renderTo.data("args", args);
    // 获取数据
    this.byDataSource();
};

// //刷新数据
// LIST.prototype.reload = function (pageNum, pageSize) {
//     // 获取缓存数据
//     var args = this.renderTo.data("args");
//     // 将调用时传递的pageNum和pageSize赋值给用户传递的args数据
//     if (pageNum) {
//         args.postData.goodsId = goodsId;
//     }
//     // 重新渲染数据
//     this.init(args);
// };

/**
 * 根据数据源获取数据
 */
IMG.prototype.byDataSource = function () {
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
IMG.prototype.build = function () {
    // 清空当前渲染区域
    this.renderTo.html("");
    // 获取渲染区域
    this.renderTo.addClass("goods");
    var v = this;

    $('<img class="img" src="imgas/xiaomi9Pro.jpg" alt=""/>').appendTo(this.renderTo);



    $.each(v.requData.rows, function (i, items) {
        var tr = new Array();

        tr.push('<img class="img" src="imgas/xiaomi9Pro.jpg" alt=""/>');
        tr.push('<ul>');
        tr.push('<li><img src="imgas/xiaomi9Pro.jpg" alt=""/></li>');
        tr.push('<li><img src="imgas/xiaomi9Pro.jpg" alt=""/></li>');
        tr.push('<li><img src="imgas/xiaomi9Pro.jpg" alt=""/></li>');
        $(tr.join("")).appendTo(limit_tbody);

    });

};