function Tips(args) {

    this.init(args);

};
/**
 * 数据初始化
 */
Tips.prototype.init = function (args) {

    // 渲染区域初始化
    this.renderTo = $("#" + args.renderTo);


};

/**
 * 提示组件显示方法
 */
Tips.prototype.build = function () {

    this.renderTo.addClass("dialog-tips");
    this.renderTo.addClass("hidden");
    this.tips_content = $('<span id="tips-content" class="tips-cls ' + this.tipsStyle + '">' + this.message + '</span>').appendTo(this.renderTo);


};

/**
 * 提示组件显示方法
 */
Tips.prototype.show = function (args) {
    this.message = args.message;
    this.tipsStyle = args.tipsStyle;

    this.build();

    $(".dialog-tips").removeClass("hidden").css({
        "top": "-1em",
        "opacity": 0
    });

    setTimeout(function () {
        $(".dialog-tips").css({
            "top": "1em",
            "opacity": 1
        });
    }, 10);


};

/**
 * 提示组件隐藏
 */
Tips.prototype.hide = function () {

    $(".dialog-tips").css({
        "top": "-1em",
        "opacity": 0
    });
    setTimeout(function () {
        $(".dialog-tips").addClass("hidden");
    }, 250);
//	删除生成的组件
    $("#tips-content").remove();

};