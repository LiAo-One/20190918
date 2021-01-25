function Dialog(args) {

    this.init(args);
}

/**
 * 数据初始化
 */
Dialog.prototype.init = function (args) {

    // 渲染区域初始化
    this.renderTo = $("#" + args.renderTo);


};

/**
 * 创建页面元素
 */
Dialog.prototype.bluid = function () {

    this.renderTo.html("");

    // 绘制背景蒙层
    this.mask = $('<div id="dialog-mask"></div>').appendTo(this.renderTo);

    // 绘制内容部分
    this.context = $('<div id="dialog-context"></div>').appendTo(this.renderTo);

    // 绘制提示信息
    this.title = $('<div class="title"></div>').appendTo(this.context);
    this.title_text = $('<span class="title-text">' + this.text + '</span>').appendTo(this.title);
    this.close = $('<i class="fa fa-close fa-icon" id="close"></i>').appendTo(this.title);


    // 绘制嵌套页面
    this.dialog_frame = $('<div class="dialog-frame">').appendTo(this.context);

    if (this.confrim) {
        // 删除提示信息
        this.delete_content = $("<div class='delete-content'><span>确定从所有设备和云端备份删除？</span></div>").appendTo(this.dialog_frame);

        // 确认删除按钮
        this.delete_btn_list = $('<div class="remove-btn-list"> <input type="button" class="btn" id="btn-exit" value="取消" /> <input type="button" class="btn" id="btn-submit" value="确认" /> </div>').appendTo(this.dialog_frame);
    } else {
        this.dialog_page = $('<iframe class="dialog-page" src=' + this.add + ' ></iframe>').appendTo(this.dialog_frame);
    }


    this.bindEvent();
};


/**
 * 对话框事件绑定
 */
Dialog.prototype.bindEvent = function () {
    var t = this;
    // 关闭按钮点击之后，隐藏对话框
    $("#close", this.renderTo).click(function () {
        t.hide();

    });

    $("#btn-submit", this.renderTo).click(function () {
        t.onClickYes();
    });

};

/**
 * 对话框显示方式
 */
Dialog.prototype.show = function (args) {

    var t = this;
    // 设置标题提示信息
    this.text = args.text;
    this.add = args.add;

    this.width = args.width;
    this.height = args.height;

    // 初始化 删除提示信息
    this.confrim = args.confrim;
    // 实例化 删除事件 （需要判断当前是否是删除状态）
    if (this.confrim) {
        this.onClickYes = args.onClickYes;
    }

//  创建页面元素
    this.bluid();

//  在页面元素创建之后，动态设置dialog-context的宽高
    $("#dialog-context", t.renderTo).css({
        "width": t.width + "em",
        "height": t.height + "em",
        "margin-top": -4.125 + "em",
        "margin-left": -3 + "em",
    });

//  动态设置dialog-page高度
    $("#dialog-frame", t.renderTo).css("height", t.height - 2.7 + "em");

    this.mask.removeClass("hidden").css("opacity", "0");
    this.context.removeClass("hidden").css("opacity", "0");

    setTimeout(function () {

        // 动画显现
        t.mask.css({
            "opacity": 0.5
        });

        t.context.css({
            "opacity": 1
        });
    }, 10);


};


/**
 * 对话框隐藏方式
 */
Dialog.prototype.hide = function () {

    var t = this;

    // 动画显现
    t.mask.css({
        "opacity": 0
    });

    t.context.css({
        "opacity": 0
    });

    setTimeout(function () {
        t.mask.addClass("hidden").css("opacity", "0");
        t.context.addClass("hidden").css("opacity", "0");

    }, 250);


};

