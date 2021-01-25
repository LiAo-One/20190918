var goodsType;

$(function () {
    $(".add-goods").click(function () {

        goodsAdd();
    });

    $(".empty").click(function () {

        empty();
    });

    $("#name").focus();


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

//	回填图片删除

    $("#upload-list").on("click", "img", function () {
        $(this).remove();
    })
});

/**
 * 图片显示方法
 * @param fileName
 */
top.showImg = function (fileName) {

    $("<img class='upload-img' date-key='" + fileName + "' src='goodsimg/" + fileName + "'/>").appendTo($("#upload-list"));
};


/**
 * 清空输入框
 */
function empty() {
    //		获取名称
    $("#name").val("");
//		获取价格
    $("#price").val("");
//		获取保质期
    $("#shelflife").val("");
//		获取邮递
    $("#post").val("");
//		获取图片
    $("#img").val("");
//		获取库存
    $("#inStock").val("");
//		获取销量
    $("#salesVolume").val("");
//		获取厂家
    $("#factory").val("");
//		获取店家
    $("#store").val("");
//		获取折扣
    $("#discount").val("");
//		获取状态
    $("#situation").val("");
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

//	// 数据格式校验  util.validate(str,type)
//	if(!util.validata(obj.val(), obj.attr("validata"))){
//		
//		// 数据不和法
//		msg = "只能是："+obj.attr("validataStr");
//		obj.val("");
//		obj.attr('placeholder',msg);
//		
//	}


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
    var str = obj.attr('placeholder');

    if (str.search("请输入")) {
        obj.attr('placeholder', msg);
    }

    // 设置后一个兄弟节点 的文本
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
function goodsAdd() {
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
    if ($(".add-goods").hasClass("btn-success") || $("#btn-register").hasClass("btn-error")) {
        return;
    }


//		获取名称
    var name = $("#name").val();
//		获取价格
    var price = $("#price").val();
//		获取类别
    var category = $(".item-select").attr("data-index");
//		获取保质期
    var shelflife = $("#shelflife").val();
//		获取邮递
    var post = $("#post").val();
//		获取图片
    var img = $("#img").val();
//		获取库存
    var inStock = $("#inStock").val();
//		获取销量
    var salesVolume = $("#salesVolume").val();
//		获取厂家
    var factory = $("#factory").val();
//		获取店家
    var store = $("#store").val();
//		获取折扣
    var discount = $("#discount").val();
//		获取状态
    var situation = $("#situation").val();

    $.post(top.isEdit ? "servlet/GoodsServlet.action" : "servlet/AddGoodsServlet.action", {
        "id": top.editObject.id,
        "name": name,
        "price": price,
        "category": category,
        "shelflife": shelflife,
        "post": post,
        "img": img,
        "inStock": inStock,
        "salesVolume": salesVolume,
        "factory": factory,
        "store": store,
        "discount": discount,
        "situation": situation,
        "imgList": $("#upload-list .upload-img").map(function () {
            return $(this).attr("date-key");
        }).get().join(",")
    }, function (res) {
        // 定义提示信息样式
        var tipsStyle;

        if (res.isSuccess == "true") {
            // 设置信息样式为 success
            tipsStyle = "tips-success";
            // 刷新表格
            top.goodsGird.reload(1, 10);

            // 隐藏对话框
            top.dialog.hide();

            top.editBtn.addClass("btn-disable");
            top.removeBtn.addClass("btn-disable");
        } else {
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

//	回填名称
    $("#name").val(top.editObject.productName);
//	回填价格
    $("#price").val(top.editObject.price);
//	回填保质期
    $("#shelflife").val(top.editObject.shelflife);
//	回填邮递
    $("#post").val(top.editObject.post);
//	回填图片
    $("#img").val(top.editObject.img);
//	回填库存
    $("#inStock").val(top.editObject.inStock);
//	回填销量
    $("#salesVolume").val(top.editObject.salesVolume);
//	回填厂家	
    $("#factory").val(top.editObject.factory);
//	回填店家	
    $("#store").val(top.editObject.store);
//	回填折扣	
    $("#discount").val(top.editObject.Discount);
//	回填状态	
    $("#situation").val(top.editObject.situation);


    // 获取 图片路径
    var imgList = top.editObject.imgList;
    $(imgList.split(",")).each(function (i, item) {
        top.showImg(item);
    });

    // 回填商品类型top.editObject.typeId
    goodsType.select($(".item[data-index='" + top.editObject.idcode + "']", $("#myddl")));


}

















