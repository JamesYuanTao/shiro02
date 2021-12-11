<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/8
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
<a href="/shiro02/goEdit">增加</a>
<table width="100%" border="1" style="text-align: center">
    <tr>
        <td>用户编号</td>
        <td>用户名</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${users}" var="i">
        <tr>
            <td>${i.userid}</td>
            <td>${i.username}</td>
            <td>
                <a href="changePassword">修改密码</a>
                <a href="javascript:mya(${i.userid})">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
<script>
    function mya(userid){
        var a=confirm("是否删除?");
        if(a){
            location.href="del?userid="+userid
        }
    }
</script>
</html>
