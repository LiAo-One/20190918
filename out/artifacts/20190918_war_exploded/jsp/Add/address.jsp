<%--
  Created by IntelliJ IDEA.
  User: liao9
  Date: 2019/10/28
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加地址</title>
    <link rel="stylesheet" href="../../css/font-awesome.css">
    <link rel="stylesheet" href="../../fonts/fontCss.css">
    <link rel="stylesheet" href="../../css/common.css">
    <link rel="stylesheet" href="../../css/Add/address.css">

    <script src="../../js/jquery-1.12.0.js"></script>
    <script src="../../js/util.js"></script>
    <script src="../../js/Add/address.js"></script>
    <script src="../../js/user/myOrder/address.js"></script>
</head>
<body>
    <div class="modal-body">
        <div class="form-box clearfix">
            <div class="form-section form-name form-section-active form-section-valid">
                <label for="user_name" class="input-label">姓名</label>
                <input type="text" class="input-text J_addressInput" placeholder="收货人姓名">
            </div>
            <div class="form-section form-phone form-section-active form-section-valid">
                <label for="user_phone" class="input-label">11位手机号</label>
                <input type="text" class="input-text J_addressInput" placeholder="手机号">
            </div>
            <div class="form-section form-address-detail form-section-active form-section-valid">
                <label for="user_adress" class="input-label">详细地址</label>
                <textarea name="" id="" cols="30" rows="10" class="input-text J_addressInput" placeholder="详细地址，路名或街道名称，门牌号"> </textarea>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <a class="btn btn-primary">
            保存
        </a>
        <a class="btn btn-gray">
            清空
        </a>
    </div>
</body>
</html>
