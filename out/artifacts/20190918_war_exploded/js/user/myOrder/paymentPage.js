$(function () {
    // 获取cookie中的价格
    var price = util.cookie.get("primaryPrice");
    // 获取地址
    var address = util.cookie.get("address");
    // 电话
    var phone = util.cookie.get("phone");
    // 姓名
    var addname = util.cookie.get("addname");
    // 拼接收获信息
    var aaa = "收货信息：" + addname + " " + phone + "";
    var bbb = "" + address + "";
    var adddd = aaa += bbb;
    // 赋值
    $(".post-info").text(adddd);
    // 价格
    $(".money em").text(price);

    // 付款单击事件
    $(".clearfix").on("click", "li", function () {
        $.post("../../../manager/servlet/UserOrderPay.action", {
            // 参数
            "userPay": price
        }, function (res) {
            if (res.isSuccess == "true") {
                // 成功
                console.log(">>>>");
                alert(res.message)
                $.post("../../../manager/servlet/UserOrderSettlement.action", {
                    "userAddress": address
                }, function (res) {
                    if (res.isSuccess == "true") {
                        console.log(">>>>>");
                        // 提交成功
                        // 获取要结算的价格 并存入Cookies
                        util.cookie.set("primaryPrice", goodsNum);
                    } else {
                        console.log("<<<<<");
                    }

                }, "json")
            } else {
                // 失败
                console.log("<<<<");
                alert(res.message)
            }
        }, "json")
    });

    // 充值单击事件
    $(".event-desc").on("click", ".Recharge", function () {
        // 获取输入框金额
        var money = $("#rechargeMoney").val();
        // 验证文本输入
        var reg = /^[1-9]\d*$|^0$/;
        if (reg.test(money) == false) {
            alert("金额输入错误");
        } else {
            $.post("../../../manager/servlet/UserRechargs.action", {
                // 参数
                "Rechargs": money
            }, function (res) {
                // 判断结果
                if (res.isSuccess == "true") {
                    // 成功
                    console.log(">>>>");
                    alert(res.message)
                } else {
                    // 失败
                    console.log("<<<<");
                    alert(res.message)
                }
            }, "json")
        }
    });

});