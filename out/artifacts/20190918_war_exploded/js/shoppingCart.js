//计算总价格
var sum = 0;
// 存储ID集合
var arr = new Array();

/**
 * 组件封装
 * @param {Object} args 参数
 * @memberOf {TypeName}
 */
function SHOPP(args) {
    this.init(args);
};

/**
 * 数据初始化
 * 将参数中的属性，转成成员变量及方法
 * @param {Object} args
 */
SHOPP.prototype.init = function (args) {
    //	将属性转成全局变量
    this.renderTo = $("#" + args.renderTo);
    //	数据库请求数据
    this.dataSource = args.dataSource;
    //	自定义单击事件
    //	this.onClik = args.onClik ? args.onClik : function(){};

    if (args.postData) {
        // 传递了请求参数
        if (!args.postData.situation) {
            args.postData.situation = "待结算";
        }

    } else {
        // 说明用户没有传递参数
        args.postData = {
            "situation": "待结算"
        };
        // 将参数转成全局变量

    }

    this.postData = args.postData;
    this.byDataSource();
};

/**
 * 根据数据源 获取数据
 */
SHOPP.prototype.byDataSource = function () {
    var v = this;
    if (typeof this.dataSource == 'string') {
        $.post(this.dataSource, v.postData, function (res) {
            console.log(res);
            v.dataSource = res;

            v.build();

        }, "json");

    } else {
        v.build();
    }
};

/**
 * 创建页面元素
 * @param {Object} init
 */
SHOPP.prototype.build = function () {
    var v = this;
    v.renderTo.addClass("size");
    $.each(v.dataSource.rows, function (i, item) {

        //		渲染区域
        v.box = $('<div shoppingid = ' + item.id + ' class="item-box"><div>').appendTo(v.renderTo);
        /*多选框*/
        v.check = $('<div class="col col-check"><div>').appendTo(v.box);

        v.i = $('<i class="chen"><i>').appendTo(v.check);

        $('<input type="checkbox" id="checkbox-1" />').appendTo(v.i);
        //		图片
        v.img = $('<div class="col col-img"></div>').appendTo(v.box);

        $('<img src="goodsimg/' + item.goodsImg + '" alt="" />').appendTo(v.img);
        //		商品名称
        v.goodsName = $('<div class="col col-name">' + item.productName + '</div>').appendTo(v.box);
        //		价格
        v.name = $('<div class="col col-pric">' + item.pric + '</div>').appendTo(v.box);
        //		数量
        v.num = $('<div class="col col-num"></div>').appendTo(v.box);

        var tr = new Array();
        tr.push('<div class="change-goods">');
        tr.push('<span id = "reduce" href="" class="J-minus">');
        tr.push('<i class="fa fa-minus" aria-hidden="true"></i>');
        tr.push('</span>');
        tr.push('<input type="text" value="' + item.quantity + '" class="J-goods-num"/>');
        tr.push('<span id = "add" href="" class="J-plus">');
        tr.push('<i class="fa fa-plus" aria-hidden="true"></i>');
        tr.push('</span>');
        tr.push('</div>');
        $(tr.join("")).appendTo(v.num);
        /*小记*/
        v.total = $('<div class="col col-total">' + item.totalPric + '</div>').appendTo(v.box);
        /*操作*/
        v.action = $('<div class="col col-action"></div>').appendTo(v.box);

        $('<i class="fa fa-times" aria-hidden="true"></i>').appendTo(v.action);

    });

    v.bindEvent();
};

SHOPP.prototype.bindEvent = function () {
    var v = this;
    // 添加数量点击事件
    $(".change-goods").on("click", ".J-plus", function () {
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
    $(".change-goods").on("click", ".J-minus", function () {
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
            // 获取购物车ID
            var goodID = $(this).parent().parent().parent().attr("shoppingid");
            //购物车修改方法
            shoppCart(currNum, sum, goodID);
        }
    });

    // 删除单击事件
    $(".col-action").on("click", ".fa", function () {

        var shoppId = $(this).parent().parent().attr("shoppingid");
        $.post("manager/servlet/deleteShoppingCart.action", {
            "shoppid": shoppId
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
    });

    // 多选单选事件
    $(".col-check").on("click", "#checkbox-1", function () {
        // 获取小计
        var price = $(this).parent().parent().next().next().next().next().next().text();
        // 获取ID
        var id = $(this).parent().parent().parent().attr("shoppingid");
        if ($(this).is(":checked")) {
            // 获取小计
            arr.push(id);
            TotalPriceAdd(price);
            console.log(arr.toString());

        } else {
            DeleteID(id);
            // 取消选中，删除ID
            TotalPriceLess(price);
        }
    });

    // 结算按钮单击事件
    $(".Settlement").on("click", ".go", function () {
        $.post("manager/servlet/SettlementShoppingCart.action", {
            "idList": arr.toString()
        }, function (res) {
            if (res.isSuccess == "true") {
                // 成功
                console.log(">>>>");
                // 判断有无选中商品
                if (sum == 0) {
                    alert("请选择一件商品");
                } else {
                    // 页面跳转
                    window.location.href = "jsp/user/myOrder/confirmOrder.jsp";
                }
            } else {
                // 失败
                console.log("<<<<");
            }
        }, "json")
    });

}

/**
 * 购物车修改方法
 * @param currNum
 * @param total
 * @param goodID
 */
function shoppCart(currNum, total, goodID) {
    $.post("manager/servlet/UpdateShoppingCart.action", {
        "quantity": currNum,
        "totalPrice": total,
        "shoppid": goodID
    }, function (res) {
        if (res.isSuccess == "true") {
            // 成功
            console.log(">>>>");
        } else {
            // 失败
            console.log("<<<<");
        }
    }, "json");
}

/**
 * 购物车删除方法
 * @param {Object} goodID
 */
function deleteshoppCart(goodID) {
    $.post("manager/servlet/deleteShoppingCart.action", {
        "shoppid": goodID
    }, function (res) {
        if (res.isSuccess == "true") {
            // 成功
            console.log(">>>>");
            // 返回删除结果
        } else {
            // 失败
            console.log("<<<<");
        }
    }, "json");
}

/**
 * 购物车单总价计算++
 * @param {Object} price
 */
function TotalPriceAdd(price) {

    sum = sum + parseFloat(price);
    $(".span2").text(sum);
}

/**
 * 购物车单总价计算--
 * @param {Object} price
 */
function TotalPriceLess(price) {
    sum = sum - parseFloat(price);
    $(".span2").text(sum);
}

/**
 * 拼接ID列表
 * @param {Object} id
 */
function DeleteID(id) {

    for (var i = 0; i < arr.length; i++) {

        if (arr[i] == id) {
            arr.splice(i, 1)
        }
    }
    console.log(arr.toString());
}
