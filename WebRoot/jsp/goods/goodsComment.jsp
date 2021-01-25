<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>商品评论</title>
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/goods/goodsComment.css">

    <script src="js/util.js"></script>
    <script src="js/jquery-1.12.0.js"></script>
    <script src="js/goods/goodsComment.js"></script>
</head>

<body>
<div class="comment-main">
    <div class="comment-top">
        <h2 class="mitit">热门评价</h2>

        <!-- <div class="comment-info">
            头像
            <img alt="" src="imgas/Mr.Wick.jpg">
            昵称
            <span class="name">Mr.Wick</span>
            时间
            <span class="time">2019-10-03</span>
            <span class="eval">
                <i class="fa fa-smile-o" aria-hidden="true"></i>
                超爱
            </span>
            <a href="">很喜欢，很满意，爱的不要不要的</a>
            <div class="img">
                <img src="imgas/comment/1569722086_3265118_s1984_1488wh.jpg" alt="" />
                <img src="imgas/comment/1569722086_3265118_s1984_1488wh.jpg" alt="" />
                <img src="imgas/comment/1569722086_3265118_s1984_1488wh.jpg" alt="" />
            </div>
        </div> -->

        <div id="size"></div>
        <!-- 满意度 -->
        <div class="num">
            <img src="imgas/comment/alkwefg.png" alt=""/>
        </div>
    </div>


</div>
</body>

<script>
    var but = new COMM({
        "renderTo": "size"
        
        /* "dataSource":[{
            "name":"李澳",
            "phon":"123456789",
            "add":"江苏 徐州市 贾汪区 翠湖路"
        },{
            "name":"sdf",
            "phon":"dfg56789",
            "add":"江苏 徐州市 贾汪区 翠湖路"
        },{
            "name":"sdf",
            "phon":"dfg56789",
            "add":"江苏 徐州市 贾汪区 翠湖路"
        },{
            "name":"sdf",
            "phon":"dfg56789",
            "add":"江苏 徐州市 贾汪区 翠湖路"
        }] */
    });
</script>
</html>
