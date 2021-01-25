$(function () {

    top.editBtn = $(".edit");
    top.removeBtn = $(".delet");

    // 表格初始化事件
    loadGird();

    //查询按钮单击事件

    $(".select").click(function () {
        loadGird();
    });

    // 	给添加按钮绑定点击事件
    $(".add").click(function () {
        if ($(".add").hasClass("btn-disable")) {
            alert("请选择一行数据");
            return;
        }
        top.isEdit = false;
        // 出现对话框 top:定层父页面
        top.dialog.show({
            "text": "添加商品",
            "add": "Add/goodsAdd.jsp",
            "width": 60,
            "height": 24.25
        });

    });

    // 	给编辑按钮绑定点击事件
    $(".edit").click(function () {
        if ($(".edit").hasClass("btn-disable")) {
            alert("请选择一行数据");
            return;
        }
        top.isEdit = true;
        // 出现对话框 top:定层父页面
        top.dialog.show({
            "text": "修改商品",
            "add": "Add/goodsAdd.jsp",
            "width": 60,
            "height": 24.25
        });
    });

    // 	给删除按钮绑定点击事件
    $(".delet").click(function () {
        if ($(".delet").hasClass("btn-disable")) {
            alert("请选择一行数据");
            return;
        }
        // 出现对话框 top:定层父页面
        top.dialog.show({
            "text": "删除",
            "confrim": true,
            "width": 20,
            "height": 9.2,
            "onClickYes": function () {
                $.post("servlet/GoodsDeleteServlet.action", {
                    "id": top.editObject.id
                }, function (res) {

                    // 定义提示信息样式
                    var tipsStyle;

                    if (res.isSuccess == "true") {
                        //				alert(res.message);

                        // 设置信息样式为 success
                        tipsStyle = "tips-success";
                        // 刷新表格
                        top.goodsGird.reload(1, 10);

                        // 隐藏对话框
                        top.dialog.hide();
                    } else {
                        //				alert(res.message);
                        // 设置信息样式为 success
                        tipsStyle = "tips-success";
                    }

                    // 显示提示信息组件
                    top.dialogTips.show({
                        "message": res.message,
                        "tipsStyle": tipsStyle
                    });
                    // 一段时间之后，提示信息隐藏
                    setTimeout(function () {
                        top.dialogTips.hide();
                    }, 2000);
                }, "json");
            }
        });
    });

    loadGird();

});

function loadGird() {

    //	获取查询条件数据
    var goodsPrice = $("#goodsPrice").val();//ID
    var goodsName = $("#goodsName").val();//ID
    var category = $(".item-select").attr("data-index");
    if (category == "-1") {
        category = "";
    }
    var store = $("#store").val();//ID


    top.goodsGird = new TAL({
        "renderTo": "goods",
        "requData": "servlet/GoodsSelectServle.action",
        "dataSource": [{
            "name": "id",
            "text": "商品ID"
        }, {
            "name": "productName",
            "text": "商品名称"
        }, {
            "name": "idcode",
            "text": "类别ID"
        }, {
            "name": "price",
            "text": "价格",
            "fomatter": function (value) { // 格式化数据
                var str = "$"+value;

                return str;
            },
            // 元素对齐方式
            "align": "right",
            // 元素隐藏
            "hide": false
        }, {
            "name": "salesVolume",
            "text": "销量"
        }, {
            "name": "inStock",
            "text": "库存",
            // 元素隐藏
            "hide": true

        }, {
            "name": "factory",
            "text": "厂家",
            // 元素隐藏
            "hide": true
        }, {
            "name": "store",
            "text": "店家"
        }, {
            "name": "shelflife",
            "text": "保质期",
            // 元素隐藏
            "hide": true
        }, {
            "name": "situation",
            "text": "状态",
            // 元素隐藏
            "hide": true
        }, {
            "name": "createTime",
            "text": "创建时间",
            // 元素隐藏
            "hide": true
        }, {
            "name": "Discount",
            "text": "折扣",
            // 元素隐藏
            "hide": true

        }, {
            "name": "img",
            "text": "图片",
            // 元素隐藏
            "hide": true

        }, {
            "name": "imgList",
            "text": "商品图片",
            "fomatter": function (value) { // 格式化数据

                var str = "";
                if(value.length > 0){
                	 // value : 图片对象 数组
                // 遍历图片数组，取出 每一个图片对象
                $(value).each(function (i, item) {
                    str += "<img class='grid-img' src='goodsimg/" + item.name + "'/>";

                });
                }else{
                	str = "图片开小差了"
                }
               
                return str;
            },
            "dateValueFomatter": function (value) { // data-value 数据格式化
                var str = "";
                // 遍历图片数组，取出 每一个图片对象
                $(value).each(function (i, item) {
                    str += item.name + ",";

                });

                str = str.substring(0, str.length - 1);

                return str;

            }
        }, {
            "name": "post",
            "text": "是否包邮"
        }, {
            "name": "typeName",
            "text": "商品类别"
        }],
        "dblclick": function (obj) {

        },
        "postData": { // 请求参数
            "goodsPrice": goodsPrice,
            "name": goodsName,
            "category": category,
            "store": store
        },
        "onClick": function (row) {
            // 点击一行之后，弹出当前点击行的id
            // 获取td的属性名
            // 定义被修改的对象
            top.editObject = {};

            // 获取选中行数据 	获取选中行中每一个td
            $(".td-select > td", $("#goods")).each(function (i, item) {

                // 获取td的属性名
                var alias = $(item).attr("data-alias");

                // 获取td的属性值
                var value = $(item).attr("data-value");

                top.editObject[alias] = value;

                $(".btn-disable").removeClass("btn-disable");

            });

            console.log(top.editObject);
        }

    });
}
