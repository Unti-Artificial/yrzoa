<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>已发布的公告</title>
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
            <li class="layui-nav-item"><a href="javascript:;" onclick="doClock('${userName}')">打卡</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;" onclick="doClock('${userName}')">上班打卡</a></dd>
                    <dd><a href="javascript:;" onclick="doClockOut('${userName}')">下班打卡</a></dd>
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
                    <a class="" href="javascript:;">信息管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="<%=basePath%>oaSystem/doFindOwnInf.action?userId=${userId}">查看个人信息</a></dd>
                        <dd><a href="<%=basePath%>oaSystem/doEditOwnInf.action?userId=${userId}">修改个人信息</a></dd>
                        <dd><a href="<%=basePath%>oaSystem/doEditPwd.action?userId=${userId}">修改登录密码</a></dd>
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
        <!--  轮播图区域  -->
        <div class="layui-container">
      <div class="layui-carousel" id="carousel1">
          <div carousel-item>
              <div><img src="<%=basePath%>images/carousel1.jpg"></div>
              <div><img src="<%=basePath%>images/carousel2.jpg"></div>
              <div><img src="<%=basePath%>images/carousel3.jpg"></div>
              <div><img src="<%=basePath%>images/carousel4.jpg"></div>
              <div><img src="<%=basePath%>images/carousel5.jpg"></div>
          </div>
      </div>
        </div>
        <!-- 表格主题区域 -->
        <div class="layui-container">
            <table class="layui-table">
                <colgroup>
                    <col width="150">
                    <col width="200">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>公告id</th>
                    <th>公告标题</th>
                    <th>公告发布人</th>
                    <th>公告内容</th>
                    <th>公告发布时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${informList}" var="list">
                    <tr>
                        <td>${list.informId}</td>
                        <td>${list.informTitle}</td>
                        <td>${list.informUserName}</td>
                        <td>${list.informContent}</td>
                        <td>${list.informCreateTime}</td>
                        <td>
                            <button type="button" onclick="doFindInformContent(${list.informId})" class="layui-btn layui-btn-sm">查看公告内容</button>
                            <button type="button" onclick="doFindInform(${list.informId})" class="layui-btn layui-btn-sm">更改公告</button>
                            <button type="button" onclick="doDeleteInform(${list.informId})" class="layui-btn layui-btn-sm">删除公告</button>
                        </td>
                    </tr>
                </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
     <div class="layui-row" id="informInf" style="display: none">
         <div class="layui-col-md11">
             <c:forEach items="${informList}" var="form">
             <form class="layui-form" id="updateInform">
                 <input type="hidden" name="informId" value="${form.informId}">

                 <div class="layui-form-item">
                     <label class="layui-form-label">通知标题</label>
                     <div class="layui-input-inline">
                         <input type="text" name="informTitle" value="${form.informTitle}" class="layui-input">
                     </div>
                 </div>
                 <div class="layui-form-item">
                     <label class="layui-form-label">发布人</label>
                     <div class="layui-input-inline">
                         <input type="text" name="informUserName" value="${form.informUserName}"  class="layui-input">
                     </div>
                 </div>
                 <div class="layui-form-item">
                      <label></label>
                     <div class="layui-input-inline">
                         <input type="time" name="informUserName" value="${form.informUserName}"  class="layui-input">
                     </div>
                 </div>
             </form>
             </c:forEach>
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
    layui.use(['jquery', 'layer', 'element','carousel'], function () {
        var element = layui.element;
        var carousel = layui.carousel;
        carousel.render({
            elem: '#carousel1'
            ,width: '100%' //设置容器宽度
            ,arrow: 'always' //始终显示箭头
            //,anim: 'updown' //切换动画方式
        });
    });
    function doClockOut(userName) {
        $.ajax({
            type: "post",
            url: "<%=basePath%>oaSystem/clockOut.action",
            data: {"userName": userName},
            success(data) {
                if (data == "success") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "下班打卡成功,出行请注意安全",
                            anim: 4
                            , offset: ['200px', '500px']
                        });
                    });
                } else if (data == "failure") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "打开失败,请联系管理员",
                            anim: 4
                            , offset: ['200px', '500px']
                        })
                    })
                } else if (data == "out clocked") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "已经打过卡",
                            anim: 4
                            , offset: ['200px', '500px']
                        })
                    })
                } else if (data == "unknown error") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "出现未知错误，请联系管理员",
                            anim: 4
                            , offset: ['200px', '500px']
                        })
                    })
                } else if (data == "time error") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "未到规定时间，请17：30来打卡",
                            anim: 4
                            , offset: ['200px', '500px']
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
                            anim: 4
                            , offset: ['200px', '500px']
                        });
                    });
                }
                else if (data == "success") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "打卡成功",
                            anim: 4
                            , offset: ['200px', '500px']
                        });
                    });
                } else if (data == "failure") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "打卡失败",
                            anim: 4
                            , offset: ['200px', '500px']
                        });
                    });
                } else if (data == "late") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "今日迟到，打卡成功，明天请注意!",
                            anim: 4
                            , offset: ['200px', '500px']
                        });
                    });
                } else if (data == "late failure") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "今日迟到，打卡失败，请联系相关人员!",
                            anim: 4
                            , offset: ['200px', '500px']
                        });
                    })
                } else if (data == "late clocked") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "今日迟到,已经打过卡",
                            anim: 4
                            , offset: ['200px', '500px']
                        });
                    });
                } else if (data == "null") {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            title: "打卡信息",
                            content: "用户信息出现错误,请联系管理员",
                            anim: 4
                            , offset: ['200px', '500px']
                        });
                    });
                }
            }
        })
    }

    //查看公告
    function doFindInform(informId) {
         $.ajax({
             type:"post",
             url:"<%=basePath%>oaSystem/doFindInform.action",
             data:{"informId":informId},
             success(data){
                 layui.use(['layer','jquery'],function () {
                     var $ = layui.$
                         ,layer = layui.layer;
                     layer.open({
                         type:1,
                         title:"通知信息",
                         area: ['50%','50%'],
                         content:$("#informInf").html()
                     })
                 })
             }

         })
    }
    //删除公告
    function doDeleteInform(informId) {

    }
    //修改公告
    function doUpdate() {

    }
    //添加公告
    function doAddInform(informId) {

    }
    //查看公告内容
    function doFindInformContent(informId) {

    }
</script>
</html>