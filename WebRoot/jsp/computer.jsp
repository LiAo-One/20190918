<%--
  Created by IntelliJ IDEA.
  User: liao9
  Date: 2019/9/14
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>计算机</title>
    <script type="text/javascript" src="../js/computer.js"></script>
    <link rel="stylesheet" href="../css/font-awesome.css">
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/computer.css">


</head>
<body>
<%--计算机--%>
<div class="calculator">
    <%--    屏幕--%>
    <div class="screen">
        <input type="text" class="txt" disabled/>
    </div>
    <%--按钮--%>
    <div class="but">
        <input type="button" class="btn" value="AC">
        <input type="button" class="btn" value="DEL">
        <input type="button" class="btn_click" value="%">
        <input id="a-1" type="button" class="btn_click" value="/">

        <input type="button" class="btn_click" value="7"/>
        <input type="button" class="btn_click" value="8">
        <input type="button" class="btn_click" value="9">
        <input type="button" class="btn_click" value="*">

        <input type="button" class="btn_click" value="4">
        <input type="button" class="btn_click" value="5">
        <input type="button" class="btn_click" value="6">
        <input type="button" class="btn_click" value="-">

        <input type="button" class="btn_click" value="1">
        <input type="button" class="btn_click" value="2">
        <input type="button" class="btn_click" value="3">
        <input type="button" class="btn_click" value="+">

        <input type="button" class="btn_click" value="00">
        <input type="button" class="btn_click" value="0">
        <input type="button" class="btn_click" value=".">
        <input type="button" class="btn_click" value="=">
    </div>
</div>
</body>
</html>
