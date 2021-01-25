<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>My JSP</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/tab.css">
    <script src="js/jquery-1.12.0.js"></script>
    <script src="js/Tab.js"></script>
</head>
<body>
<!--
<div class="help">
<ul class = "title" id="title">
<li class="lable">商品详情</li>
<li class="lable">商品价格</li>
<li class="lable">商品评价</li>
</ul>
</div>
-->
<div id="myddl">
</div>
</body>
<script>

    var index = new TAB({
        "renderTo": "myddl",
        "dataSou": "servlet/CategorySelectServlet.action",
        "onClik": function (obj) {
            alert(obj.id);
        }
    });
</script>
</html>
