<%--
  Created by IntelliJ IDEA.
  User: WINDOWS
  Date: 10/24/2024
  Time: 3:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Convert Money</title>
</head>
<body>
<h1>${message}</h1>
<br/>
<form action="/money" method="post">
    USD: <input type="text" name="usd">
    <br/>
    <p>VND: ${vnd} đ</p>
    <button type="submit">Convert</button>
</body>
</html>
