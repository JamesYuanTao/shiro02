<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑用户</title>
</head>
<body>
<form action="/shiro02/user/add" method="post">
    用户名：<input type="text" name="username" /><br/>
    密码：<input type="text" name="password" /><br/>
    <input type="submit"/>
</form>
</body>
</html>
