var userType;

$(function () {

    $(".add-user").click(function () {

        userAdd();
    });

    $(".empty").click(function () {

        empty();
    });


    // 输入框失去焦点事件
    $("input[type='text'],input[type='password']").blur(function () {
        // 验证当前输入框 数据
        checkText($(this));
    }).focus(function () {
        // 隐藏错误提示信息
        hideErrorTips($(this));
    });

    // 上传按钮点击事件
    $(".uoload-button").click(function () {

        // 创建上传文件域 并 追加到 form表单中
        var file = $('<input type="file" name="fileName" class="hidden" />').appendTo($("form"));
        // 上传文本域点击事件
        file.click();

        // 文本域内容改变事件
        file.change(function () {

            $("form").submit();
        });


    });

    //	单击图片删除

    $("#upload-list").on("click", "img", function () {
        $(this).remove();
    })
});


/**
 * 图片显示方法
 * @param fileName
 */
top.showImg = function (fileName) {
    $("img").remove();
    $("<img class='upload-img' date-key='" + fileName + "' src='imgas/" + fileName + "'/>").appendTo($("#upload-list"));
};


/**
 * 清空输入框
 */
function empty() {
    //		获取名称
    $("#account").val("");
//		获取价格
    $("#pwd").val("");
//		获取保质期
    $("#age").val("");
//		获取邮递
    $("#img").val("");
//		获取图片
    $("#lev").val("");
//		获取库存
    $("#name").val("");
}

//验证输入框数据
function checkText(obj) {
    var msg = "";
    var isHasError = true;
    // 验证当前输入框输入是否为空
    if (obj.val() == "") {
        var str = obj.attr('placeholder');
        msg = "请输入" + str;

        // 有错误数据，将isHasError编程false
        isHasError = false;
    }

    // 数据格式校验  util.validate(str,type)
    if (!util.validata(obj.val(), obj.attr("validata"))) {

        // 数据不和法
        msg = "只能是：" + obj.attr("validataStr");
        obj.val("");
        obj.attr('placeholder', msg);

    }


    // 是否有错误数据
    return isHasError ? hideErrorTips(obj) : showErrorTips(obj, msg);


}


/**
 * 显示错误提示信息
 */
function showErrorTips(obj, msg) {

    // 给当前对象边框加上错误样式
    obj.addClass("boder-error");

    // 获取当前对象的后一个兄弟节点
    var nextObj = obj.next();


    // 设置后一个兄弟节点 的文本
    var str = obj.attr('placeholder');
    if (str.search("请输入")) {
        obj.attr('placeholder', msg);
    }

    setTimeout(function () {
        nextObj.css({
            "right": "0.65em",
            "opacity": "1"
        });
    }, 10);


    return 1;

};

/**
 * 隐藏错误提示信息
 */
function hideErrorTips(obj) {
//	// 给当前对象边框去掉错误样式
    obj.removeClass("boder-error");

    return 0;
};


// 添加事件
function userAdd() {
    var count = 0;


    $("input[type='text'],input[type='password']").each(function () {

        count += checkText($(this));
    });


    // 判断商品类型是否选择

    var goodsTypeId = $(".item-select", $("#goodsType")).attr("data-index");

    if (goodsTypeId == "-1") {
        count++;
        // 调整边框颜色
        //$(".ddl-title",$("#goodsType")).addClass("boder-error");

        showErrorTips($("#goodsType"), "请选择商品类型");
    }

    if (count > 0) {
        // 说明有错误信息
        return;
    }

    // 当按钮具有 提交样式 时 不能继续请求服务器
    if ($(".add-user").hasClass("btn-success") || $("#btn-register").hasClass("btn-error")) {
        return;
    }


//		获取帐号
    var account = $("#account").val();
//		获取密码
    var pwd = $("#pwd").val();
//		获取性别
    var sex = $(".item-select").attr("data-index");
//		获取年龄
    var age = $("#age").val();
//		获取头像
    var img = $("#img img").attr("data-index");
//		获取等级
    var lev = $("#lev").val();
//		获取姓名
    var name = $("#name").val();


    $.post(top.isEdit ? "servlet/UserServlet.action" : "servlet/AddUserServlet.action", {
        "id": top.editObject.id,
        "account": account,
        "pwd": pwd,
        "sex": sex,
        "age": age,
        "img": img,
        "lev": lev,
        "name": name
    }, function (res) {
        // 定义提示信息样式
        var tipsStyle;

        if (res.isSuccess == "true") {
            alert(res.message);
            // 刷新表格
            top.goodsGird.reload(1, 10);

            // 隐藏对话框
            top.dialog.hide();
            // 设置信息样式为 success
            tipsStyle = "tips-success";

            top.editBtn.addClass("btn-disable");
            top.removeBtn.addClass("btn-disable");
        } else {
//				alert(res.message);
            // 设置信息样式为 success
            tipsStyle = "tips-success";
        }
        // 显示提示信息组件
        top.dialogTips.show({
            "message": "",
            "message": res.message,
            "tipsStyle": tipsStyle
        });
        // 一段时间之后，提示信息隐藏
        setTimeout(function () {
            top.dialogTips.hide();
        }, 2000);
    }, "json");
}

/**
 * 修改时数据回填
 */
function fullText() {

//	回填帐号
    $("#account").val(top.editObject.loginName);
//	回填密码
    $("#pwd").val(top.editObject.loginPwd);
//	回填年龄
    $("#age").val(top.editObject.age);
//	回填头像
    $("#img").val($("#upload-list img").attr("date-key"));
//	回填等级
    $("#lev").val(top.editObject.lev);
//	回填姓名
    $("#name").val(top.editObject.nikeName);

    // 获取 图片路径
    var imgList = top.editObject.img;
    top.showImg(imgList);

//	usreType.select($(".item[data-index='"+top.editObject.sex+"']",$("#size")));

}

