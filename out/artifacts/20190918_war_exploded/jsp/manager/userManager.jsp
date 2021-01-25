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
    <link rel="stylesheet" href="css/manger/goodsManager.css">

    <script src="js/jquery-1.12.0.js"></script>
    <script src="js/Grid.js"></script>
    <script src="js/ddl.js"></script>
    <script src="js/manger/userManager.js"></script>

</head>

<body>
<div class="title-text">
    <p class="p1">用户管理</p>
    <p class="p2">在下方输入查询条件，点击查询</p>
</div>

<div class="condition">
    <div class="container">
        <span>用户姓名</span>
        <input type="text" id="name">
    </div>

    <div class="container">
        <span>用户帐号</span>
        <input type="text" id="userName">
    </div>

    <div class="container">
        <span class="goodsType">用户等级</span>
        <input type="text" id="lev">
    </div>

    <div class="container">
        <span>用户年龄</span>
        <input type="text" id="age">
    </div>
</div>


<div class="but-list">
    <button class="select">查询</button>
    <button class="add">添加</button>
    <button class="edit btn-disable">编辑</button>
    <button class="delet btn-disable">删除</button>
</div>
<div id="user" class="tablebox"></div>
</body>
</html>
