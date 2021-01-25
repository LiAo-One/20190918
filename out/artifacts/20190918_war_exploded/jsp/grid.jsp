<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">


    <title>page</title>
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/grid.css">
    <link rel="stylesheet" href="css/ddl-demo.css">
    <script src="js/jquery-1.12.0.js"></script>
    <script src="js/Grid.js"></script>
    <script src="js/ddl.js"></script>

</head>

<body>
<div id="table" class="tablebox">
</div>

<div id="goods" class="tablebox">

</div>

<div id="user" class="tablebox">
</div>
</body>
<script type="text/javascript">
    new TAL({
        "renderTo": "table",
        "requData": "servlet/CategorySelectServlet.action",
        "dataSource": [{
            "name": "id",
            "text": "类别ID"
        }, {
            "name": "name",
            "text": "名称"
        }, {
            "name": "time",
            "text": "时间"
        }],
        "dblclick": function (obj) {
            alert(obj.id);
        },
        "onClick": function (row) {
            // 点击一行之后，弹出当前点击行的id
            alert($("td[data-alias='id']", row).text());
        }

    });

    new TAL({
        "renderTo": "goods",
        "requData": "servlet/GoodsSelectServlet.action",
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
                var str = value + "￥";

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
            "name": "store",
            "text": "店家"
        }, {
            "name": "Discount",
            "text": "折扣",
            // 元素隐藏
            "hide": true

        }, {
            "name": "post",
            "text": "是否包邮"
        }, {
            "name": "typeName",
            "text": "商品类别"
        }],
        "dblclick": function (obj) {
            alert(obj.id);
        },
        "onClick": function (row) {
            // 点击一行之后，弹出当前点击行的id
            alert($("td[data-alias='id']", row).text());
        }
    });

    new TAL({
        "renderTo": "user",
        "requData": "servlet/UserSelectServlet.action",
        "dataSource": [{
            "name": "id",
            "text": "ID"
        }, {
            "name": "nikeName",
            "text": "姓名"
        }, {
            "name": "loginName",
            "text": "帐号"
        }, {
            "name": "loginPwd",
            "text": "密码"
        }, {
            "name": "lev",
            "text": "等级",
            "fomatter": function (value) { // 格式化数据

                var str = "";
                var lev = parseInt(value);
                if (value == "10") {
                    str = "<i class='fa fa-asterisk fa-woman'></i>";

                } else {
                    // 性别为男
                    str = "<i class='fa fa-user-circle fa-woman'></i>";
                }

                return str;
            }
        }, {
            "name": "sex",
            "text": "性别",
            "fomatter": function (value) { // 格式化数据

                var str = "";
                if (value == "男") {
                    // 性别为女
                    str = "<i class='fa fa-venus fa-woman'></i>";

                } else {
                    // 性别为男
                    str = "<i class='fa fa-mars fa-man'></i>";
                }

                return str;
            }
        }, {
            "name": "age",
            "text": "年龄"
        }, {
            "name": "img",
            "text": "头像",
            "fomatter": function (value) { // 格式化数据

                var str = "";
                if (value == "1.jpg") {
                    str = "<img src=" + 'imgas/Mr.Wick.jpg' + ">";

                } else {
                    str = "<img src=" + 'imgas/QiuYang.jpg' + ">";
                }

                return str;
            }
        }, {
            "name": "createTime",
            "text": "时间"
        }],
        "onClick": function (row) {
            // 点击一行之后，弹出当前点击行的id
            alert($("td[data-alias='id']", row).text());
        }
    });
</script>
</html>
