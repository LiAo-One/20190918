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
    var userName = $("#userName").val();//用户名称
    var userAddress = $("#userAddress").val();//用户地址
    var phone = $("#phone").val();//手机

    top.goodsGird = new TAL({
        "renderTo": "shoppingCart",
        "requData": "manager/servlet/AddressServel.action",
        "dataSource": [{
            "name": "userid",
            "text": "用户ID"
        }, {
            "name": "userName",
            "text": "用户姓名"
        }, {
            "name": "userAddress",
            "text": "用户地址"
        }, {
            "name": "phone",
            "text": "手机",
        }, {
            "name": "Remarks",
            "text": "备注"
        }, {
            "name": "situation",
            "text": "状态"
        }],
        "dblclick": function (obj) {
            alert(obj.id);
        },
        "postData": { // 请求参数
            "userId": userId,
            "userName": userName,
            "userAddress": userAddress,
            "phone": phone
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



























