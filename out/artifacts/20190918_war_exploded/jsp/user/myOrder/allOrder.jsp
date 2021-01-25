<%--
  Created by IntelliJ IDEA.
  User: liao9
  Date: 2019/10/20
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>全部订单</title>
    <script src="../../../js/jquery-1.12.0.js"></script>
    <script src="../../../js/util.js"></script>
    <script src="../../../js/user/myOrder/allOrder.js"></script>
    
    
    
    <link rel="stylesheet" href="../../../css/font-awesome.css">
    <link rel="stylesheet" href="../../../fonts/fontCss.css">
    <link rel="stylesheet" href="../../../css/common.css">
    <link rel="stylesheet" href="../../../css/user/myOrder/allOrder.css">
    
    
    
    
</head>
<body>
    <%--<div class="J_orderList">
    
        <ul class="order-list">
            <li class="uc-order-item uc-order-item-finish">
                <div class="order-remove">
                    <i class="fa fa-trash-o"></i>
                </div>
                <div class="order-detail">
                    <div class="order-summary">
                        <div class="order-status">已收货</div>
                    </div>
                    <table class="order-detail-table">
                        <thead>
                            <tr>
                                <th class="col-main">
                                    <p class="caption-info">
                                        2019年10月03日 20:51
                                        <span class="sep">|</span>
                                        李澳
                                        <span class="sep">|</span>
                                        订单号：5191003906811483
                                    </p>
                                </th>
                                <th class="col-sub">
                                    <p class="caption-price">
                                        实付金额
                                        <span class="num">699.00</span>
                                        元
                                    </p>
                                </th>
                            </tr>
                        </thead>

                        <tbody>
                           <tr class="solid">
                               <td class="order-items">
                                       <ul class="goods-list">
                                           <li>
                                               <div class="figure figure-thumb">
                                                   <a href="" >
                                                       <img src="../../../goodsimg/pms_1555075954.81667747.jpg" alt="">
                                                   </a>
                                               </div>
                                               <p class="name">
                                                   <a href="">Redmi 7 3GB+32GB 亮黑色 32GB</a>
                                               </p>
                                               <p class="price">699元 × 1</p>
                                           </li>
                                       </ul>
                                   </td>
                               <td class="order-actions">
                                       <a href="btn btn-small btn-line-gray">订单详情</a>
                                       <a href="btn btn-small btn-line-gray">晒单评价</a>
                                       <a href="btn btn-small btn-line-gray">申请售后</a>
                               </td>
                           </tr>
                        </tbody>
                    </table>
                </div>
            </li>
        </ul>  
    </div>
    
    --%>
    <div class = J_orderList></div>
    
</body>
	<script>
		new TAL({
			"renderTo": "J_orderList",
			"requData": "../../../manager/servlet/UserIdOrderAll.action",
			"postData":{
				situation:"全部"
			}
		})
	</script>
	
</html>
