$(function () {
    $("#regiBut").click(function () {
        registered();
    });

    // 键盘按下事件
    $(window).keydown(function (e) {

        // 回车键
        if (e.keyCode == "13") {
            // 调用登录方法
            registered();
        }
    });

    //	输入框失去焦点事件
    $("input[type='text'],input[type='password']").blur(function () {
        checkText($(this));
    }).focus(function () {
        hideErrorTips($(this));
    });
});

//验证输入框数据
function checkText(obj) {

    var msg = "";
    var isHasError = true;
//	验证数据是否为空
    if (obj.val() == "") {
        msg = "" + obj.attr("placeholder");

        isHasError = false;
    }
//	验证数据是否合法	
    if (!util.validata(obj.val(), obj.attr("validata"))) {
        // 数据不合法
        msg = "只能是：" + obj.attr("validataStr");
        isHasError = false;
    }

    if (obj.val().trim().length > 16 || obj.val().trim().length < 4) {
        msg = "长度之只能是4-16位";
        isHasError = false;
    }

    return isHasError ? hideErrorTips(obj) : showErrorTips(obj, msg);
}

/**
 * 显示错误提示信息
 * @param {Object} obj
 * @param {Object} msg
 * @return {TypeName}
 */
function showErrorTips(obj, msg) {
//	给当前边框加上错误样式
    obj.addClass("boder-error");
//	获取当前对象的后一个兄弟节点
    var nextObj = obj.next();

    nextObj.removeClass("hidden").css("opacity", "0");

    obj.next().text(msg);

    setTimeout(function () {
        nextObj.css({
            "right": "0.65em",
            "opacity": "1"
        });
    }, 1);
    return 1;
};

/**
 * 隐藏错误提示信息
 * @param {Object} obj
 * @return {TypeName}
 */
function hideErrorTips(obj) {
    obj.removeClass("boder-error");

    var nextObj = obj.next();

    nextObj.css({
        "right": "-0.5em",
        "opacity": "0"
    });

    setTimeout(function () {
        nextObj.addClass("hidden");
    }, 250);
    return 0;
};

/**
 * 注册事件
 */
function registered() {

    var count = 0;

    $("input[type='text'],input[type='password']").each(function () {

        count += checkText($(this));
    });

    if (count > 0) {
        return;
    }

    if ($("#btn-login").hasClass("btn-success") || $("#btn-login").hasClass("btn-error")) {
        return;
    }


//		获取帐号
    var logName = $("#name").val();
//		获取密码
    var logPwd = $("#pwd").val();

    $.post("../servlet/RegisteredServel.action", {
        "loginName": logName,
        "loginPwd": logPwd
    }, function (res) {
        if (res.isSuccess == "true") {
//				注册成功
            $("#regiBut").addClass("btn-success").val(res.message);
//				一段时间之后，跳转页面
            setTimeout(function () {
//				注册成功，跳转页面
                location.href = "login.jsp";
            }, 1000);
        } else {
//				注册失败
            $("#regiBut").addClass("btn-error").val(res.message);
//				一段时间之后，将按钮设置为默认状态
            setTimeout(function () {
//				失败，
                $("#regiBut").removeClass("btn-error").val("立即注册");
            }, 1500);
        }
    }, "json");
}