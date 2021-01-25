<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>你好啊 李澳-地址</title>
    <script src="js/jquery-1.12.0.js"></script>
    <script src="js/address.js"></script>
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/address.css">
</head>

<body>
<!--
  <div class = "uc-main-box">
      <div class="uc-content-box">
          <div class="box-hd">
              <h1 class="title">收货地址</h1>
          </div>

          <div class="box-bd">
              <div class="address-item new">
                  <i class="fa fa-plus-circle" aria-hidden="true"></i>
              </div>
              <div class="address-item jadd">
                      <h1 class="name-title">李澳</h1>
                      <h1 class="add-title">18451931208</h1>
                      <h1 class="add-title">江苏 徐州市 贾汪区 翠湖路</h1>
              </div>
              <div class="address-item jadd"></div>
              <div class="address-item jadd"></div>
          </div>
      </div>
  </div>
  -->
<div id="size"></div>
</body>

<script>
    var but = new ADD({
        "renderTo": "size",
        "dataSource": [{
            "name": "李澳",
            "phon": "123456789",
            "add": "江苏 徐州市 贾汪区 翠湖路"
        }, {
            "name": "李澳",
            "phon": "123456789",
            "add": "江苏 徐州市 贾汪区 翠湖路"
        }, {
            "name": "李澳",
            "phon": "123456789",
            "add": "江苏 徐州市 贾汪区 翠湖路"
        }, {
            "name": "李澳",
            "phon": "123456789",
            "add": "江苏 徐州市 贾汪区 翠湖路"
        }, {
            "name": "李澳",
            "phon": "123456789",
            "add": "江苏 徐州市 贾汪区 翠湖路"
        }]
    });
</script>
</html>
