<%--
  Created by IntelliJ IDEA.
  User: dung
  Date: 10/28/2024
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Thêm mới</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


</head>
<body>
<h1>Thêm mới</h1>
<div class="container">
    <form action="/student?action=create" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Họ & tên</label>
            <input type="text" class="form-control" id="name" placeholder="Họ & tên" name="name" required>
        </div>
        <div class="mb-3">
            <label for="address" class="form-label">Địa chỉ</label>
            <input type="text" class="form-control" id="address" placeholder="Địa chỉ" name="address" required>
        </div>
        <div class="mb-3">
            <label for="point" class="form-label">Điểm</label>
            <input type="text" class="form-control" id="point" placeholder="Điểm" name="point" required>
        </div>
        <div class="mb-3">
            <label for="nameclass" class="form-label">Lớp</label>
            <select class="form-select w-auto" id="nameclass" name="nameclass" required>
                <c:forEach var="classrooms" items="${classrooms}">
                    <option value="${classrooms.id}">${classrooms.name}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Thêm</button>
    </form>
</div>
</body>
</html>
