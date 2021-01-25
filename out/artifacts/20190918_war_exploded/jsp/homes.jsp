<%--
  Created by IntelliJ IDEA.
  User: liao9
  Date: 2019/9/10
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.liao.entity.User" %>
<%
    String userName = "";
    int lev = 0;
    String userImg = "";

    HttpSession s = request.getSession();

    User u = (User) s.getAttribute("user");

    if (u != null) {
        lev = Integer.parseInt(u.getLev());
        userName = u.getNikeName();
        userImg = "../imgas/" + u.getImg();
    } else {
        response.sendRedirect("login.jsp");
    }

    // 获取浏览器中所有的cookie
    /*Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        // 遍历cookies
        for (Cookie c : cookies) {
            if (c.getName().equals("userName")) {
                //userName = c.getValue();
            }
        }
    } else {
        // userName为空，说明没有登录
        response.sendRedirect("login.jsp");
    }

    // 判断用户是否登录
    if (userName.trim().length() == 0) {
        // userName为空，说明没有登录
        response.sendRedirect("login.jsp");
    }*/

    if (lev < 5) {
        // 用户登录 判断用户的等级
        response.sendRedirect("Homepage.jsp");
    }

    ServletContext context = this.getServletContext();

    int num = (Integer) context.getAttribute("num");
%>
<html>
<head>
    <title>你好啊 李澳—主页</title>
    <script src="../js/jquery-1.12.0.js"></script>
    <script src="../js/Buts.js"></script>
    <script src="../js/dialog.js"></script>
    <script src="../js/dialog-tips.js"></script>
    <script src="../js/home.js"></script>


    <link rel="stylesheet" href="../css/font-awesome.css">
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/dialog-tips.css">
    <link rel="stylesheet" href="../css/home.css">

</head>
<body>
<%--    头部--%>
<div class="heads">
<%--    <span class="userNum">在线人数:${num}</span>--%>
    <%--<span id="esc" class="esc">退出</span>--%>
    <div class="heads-icon">

    </div>
    <div class="heads-hlep">
        <lable class="labl">
            <i class="fa fa-address-book fa-lg" aria-hidden="true"></i>
            <a href="">用户中心</a>
        </lable>

        <lable class="labl">
            <i class="fa fa fa-shopping-cart fa-lg" aria-hidden="true"></i>
            <a href="">购物车</a>
        </lable>

        <lable class="labl">
            <i class="fa fa fa-star fa-lg" aria-hidden="true"></i>
            <a href="">收藏夹</a>
        </lable>

        <lable class="labl" id="esc">
            <i class="fa fa fa-question-circle fa-lg" aria-hidden="true"></i>
            <a href="">退出</a>
        </lable>

    </div>
</div>
<%--    身体--%>
<div class="bodys">
    <%--身体左边--%>
    <div class="bodys-left">
        <%--            头像--%>
        <div class="bodys-left-Avatar">
            <img alt="" src="<%=userImg%>">
        </div>
        <%--        昵称--%>
        <div class="bodys-left-nickname">
            <a href=""><%= userName %>
            </a>
        </div>
        <%--    左边按钮列表--%>
        <div id="size"></div>

    </div>
    <%--右边按钮列表--%>
    <div class="bodys-right">
        <iframe id="manager-page" src="../jsp/manager/userManager.jsp"></iframe>
    </div>

</div>

<div id="dialog">
</div>
<%--底部--%>
<div class="bottoms">

</div>

<!-- 提示信息组件 -->
<div id="dialog-tips">
    <%--<span class="tips-cls tips-success ">请选中一行！</span>--%>
</div>
</body>

<script>
    var but = new BUT({
        "renderTo": "size",
        "dataSource": [{
            "ico": "fa fa-user-circle",
            "name": "用户管理",
            "url": "../jsp/manager/userManager.jsp"
        }, {
            "ico": "fa fa-coffee",
            "name": "商品管理",
            "url": "../jsp/manager/goodsManager.jsp"
        }, {
            "ico": "fa fa-archive",
            "name": "商品类型",
            "url": "../jsp/manager/goodsTypeManager.jsp"
        }, {
            "ico": "fa fa-shopping-basket",
            "name": "购物车管理",
            "url": "../jsp/manager/shoppingCartManager.jsp"
        }, {
            "ico": "fa fa-map-marker",
            "name": "地址管理",
            "url": "../jsp/manager/address.jsp"
        }, {
            "ico": "fa fa-calculator",
            "name": "订单管理",
            "url": "../jsp/manager/orderManager.jsp"
        }, {
            "ico": "fa fa-hand-spock-o",
            "name": "评论管理",
            "url": "../jsp/manager/commentManger.jsp"
        }],
        "onClik": function (obj) {
            $("#manager-page").attr("src", obj.url);
        }
    });
</script>
</html>
