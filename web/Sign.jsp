<%--
  Created by IntelliJ IDEA.
  User: zhangqin
  Date: 2024/1/9
  Time: 下午7:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册信息</title>
    <script src="js/jquery-3.3.1.js"></script>
    <style>
        .ok{
            color:green;
        }
        .err{
            color: red;
        }
    </style>
    <script>
        function sbqFun(userName) {$.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/ajax.do",
            data: "userName="+userName+"&location=Boston",
            success: function(msg){
                var userNameErr=document.getElementById("userNameErr");
                if (msg==1){
                    userNameErr.innerHTML="可以使用"
                }else {
                    userNameErr.innerHTML="用户名被占用";
                    return false;
                }
            }
        });

        }
        //正则表达式
        var regNull = /^\s*$/g;

        function Fromsbq() {
            //获取值
            var userName=document.getElementById("userName").value;
            var pwd=document.getElementById("pwd").value;
            var id=document.getElementById("id").value;
            var cpu=document.getElementById("cpu").value;
            var cpuType=document.getElementById("cpuType").value;
            var gpu=document.getElementById("gpu").value;
            var display=document.getElementById("displaySize").value;
            //开始判断
            if(regNull.test(userName)){
                $("#userNameErr").html("用户名不能为空");
                $("#userNameErr").addClass("err");
                return false;
            }else{
                $("#userNameErr").html("正确");
                $("#userNameErr").addClass("ok");
            }
            //判断密码
            if(regNull.test(pwd)){
                $("#pwdErr").html("密码不能为空");
                $("#pwdErr").addClass("err");
                return false;
            }else{
                $("#pwdErr").html("正确");
                $("#pwdErr").addClass("ok");
            }
            //判断编号
            if(regNull.test(id)){
                $("#idErr").html("id不能为空");
                $("#idErr").addClass("err");
                return false;
            }else{
                $("#idErr").html("正确");
                $("#idErr").addClass("ok");
            }
            //判断cpu
            if(regNull.test(cpu)){
                $("#cpuErr").html("不能为空");
                $("#cpuErr").addClass("err");
                return false;
            }else{
                $("#cpuErr").html("正确");
                $("#cpuErr").addClass("ok");
            }
            //判断类型
            if(regNull.test(cpuType)){
                $("#cpuTypeErr").html("不能为空");
                $("#cpuTypeErr").addClass("err");
                return false;
            }else{
                $("#cpuTypeErr").html("正确");
                $("#cpuTypeErr").addClass("ok");
            }
            //判断gpu
            if(regNull.test(gpu)){
                $("#gpuErr").html("不能为空");
                $("#gpuErr").addClass("err");
                return false;
            }else{
                $("#gpuErr").html("正确");
                $("#gpuErr").addClass("ok");
            }
            //判断显示器
            if(regNull.test(display)){
                $("#displaySizeErr").html("不能为空");
                $("#displaySizeErr").addClass("err");
                return false;
            }else{
                $("#displaySizeErr").html("正确");
                $("#displaySizeErr").addClass("ok");
            }


        }
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/Sign.do" method="post" onsubmit="return Fromsbq();">

    <table>
        <tr>
            <td>用户名：</td>
            <td>
                <input type="text" id="userName" name="userName" onchange="sbqFun(this.value);">
                <font id="userNameErr"></font>
            </td>

        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <input type="password" id="pwd" name="pwd">
                <font id="pwdErr"></font>
            </td>

        </tr>
        <tr>
            <td>编号：</td>
            <td>
                <input type="text" id="id" name="id">
                <font id="idErr"></font>
            </td>

        </tr>

        <tr>
            <td>处理器：</td>
            <td>
                <input type="text" id="cpu" name="cpu">
                <font id="cpuErr"></font>
            </td>

        </tr>
        <tr>
            <td>cpu类型：</td>
            <td>
                <input type="text" id="cpuType" name="cpuType">
                <font id="cpuTypeErr"></font>
            </td>

        </tr>
        <tr>
            <td>GPU</td>
            <td>
                <input type="text" id="gpu" name="gpu">
                <font id="gpuErr"></font>
            </td>

        </tr>
        <tr>
            <td>显示器</td>
            <td>
                <input type="text" id="displaySize" name="displaySize">
                <font id="displaySizeErr"></font>
            </td>

        </tr>
        <tr>
            <td>
                <input type="submit" value="提交">
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
