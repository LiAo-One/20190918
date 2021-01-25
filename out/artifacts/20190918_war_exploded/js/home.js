// 定义全局变量
var dialog;

var dialogTips;

// 商品表格全局变量
var goodsGird;

// 定义全局变量editObject
var editObject = {"id": "0"};

var showImg;

// 定义全局变量 判断当前是添加还是修改
var isEdit;
$(function () {

// 	使用对话框组件 并给全局变量赋值
    dialog = new Dialog({
        "renderTo": "dialog"
    });

    // 实例化 提示信息组件
    dialogTips = new Tips({
        "renderTo": "dialog-tips"
    });


//	鼠标移入移出事件
    $(".bodys-left-but").hover(function () {
        $("#hover-item").removeClass("hidden");
    }, function () {
        $("#hover-item").addClass("hidden");
    });

    $(".bodys-left-but").on("mouseenter", ".line", function () {
        $("#hover-item").css("top", $(this).index() * 61 + "px");
    });

    $(".line").click(function () {
        $("#select-item").css("top", $(this).index() * 61 + "px");
    });

    // 退出按钮点击事件
    $("#esc").click(function () {
        $.post("../servlet/UserExitServlet.action", {}, function (res) {
            location.href = "login.jsp";

        });

    });
});