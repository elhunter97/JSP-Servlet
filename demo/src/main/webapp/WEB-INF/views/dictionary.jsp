<%--
  Created by IntelliJ IDEA.
  User: WINDOWS
  Date: 10/24/2024
  Time: 3:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form action="dictionary" method="post">
  English: <input type="text" name="english">
    <br/>
    <p>Vietnamese: ${vietnamese}</p>
    <button type="submit">Translate</button>
</form>
</body>
</html>
