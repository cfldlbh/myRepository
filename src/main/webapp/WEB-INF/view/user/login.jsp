<%--
  Created by IntelliJ IDEA.
  User: llbbhh
  Date: 2018/9/11
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <%@ include file="/head.jsp"%>
</head>
<body  >
<div class="loginMain">
    <form class="layui-form" action="${pageContext.request.contextPath}/user/loginValid">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名：</label>
            <div class="layui-input-block">
                <input type="text" name="loginname" required="" lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input" maxlength="16">
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
            <label class="layui-form-label">验证码:</label>
            <div class="layui-input-block">
                <input type="text" name="verify" required="" lay-verify="required" placeholder="请输入验证码" autocomplete="off" class="layui-input" maxlength="5">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="formDemo">登录</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
