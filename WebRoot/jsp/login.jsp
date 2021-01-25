<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">

    <title>你好啊 李澳—登录</title>
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/login.css">

    <script src="js/jquery-1.12.0.js"></script>
    <script src="js/util.js"></script>
    <script src="js/login.js"></script>

</head>

<body>
<div class="h_panel">
    <div class="logMi">

    </div>
</div>


<div class="bodys">
    <div class="loginPanle">
        <div class="logingText">帐号登录
            <span class="separate"></span>
        </div>

        <div class="loginDes">扫码登录</div>
        <div class="line">
            <input id="loginName" type="text" maxlength="20" placeholder="邮箱/手机号码/小米ID" autocomplete="off"/>
            <div class="errorTips hidden"></div>
        </div>
        <div class="line">
            <input id="loginPwd" type="password" maxlength="20" placeholder="密码" autocomplete="off"/>
            <div class="errorTips hidden"></div>
        </div>
        <div class="line">
            <button id="logBut">登录</button>
        </div>


        <div class="line">
            <label class="left">
                <a href="">手机短信登录</a>
                <a>/</a>
                <a href="">注册</a>
            </label>
            <label class="right">
                <a href="jsp/registered.jsp">立即注册</a>
                <a>|</a>
                <a href="">忘记密码？</a>
            </label>
        </div>
        <div class="oth_type_txt">

        </div>

        <div class="btn">

        </div>

    </div>
</div>


<div class="buttom">
    <div class="lang_select">
        <div class="current">
            <label><a href="" title="">简体&nbsp;|</a></label>
            <label><a href="" title="">繁体&nbsp;|</a></label>
            <label><a href="" title="">English&nbsp;|</a></label>
            <label><a href="" title="">常见问题&nbsp;|</a></label>
            <label><a href="" title="">隐私政策</a></label>
        </div>
    </div>

    <div class="intro">
        <p>小米公司版权所有-京ICP备10046444-<img src="imgas/ghs.png">京公网安备11010802020134号-京ICP证110507号</p>
    </div>
</div>
</body>
</html>
