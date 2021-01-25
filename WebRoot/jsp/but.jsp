<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>But</title>
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/home.css">
    <script src="js/jquery-1.12.0.js"></script>
    <script src="js/Buts.js"></script>

</head>

<body>
<div class="bodys-left-but">
    <div class="line">
        <buttom><i class="fa fa-windows fa-lg"></i>主页</buttom>
    </div>
    <div class="line">
        <buttom><i class="fa fa-user-circle fa-lg"></i>用户管理</buttom>
    </div>
    <div class="line">
        <buttom><i class="fa fa-archive fa-lg"></i>我的店铺</buttom>
    </div>
    <div class="line">
        <buttom><i class="fa fa-shopping-basket fa-lg"></i>产品管理</buttom>
    </div>
    <div class="line">
        <buttom><i class="fa fa-cog fa-lg"></i>设置</buttom>
    </div>

</div>

<div id="size" style="margin-top: 5em;width: 279.125px"></div>
</body>
<script>
    var but = new BUT({
        "renderTo": "size",
        "dataSource": [{
            "ico": "fa fa-windows fa-lg",
            "name": "主页"
        }, {
            "ico": "fa fa-user-circle fa-lg",
            "name": "用户管理"
        }, {
            "ico": "fa fa-archive fa-lg",
            "name": "我的店铺"
        }, {
            "ico": "fa fa-shopping-basket fa-lg",
            "name": "产品管理"
        }, {
            "ico": "fa fa-cog fa-lg",
            "name": "设置"
        }],
        "onClik": function (obj) {
            alert(obj.name);
        }
    });
</script>
</html>
