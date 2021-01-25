<%--
  Created by IntelliJ IDEA.
  User: liao9
  Date: 2019/10/23
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付页面</title>
    
    <script src="../../../js/jquery-1.12.0.js"></script>
    <script src="../../../js/user/myOrder/paymentPage.js"></script>
    <script src="../../../js/util.js"></script>
    
    <link rel="stylesheet" href="../../../css/font-awesome.css">
    <link rel="stylesheet" href="../../../fonts/fontCss.css">
    <link rel="stylesheet" href="../../../css/common.css">
    <link rel="stylesheet" href="../../../css/user/myOrder/paymentPage.css">

</head>
<body>
<div class="site-header site-mini-header">
    <div class="container">
        <div class="header-logo">
            <a class="logo" href=""></a>
        </div>

        <div class="header-title">
            <h2>支付订单</h2>
        </div>
        <div class="topbar-info">
                <span class="user">
                    <a href="" class="user-name">
                        <span class="name">李 澳</span>
                    </a>
                </span>
        </div>
    </div>
</div>
<div class="page-main">
    <div class="container confirm-box">
        <form action="">
            <div class="section section-order">
                <div class="order-info clearfix">
                    <div class="fl">
                        <h2 class="title">订单提交成功！去付款咯～</h2>
                        <p class="order-time"></p>
                        <p class="order-time">
                            请在
                            <span class="pay-time-tip">1小时59分</span>
                            内完成支付，超时将取消订单
                        </p>
                        <p class="post-info">

                            收货信息：李澳 183****2734 &nbsp;&nbsp;
                            安徽&nbsp;&nbsp;宿州市&nbsp;&nbsp;砀山县&nbsp;&nbsp;周寨镇&nbsp;&nbsp;周寨镇李心庄联村李心庄016
                        </p>
                    </div>
                    <div class="fr">
                        <p class="total">

                            应付总额：
                            <span class="money">
                                <em>2999</em>
                                元
                            </span>
                        </p>
                        <a href="" class="show-detail">
                            订单详情
                        </a>
                    </div>
                </div>
                <i class="iconfont icon-right">√</i>
            </div>
            <div class="section section-payment">
                <div class="cash-title">

                    选择以下支付方式付款

                </div>
                <div class="payment-box ">
                    <div class="payment-header clearfix">
                        <div class="title">
                            支付平台
                        </div>
                        <span class="desc"></span>
                    </div>
                    <div class="payment-body">
                        <ul class="clearfix payment-list J_paymentList J_linksign-customize">
                            <li class="J_bank">
                                <input type="radio" value="alipay">
                                <img src="../../../imgas/payimg/payOnline_zfb.png" alt="支付宝" style="margin-left: 0;">
                            </li>

                            <li class="J_bank">
                                <img src="../../../imgas/payimg/weixinpay.png" alt="微信支付" style="margin-left: 0;">
                            </li>

                            <li class="J_bank">
                                <input type="radio" value="unionpay">
                                <img src="../../../imgas/payimg/unionpay.png" alt="银联" style="margin-left: 0;">
                            </li>

                            <li class="J_bank">
                                <input type="radio" value="alipay">
                                <img src="../../../imgas/payimg/micash.png" alt="小米钱包" style="margin-left: 0;">
                            </li>

                        </ul>
                        <div class="event-desc">
                            <div class="Recharge">
                                充值
                            </div>
                            <input type="text" class="money" id = "rechargeMoney">
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
