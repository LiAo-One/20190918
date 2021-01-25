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

    <title>小米商城-小米9 Pro</title>
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/Homepage.css">
    <link rel="stylesheet" href="fonts/fontCss.css">
    <link rel="stylesheet" href="css/jquery.slider.css">
    <link rel="stylesheet" href="css/goodsList.css">
    <%--图标--%>
    <link rel="icon" href="imgas/ico/favicon.ico">

    <script src="js/jquery-1.12.0.js"></script>
    <script src="js/List.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/jquery.slider.js"></script>
    <script src="js/Homepage.js"></script>
    <script src="js/util.js"></script>
</head>

<body>
<div class="header">
    <div class="J_topbarBannerWrapper"></div>
    <div class="site-topbar">
        <div class="container">
            <div class="topbar-nav">
                <a href="jsp/Homepage.jsp">小米商城</a>
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
                <a href="jsp/shoppingCart.jsp" class="cart-mini">
                    <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                    购物车
                </a>
            </div>
            <div class="topbar-info">
                <a href="jsp/personalCenter.jsp" class="link"><%=userName%>
                </a>
                <span class="sep">|</span>
                <a href="jsp/registered.jsp" class="link">注册</a>
                <span class="sep">|</span>
                <a href="" class="link">消息通知</a>
            </div>
        </div>
    </div>
    <div class="site-header ">
        <div class="container">
            <div class="header-logo">
                <a href="" class="logo ir">
					<img alt="" src="imgas/mi-logo.png">
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


<!-- 身体  -->
<div class="home-hero">
    <div class="container">
        <!-- 轮播图 -->
        <div class="testSlider"></div>
        <!-- 轮播图下面图片 -->
        <div class="home-hero-sub row">
            <!-- F码 -->
            <div class="span4">
                <div class="home-channel-list clearfix">
                    <li>
                        <a href="">
                            <img src="imgas/82abdba456e8caaea5848a0cddce03db.png" alt="">
                            小米秒杀
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img src="imgas/806f2dfb2d27978e33fe3815d3851fa3.png" alt="">
                            企业团购
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img src="imgas/eded6fa3b897a058163e2485532c4f10.png" alt="">
                            F码通道
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img src="imgas/43a3195efa6a3cc7662efed8e7abe8bf.png" alt="">
                            米粉卡
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img src="imgas/f4846bca6010a0deb9f85464409862af.png" alt="">
                            以旧换新
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img src="imgas/9a76d7636b08e0988efb4fc384ae497b.png" alt="">
                            话费充值
                        </a>
                    </li>
                </div>
            </div>

            <div class="span16">
                <ul class="home-promo-list clearfix">
                    <li class=" first ">
                        <a href="">
                            <img src="imgas/37d52be5170e1b25d30ff44db4b0791c.jpg" alt="">
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img src="imgas/e7b51b721c3319e9c2916cc41cd9c695.jpg" alt="">
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <img src="imgas/816a66edef10673b4768128b41804cae.jpg" alt="">
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="home-main">
            <div class="banner-box">
                <img src="imgas/18fa67.jpg" alt=""/>
            </div>

            <div class="left-s">
                <div class="left-span4">
                    <img src="imgas/79ed6663b57e30554a5d1f0653c68b78.jpg" alt="">
                </div>
                <div class="left-span16">
                    <div id="table" class="tablebox">
                    </div>
                </div>

            </div>
        </div>

    </div>

</div>
<!-- 底部 -->
<div class="footer">
    <img src="imgas/Button.jpg" alt=""/>
</div>
</body>

</html>
