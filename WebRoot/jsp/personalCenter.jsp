<%--
  Created by IntelliJ IDEA.
  User: liao9
  Date: 2019/10/20
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.liao.entity.User" %>

<%
    String userName = "";
    int lev = 0;
    String userImg = "";

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
    <title>个人中心</title>

    <link rel="stylesheet" href="../css/font-awesome.css">
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../fonts/fontCss.css">
    <link rel="stylesheet" href="../css/personalCenter.css">
    
    <script src="../js/jquery-1.12.0.js"></script>
    <script src="../js/personalCenter.js"></script>
    <script src="../js/util.js"></script>
</head>
<body>
<!--   头部 -->
<div class="header">
    <div class="J_topbarBannerWrapper"></div>
    <div class="site-topbar">
        <div class="container">
            <div class="topbar-nav">
                <a href="Homepage.jsp">小米商城</a>
                <span class="sep">|</span>
                <a>MIUI</a>
                <span class="sep">|</span>
                <a>loT</a>
                <span class="sep">|</span>
                <a>云服务</a>
                <span class="sep">|</span>
                <a>金融</a>
                <span class="sep">|</span>
                <a>有品</a>
                <span class="sep">|</span>
                <a>小爱开放平台</a>
                <span class="sep">|</span>
                <a>企业团购</a>
                <span class="sep">|</span>
                <a>资质证照</a>
                <span class="sep">|</span>
                <a>协议规则</a>
                <span class="sep">|</span>
                <a>下载app</a>
                <span class="sep">|</span>
                <a>Select Location</a>
            </div>
            <div class="topbar-cart">
                <a href="shoppingCart.jsp" class="cart-mini">
                    <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                    购物车
                </a>
            </div>
            <div class="topbar-info">
                <a href="personalCenter.jsp" class="link"><%=userName%>
                </a>
                <span class="sep">|</span>
                <a href="registered.jsp" class="link">注册</a>
                <span class="sep">|</span>
                <a href="" class="link">消息通知</a>
            </div>
        </div>
    </div>
    <div class="site-header ">
        <div class="container">
            <div class="header-logo">
                <a href="" class="logo ir">
					<img alt="" src="../imgas/mi-logo.png">
                </a>
            </div>
            <div class="header-nav ">
                <ul class="nav-list J_navMainList clearfix">
                    <li class="nav-item">
                        <a href="" class="link">
                            <span class="text">小米手机</span>
                        </a>
                    <li class="nav-item">
                        <a href="" class="link">
                            <span class="text">Redmi 红米</span>
                        </a>
                    <li class="nav-item">
                        <a href="" class="link">
                            <span class="text">电视</span>
                        </a>
                    <li class="nav-item">
                        <a href="" class="link">
                            <span class="text">笔记本</span>
                        </a>
                    <li class="nav-item">
                        <a href="" class="link">
                            <span class="text">家电</span>
                        </a>
                    <li class="nav-item">
                        <a href="" class="link">
                            <span class="text">路由器</span>
                        </a>
                    <li class="nav-item">
                        <a href="" class="link">
                            <span class="text">智能硬件</span>
                        </a>
                    <li class="nav-item">
                        <a href="" class="link">
                            <span class="text">服务</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="" class="link">
                            <span class="text">社区</span>
                        </a>
                    </li>
                </ul>
            </div>
            <div class="header-search ">
                <div class="search-form clearfix">
                    <input type="text" class="search-text">
                    <div class="search-btn iconfont">
                        <i class="fa fa-search" aria-hidden="true"></i>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--身体--%>
<div class="intermediate">
    <%--第一层，首页小字部分--%>
    <div class="breadcrumbs">
        <div class="container">
            <a href="">首页</a>
            <span class="sep">></span>
            <span>个人中心</span>
        </div>
    </div>
    <%--第二层，主体部分--%>
    <div class="page-main user-main">
        <div class="container">
            <div class="row">
                <%--左侧菜单--%>
                <div class="span4">
                    <div class="uc-box">
                        <%--订单中心--%>
                        <div class="uc-nav-box">
                            <div class="box-hd">
                                <h3 class="title">订单中心</h3>
                            </div>
                            <div class="box-bd">
                                <ul class="uc-nav-list J_navList">
                                    <li><a class="myOrdes">我的订单</a></li>
                                    <li><a href="">团购订单</a></li>
                                    <li><a class="comment">评价晒单</a></li>
                                    <li><a href="">话费充值订单</a></li>
                                    <li><a href="">以旧换新订单</a></li>
                                </ul>
                            </div>
                        </div>
                        <%--个人中心--%>
                        <div class="uc-nav-box">
                            <div class="box-hd">
                                <h3 class="title">个人中心</h3>
                            </div>
                            <div class="box-bd">
                                <ul class="uc-nav-list J_navList">
                                    <li><a href="" class="personalCenter selecteds">我的个人中心</a></li>
                                    <li><a href="">消息通知</a></li>
                                    <li><a href="">购买资格</a></li>
                                    <li><a href="">现金账户</a></li>
                                    <li><a href="">小米礼品卡</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <%--右侧界面--%>
                <div class="span16">
                    <iframe id="manager-page" src="../jsp/user/myInformation/modifyInformation.jsp"></iframe>
                </div>
            </div>
        </div>
    </div>
        <div class="footer">
            <img src="../imgas/Button.jpg" alt=""/>
        </div>
</div>
</body>
</html>
