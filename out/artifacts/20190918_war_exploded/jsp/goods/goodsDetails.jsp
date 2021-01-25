<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">

    <title>商品详情</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/goods/goodsDetails.css">

    <script src="js/jquery-1.12.0.js"></script>
    <script src="js/goods/goodsDetails.js"></script>
</head>

<body>

<div class="goods">
    <img src="imgas/mi9pro/mi9-01.jpg">
    <img src="imgas/mi9pro/1570095190(1).jpg">
    <video controls muted id="video-list" src="video/video-03.mp4" controls="controls"></video>
    <img src="imgas/mi9pro/mi9-10.jpg">

</div>


</body>
</html>
