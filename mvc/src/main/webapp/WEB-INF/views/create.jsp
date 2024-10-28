<%--
  Created by IntelliJ IDEA.
  User: dung
  Date: 10/28/2024
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới</title>
</head>
<body>
<h1>Thêm mới</h1>
<form>
    <div class="mb-3">
        <label for="name" class="form-label">Họ & tên</label>
        <input type="text" class="form-control" id="name" placeholder="Họ & tên" required>
    </div>
    <div class="mb-3">
        <label for="address" class="form-label">Địa chỉ</label>
        <input type="text" class="form-control" id="address" placeholder="Địa chỉ" required>
    </div>
    <div class="mb-3">
        <label for="point" class="form-label">Điểm</label>
        <input type="number" class="form-control" id="point" placeholder="Điểm" required>
    </div>
    <button type="submit" class="btn btn-primary">Thêm</button>
</form>
</body>
</html>
