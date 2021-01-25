<%--
  Created by IntelliJ IDEA.
  User: liao9
  Date: 2019/10/20
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的订单</title>
    <link rel="stylesheet" href="../../../css/font-awesome.css">
    <link rel="stylesheet" href="../../../css/common.css">
    <link rel="stylesheet" href="../../../fonts/fontCss.css">
    <link rel="stylesheet" href="../../../css/user/myOrder/myOrder.css">
    
    <script src="../../../js/jquery-1.12.0.js"></script>
    <script src="../../../js/user/myOrder/myOrder.js"></script>
    

</head>
<body>
    <div class="uc-box uc-main-box">
        <div class="uc-content-box order-list-box">
            <div class="box-hd">
                <h1 class="title">
                    我的订单
                    <small>
                        请谨防钓鱼链接或诈骗电话，
                        <a href="">了解更多></a>
                    </small>
                </h1>
                <div class="more clearfix">
                    <ul class="filter-list J_orderType">
                        <li><a class="allOrders selecteds">全部有效订单</a></li>
                        <li><a class="pendingReceipt">待支付</a></li>
                        <li><a class="pendingPayment">待收货</a></li>
                    </ul>
                </div>
            </div>
            <div class="box-bd">
                <iframe frameborder="0"   scrolling="no" id="manager-page" src="allOrder.jsp"></iframe>
            </div>
        </div>
    </div>
</body>
</html>
