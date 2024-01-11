<%--
  Created by IntelliJ IDEA.
  User: zhangqin
  Date: 2024/1/9
  Time: 下午8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"      isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改信息</title>
</head>
<body>
<form  action="${pageContext.request.contextPath}/update.do" method="post">
    <h1>只允许修改cpu  gpu信息</h1>
    <input name="id" type="hidden" value="${ById.id}">
    cpu:<input type="text" name="cpu">
    gpu:<input type="text" name="gpu">
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>
</body>
</html>
