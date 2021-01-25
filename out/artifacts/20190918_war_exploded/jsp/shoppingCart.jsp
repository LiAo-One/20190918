<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@page import="com.liao.entity.User" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<%
    String userName = "";

    HttpSession s = request.getSession();

    User u = (User) s.getAttribute("user");

    if (u != null) {
        userName = u.getNikeName();
    } else {
        response.sendRedirect("login.jsp");
        userName = "登录";
    }


%>

<html>
<head>
    <base href="<%=basePath%>">

    <title>你好啊-李澳 购物车</title>
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/shoppingCart.css">

    <script src="js/jquery-1.12.0.js"></script>
    <script src="js/shoppingCart.js"></script>
    <script src="js/util.js"></script>
    
    
</head>

<body>
<!-- 头部 -->
<div class="title-head">
    <div class="container">
        <div class="m-log">
            <img src="imgas/mi-logo.png" alt=""/>
        </div>
        <div class="header-title">
            <h2>我的购物车</h2>
            <p>温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</p>
        </div>
        <span class="name">李澳</span>

    </div>

</div>
<!-- 购物车 -->

<div id="table">
    <!-- 购物车内容 -->
    <div class="container">
        <!-- 标题 -->
        <div class="list-head">
            <div class="col col-check">
                <%--<i class="chen">
                    <input type="checkbox" id="checkboxAll"/>
                    
                </i>--%>
                选择
            </div>
            <div class="col col-img">&nbsp;</div>
            <div class="col col-name">商品名称</div>
            <div class="col col-pric">单价</div>
            <div class="col col-num">数量</div>
            <div class="col col-total">小计</div>
            <div class="col col-action">删除</div>
        </div>

        <!-- 身体 -->
        <div class="list-boy">
            <div id="size"></div>
        </div>

        <!-- 结算 -->
        <div class="Settlement">
            <div class="contion">
                <span class="span1">合计: </span>
                <span class="span2"></span>
                <span class="span3">元 </span>
            </div>


            <div class="go">去结算</div>
        </div>

    </div>
</div>
    <!-- 底部 -->
    <div class="footer">
        <img src="imgas/Button.jpg" alt=""/>
    </div>
</body>

<script>
    var but = new SHOPP({
        "renderTo": "size",
        "dataSource": "manager/servlet/SelectUserShoppingCart.action"
    });
</script>
</html>
