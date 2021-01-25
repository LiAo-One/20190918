$(function () {

// 获取cookie中的数据，进行回填
    var userName = util.cookie.get("userName");
    var userPwd = util.cookie.get("userPwd");
//	回填
    if (userName == "") {
        $("#loginName").focus();
    } else {
        $("#loginName").val(userName);
        $("#loginPwd").val(userPwd);
//		选中  记住密码
        $("#checkme").prop("checked", true);
    }

    $("#logBut").click(function () {
        login();
    });
    // 键盘按下事件
    $(window).keydown(function (e) {

        // 回车键
        if (e.keyCode == "13") {
            // 调用登录方法
            login();
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
    var flag = true;
    if (obj.val() == "") {
        msg = "请输入" + obj.attr("placeholder");

        flag = false;
    }

    return flag ? hideErrorTips(obj) : showErrorTips(obj, msg);
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


// 登录事件
function login() {
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
    var logName = $("#loginName").val();
//		获取密码
    var logPwd = $("#loginPwd").val();

    $.post("servlet/LogingSelectServlet.action", {
        "loginName": logName,
        "loginPwd": logPwd
    }, function (res) {
        if (res.isSuccess == "true") {
//				登录成功
//				登录成功，将用户数据进行存储
//				判断"记住密码"checkbox是否选中，如果选中则记住数据，如果没有选中则清空数据
//				util.cookie.set("userName", $("#logBut").is(":checked") ? logName : "" );
            util.cookie.set("userName", logName);
            util.cookie.set("userPwd", logPwd);
            $("#logBut").addClass("btn-success").text(res.message);
//				一段时间之后，跳转至管理页面
            setTimeout(function () {
//				登录成功，跳转至管理页面
                location.href = "jsp/homes.jsp";
            }, 1000);

        } else {
            $("#logBut").addClass("btn-error").text(res.message);
//				一段时间之后，将按钮设置为默认状态
            setTimeout(function () {
//				登录失败，
                $("#logBut").removeClass("btn-error").text("登录");
            }, 1500);
        }
    }, "json");
}




















