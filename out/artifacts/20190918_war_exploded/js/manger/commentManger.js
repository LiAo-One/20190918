/**
 * 评论
 */
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
    var goodsName = $("#goodsName").val();//用户地址
    var mood = $("#mood").val();//手机

    top.goodsGird = new TAL({
        "renderTo": "shoppingCart",
        "requData": "manager/servlet/CommentServlet.action",
        "dataSource": [{
            "name": "userId",
            "text": "用户ID"
        }, {
            "name": "userName",
            "text": "用户姓名"
        }, {
            "name": "userImg",
            "text": "用户头像",
            "fomatter": function (value) { // 格式化数据
                // value : 图片对象 数组
                var str = "<img class='grid-img' src='imgas/" + value + "'/>";

                return str;
            },
        }, {
            "name": "goodsName",
            "text": "商品名称",
        }, {
            "name": "mood",
            "text": "满意度"
        }, {
            "name": "fell",
            "text": "语句"
        }, {
            "name": "situation",
            "text": "状态"
        }, {
            "name": "times",
            "text": "时间"
        }],
        "dblclick": function (obj) {
            alert(obj.id);
        },
        "postData": { // 请求参数
            "userId": userId,
            "userName": userName,
            "goodsName": goodsName,
            "mood": mood
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



























