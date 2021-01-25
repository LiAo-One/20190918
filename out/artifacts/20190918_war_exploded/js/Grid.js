function TAL(args) {
    try {
        if (!args.renderTo) {
            throw ("组件加载失败，renderTo值为空");
        }

        if (!args.dataSource) {
            throw ("组件加载失败，dataSource值为空");
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


/**
 * 数据初始化
 * @param {Object} args
 */
TAL.prototype.init = function (args) {
    this.renderTo = $("#" + args.renderTo);
    this.dataSource = args.dataSource;
    this.requData = args.requData;
    this.onClick = args.onClick ? args.onClick : function () {
    };

    if (args.postData) {
        // 传递了请求参数
        if (!args.postData.pageNum) {
            args.postData.pageNum = 1;
        }

        if (!args.postData.pageSize) {
            args.postData.pageSize = 10;
        }
    } else {
        // 说明用户没有传递参数
        args.postData = {
            "pageNum": 1,
            "pageSize": 10
        };
    }

    // 将参数转成全局变量
    this.postData = args.postData;
    // 数据缓存
    this.renderTo.data("args", args);
    // 获取数据
    this.byDataSource();
};

// 表格刷新
TAL.prototype.reload = function (pageNum, pageSize) {

    // 获取缓存数据
    var args = this.renderTo.data("args");

    // 将调用时传递的pageNum和pageSize赋值给用户传递的args数据
    if (pageNum) {
        args.postData.pageNum = pageNum;
    }

    if (pageSize) {
        args.postData.pageSize = pageSize;
    }

    // 重新渲染数据
    this.init(args);

};

/**
 * 根据数据源 获取数据
 */
TAL.prototype.byDataSource = function () {
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
/**
 * 创建页面元素
 */
TAL.prototype.build = function () {
    // 清空当前渲染区域
    this.renderTo.html("");
//  获取渲染区域
    this.renderTo.addClass("table");


//	创建表格
    this.taltable = $('<table border="1"></table>').appendTo(this.renderTo);

    this.talbory = $('<tbody></tbody>').appendTo(this.taltable);
//	表格标题
    this.taltr = $('<tr></tr>').appendTo(this.talbory);
//	循环为标题赋值；
    var v = this;
    $.each(v.dataSource, function (i, item) {
        var th = $('<th>' + item.text + '</th>').appendTo(v.taltr);

        if (item.hide) {
            th.addClass("hidden");
        }
    });
//	循环为表格内容赋值
    $.each(v.requData.rows, function (i, items) {
        var items = items;
        v.taltrs = $('<tr class = "tr-item"></tr>').appendTo(v.talbory);
        $.each(v.dataSource, function (i, item) {
            // 取出数据
            var newText = oldText = items[item.name];

            // 如果当前列下存在fomatter属性，说明用户希望这里的数据需要格式化
            if (item.fomatter) {

                // 调用格式化方法
                newText = item.fomatter(oldText);

            }

            if (item.dateValueFomatter) {
                oldText = item.dateValueFomatter(oldText);
            }

            var td = $('<td data-alias = ' + item.name + ' data-value= ' + oldText + '>' + newText + '</td>').appendTo(v.taltrs);

            if (item.align) {
                td.addClass("align-" + item.align);
            }

            if (item.hide) {
                td.addClass("hidden");
            }
        });

    });

    var page_limit = $('<table class="page-limit"></table>').appendTo(this.renderTo);
    var limit_tbody = $('<tbody></tbody>').appendTo(page_limit);
    var tr = new Array();
    tr.push('<tr>');
    tr.push('<td class="total-td">总条数:<span id = "total">' + v.requData.total + '</span></td>');
    tr.push('<td>每页展示:<div id = "pageSize"></div>条</td>');
    tr.push('<td class="prev-td">');
    tr.push('<button id="prevBtn">上一页</button>');
    tr.push('<span id = "curpage">' + v.postData.pageNum + '</span>/<span id = ' +
        '"totalpage">' + Math.ceil(v.requData.total / v.postData.pageSize) + '</span>');
    tr.push('<button id="nextBut">下一页</button></td>');
    tr.push('<td><input type = "text" class="go">');
    tr.push('<button class="toGo">跳转</button></td>');
    tr.push('</tr>');
    $(tr.join("")).appendTo(limit_tbody);

    this.bindEvent();
};

/**
 * 绑定事件
 */
TAL.prototype.bindEvent = function () {
    var v = this;
    $(".tr-item", v.renderTo).click(function () {
        var td = $(this);
        var tr = $("tr", v.renderTo).removeClass("td-select");
//		if(td.attr("data-alias") != null){
        td.addClass("td-select");
        // 调用自定义点击事件
        v.onClick($(this));
//		}

    });

    new DDL({
        "renderTo": $("#pageSize", v.renderTo).attr("id") + "#pageSize",
        "dataSource": [{
            "num": 10,
            "size": 10
        }, {
            "num": 20,
            "size": 20
        }, {
            "num": 30,
            "size": 30
        }],
        "mappin": {
            "key": "num",
            "value": "size"
        },
        "defaultSelect": v.postData.pageSize,
        "direction": "up",
        "offset": 1.2,
        "onClik": function (obj) {
            v.reload(1, obj.id);
        }
    });

    // 下一页按钮点击事件
    $("#nextBut", v.renderTo).click(function () {
        // 获取当前页对象
        var currPage = $("#curpage", v.renderTo);
        // 获取当前页数
        var currNum = currPage.text();
        // 获取最大页数
        var totalPage = $("#totalpage", v.renderTo).text();
        // 判断当前页数是否为最大值
        if (currNum - totalPage >= 0) {
            alert("当前已经是最大页");
        } else {
            currNum++;
            // 回填当前页
            currPage.text(currNum);
            // 刷新表格
            v.reload(currNum, v.postData.pageSize);
        }
    });

    // 上一页按钮点击事件
    $("#prevBtn", v.renderTo).click(function () {
        // 获取当前页对象
        var currPage = $("#curpage", v.renderTo);
        // 获取当前页数
        var currNum = currPage.text();

        // 获取最大页数
        var totalPage = $("#totalpage", v.renderTo).text();
        // 判断当前页数是否为最大值
        if (currNum <= 1) {
            alert("当前已经是第一页");
        } else {
            currNum--;
            // 回填当前页
            currPage.text(currNum);
            // 刷新表格
            v.reload(currNum, v.postData.pageSize);
        }
    });

    /**
     * 页面跳转
     */
    $(".toGo", v.renderTo).click(function () {

        // 获取当前页对象
        var currPage = $("#curpage", v.renderTo);
		// 获取跳转文本框的值
        var text = $(".go").val();
	    // 验证文本输入
        var reg = /^[1-9]\d*$|^0$/;
        if (reg.test(text) == false) {
            alert("文本输入错误");
        } else {
			// 转为int
            var gotext = new Number(text);
        }
        // 获取最大页数
        var totalPage = $("#totalpage", v.renderTo).text();
        // 判断当前页数是否为最大值
        if (gotext > totalPage || gotext <= 0) {
            alert("页码错误");
        } else {
            currNum = gotext;
            // 回填当前页
            currPage.text(currNum);
            // 刷新表格
            v.reload(currNum, v.postData.pageSize);
        }
    });
};

























































