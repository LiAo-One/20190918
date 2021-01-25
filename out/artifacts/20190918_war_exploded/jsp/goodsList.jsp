<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>goodsList</title>
    <script src="js/util.js"></script>
    <script src="js/jquery-1.12.0.js"></script>
    <script src="js/List.js"></script>


    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/goodsList.css">
</head>

<body>
<%--    <div class="goods">--%>
<%--    	<div class="goods-lab">--%>
<%--    		<img alt="" src="">--%>
<%--    		<ul>--%>
<%--    			<li class="name">MIX4</li>--%>
<%--    			<li class="price">2499.00</li>--%>
<%--    		</ul>--%>
<%--    	</div>--%>
<%--    	--%>
<%--    	<div class="goods-lab">--%>
<%--    		<img alt="" src="">--%>
<%--    		<ul>--%>
<%--    			<li class="name">MIX4</li>--%>
<%--    			<li class="price">2499.00</li>--%>
<%--    		</ul>--%>
<%--    	</div>--%>
<%--    	--%>
<%--    	<div class="goods-lab">--%>
<%--    		<img alt="" src="">--%>
<%--    		<ul>--%>
<%--    			<li class="name">MIX4</li>--%>
<%--    			<li class="price">2499.00</li>--%>
<%--    		</ul>--%>
<%--    	</div>--%>
<%--    	--%>
<%--    	<div class="goods-lab">--%>
<%--    		<img alt="" src="">--%>
<%--    		<ul>--%>
<%--    			<li class="name">MIX4</li>--%>
<%--    			<li class="price">2499.00</li>--%>
<%--    		</ul>--%>
<%--    	</div>--%>
<%--    	--%>
<%--    	<div class="goods-lab">--%>
<%--    		<img alt="" src="">--%>
<%--    		<ul>--%>
<%--    			<li class="name">MIX4</li>--%>
<%--    			<li class="price">2499.00</li>--%>
<%--    		</ul>--%>
<%--    	</div>--%>
<%--    	--%>
<%--    	<div class="goods-lab">--%>
<%--    		<img alt="" src="">--%>
<%--    		<ul>--%>
<%--    			<li class="name">MIX4</li>--%>
<%--    			<li class="price">2499.00</li>--%>
<%--    		</ul>--%>
<%--    	</div>--%>
<%--    	--%>
<%--    	<div class="goods-lab">--%>
<%--    		<img alt="" src="">--%>
<%--    		<ul>--%>
<%--    			<li class="name">MIX4</li>--%>
<%--    			<li class="price">2499.00</li>--%>
<%--    		</ul>--%>
<%--    	</div>--%>
<%--    	--%>
<%--    	<div class="goods-lab">--%>
<%--    		<img alt="" src="">--%>
<%--    		<ul>--%>
<%--    			<li class="name">MIX4</li>--%>
<%--    			<li class="price">2499.00</li>--%>
<%--    		</ul>--%>
<%--    	</div>--%>
<%--    	--%>
<%--    	<div class="goods-lab">--%>
<%--    		<img alt="" src="">--%>
<%--    		<ul>--%>
<%--    			<li class="name">MIX4</li>--%>
<%--    			<li class="price">2499.00</li>--%>
<%--    		</ul>--%>
<%--    	</div>--%>
<%--    	--%>
<%--    	--%>
<%--    </div>--%>
<div id="table" class="tablebox">
</body>
<script type="text/javascript">
    new LIST({
        "renderTo": "table",
        "dataSource": [{
            "img": "img",
            "name": "name",
            "price": "price"
        }, {
            "img": "img",
            "name": "name",
            "price": "price"
        }, {
            "img": "img",
            "name": "name",
            "price": "price"
        }, {
            "img": "img",
            "name": "name",
            "price": "price"
        }, {
            "img": "img",
            "name": "name",
            "price": "price"
        }, {
            "img": "img",
            "name": "name",
            "price": "price"
        }, {
            "img": "img",
            "name": "name",
            "price": "price"
        }, {
            "img": "img",
            "name": "name",
            "price": "price"
        }, {
            "img": "img",
            "name": "name",
            "price": "price"
        }, {
            "img": "img",
            "name": "name",
            "price": "price"
        }, {
            "img": "img",
            "name": "name",
            "price": "price"
        }, {
            "img": "img",
            "name": "name",
            "price": "price"
        }],
        "onClick": function (row) {
            // 单击后跳转到商品详情页
            window.location.href = "jsp/goodsDetails.jsp";
        }
    });
</script>
</html>
