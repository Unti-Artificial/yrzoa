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
    <title>Title</title>
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
            <li class="layui-nav-item"><a href="">账户信息管理</a></li>
            <li class="layui-nav-item"><a href="" onclick="fingCalendar()">查看日历</a></li>
            <li class="layui-nav-item"><a href="">公告查看</a></li>
            <li class="layui-nav-item"><a href="javascript:;" onclick="doClock('${userName}')">打卡</a></li>
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
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item">
                 <a href="<%=basePath%>oaSystem/Main.action">后台主页</a>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">信息管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=basePath%>oaSystem/doFindInf.action">查看个人信息</a></dd>
                        <dd><a href="#" onclick="doFindInf()">修改个人信息</a></dd>
                        <dd><a href="<%=basePath%>">修改登录密码</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">考勤管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">查看本月考勤信息</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">公告管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">发布公告</a></dd>
                        <dd><a href="javascript:;">查看公告</a></dd>
                        <dd><a href="javascript:;">公告管理</a></dd>
                    </dl>
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
        <div class="layui-container">
            <div class="layui-row">
                <div class="layui-col-md9">
                    <div class="layui-card">
                        <div class="layui-card-header">工作内容</div>
                        <div class="layui-card-body">
                            <p>卡片式面板面板通常用于非白色背景色的主体内
                                从而映衬出边框投影</p>
                            <p>卡片式面板面板通常用于非白色背景色的主体内
                                从而映衬出边框投影</p>
                            <p>卡片式面板面板通常用于非白色背景色的主体内
                                从而映衬出边框投影</p>
                            <p>卡片式面板面板通常用于非白色背景色的主体内
                                从而映衬出边框投影</p>
                        </div>
                    </div>
                </div>
                <div class="layui-col-md3">
                    <div id="calendarTable"></div>
                </div>
            </div>
        </div>

        <div class="layui-container">
            <div class="layui-row">
                <div class="layui-col-md3">
                     <h2>今日天气预报</h2>
                </div>
                <div class="layui-col-md9">
                   <div id="InformContent">
                         天气预报内容
                   </div>
                </div>
            </div>
        </div>

        <div class="layui-container">
            <div class="layui-row">
                <div class="layui-col-md4">
                    <div class="layui-card">
                        <div class="layui-card-header">
                            放假事宜
                        </div>

                        <div class="layui-card-body">
                            内容
                        </div>
                    </div>
                </div>
                <div class="layui-col-md4">
                    <div class="layui-card">
                        <div class="layui-card-header">
                            通告
                        </div>

                        <div class="layui-card-body">
                            内容
                        </div>
                    </div>
                </div>
                <div class="layui-col-md4">
                    <div class="layui-card">
                        <div class="layui-card-header">
                            通讯录
                        </div>
                        <div class="layui-card-body">
                            内容
                        </div>
                    </div>
                </div>
            </div>
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
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        laydate.render({
            elem: '#calendarTable'
            ,position: 'static'
            ,format: '北京时间:yyyy年MM月dd日'
            ,calendar: true
            ,showBottom: false
            ,change: function(value, date){ //监听日期被切换
                lay('#testView').html(value);
            }
        });
    });
    function doFindInf(userId) {
            $.ajax({
                type:"post",
                url:"<%=basePath%>oaSystem/doFindInf.action",
                data:{"userId":userId},
                success(data){
                    console.log(data);
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
                        });
                    });
                } else if (data == "success") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "打卡成功",
                        });
                    });
                } else if (data == "failure") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "打卡失败",
                        });
                    });
                } else if (data == "late") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "今日迟到，打卡成功，明天请注意!",
                        });
                    });
                } else if (data == "late failure") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "今日迟到，打卡失败，请联系相关人员!",
                        });
                    })
                } else if (data == "late clocked") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "今日迟到,已经打过卡!",
                        });
                    });
                } else if (data == "null") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "用户信息出现错误,请联系管理员",
                        });
                    });
                }
            }
        })
    }
</script>
</html>