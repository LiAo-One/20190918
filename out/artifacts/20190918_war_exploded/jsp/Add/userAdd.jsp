<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

    String[] validataArray = {"中文、数字、字母、下划线", "中文、数字、字母", "数字"};
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>用户添加</title>

    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/Add/userAdd.css">
    <link rel="stylesheet" href="css/ddl-demo.css">


    <script src="js/jquery-1.12.0.js"></script>
    <script src="js/Add/userAdd.js"></script>
    <script src="js/ddl.js"></script>
    <script src="js/util.js"></script>
</head>

<body>
<div class="container">
    <div class="goods-data">
        <input id="account" type="text" placeholder="帐号" validata="ne" validataStr= <%= validataArray[1] %>>
        <input id="pwd" type="text" placeholder="密码" validata="ne" validataStr= <%= validataArray[1] %>>
    </div>
    <div class="goods-data">
        <div id="size" style="width: 200px;margin-left: 5em;"></div>
        <input id="name" type="text" placeholder="姓名" validata="ne" validataStr= <%= validataArray[1] %>>
    </div>
    <div class="goods-data">
        <input id="age" type="text" placeholder="年龄" validata="n" validataStr= <%= validataArray[2] %>>
        <input id="lev" type="text" placeholder="等级" validata="n" validataStr= <%= validataArray[2] %>>
    </div>
    <div class="goods-data ">
    </div>
    <button class="add-user">确定</button>
    <button class="empty">清空</button>

    <div class="upload">
        <div class="uoload-button">
            <button>上传图片</button>
        </div>
        <form action="servlet/UserImgUpload.action" target="iframe-upload" method="post" enctype="multipart/form-data">

        </form>

        <iframe id="iframe-upload" name="iframe-upload" style="display: none"></iframe>

        <div id="upload-list">
            <iframe id="iframe-upload" name="iframe-upload" style="display: none"></iframe>
            <!-- 图片显示区域 -->
            <div id="upload-list">

            </div>
        </div>
    </div>
</div>
</body>
<script>
    userType = new DDL({
        "renderTo": "size",
        "dataSource": [{
            "num": "男",
            "size": "男"
        }, {
            "num": "女",
            "size": "女"
        }],
        "mappin": {
            "key": "num",
            "value": "size"
        },
        "defaultSelect": "男",
        "direction": "dow",
        "offset": 1.5,
        "onClik": function (obj) {
        },
        "onComplate": function () { // 组件加载完成事件
            // 判断当前是修改 还是 添加
            if (top.isEdit) {
                // 说明是修改
                fullText();
            }
        }
    });

</script>
</html>
