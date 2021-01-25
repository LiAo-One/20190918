<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.liao.entity.User" %>
<%@ page import="com.liao.util.ResJson" %>
<%@ page import="com.liao.service.UserService" %>
<%@ page import="com.liao.factory.ObjectFactory" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>登录</title>


</head>

<body>
<%
    String loginName = request.getParameter("loginName");
    String loginPwd = request.getParameter("loginPwd");
    User u = new User();

    u.setLoginName(loginName);
    u.setLoginPwd(loginPwd);

    UserService userService = (UserService) ObjectFactory.getBean("UserService");
    ResJson json = userService.login(u);
    if (json.getSub()) {
        User user = (User) json.getList().get(0);
        out.print("登录成功" + u.getLoginName());
    } else {
        out.print(json.getStr());
    }
%>
</body>
</html>
