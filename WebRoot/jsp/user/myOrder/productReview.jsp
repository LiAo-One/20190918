<%--
  Created by IntelliJ IDEA.
  User: liao9
  Date: 2019/10/23
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品评价</title>

	<script src="../../../js/jquery-1.12.0.js"></script>
	<script src="../../../js/util.js"></script>
    <script src="../../../js/user/myOrder/productReview.js"></script>


    <link rel="stylesheet" href="../../../css/font-awesome.css">
    <link rel="stylesheet" href="../../../fonts/fontCss.css">
    <link rel="stylesheet" href="../../../css/common.css">
    <link rel="stylesheet" href="../../../css/user/myOrder/productReview.css">
    
    
</head>
<body>
<div class="span16">
    <div class="goods-comment-detail">
        <div class="container">
            <div class="row">
                <div class="comment-top">
                    <h2 class="title">
                        服务评价
                    </h2>
                </div>
                <div class="comment-content">
                    <div class="clearfix cont-top J_top ">
                        <div class="top-l">
                            <div class="top-common">
                                <div class="common-l">

                                    物流包装
                                </div>
                                <div class="common-r J_stars">
                                    <div class="star chose">
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="star chose">
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="star chose">
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="star chose">
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="star chose">
                                        <i class="fa fa-star"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="top-common">
                                <div class="common-l">

                                    物流包装
                                </div>
                                <div class="common-r J_stars">
                                    <div class="star chose">
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="star chose">
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="star chose">
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="star chose">
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="star chose">
                                        <i class="fa fa-star"></i>
                                    </div>
                                </div>
                            </div>
                            <div class="top-common">
                                <div class="common-l">

                                    物流包装
                                </div>
                                <div class="common-r J_stars">
                                    <div class="star chose">
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="star chose">
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="star chose">
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="star chose">
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="star chose">
                                        <i class="fa fa-star"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="top-r">
                            <div class="right-text">
                                <textarea placeholder="还有想说的吗？您的意见对我们非常重要" style="height: 99px;" id="comment" cols="30" rows="10"></textarea>
                                <i class="icon"></i>
                                <div class="words">0/500</div>
                            </div>
                            <div class="btn btn-primary submit J_submit">
                                发表评价
                            </div>
                        </div>
                    </div>
                    <div class="cont-content">
                        <div class="comment-common clearfix">
                            <div class="common-left">
                                <img src="../../../goodsimg/pms_1555075954.81667747.jpg" alt="">
                                <div class="title">
                                    Redmi 7 3GB+32GB 亮黑色 32GB
                                </div>
                            </div>
                            <div class="common-right J_right ">
                                <div class="right-top">
                                    <div class="inline">
                                        评分
                                    </div>
                                    <div class="inline J_stars">
                                        <div class="star chose">
                                            <i class="fa fa-star"></i>
                                        </div>
                                        <div class="star chose">
                                            <i class="fa fa-star"></i>
                                        </div>
                                        <div class="star chose">
                                            <i class="fa fa-star"></i>
                                        </div>
                                        <div class="star chose">
                                            <i class="fa fa-star"></i>
                                        </div>
                                        <div class="star chose">
                                            <i class="fa fa-star"></i>
                                        </div>
                                    </div>
                                    <div class="inline perform">
                                        <div>
                                            <i></i>
                                            <span>超爱</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="right-middle">
                                    <textarea class="middle-text" placeholder="外形如何？品质如何？写写你的感受分享给网友吧！" maxlength="500" cols="30" rows="10"></textarea>
                                    <i class="words">0/500</i>
                                </div>
                                <div class="right-bot">
                                    <div class="btn btn-primary ensure J_ensure">

                                        发表评价

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
