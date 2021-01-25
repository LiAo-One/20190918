<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML >
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'userManager.jsp' starting page</title>
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/grid.css">
    <link rel="stylesheet" href="css/ddl-demo.css">
    <link rel="stylesheet" href="css/manger/userManager.css">
    <link rel="stylesheet" href="css/manger/goodsManager.css">

    <script src="js/jquery-1.12.0.js"></script>
    <script src="js/Grid.js"></script>
    <script src="js/ddl.js"></script>
    <script src="js/manger/goodsManager.js"></script>

</head>

<body>
<div class="title-text">
    <p class="p1">商品管理</p>
    <p class="p2">在下方输入查询条件，点击查询</p>
</div>

<div class="condition">
    <div class="container">
        <span>商品价格</span>
        <input type="text" id="goodsPrice">
    </div>

    <div class="container">
        <span>商品名称</span>
        <input type="text" id="goodsName">
    </div>

    <div class="container">
        <span class="goodsType">商品类别</span>
        <input type="text" id="goodsName">
    </div>

    <div class="container">
        <span>商品店家</span>
        <input type="text" id="store">
    </div>
</div>


<div class="but-list">
    <button class="select">查询</button>
    <button class="add">添加</button>
    <button class="edit btn-disable">编辑</button>
    <button class="delet btn-disable">删除</button>
</div>
<div id="goods" class="tablebox">

</div>
</body>
<script>
    goodsType = new DDL({
        "renderTo": "myddl_s",
        "dataSource": "servlet/Common.action",
        "prevLoadItem": [{
            "id": "-1",
            "name": "请选择"
        }],
        "mappin": {
            "key": "id",
            "value": "name"
        },
        "defaultSelect": 89745,
        "direction": "dow",
        "offset": -0.6,
        "onClik": function (obj) {
            /* alert(obj.id); */
        },
        "onComplate": function () { // 组件加载完成事件
            // 判断当前是修改 还是 添加
            if (top.isEdit) {
                // 说明是修改
                fullText();
            }
        }
    });
</script>
</html>
