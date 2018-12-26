<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2018/12/18
  Time: 10:42
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
    <title>登陆界面</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>login/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>login/css/demo.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>login/css/component.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>layui/css/layui.css" media="all">
    <script type="text/javascript" src="<%=basePath%>layui/layui.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
</head>
<body>
<div class="layui-canvs"></div>
<div class="layui-layout layui-layout-login">

    <div class="container demo-1">
        <div class="content">
            <div id="large-header" class="large-header">
                <canvas id="demo-canvas"></canvas>
                <div class="logo_box">
                    <h3>欢迎你</h3>
                    <p style="color: #45BDA6">${error1}</p>
                    <p style="color: #45BDA6">${error2}</p>
                    <form action="<%=basePath%>oaSystem/Login.action" id="LoginForm" class="layui-form">
                        <div class="input_outer">
                            <span class="u_user"></span>
                            <input name="account" class="text" style="color: #FFFFFF !important" type="text" autocomplete="off" id="user_account" placeholder="请输入账户">
                        </div>
                        <div class="input_outer">
                            <span class="us_uer"></span>
                            <input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" id="user_password" type="password" placeholder="请输入密码">
                        </div>
                        <div class="input_outer">
                            <input name="" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="登录" type="submit">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div><!-- /container -->
</div>
</body>

<script src="<%=basePath%>login/js/TweenLite.min.js"></script>
<script src="<%=basePath%>login/js/EasePack.min.js"></script>
<script src="<%=basePath%>login/js/rAF.js"></script>
<script src="<%=basePath%>login/js/demo-1.js"></script>
<script type="text/javascript">

</script>
</html>