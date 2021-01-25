$(function () {

    // 清空按钮单击事件
    $(".modal-footer").on("click", ".btn-gray", function () {
        removeAddress();
    });


    // 添加按钮单击事件
    $(".modal-footer").on("click", ".btn-primary", function () {
        // 获取数据
        // 姓名
        var addName = $(".form-name input").val();
        // 电话
        var addPhone = $(".form-phone input").val();
        // 详细地址
        var address = $(".form-address-detail textarea").val();
        // 判断信息完整度
        if (addName.length == 0 || addPhone.length == 0 || address.length == 0) {
            alert("信息不完整");
        }
        // 手机号码正则判断
        var pattern = /^1[34578]\d{9}$/;
        if (pattern.test(addPhone) == false) {
            alert("手机号码输入错误");
        } else {
            // 地址提交事件
            $.post("../../manager/servlet/userAddressAdd.action", {
                // 参数
                "addName": addName,
                "addPhone": addPhone,
                "address": address
            }, function (res) {
                // 判断结果
                if (res.isSuccess == "true") {
                    // 成功
                    console.log(">>>>");
                    removeAddress();
                    alert("添加成功");
                    // 刷新界面
                    parent.location.reload()
                } else {
                    // 失败
                    console.log("<<<<");
                }
            }, "json")
        }

    });

    // 清空地址事件

    function removeAddress() {
        var addName = $(".form-name input").val("");
        // 电话
        var addPhone = $(".form-phone input").val("");
        // 详细地址
        var address = $(".form-address-detail textarea").val("");
    }

})