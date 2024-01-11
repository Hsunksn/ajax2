<%--
  Created by IntelliJ IDEA.
  User: zhangqin
  Date: 2024/1/9
  Time: 下午8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>详细信息</title>

</head>
<body>
<table border="1" cellpadding="0" cellspacing="0" width="80%">
    <tr>
        <td>编号</td>
        <td>用户名</td>
        <td>密码</td>
        <td>cpu型号</td>
        <td>gpu型号</td>
        <td>cpu类型</td>
        <td>显示器尺寸</td>
        <td>操作</td>
        id, username, password, cpu, gpu, cpuType, displaySize
    </tr>
    <c:forEach var="li" items="${sbq}">
        <tr>
            <td>${li.id}</td>
            <td>${li.username}</td>
            <td>${li.password}</td>
            <td>${li.cpu}</td>
            <td>${li.gpu}</td>
            <td>${li.cpuType}</td>
            <td>${li.displaySize}</td>
            <td>
                <a href="${pageContext.request.contextPath}/delete.do?id=${li.id}">删除</a>
                <a href="${pageContext.request.contextPath}/findById.do?id=${li.id}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
