<%--
  Created by IntelliJ IDEA.
  User: liao9
  Date: 2019/9/17
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/carouselMap.css">
    <script type="text/javascript" src="../js/bundle.js"></script>
<body>
<div class="wrapper"></div>
</body>
<script>
    var wrapper = document.querySelector('.wrapper');
    wrapper.creatTurnPage(['../ings/a1.jpg', '../ings/a2.jpg', '../ings/a3.jpg',
        '../ings/a4.jpg', '../ings/a5.jpg', '../ings/a6.jpg']);
</script>

</html>
