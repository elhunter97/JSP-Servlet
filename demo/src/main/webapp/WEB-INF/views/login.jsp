<%--
  Created by IntelliJ IDEA.
  User: WINDOWS
  Date: 10/24/2024
  Time: 2:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>LOGIN</h1>
<form action="/login" method="post">
  username: <input type="text" name="username">
    <br/>
    password: <input type="password" name="password">
    <br/>
  <p>${message}</p>
    <button type="submit">Login</button>
</form>
</body>
</html>
