<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>轮播图</title>
    <script src="js/jquery-1.12.0.js"></script>
    <script type="text/javascript" src="js/pic.js"></script>
    <link rel="stylesheet" href="css/common.css"/>
    <link rel="stylesheet" href="css/pic.css"/>
    <link rel="stylesheet" href="css/font-awesome.css"/>
</head>

<body>
<div class="body">
    <img src="ings/a1.jpg">
    <img src="ings/a2.jpg">
    <img src="ings/a3.jpg">
    <img src="ings/a4.jpg">
    <img src="ings/a5.jpg">
    <img src="ings/a6.jpg">
    <ul>
        <li class="active"></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
    <a href="javascript:;" class="left"><i class="fa fa-angle-left" aria-hidden="true"></i></a>
    <a href="javascript:;" class="right"><i class="fa fa-angle-right" aria-hidden="true"></i></a>
</div>
<script type="text/javascript">
    $.slider({
        imgElement: $(".body img"),
        liElement: $(".body li"),
        leftBtn: $(".left"),
        rightBtn: $(".right"),
        time: 2000
    })
</script>
</body>
</html>
