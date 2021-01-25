/**
 * 组件封装
 * @param {Object} args 参数
 * @memberOf {TypeName}
 */
function DDL(args) {
    //	异常信息处理
    try {
        if (!args.renderTo) {
            throw ("组件加载失败，renderTo值为空");
        }

        if (!args.dataSource) {
            throw ("组件加载失败，dataSource值为空");
        }

        this.init(args);
        //	捕获异常，弹出
    } catch (e) {
        alert(e);
    }

};


/**
 * 数据初始化
 * 将参数中的属性，转成成员变量及方法
 * @param {Object} args
 */
DDL.prototype.init = function (args) {
//	将属性转成全局变量
//	this.renderTo = args.renderTo;
//	this.dataSource = args.dataSource;
//	this.build();
    this.renderTo = $("#" + args.renderTo);
//	数据库请求数据
    this.dataSource = args.dataSource;
//	预加载
    this.prevLoadItem = args.prevLoadItem == undefined ? null : args.prevLoadItem;
//	默认选项
    this.defaultSelect = args.defaultSelect;
//	映射
    this.mappin = args.mappin ? args.mappin : {"key": "id", "value": "name"};
//	列表弹出方向
    this.direction = args.direction == "dow" ? "top" : "bottom";
//	自定义单击事件
    this.onClik = args.onClik ? args.onClik : function () {
    };
    this.offset = args.offset ? args.offset : 1.3;

    this.onComplate = args.onComplate ? args.onComplate : function () {
    };

    this.byDataSource();
};

DDL.prototype.byDataSource = function () {
    var v = this;
    if (typeof this.dataSource == 'string') {
        $.post(this.dataSource, {}, function (res) {
            v.dataSource = res;
            v.build();

        }, "json");


    } else {
        v.build();
    }
};

/**
 * 创建页面元素
 * @param {Object} init
 */
DDL.prototype.build = function () {
    //	获取渲染区域
//	this.renderTo = document.getElementById(this.renderTo);
    //	给渲染区域添加class；
//	this.renderTo.className = "ddl-title";

    this.renderTo.addClass("ddl-title");


    // 创建下拉列表组件的 head
//	this.ddlTitle = document.createElement("div");
//	//	为ddlTitle添加class属性
//	this.ddlTitle.className = "list";
//	//	将div渲染到区域
//	this.renderTo.appendChild(this.ddlTitle);

    this.ddlTitle = $('<div class="list"></div>').appendTo(this.renderTo);


    //	默认选中项
//	this.ddlSelectText = document.createElement("span");
//	//	添加ID
//	this.ddlSelectText.id = "ddl-select-text";
//	//	添加内容
//	this.ddlSelectText.innerText = "请选择";
//	//	添加进父元素
//	this.ddlTitle.appendChild(this.ddlSelectText);

    this.ddlSelectText = $('<span class = "head" id="ddl-select-text">请选择</span>')
        .appendTo(this.ddlTitle);


    //	右侧三角图表
//	this.arrow = document.createElement("span");
//	//	添加class值
//	this.arrow.className = "list-arrow";
//	//	添加进父元素
//	this.ddlTitle.appendChild(this.arrow);

    this.arrow = $('<span class="list-arrow"></span>')
        .appendTo(this.ddlTitle);


    //	创建ul
//	this.itemList = document.createElement("ul");
//	//	添加class值
//	this.itemList.className = "item-list hidden";
//	//	添加进父元素
//	this.renderTo.appendChild(this.itemList);

    this.itemList = $('<ul class="item-list hidden"></ul>')
        .appendTo(this.renderTo);

    //	预加载
//	var li = document.createElement("li");
//	li.className = "item";
//	li.innerText = "请选择";
//	//	添加进ul
//	this.itemList.appendChild(li);


    if (this.prevLoadItem) {
//		var li = $('<li class="item">'+ this.prevLoadItem.name +'</li>')
//	.appendTo(this.itemList);

        this.dataSource = this.prevLoadItem.concat(this.dataSource);
    }
    //	创建选项列表
//	for ( var i = 0; i < this.dataSource.length; i++) {
//		//		获取li标签属性
//		var li = document.createElement("li");
//
//		li.className = "item";
//		//		赋值给li标签
//		li.innerText = this.dataSource[i];
//		//		添加进ul
//		this.itemList.appendChild(li);
//	}

    var v = this;

    $.each(v.dataSource, function (i, item) {
//		alert(item);
        var li = $('<li class="item" data-index = "' + item[v.mappin.key] + '">' + item[v.mappin.value] + '</li>')
            .appendTo(v.itemList);
    });
//	默认选中项
    v.select($("li[data-index = '" + this.defaultSelect + "']", this.renderTo));

    //	调用事件
    this.bindEvent();
}
/**
 * 事件绑定
 * @memberOf {TypeName}
 */
DDL.prototype.bindEvent = function () {
    //	获取组件的值
    var v = this;
//	//	控制下拉列的显示与隐藏
//	this.renderTo.addEventListener("click", function() {
//		//		判断下拉列是否隐藏
//			//		已经隐藏
//			if (v.itemList.className.indexOf("hidden") > 1) {
//				//			显示
//				v.itemList.className = "item-list";
//			} else {
//				//			隐藏
//				v.itemList.className = "item-list hidden"
//			}
//		});
    this.renderTo.click(function () {
        if (v.itemList.hasClass("hidden")) {
            v.show();
        } else {
            v.hide();
        }
    });

    //获取渲染区域的所有li标签
//	var arrItem = this.renderTo.getElementsByClassName("item");
//	//单击事件
//	v.itemList.addEventListener("click", function(e) {
//		//获取当前选中项
//			var li = e.target;
//			//替换文字
//			v.ddlSelectText.innerText = li.innerText;
//			//清空选中项css样式
//			for ( var i = 0; i < arrItem.length; i++) {
//				arrItem[i].className = "item";
//
//			}
//			//为选中项添加样式	
//			li.className = "item item-select";
//		});
    $(".item", v.renderTo).click(function () {

        var li = $(this);
        v.select(li);

//		v.ddlSelectText.text(li.text());
//		$(".item",v.renderTo).removeClass("item-select");
//		
//		li.addClass("item-select");
        v.onClik({
            "id": li.attr("data-index"),
            "name": li.text()
        });
    });

    // 调用组件加载完成事件
    this.onComplate();
};

/**
 * 列表显示特效
 * @param {Object} li
 * @memberOf {TypeName}
 */
DDL.prototype.select = function (li) {
    var v = this;
    v.ddlSelectText.text(li.text());
    $(".item", v.renderTo).removeClass("item-select");

    li.addClass("item-select");

};

/**
 * 列表弹出事件
 * @memberOf {TypeName}
 */
DDL.prototype.show = function () {
    var v = this;

    v.itemList.css(v.direction, "1.3em").removeClass("hidden");

    setTimeout(function () {
        v.itemList.css(v.direction, 1.3 + v.offset + "em").css("opacity", 1);
//		v.itemList.css({
//			"top":"2.6em",
//			"opactiy":"1"
//		});
    }, 1);
}
/**
 * 列表收回事件
 * @memberOf {TypeName}
 */
DDL.prototype.hide = function () {
    var v = this;
    v.itemList.css(v.direction, 1.3 + v.offset + "em").css("opacity", 0);
//	v.itemList.css({
//		"top":"1.6em",
//		"opactiy":"0"
//	});
    setTimeout(function () {
        v.itemList.addClass("hidden");
    }, 250);

}

























