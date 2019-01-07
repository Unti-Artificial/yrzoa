<%--
  Created by IntelliJ IDEA.
  User: Unti
  Date: 2019/1/2
  Time: 11:13
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
    <link href="<%=basePath%>layui/css/layui.css" rel="stylesheet">
    <title>提交申请</title>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">易融租办公系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="javascript:;">打卡</a>
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
                    <a href="<%=basePath%>oaSystem/toMain.action?userId=${userId}">后台主页面</a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">信息管理</a>
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
                    <a href="javascript:;"></a>
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
    <!--提交审批信息 -->
    <div class="layui-container">
        <div class="layui-card-header">审批信息表</div>
        <div class="layui-card-body" style="padding: 15px;">
            <form class="layui-form" id="approveForm" lay-filter="component-approveForm-group">
                <input type="hidden" name="userId" value="${userId}">
                <div class="layui-form-item">
                    <label class="layui-form-label">审批标题</label>
                    <div class="layui-input-block">
                        <input type="text" name="applyTitle" lay-verify="title" autocomplete="off" placeholder="请输入标题"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">请求人</label>
                    <div class="layui-input-block">
                        <input type="text" name="applyUser" lay-verify="required" autocomplete="off" placeholder="请输入请求人姓名"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">审批信息相关内容</label>
                    <div class="layui-input-block">
                        <textarea name="applyContent" placeholder="请输入相关内容(不得超过100个字)" class="layui-textarea"
                                  onkeyup="keyPress()" id="mytext1"></textarea><font color="#fa8072"><label id="name">你还可以输入100字</label></font>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">提交日期</label>
                    <div class="layui-input-inline">
                        <input type="text" name="applyCreateTime" id="LAY-component-form-group-date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button type="submit" class="layui-btn" onclick="doSubmit()" lay-submit="" lay-filter="component-form-element">提交审批</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
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
<script type="text/javascript">
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
                } else if (data == "success") {
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
    function keyPress()
    {
        var text1=document.getElementById("mytext1").value;
        var len=100-text1.length;
        var show="你还可以输入"+len+"个字";
        document.getElementById("name").innerText=show;
        if(text1.length>100){
            alert("字数已经超过100,请适当删除字数");
            return false;
        }
    }
    layui.use(['form', 'laydate'], function(){
        var $ = layui.$
            ,laydate = layui.laydate
            ,form = layui.form;
        form.render(null, 'component-approveForm-group');
        laydate.render({
            elem: '#LAY-component-form-group-date'
        });
        form.verify({
            title: function(value){
                if(value.length < 3){
                    return '标题过于简短';
                }
            }
        });
    })
        function doSubmit(){
        $.ajax({
            url:"<%=basePath%>oaSystem/startApply.action",
            type:"post",
            data:$("#approveForm").serialize(),
            success(data){
           if (data == "success"){
               layer.msg("提交申请成功",{icon: 2,time:1000,end:function(){
                       location.reload();
                   }})
           }
           else{
               layer.msg("提交申请失败,请重试",{icon: 2,time:1000,end:function(){
                       location.reload();
                   }})
           }
            }


        })
        }
</script>
</html>
