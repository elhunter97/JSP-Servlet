<%--
  Created by IntelliJ IDEA.
  User: WINDOWS
  Date: 10/24/2024
  Time: 1:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<H1>Xin chào Hán Bảo Ngọc</H1>
<br/>
<form action="/main" method="post"> <%--action="/main" nghĩa là khi submit form thì sẽ gọi đến url /main với method là post--%>
<%--    // phải đặt name="a" để khi submit form thì server có thể lấy được giá trị của input này phân biệt với các input khác--%>
    a: <input type="text" name="a">
    b: <input type="text" name="b">
    <p>Kết quả: ${result}</p>
    <br/>
    <p>THời gian hiện tại: ${today}</p>
    <button type="submit">Tính</button>
</form>
</body>
</html>
