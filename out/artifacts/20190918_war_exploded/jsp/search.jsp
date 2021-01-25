<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@page import="com.liao.entity.User" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
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
    <base href="<%=basePath%>">

    <title>搜索结果页</title>
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/search.css">
    <link rel="stylesheet" href="css/goodsList.css">

    <script src="js/util.js"></script>
    <script src="js/jquery-1.12.0.js"></script>
    <script src="js/List.js"></script>
    <script src="js/search.js"></script>
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
<!-- 身体 -->
<div class="home-hero">
    <div class="container">
        <div class="addres">
            <a>首页 > 全部结果 </a>
        </div>
        <!-- 分类 -->
        <div class="hero-kind">
            <a>分类：</a>
            <ul>
                <li>全部</li>
                <li>手机</li>
                <li>出行</li>
                <li>包</li>
                <li>配件</li>
                <li>日用百货</li>
                <li>手机贴膜</li>
            </ul>
        </div>
        <!-- 筛选 -->
        <div class="hero-filter">
            <a>综合</a>
            <span class="sep">|</span>
            <a>新品</a>
            <span class="sep">|</span>
            <a>销量</a>
            <span class="sep">|</span>
            <a>价格</a>
        </div>
        <div class="goods-result">
            <div id="table" class="tablebox"></div>
        </div>
        <!-- 分页 -->
        <div class="pagination">
            <!-- 上一页 -->
            <i id="previousPage" class="fa fa-angle-left" aria-hidden="true"></i>
            <!-- 当前页 -->
            <span class="pageNum">1</span>
            <span>/</span>
            <%-- 总页数--%>
            <span class="totalNum">1</span>
            <%--下一页--%>
            <i id="nextPage" class="fa fa-angle-right" aria-hidden="true"></i>
        </div>
    </div>

</div>
<!-- 底部 -->
<div class="footer">
    <img src="imgas/Button.jpg" alt=""/>
</div>
</body>
<script>

</script>
</html>
