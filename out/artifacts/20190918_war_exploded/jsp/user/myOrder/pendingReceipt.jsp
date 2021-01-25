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
    <title>待付款订单</title>
    <script src="../../../js/jquery-1.12.0.js"></script>
    <script src="../../../js/user/myOrder/pendingReceipt.js"></script>
    
    
    <link rel="stylesheet" href="../../../css/font-awesome.css">
    <link rel="stylesheet" href="../../../fonts/fontCss.css">
    <link rel="stylesheet" href="../../../css/common.css">
    <link rel="stylesheet" href="../../../css/user/myOrder/allOrder.css">
    
    
    
    
</head>
<body>
    
    <div class = J_orderList></div>
    
</body>
	<script>
		new TAL({
			"renderTo": "J_orderList",
			"requData": "../../../manager/servlet/SelectUserShoppingCart.action",
			"postData":{
				situation:"结算"
			}
		})
	</script>
	
</html>
