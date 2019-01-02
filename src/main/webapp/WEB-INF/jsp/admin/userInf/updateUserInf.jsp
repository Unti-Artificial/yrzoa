<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2018/12/18
  Time: 11:23
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
    <title>更改用户信息界面</title>
    <link href="<%=basePath%>layui/css/layui.css" rel="stylesheet">
    <style type="text/css">
    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">易融租办公系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="javascript:;">打卡</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;" onclick="doClock('${updateName}')">上班打卡</a></dd>
                    <dd><a href="javascript:;" onclick="doClockOut('${updateName}')">下班打卡</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="">欢迎您,${USER_NAME}</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">身份:${USER_ROLE}</a></dd>
                    <dd><a href="<%=basePath%>oaSystem/updateInf.action">修改信息</a></dd>
                    <dd><a href="javascript:;">权限管理</a></dd>
                    <dd><a href="<%=basePath%>oaSystem/Logout.action">注销登陆</a></dd>
                </dl>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item">
                    <a href="<%=basePath%>oaSystem/toMain.action?userId=${userId}">后台主页面</a>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">信息管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=basePath%>oaSystem/doFindOwnInf.action?userId=${updateId}">查看个人信息</a></dd>
                        <dd><a href="<%=basePath%>oaSystem/doEditOwnInf.action?userId=${updateId}">修改个人信息</a></dd>
                        <dd><a href="<%=basePath%>oaSystem/doEditPwd.action?userId=${updateId}">修改登录密码</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">考勤管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=basePath%>oaSystem/clockOwnInf.action?userId=${userId}">查看本月考勤信息</a></dd>
                        <dd><a href="<%=basePath%>oaSystem/clockInf.action">查看全体人员本月考勤信息</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="<%=basePath%>oaSystem/showInform.action?userId=${userId}">公告管理</a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">工作管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">查看工作日志</a></dd>
                        <dd><a href="javascript:;">查看当月记事</a></dd>
                        <dd><a href="javascript:;">填写文档</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">日历记事</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">查看记事</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">流程管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">流程查看</a></dd>
                        <dd><a href="javascript:;">部署流程</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">审批管理</a>
                </li>
                <li class="layui-nav-item"><a href="javascript:;">系统管理</a></li>

            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>个人信息汇总</legend>
        </fieldset>

        <div class="layui-container">
            <form action="" class="layui-form" lay-filter="form1" id="updateForm">
                <input type="hidden" name="userId" value="${updateId}" id="update_id">
                <div class="layui-form-item" style="margin-top: 30px">
                    <label class="layui-form-label">账户名</label>
                    <div class="layui-input-block">
                        <input type="text" name="userAccount" id="update_account" value="${updateAccount}" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item"  style="margin-top: 30px">
                    <label class="layui-form-label">姓名</label>
                    <div class="layui-input-block">
                        <input type="text" name="userName" id="update_name" value="${updateName}" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item"  style="margin-top: 30px">
                    <label class="layui-form-label">邮箱</label>
                    <div class="layui-input-block">
                        <input type="text" name="userEmail" id="update_email" value="${updateEmail}" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item"  style="margin-top: 30px">
                    <label class="layui-form-label">电话</label>
                    <div class="layui-input-block">
                        <input type="text" name="userPhone" id="update_phone" value="${updatePhone}" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" onclick="doUpdate()">立即提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="layui-footer la">
        <!-- 底部固定区域 -->
        © 易融租网络科技有限公司 2018-2019
    </div>
</div>
</body>
<script src="<%=basePath%>layui/layui.js"></script>
<script src="<%=basePath%>js/jquery-1.11.3.min.js"></script>
<script>
    layui.use(['jquery', 'layer','element'], function (){
        var element = layui.element;
    });
    function doClockOut(userName) {
        $.ajax({
            type: "post",
            url:"<%=basePath%>oaSystem/clockOut.action",
            data:{"userName" : userName},
            success(data){
                if(data =="success"){
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "下班打卡成功,出行请注意安全",
                            anim:4
                            ,offset: ['200px', '500px']
                        });
                    });
                }else if (data == "failure"){
                    layui.use('layer',function () {
                        var layer = layui.layer;
                        layer.open({
                            title:"打卡信息",
                            content:"打开失败,请联系管理员",
                            anim:4
                            ,offset: ['200px', '500px']
                        })
                    })
                }else if (data == "out clocked"){
                    layui.use('layer',function () {
                        var layer = layui.layer;
                        layer.open({
                            title:"打卡信息",
                            content:"已经打过卡",
                            anim:4
                            ,offset: ['200px', '500px']
                        })
                    })
                }else if (data == "unknown error"){
                    layui.use('layer',function () {
                        var layer = layui.layer;
                        layer.open({
                            title:"打卡信息",
                            content:"出现未知错误，请联系管理员",
                            anim:4
                            ,offset: ['200px', '500px']
                        })
                    })
                }else if (data == "time error"){
                    layui.use('layer',function () {
                        var layer = layui.layer;
                        layer.open({
                            title:"打卡信息",
                            content:"未到规定时间，请17：30来打卡",
                            anim:4
                            ,offset: ['200px', '500px']
                        })
                    })
                }
            }
        })
    }
    function doClock(userName) {
        $.ajax({
            type: "post",
            url: "<%=basePath%>oaSystem/clockIn.action",
            data: {"userName": userName},
            success(data) {
                if (data == "clocked") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "今日已经完成打卡",
                            anim:4
                            ,offset: ['200px', '500px']
                        });
                    });
                } else if (data == "success") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "打卡成功",
                            anim:4
                            ,offset: ['200px', '500px']
                        });
                    });
                } else if (data == "failure") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "打卡失败",
                            anim:4
                            ,offset: ['200px', '500px']
                        });
                    });
                } else if (data == "late") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "今日迟到，打卡成功，明天请注意!",
                            anim:4
                            ,offset: ['200px', '500px']
                        });
                    });
                } else if (data == "late failure") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "今日迟到，打卡失败，请联系相关人员!",
                            anim:4
                            ,offset: ['200px', '500px']
                        });
                    })
                } else if (data == "late clocked") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "今日迟到,已经打过卡",
                            anim:4
                            ,offset: ['200px', '500px']
                        });
                    });
                } else if (data == "null") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "用户信息出现错误,请联系管理员",
                            anim:4
                            ,offset: ['200px', '500px']
                        });
                    });
                }
            }
        })
    }
    function doUpdate(){
        layui.use(['layer','jquery'],function () {
            var $ = layui.$
                ,layer = layui.layer;
        $.ajax({
            type:"post",
            url:"<%=basePath%>oaSystem/doUpdateInf.action",
            data:$("#updateForm").serialize(),
            success(data) {
                if(data == "success"){
                    layer.msg("更改成功",{icon: 1,time:1000,end:function(){
                            location.reload();
                        }})
                }else if (data =="failure"){
                    layer.msg("更改失败",{icon: 2,time:1000,end:function(){
                            location.reload();
                        }})
                }
            }
        })
    }
</script>
</html>