<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>图片上传</title>

    <script src="js/jquery-1.12.0.js"></script>
    <script>
        function showImg(fileName) {

            $("<img src='goodsimg/" + fileName + "'/>").appendTo($("#upload-list"));
        }
    </script>

</head>

<body>
<form action="servlet/UploadServlet" target="iframe-upload" method="post" enctype="multipart/form-data">
    <input type="file" name="fileName"/>

    <input type="submit"/>

</form>

<iframe id="iframe-upload" name="iframe-upload" style="display: none"></iframe>

<div id="upload-list">

</div>
</body>
</html>
