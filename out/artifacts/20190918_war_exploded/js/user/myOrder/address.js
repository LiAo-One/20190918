/**
 * 地址封装
 */

function ADDRESS(args) {
    try {
        if (!args.renderTo) {
            throw ("组件加载失败，renderTo值为空");
        }
        if (!args.requData) {
            throw ("组件加载失败，data值为空");
        }
        this.init(args);
        //	捕获异常，弹出
    } catch (e) {
        alert(e);
    }
};

ADDRESS.prototype.init = function (args) {
    this.renderTo = $("." + args.renderTo);
    this.requData = args.requData;
    //    this.dataSource = args.dataSource;
    //    this.onClik = args.onClik ? args.onClik : function () {
    //    };

    if (args.postData) {
        // 传递了请求参数
        if (!args.postData.situation) {
            args.postData.situation = "存在";
        }

    } else {
        // 说明用户没有传递参数
        args.postData = {
            "situation": "存在"
        };
        // 将参数转成全局变量

    }
    this.postData = args.postData;

    this.byDataSource();
};

ADDRESS.prototype.byDataSource = function () {
    var v = this;
    if (typeof this.requData == 'string') {
        $.post(this.requData, v.postData, function (res) {
            console.log(res);
            v.requData = res;
            v.build();

        }, "json");

    } else {
        v.build();
    }
};

ADDRESS.prototype.build = function () {
    // 获取渲染区域
    this.renderTo.addClass("section-body");
    this.renderTo.addClass("clearfix");
    // 循环创建单个订单
    var v = this;
    $.each(v.requData.rows, function (i, item) {
        var add = new Array();

        add.push('<div class="address-item J_addressItem" phone = ' + item.phone + ' addName = ' + item.userName + ' userAdd = ' + item.userAddress + '>');
        add.push('<dl>');
        add.push('<dt>');
        add.push('<span class="tag"></span>');
        add.push('<em class="uname">' + item.userName + '</em>');
        add.push('</dt>');
        add.push('<dd class="utel">');
        add.push('' + item.phone + '');
//		184****1502
        add.push('</dd>');
        add.push('<dd class="uaddress">');
        add.push('' + item.userAddress + '');
        add.push('<br>');
        add.push('<i>****************<i>');
        add.push('</dd>');
        add.push('</dl>');
        add.push('<a class="remove" id = ' + item.id + '>删除</a>')
        add.push('</div>');

        $(add.join("")).appendTo(v.renderTo);


    });
    var tr = new Array();
    tr.push('<div class="address-item address-item-new">');
    tr.push('<i class="fa fa-plus-circle" aria-hidden="true"></i>');
    tr.push('<br>');
    tr.push('添加地址');
    tr.push('</div>');
    $(tr.join("")).appendTo(v.renderTo);

    v.bindEvent();
}

/**
 * 绑定事件
 */
ADDRESS.prototype.bindEvent = function () {
    // 地址添加单击按钮
    $(".address-item-new").on("click", "i", function () {
        // 弹出对话框
        top.dialog.show({
            "text": "添加收货地址",
            "add": "../../Add/address.jsp",
            "width": 55,
            "height": 33.25
        });
    });

    //删除按钮单击事件
    $(".address-item").on("click", ".remove", function () {
        // 获取ID
        var id = $(this).attr("id");
        $.post("../../../manager/servlet/userAddressDelete.action", {
            // 参数
            "id": id,
            "param": "销毁"
        }, function (res) {
            // 判断结果
            if (res.isSuccess == "true") {
                // 成功
                console.log(">>>>");
                // 返回删除结果
            } else {
                // 失败
                console.log("<<<<");
            }
        }, "json")
        // 删除元素
        $(this).parent().parent().parent().remove();
    })


}