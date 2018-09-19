<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/head.jsp"%>
    <script>
        window.onload = function(){
            $("#loginOrRegister").click(function(){
                    window.location.href = "user/jumpPageToLogin"
            });
        }
    </script>
</head>
<body background="${pageContext.request.contextPath}/static/indexPictrue.jpg" style="background-size: 100% ">
<div style="text-align: right;">
    <button class="layui-btn layui-btn-radius layui-btn-normal" style="margin-top:20px;margin-right:150px  " id="loginOrRegister">登入/注册</button>
</div>
<div style="margin-top: 50px;">
    <span><input type="text" name="title" required lay-verify="required" placeholder="搜索内容..." autocomplete="off" class="layui-input" style="width: 35%;margin: 0 auto;"></span>
    <span><input type="button" class="layui-btn layui-btn-normal"  value="搜索"></span>
</div>

</body>
</html>
