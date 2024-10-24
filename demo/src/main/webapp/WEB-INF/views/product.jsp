<%--
  Created by IntelliJ IDEA.
  User: WINDOWS
  Date: 10/24/2024
  Time: 12:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product Discount Calculator</h1>
<form action="product" method="post">
    Product Description: <input type="text" name="description">
    <br/>
    List Price: <input type="text" name="price">
    <br/>
    Discount Percent: <input type="text" name="percent">
    <br/>
    <button type="submit">Calculate Discount</button>
</form>
</body>
</html>
