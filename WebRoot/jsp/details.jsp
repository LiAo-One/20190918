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

    <title>商品详情页</title>
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/details.css">
    <link rel="stylesheet" href="css/tab.css">

    <link rel="icon" href="imgas/ico/favicon.ico">

    <script src="js/jquery-1.12.0.js"></script>
    <script src="js/util.js"></script>
    <script src="js/Tab.js"></script>
    <script src="js/details.js"></script>
    <script src="js/goods/img.js"></script>
    <script src="js/Homepage.js"></script>

</head>

<body>
<!--   头部 -->
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
                <a href="jsp/personalCenter.jsp" class="link"><%=userName%></a>
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
					<img alt="" src="imgas/mi-logo.png">s
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
<!-- 商品名称 -->
<div class="nav-bar">
    <h2>小米9 Pro</h2>
</div>
<!-- 商品内容 -->
<div class="goods-details">
    <!-- 商品详情容器 -->
    <div class="container">

        <div class="goods-img">
           </div>

        <!-- 商品右边详情 -->
        <div class="por-info sapn10">
            <!-- 商品名称 -->
            <h1 class="J-proName">
                <span class="name">小米9 Pro</span>
            </h1>
            <!-- 提示 -->
            <p class="sale-desc" id="J_desc">
                <font color="#ff4a00">「4800万四摄小金刚，标配18W快充，+19元得手机膜」</font>
                4800万全场景四摄 / 前置1300万美颜相机 / 骁龙665处理器 / 4000mAh超长续航 / 标配18W快充 / 超线性扬声器 / 90%高屏占比 / 康宁大猩猩保护玻璃 / 6.3英寸水滴全面屏
            </p>
            <!-- 经营主题 -->
            <p class="aftersale">小米自营</p>
            <!-- 价格 -->
            <div class="por-price">
                <span class="price">699元</span>
            </div>
            <!-- 选择版本 -->
            <div class="pro-chose">
                <div class="steo-title">选择 小米9 Pro 版本</div>
                <ul class="step-one">
                    <li class="btn-active">
                        <span class="name">3GB+32GB</span>
                        <span class="price">699元</span>
                    </li>
                    <li class="btn-biglarge">
                        <span class="name">4GB+64GB</span>
                        <span class="price">899元</span>
                    </li>
                </ul>
            </div>
            <!-- 已经购买的商品及价格 -->
            <div class="pro-list">
                <ul>
                    <li class="totleName">小米9 Pro 3G+32GB</li>
                    <li class="totlePrice">秒杀价： 699元</li>
                </ul>
            </div>
            <!-- 底部按钮 -->
            <div class="btn-primary">
                <button class="byn-biglarge">加入购物车</button>
                <button class="btn-like"><i class="fa fa-heart-o" aria-hidden="true"></i>喜欢</button>
            </div>
        </div>
    </div>
</div>
<!-- tab选项卡 -->
<div class="table">
    <div class="container">
        <div id="myddl"></div>
    </div>
</div>
<!-- 选项卡内容 -->
<div class="table-container">

    <div class="container">
        <iframe id="manager-page" src="jsp/goods/goodsDetails.jsp"></iframe>
    </div>
</div>
<!-- 底部 -->
<div class="footer">
    <img src="imgas/Button.jpg" alt=""/>
</div>
</body>
<script>

    var index = new TAB({
        "renderTo": "myddl",
        "dataSou": [{
            "id": "1",
            "name": "商品详情",
            "url": "jsp/goods/goodsDetails.jsp"
        }, {
            "id": "2",
            "name": "商品评论",
            "url": "jsp/goods/goodsComment.jsp"
        }, {
            "id": "3",
            "name": "售后保障",
            "url": "jsp/goods/afterSale.jsp"
        }],
        "onClik": function (obj) {
            $("#manager-page").attr("src", obj.url);
        }
    });
    
    new IMG({
    	"renderTo": "goods-img",
    	"requData":"servlet/SelectGoodsIdImg.action"
    })
</script>
</html>
