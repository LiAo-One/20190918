var goodsId = util.cookie.get("goodsid")

/**
 * 组件封装
 * @param {Object} args 参数
 * @memberOf {TypeName}
 */
function COMM(args) {

//	异常信息处理
    try {
        if (!args.renderTo) {
            throw ("组件加载失败，renderTo值为空");
        }
//
//		if (!args.dataSource) {
//			throw ("组件加载失败，dataSource值为空");
//		}

        this.init(args);
        //	捕获异常，弹出
    } catch (e) {
        alert(e);
    }
};

/**
 * 数据初始化
 * 将参数中的属性，转成成员变量及方法
 * @param {Object} args
 */
COMM.prototype.init = function (args) {
//	将属性转成全局变量
    this.renderTo = $("#" + args.renderTo);
    this.build();
};

/**
 * 创建页面元素
 * @param {Object} init
 */
COMM.prototype.build = function () {
	var v = this;
    $.post("manager/servlet/GoodsIdCommernt.action", {
        "goodsId": goodsId
    }, function (res) {
        v.renderTo.addClass("list-boy");
        $.each(res.rows, function (i, item) {
            //		渲染区域
            v.info = $('<div class="comment-info"><div>')
                .appendTo(v.renderTo);
            /*头像*/
            v.img = $('<img alt="" src="imgas/'+ item.userImg +'">')
                .appendTo(v.info);
            /*昵称*/
            v.name = $('<span class="name">'+ item.userName +'</span>')
                .appendTo(v.info);
            /*时间*/
            $('<span class="time">****-**-**</span>')
                .appendTo(v.info);
//			满意度
            v.span = $('<span class="eval">超爱</span>')
                .appendTo(v.info);

            $('<i class="fa fa-smile-o" aria-hidden="true"></i>')
                .appendTo(v.span);
//			评论语句
            v.clike = $('<a href="">'+ item.fell +'</a>')
                .appendTo(v.info);

            var tr = new Array();
            tr.push('<div class="img">');
            tr.push('<img src="imgas/comment/1569722086_3265118_s1984_1488wh.jpg" alt="" />');
            tr.push('<img src="imgas/comment/1569722086_3265118_s1984_1488wh.jpg" alt="" />');
            tr.push('<img src="imgas/comment/1569722086_3265118_s1984_1488wh.jpg" alt="" />');
            tr.push('</div>');
            $(tr.join("")).appendTo(v.info);
        });

    }, "json");


    v.bindEvent();
};

COMM.prototype.bindEvent = function () {


};


//function IMG(args) {
//    this.init(args);
//}
//
//LIST.prototype.init = function (args) {
//    this.renderTo = $("#" + args.renderTo);
//    this.requData = args.requData;
//    this.onClick = args.onClick ? args.onClick : function () {
//    };
//
//    if (args.postData) {
//        // 传递了请求参数
//        if (!args.postData.goodsId) {
//            args.postData.goodsId = 1;
//        }
//    } else {
//        // 说明用户没有传递参数
//        args.postData = {
//            "goodsId": 1
//        };
//    }
//
//    // 将参数转成全局变量
//    this.postData = args.postData;
//    // 数据缓存
//    this.renderTo.data("args", args);
//    // 获取数据
//    this.byDataSource();
//};
//
///**
// * 根据数据源获取数据
// */
//LIST.prototype.byDataSource = function () {
//    var v = this;
//    if (typeof this.requData == 'string') {
//        $.post(this.requData, v.postData, function (res) {
//            console.log(res);
//            v.requData = res;
//            v.build();
//
//        }, "json");
//    } else {
//        v.build();
//    }
//};
//
///**
// * 创建页面元素
// */
//LIST.prototype.build = function () {
//    // 清空当前渲染区域
//    var v = this;
//    var goodsId = util.cookie.get("goodsid");
//
//    $.each(v.requData.rows, function (i, items) {
//        var tr = new Array();
//
//        tr.push('<img class="img" src="imgas/xiaomi9Pro.jpg" alt=""/>');
//        tr.push('<ul>');
//        tr.push('<li><img src="imgas/xiaomi9Pro.jpg" alt=""/></li>');
//        tr.push('<li><img src="imgas/xiaomi9Pro.jpg" alt=""/></li>');
//        tr.push('<li><img src="imgas/xiaomi9Pro.jpg" alt=""/></li>');
//        $(tr.join("")).appendTo(limit_tbody);
//
//    });
//
//};




































