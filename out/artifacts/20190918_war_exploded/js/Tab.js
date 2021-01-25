/**
 * 组件封装
 * @param {Object} args
 * @memberOf {TypeName}
 */
function TAB(args) {
    //	异常信息处理
    try {
        if (!args.renderTo) {
            throw ("组件加载失败，renderTo值为空");
        }

        if (!args.dataSou) {
            throw ("组件加载失败，dataSou值为空");
        }

        this.init(args);
        //		捕获异常，弹出
    } catch (e) {
        alert(e);
    }
    
    
//    var index = new TAB({
//        "renderTo": "myddl",
//        "dataSou": [{
//            "id": "1",
//            "name": "商品详情",
//            "url": "jsp/goods/goodsDetails.jsp"
//        }, {
//            "id": "2",
//            "name": "商品评论",
//            "url": "jsp/goods/goodsComment.jsp"
//        }, {
//            "id": "3",
//            "name": "售后保障",
//            "url": "jsp/goods/afterSale.jsp"
//        }],
//        "onClik": function (obj) {
//            $("#manager-page").attr("src", obj.url);
//        }
//    });

}

/**
 * 数据初始化
 * 将参数中的属性，转成成员变量及方法
 * @param {Object} args
 * @memberOf {TypeName}
 */
TAB.prototype.init = function (args) {
    //	将属性转为全局变量
    this.renderTo = $("#" + args.renderTo);
    this.dataSou = args.dataSou;
    this.asd = args.asd;
    this.onClik = args.onClik ? args.onClik : function () {
    };
    this.byDataSource();

};

TAB.prototype.byDataSource = function () {
    var v = this;
    if (typeof this.dataSou == 'string') {
        $.post(this.dataSou, {}, function (res) {
            console.log(res);
            v.dataSou = res;
            v.build();

        }, "json");


    } else {
        v.build();
    }
};
/**
 * 创建页面元素
 * @memberOf {TypeName}
 */
TAB.prototype.build = function () {
    //	获取渲染区域
    this.renderTo.addClass("help");
    //	创建ul

    this.itemList = $('<ul class = "title" id="title"></ul>').appendTo(this.renderTo);

    var v = this;

    $.each(v.dataSou, function (i, item) {
        var li = $('<li class="lable" data-url = ' + item.url + ' data-index = ' + item.id + '>' + item.name + '</li>')
            .appendTo(v.itemList);
    });

//    this.hoverItem = $('<div id="hover-item" class="hover-select hidden"></div>')
//        .appendTo(v.renderTo);


    this.bindEvent();
}
/**
 * 绑定事件
 */
TAB.prototype.bindEvent = function () {

    var v = this;

    //	鼠标移入移出事件
    $(".title").hover(function () {
        $("#hover-item").removeClass("hidden");
    }, function () {
        $("#hover-item").addClass("hidden");
    });


    $(".title").on("mouseenter", ".lable", function () {
        $("#hover-item").css("left", $(this).index() * 5.99285714 + "em");
    });


//	单击事件
    $(".lable", v.renderTo).click(function () {

        var li = $(this);
        $(".lable", v.renderTo).removeClass("lis");
        li.addClass("lis");
        v.onClik({
            url: $(this).attr("data-url")
        });
    });
};










