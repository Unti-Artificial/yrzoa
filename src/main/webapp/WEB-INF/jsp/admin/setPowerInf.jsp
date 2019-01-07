<%--
  Created by IntelliJ IDEA.
  User: Unti
  Date: 2019/1/7
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>用户权限设置</title>
</head>
<link href="<%=basePath%>layui/css/layui.css" rel="stylesheet">
<body>

</body>
<script src="<%=basePath%>layui/layui.js"></script>
<script src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
</html>
