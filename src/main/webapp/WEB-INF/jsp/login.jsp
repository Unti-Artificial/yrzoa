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
    <link rel="stylesheet" type="text/css" href="<%=basePath%>layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css" media="all">
</head>
<body>
<div class="layui-canvs"></div>
<div class="layui-layout layui-layout-login">
    <h1>
        <strong>办公系统</strong>
    </h1>
    <p style="color: #45BDA6">${msg}</p>
    <form action="/oaSystem/Login.action">
    <div class="layui-user-icon larry-login">
        <input type="text" placeholder="账号" class="login_txtbx" name="account"/>
    </div>
    <div class="layui-pwd-icon larry-login">
        <input type="password" placeholder="密码" class="login_txtbx" name="password" />
    </div>
   <div class="layui-user-icon larry-login">
       <select name="role" class="login_txtbx">
           <option value="">请选择一个身份</option>
           <option value="user">用户</option>
           <option value="admin">管理员</option>
       </select>
   </div>
    <div class="layui-submit larry-login">
        <input type="submit" value="立即登陆" class="submit_btn"/>
    </div>
    </form>
    <div class="layui-login-text">
        <p>© 2018-2019 yrz 版权所有</p>
        <p>易融租网络科技有限公司</p>
    </div>
</div>
</body>
<script type="text/javascript" src="<%=basePath%>/layui/layui.all.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login.js"></script>
<script type="text/javascript" src="<%=basePath%>jsplug/jparticle.jquery.js"></script>
<script type="text/javascript">
    $(function(){
        $(".layui-canvs").jParticle({
            background: "#141414",
            color: "#E6E6E6"
        });

    });
</script>
</html>