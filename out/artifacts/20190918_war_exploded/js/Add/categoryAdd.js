$(function () {
//	确定按钮
    $(".add-category").click(function () {

        categoryAdd();
    });
//	清空按钮
    $(".empty").click(function () {

        empty();
    });
//	将焦点定位在id输入框
    $("#id").focus();

    // 输入框失去焦点事件
    $("input[type='text'],input[type='password']").blur(function () {
        // 验证当前输入框 数据
        checkText($(this));
    }).focus(function () {
        // 隐藏错误提示信息
        hideErrorTips($(this));
    });

    // 判断当前是修改 还是 添加
    if (top.isEdit) {
        // 说明是修改
        fullText();
    }

});


/**
 * 清空输入框
 */
function empty() {
//		获取名称
    $("#id").val("");
//		获取价格
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
function categoryAdd() {
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
    if ($(".add-create").hasClass("btn-success") || $("#btn-register").hasClass("btn-error")) {
        return;
    }
//		获取id
    var id = $("#id").val();
//		获取名称
    var name = $("#name").val();

    $.post(top.isEdit ? "servlet/CategoryServlet.action" : "servlet/AddCatrgoryServlet.action", {
        "id": id,
        "name": name,
    }, function (res) {
        // 定义提示信息样式
        var tipsStyle;

        if (res.isSuccess == "true") {
//				alert(res.message);
            // 刷新表格
            top.goodsGird.reload(1, 10);

            // 隐藏对话框
            top.dialog.hide();
            // 设置信息样式为 success
            tipsStyle = "tips-success";
            top.editBtn.addClass("btn-disable");
            top.removeBtn.addClass("btn-disable");
        } else {
            alert(res.message);
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
    $("#id").val(top.editObject.id);
//	回填密码
    $("#name").val(top.editObject.name);

    // 回填商品类型top.editObject.typeId
//	goodsType.select($(".item[data-index='"+top.editObject.typeId+"']",$("#goodsType")));


}

