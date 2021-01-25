<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
  </head>
  
  <body>
  		<form action="servlet/login">
  			<input type="submit" value="asd">
  		</form><%--
  	
	  	验证码：<input type="text" name="loginName" />
	  	
	  	<!--<img id="codeImg" class="codeImg" src="" data-path = "servlet/GetCodePicServlets" alt="" />-->
	  	<img id="codeImg" class="codeImg" src="servlet/GetCodePicServlet" data-path="" alt="验证码" />
		<button id = "log" >登录</button>  	
  --%></body>
</html>
