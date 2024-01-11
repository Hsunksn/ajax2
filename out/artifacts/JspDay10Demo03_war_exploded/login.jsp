<%--
  Created by IntelliJ IDEA.
  User: zhangqin
  Date: 2024/1/9
  Time: 下午7:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login.do" method="post">
    用户名：<input type="text" name="userName">
    密码： <input type="password" name="pwd">
    <input value="登陆" type="submit">
    <input value="重置" type="reset">
</form>
<form>
    <a href="${pageContext.request.contextPath}/Sign.jsp">没有账户？点击注册</a>
</form>
</body>
</html>
