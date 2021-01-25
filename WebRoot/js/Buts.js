/**
 * 组件封装
 * @param {Object} args 参数
 * @memberOf {TypeName}
 */
function BUT(args) {
    this.init(args);
}

BUT.prototype.init = function (args) {
    this.renderTo = $("#" + args.renderTo);
    this.dataSource = args.dataSource;
    this.onClik = args.onClik ? args.onClik : function () {
    };

    this.build();
};

BUT.prototype.build = function () {
    this.renderTo.addClass("bodys-left-but");

    var v = this;

    $.each(v.dataSource, function (i, item) {
        v.line = $('<div class="line" data-url= "' + item.url + '"></div>').appendTo(v.renderTo);
        v.butt = $('<buttom></<buttom>').appendTo(v.line);
        v.lis = $('<i class="' + item.ico + '"></i>').appendTo(v.butt);
        v.text = $('<a data-index = ' + item.name + '>' + item.name + '</a>').appendTo(v.butt);

    });

    this.hoverItem = $('<div id="hover-item" class="hover-select hidden"></div>').appendTo(v.renderTo);
    this.selectItem = $('<div id="select-item" class="hover-select"></div></div>').appendTo(v.renderTo);

    this.bindEvent();
}

BUT.prototype.bindEvent = function () {
    var v = this;
    //	鼠标移入移出事件
    $(".bodys-left-but").hover(function () {
        $("#hover-item").removeClass("hidden");
    }, function () {
        $("#hover-item").addClass("hidden");
    });


    $(".bodys-left-but").on("mouseenter", ".line", function () {
        $("#hover-item").css("top", $(this).index() * 4.31361429 + "em");
    });


    $(".line").click(function () {
        $("#select-item").css("top", $(this).index() * 4.31361429 + "em");
        v.onClik({
            url: $(this).attr("data-url")
        });
    });
}


































































