/**
 * 组件封装
 * @param {Object} args 参数
 * @memberOf {TypeName}
 */
function ADD(args) {
    this.init(args);
};

/**
 * 数据初始化
 * 将参数中的属性，转成成员变量及方法
 * @param {Object} args
 */
ADD.prototype.init = function (args) {
//	将属性转成全局变量
    this.renderTo = $("#" + args.renderTo);
//	数据库请求数据
    this.dataSource = args.dataSource;
//	自定义单击事件
//	this.onClik = args.onClik ? args.onClik : function(){};

    this.build();
};


/**
 * 创建页面元素
 * @param {Object} init
 */
ADD.prototype.build = function () {
//	渲染区域
    this.renderTo.addClass("uc-main-box");
//	盒子
    this.ddlTitle = $('<div class="uc-content-box"><div>')
        .appendTo(this.renderTo);
//	hd
    this.boxHd = $('<div class="box-hd"><div>')
        .appendTo(this.ddlTitle);
//	头部文字
    this.addtext = $(' <h1 class="title">收货地址</h1>')
        .appendTo(this.boxHd);
//	bd
    this.boxBd = $('<div class="box-bd"><div>')
        .appendTo(this.ddlTitle);
//	添加地址盒子
    this.addnew = $('<div class="address-item new"></div>')
        .appendTo(this.boxBd);
//	添加地址图标
    this.ico = $('<i class="fa fa-plus-circle" aria-hidden="true"></i>').appendTo(this.addnew);

    var v = this;

    $.each(v.dataSource, function (i, item) {
        v.divs = $('<div class="address-item jadd"><div>')
            .appendTo(v.boxBd);

        v.name = $('<h1 class="name-title">' + item.name + '</h1>')
            .appendTo(v.divs);

        v.phon = $('<h1 class="add-title">' + item.phon + '</h1>')
            .appendTo(v.divs);

        v.adds = $('<h1 class="add-title">' + item.add + '</h1>')
            .appendTo(v.divs);
    });
}























