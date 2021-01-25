<%--
  Created by IntelliJ IDEA.
  User: liao9
  Date: 2019/10/20
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.liao.entity.User" %>
<html>
<head>
    <title>个人信息</title>
    <link rel="stylesheet" href="../../../css/font-awesome.css">
    <link rel="stylesheet" href="../../../fonts/fontCss.css">
    <link rel="stylesheet" href="../../../css/common.css">
    <link rel="stylesheet" href="../../../css/user/myInformation/modifyInformation.css">
    <link rel="stylesheet" href="../../../css/home.css">
    
    <script src="../../../js/jquery-1.12.0.js"></script>
    <script src="../../../js/util.js"></script>
    <script src="../../../js/user/myInformation/modifyInformation.js"></script>
    <script src="../../../js/dialog.js"></script>
    
</head>
<body>
    <div class="uc-box uc-main-box">
        <div class="uc-content-box portal-content-box">
            <div class="box-bd">
                <div class="portal-main clearfix">
                    <div class="user-card">
                        <h2 class="username">张 康</h2>
                        <p class="tip">你好啊</p>
                        <a class="link" href="">修改个人信息></a>
                        <img class="avatar" src="../../../imgas/Mr.Wick.jpg" alt="" width="150px" height="150px">
                    </div>
                    <div class="user-actions">
                        <ul class="action-list">
                            <li>账户安全：<span class="level level-3">较高</span></li>
                            <li>绑定手机：<span class="tel">183********34</span></li>
                            <li>绑定邮箱：<span class="tel">li*******4@g****.com</span></li>
                        </ul>
                    </div>
                </div>

<%--                <div class="portal-sub">--%>
<%--                    <div class="mod_tip_bd">--%>
<%--                        <from >--%>
<%--                            <div class="wapbox editbasicinfo">--%>
<%--                                <div class="infobox c_b">--%>
<%--                                    <dt>昵称：</dt>--%>
<%--                                    <dd class="labelbox">--%>
<%--                                        <input type="text" class="nickname" maxlength="20">--%>
<%--                                    </dd>--%>
<%--                                    <dt>性别：</dt>--%>
<%--                                    <dd class="checkbox infosex">--%>
<%--                                        --%>
<%--                                    </dd>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </from>--%>
<%--                    </div>--%>
<%--                </div>--%>
            </div>
        </div>
    </div>
    
</body>
</html>
