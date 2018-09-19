<%--
  Created by IntelliJ IDEA.
  User: llbbhh
  Date: 2018/9/11
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>

<%@ page pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.js"></script>
    <script src="${pageContext.request.contextPath}/js/vue.js"></script>
    <script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.mobile.css">
</head>
<body>

</body>
<%
    String JSFileForThis = request.getAttribute("jsFilePath") == null ? null : (String) request.getAttribute("jsFilePath");
    String CSSFileForThis = request.getAttribute("cssFilePath") == null ? null : (String) request.getAttribute("cssFilePath");
    if (JSFileForThis != null) {
%>
<script type="text/javascript" src="<%=JSFileForThis%>"></script>
<%
    }
    if (CSSFileForThis != null) {
%>
<link href="<%=CSSFileForThis%>" rel="stylesheet">
<%
    }
%>
</html>
