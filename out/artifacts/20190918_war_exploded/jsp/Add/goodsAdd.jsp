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

    <title>商品添加</title>
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/Add/goodsAdd.css">
    <link rel="stylesheet" href="css/ddl-demo.css">


    <script src="js/jquery-1.12.0.js"></script>
    <script src="js/Add/goodsAdd.js"></script>
    <script src="js/ddl.js"></script>
    <script src="js/util.js"></script>
</head>

<body>
<div class="title-head">
    <div class="container">
        <div class="goods-data">

            <input id="name" type="text" placeholder="名称" validata="ne" validataStr= <%= validataArray[1] %>>
            <input id="price" type="text" placeholder="价格" validata="n" validataStr= <%= validataArray[2] %>>
            <div id="myddl" style="width: 200px;margin-left: 5em;"></div>
        </div>
        <div class="goods-data">
            <input id="shelflife" type="text" placeholder="保质期" validata="n" validataStr= <%= validataArray[2] %>>
            <input id="post" type="text" placeholder="邮递" validata="ne" validataStr= <%= validataArray[1] %>>
            <input id="img" type="text" placeholder="图片" validata="ne" validataStr= <%= validataArray[1] %>>
        </div>
        <div class="goods-data">
            <input id="inStock" type="text" placeholder="库存" validata="n" validataStr= <%= validataArray[2] %>>
            <input id="salesVolume" type="text" placeholder="销量" validata="n" validataStr= <%= validataArray[2] %>>
            <input id="factory" type="text" placeholder="厂家" validata="ne" validataStr= <%= validataArray[1] %>>
        </div>
        <div class="goods-data">
            <input id="store" type="text" placeholder="店家" validata="ne" validataStr= <%= validataArray[1] %>>
            <input id="discount" type="text" placeholder="折扣" validata="n" validataStr= <%= validataArray[2] %>>
            <input id="situation" type="text" placeholder="状态" validata="ne" validataStr= <%= validataArray[0] %>>
        </div>

        <button class="add-goods">确定</button>
        <button class="empty">清空</button>

        <div class="upload">
            <div class="uoload-button">
                <button>上传图片</button>
            </div>
            <form action="servlet/GoodsImgUpload.action" target="iframe-upload" method="post"
                  enctype="multipart/form-data">

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
</div>
</body>
<script>
    goodsType = new DDL({
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
        "offset": 1.2,
        "onClik": function (obj) {
            /* alert(obj.id); */
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
