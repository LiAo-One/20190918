<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'MyJsp.jsp' starting page</title>
    <script src="js/jquery-1.12.0.js"></script>
    <script src="js/ddl.js"></script>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/ddl-demo.css">

    <script src="js/ddl.js"></script>
</head>

<body>
<!--
<div class="ddl-title">


   <div class="list">
     <span class = "head" id="ddl-select-text">请选择</span>
     <span class="list-arrow"></span>
 </div>

 <ul class="item-list">
     <li class="item">请选择</li>
     <li class="item">南京</li>
     <li class="item">宿州</li>
     <li class="item">徐州</li>
 </ul>
</div>

 </div>
     -->
<div id="myddl" style="width: 200px;margin-left: 5em;">

</div>
<div id="size" style="width: 200px;margin-left: 5em;margin-top: 10em;">

</div>
</body>

<script>
    var ddl = new DDL({
        "renderTo": "myddl",
        "dataSource": "servlet/Common.action",
        "prevLoadItem": [{
            "id": "-1",
            "name": "请选择"
        }],
        "mappin": {
            "key": "id",
            "value": "name"
        },
        "defaultSelect": 89745,
        "direction": "dow",
        "offset": 0.9,
        "onClik": function (obj) {
            alert(obj.id);
        }
    });

    var ddl = new DDL({
        "renderTo": "size",
        "dataSource": [{
            "num": 10,
            "size": 10
        }, {
            "num": 20,
            "size": 20
        }, {
            "num": 30,
            "size": 30
        }],
        "mappin": {
            "key": "num",
            "value": "size"
        },
        "defaultSelect": 10,
        "direction": "up",
        "offset": 0.9,
        "onClik": function (obj) {
            alert(obj.id);
        }
    });
</script>
</html>













