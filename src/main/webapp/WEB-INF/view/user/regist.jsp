<%--
  Created by IntelliJ IDEA.
  User: llbbhh
  Date: 2018/9/17
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/head.jsp" %>
<html>
<head>
    <title>regist</title>
    <SCRIPT>
        var registUrl = "${pageContext.request.contextPath}/user/register";
    </SCRIPT>
</head>
<body>
<div class="registerMain">
    <form class="layui-form" method="post" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名：</label>
            <div class="layui-input-inline">
                <input type="text" name="loginname" required="" lay-verify="required" placeholder="将用于登录账号使用" autocomplete="off" class="layui-input" maxlength="16">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码：</label>
            <div class="layui-input-inline">
                <input type="password" name="password" required="" lay-verify="required" lay-vertype="tips" placeholder="请输入密码" autocomplete="off" class="layui-input" maxlength="20">
            </div>
            <div class="layui-form-mid layui-word-aux">请输入6到20位的密码</div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号：</label>
            <div class="layui-input-inline">
                <input type="text" name="phonenumber" required="" lay-verify="phone" placeholder="请输入11位手机号" autocomplete="off" class="layui-input" maxlength="16">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">昵称：</label>
            <div class="layui-input-inline">
                <input type="text" name="username" required="" lay-verify="required" placeholder="社交名称" autocomplete="off" class="layui-input" maxlength="16">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱地址：</label>
            <div class="layui-input-inline">
                <input type="text" name="email" required="" lay-verify="email"  autocomplete="off" class="layui-input" maxlength="40">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
