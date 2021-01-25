<%--
  Created by IntelliJ IDEA.
  User: liao9
  Date: 2019/10/21
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>确认订单</title>

    <link rel="stylesheet" href="../../../css/font-awesome.css">
    <link rel="stylesheet" href="../../../css/common.css">
    <link rel="stylesheet" href="../../../fonts/fontCss.css">
    <link rel="stylesheet" href="../../../css/user/myOrder/confirmOrder.css">
    <link rel="stylesheet" href="../../../css/home.css">

    <script src="../../../js/jquery-1.12.0.js"></script>
    <script src="../../../js/user/myOrder/myOrder.js"></script>
    <script src="../../../js/user/myOrder/address.js"></script>
    <script src="../../../js/user/myOrder/orders.js"></script>
    <script src="../../../js/util.js"></script>
    <script src="../../../js/user/myOrder/confirmOrder.js"></script>
    <script src="../../../js/dialog.js"></script>

</head>
<body>
    <div class="site-header site-mini-header">
        <div class="container">
            <div class="header-logo">
                <a class="logo" href=""></a>
            </div>

            <div class="header-title">
                <h2>确认订单</h2>
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
        <div class="container">
            <div class="checkout-box">
                <div class="section section-address">
                    <div class="section-header clearfix">
                        <h3 class="title">收货地址</h3>
                        <div class="more">

                        </div>
                        <div class="mitv-tips hide" style="margin-left: 0;border: none;"></div>
                    </div>

                    <%--<div class="section-body clearfix">
                        <div class="address-item J_addressItem ">
                            <dl>
                                <dt>
                                    <span class="tag"></span>
                                    <em class="uname">李澳</em>
                                </dt>
                                <dd class="utel">
                                    184****1502
                                </dd>
                                <dd class="uaddress">
                                    江苏 镇江市 句容市 华阳街道
                                    <br>
                                    文昌东路19号江苏农林职业技术学院
                                </dd>
                            </dl>
                        </div>
						
                        <div class="address-item J_addressItem ">
                            <dl>
                                <dt>
                                    <span class="tag"></span>
                                    <em class="uname">李澳</em>
                                </dt>
                                <dd class="utel">
                                    184****1502
                                </dd>
                                <dd class="uaddress">
                                    江苏 镇江市 句容市 华阳街道
                                    <br>
                                    文昌东路19号江苏农林职业技术学院
                                </dd>
                            </dl>
                        </div>
						
                        <div class="address-item address-item-new">
                            <i class="fa fa-plus-circle" aria-hidden="true"></i>
                            <br>
                            添加地址
                        </div>
                    </div>
                    
                    
                --%>
                <div class="section-bodys clearfix"></div>
                </div>

                <div class="section section-goods">
                    <div class="section-header clearfix">
                        <h3 class="title">商品及优惠券</h3>
                    </div>

                    <div class="section-body">
                        <%--<ul class="goods-list">
                            <li class="clearfix">
                                <div class="col col-img">
                                    <img src="../../../imgas/goods/pms_1496889806.98781765!80x80.jpg" alt="">
                                </div>
                                <div class="col col-name">
                                    <a href="">
                                        小米盒子4
                                    </a>
                                </div>
                                <div class="col col-price">
                                    299元 x 1
                                </div>
                                <div class="col col-status">
                                    &nbsp;
                                </div>
                                <div class="col col-total">
                                    299元
                                </div>
                            </li>

                            <li class="clearfix">
                                <div class="col col-img">
                                    <img src="../../../imgas/goods/pms_1496889806.98781765!80x80.jpg" alt="">
                                </div>
                                <div class="col col-name">
                                    <a href="">
                                        小米盒子4
                                    </a>
                                </div>
                                <div class="col col-price">
                                    299元 x 1
                                </div>
                                <div class="col col-status">
                                    &nbsp;
                                </div>
                                <div class="col col-total">
                                    299元
                                </div>
                            </li>
                        </ul>
--%>
                   	<ul class="goods-list"></ul>
                    </div>
                </div>
                <div class="section section-options section-payment clearfix hide">
                    <div class="section-header">
                        <h3 class="title">支付方式</h3>
                    </div>
                </div>
                <div class="section section-options section-shipment clearfix">
                    <div class="section-header">
                        <h3 class="title">配送方式</h3>
                    </div>
                    <div class="section-body clearfix">
                        <ul class="clearfix J_optionList options ">
                            <li class="J_option selected">

                                包邮
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="section section-options section-invoice clearfix">
                    <div class="section-header">
                        <h3 class="title">发票</h3>
                    </div>
                    <div class="section-body clearfix">
                        <div class="invoice-result">
                            <span>电子发票</span>
                            <span>个人</span>
                            <span>商品明细</span>
                            <a href="">修改></a>
                        </div>
                    </div>
                </div>
                <div class="section section-count clearfix">
                    <div class="count-actions">
                        <a href="" class="coupon-trigger">
                            <i class="fa fa-plus-circle" aria-hidden="true">
                                使用优惠券
                            </i>
                        </a>
                        <a href="" class="ecard-trigger">
                            <i class="fa fa-plus-circle" aria-hidden="true">
                                使用小米礼品卡
                            </i>
                        </a>
                    </div>
                    <div class="money-box">
                        <ul>
                            <li class="clearfix">
                                <label for="">商品件数：</label>
                                <span class="val shuliang">2件</span>
                            </li>
                            <li class="clearfix">
                                <label for="">商品总价：</label>
                                <span class="val priceGoods">308.9元</span>
                            </li>
                            <li class="clearfix">
                                <label for="">活动优惠：</label>
                                <span class="val">-0元</span>
                            </li>
                            <li class="clearfix">
                                <label for="">优惠券抵扣：</label>
                                <span class="val">-0元</span>
                            </li>
                            <li class="clearfix">
                                <label for="">运费：</label>
                                <span class="val">-0元</span>
                            </li>
                            <li class="clearfix total-price">
                                <label for="">应付总额：</label>
                                <span class="val">
                                    <em>308.9</em>元
                                </span>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="section-bar clearfix">
                    <div class="fl"></div>
                    <div class="fr">
                        <a class="btn btn-primary">去结算</a>
                        <a href="" class="btn  btn-return">返回购物车</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
<%--    弹出对话框--%>
    <div id="dialog"></div>
</body>
<script>
	
	new ADDRESS({
		renderTo:"section-bodys",
		"requData": "../../../manager/servlet/selectUserAddress.action",
		"postData":{
			situation:"存在"
		}
	})
	
	new ORDER({
		renderTo:"goods-list",
		"requData": "../../../manager/servlet/SelectUserShoppingCart.action",
		"postData":{
			situation:"结算"
		}
	})
		
	
</script>
</html>
