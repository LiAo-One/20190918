$(function () {

    top.editBtn = $(".edit");
    top.removeBtn = $(".delet");

    loadGird();
    // 	给查询按钮绑定点击事件
    $(".select").click(function () {
        loadGird();
    });
});

function loadGird() {

    //	获取查询参数
    var userId = $("#userId").val();//用户ID
    var userName = $("#userName").val();//用户姓名
    var godosName = $("#godosName").val();//商品名称
    var numbering = $("#numbering").val();//订单编号

    top.goodsGird = new TAL({
        "renderTo": "shoppingCart",
        "requData": "manager/servlet/OrderSelectServlet.action",
        "dataSource": [{
            "name": "userid",
            "text": "用户ID"
        }, {
            "name": "userName",
            "text": "用户姓名"
        }, {
            "name": "productName",
            "text": "商品名称"
        }, {
            "name": "img",
            "text": "商品图片",
            "fomatter": function (value) { // 格式化数据

                // value : 图片对象 数组

                var str = "<img class='grid-img' src='goodsimg/" + value[0].name + "'/>";

                return str;
            },
        }, {
            "name": "pric",
            "text": "单价"
        }, {
            "name": "quantity",
            "text": "数量"
        }, {
            "name": "totalPric",
            "text": "总价"
        }, {
            "name": "numbering",
            "text": "订单编号",
        }, {
            "name": "situation",
            "text": "状态"
        }, {
            "name": "createTime",
            "text": "时间"
        }],
        "dblclick": function (obj) {
            alert(obj.id);
        },
        "postData": { // 请求参数
            "userId": userId,
            "userName": userName,
            "godosName": godosName,
            "numbering": numbering
        },
        "onClick": function (row) {
            // 点击一行之后，弹出当前点击行的id
            top.editObject = {};

            // 获取选中行数据 	获取选中行中每一个td
            $(".td-select > td", $("#shoppingCart")).each(function (i, item) {

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



























