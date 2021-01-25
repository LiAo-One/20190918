<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'address.java.jsp' starting page</title>

    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/grid.css">
    <link rel="stylesheet" href="css/ddl-demo.css">
    <link rel="stylesheet" href="css/manger/userManager.css">
    <link rel="stylesheet" href="css/manger/shoppingCartManager.css">

    <script src="js/jquery-1.12.0.js"></script>
    <script src="js/Grid.js"></script>
    <script src="js/ddl.js"></script>
    <script src="js/manger/address.js"></script>

</head>

<body>
<div class="title-text">
    <p class="p1">购物车管理</p>
    <p class="p2">在下方输入查询条件，点击查询</p>
</div>

<div class="condition">
    <div class="container">
        <span>用户ID</span>
        <input type="text" id="userId">
    </div>

    <div class="container">
        <span>用户姓名</span>
        <input type="text" id="userName">
    </div>

    <div class="container">
        <span class="goodsType">用户地址</span>
        <input type="text" id="userAddress">
    </div>

    <div class="container">
        <span>手机</span>
        <input type="text" id="phone">
    </div>
</div>

<div class="but-list">
    <button class="select">查询</button>
</div>

<div id="shoppingCart" class="asd">

</div>
</body>
</html>
