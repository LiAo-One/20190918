<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

    String[] validataArray = {"中文、数字、字母、下划线", "中文、数字、字母", "数字"};
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>类别添加</title>
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/Add/category.css">
    <link rel="stylesheet" href="css/ddl-demo.css">


    <script src="js/jquery-1.12.0.js"></script>
    <script src="js/Add/categoryAdd.js"></script>
    <script src="js/ddl.js"></script>
    <script src="js/util.js"></script>
</head>

<body>
<div class="container">
    <div class="goods-data">
        <input id="id" type="text" placeholder="ID" validata="n" validataStr= <%= validataArray[2] %>>
        <input id="name" type="text" placeholder="名称" validata="ne" validataStr= <%= validataArray[0] %>>
    </div>
    <button class="add-category">确定</button>
    <button class="empty">清空</button>
</div>
</body>
</html>
