<%--
  Created by IntelliJ IDEA.
  User: liao9
  Date: 2019/9/14
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String[] validataArray = {"数字，字母", "数字，字母"}; %>
<html>
<head>
    <title>你好啊 李澳—注册</title>


    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/registered.css">
    <link rel="stylesheet" href="../css/font-awesome.css">

    <script src="../js/jquery-1.12.0.js"></script>
    <script src="../js/registered.js"></script>
    <script src="../js/util.js"></script>


</head>
<body>
<div class="body">
    <div class="regis">
        <div class="regis-log">

        </div>
        <p class="head-txt">注册小米帐号</p>
        <p class="haed-ch">帐号</p>
        <div class="line">
            <input id="name" type="text" validata="ne" validataStr=<%= validataArray[0] %> maxlength="20"
                   placeholder="请输入帐号"/>
            <div class="errorTips hidden">asd</div>
        </div>
        <p class="head-regis-txt">成功注册账号后，帐号将不能被修改</p>
        <p class="haed-ph">密码</p>
        <div class="line">
            <input id="pwd" type="text" validata="ne" validataStr=<%= validataArray[1] %> maxlength="20"
                   placeholder="请输入密码"/>
            <div class="errorTips hidden">asd</div>
        </div>

        <div class="line">
            <input id="regiBut" type="button" value="立即注册"/>
        </div>

        <div class="policy">
            <p class="p-1">以阅读并同意：小米</p>
            <p class="p-2">用户协议</p>
            <p class="p-1">和</p>
            <p class="p-2">隐私政策</p>
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
        <p>小米公司版权所有-京ICP备10046444-<img src="../imgas/ghs.png">京公网安备11010802020134号-京ICP证110507号</p>
    </div>
</div>
</body>
</html>
