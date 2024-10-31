<%--
  Created by IntelliJ IDEA.
  User: WINDOWS
  Date: 10/29/2024
  Time: 12:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa thông tin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<h1>Chỉnh sửa thông tin</h1>
<div class="container">
    <form action="/student?action=edit&id=${student.id}" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Họ & tên</label>
            <input type="text" class="form-control" id="name" placeholder="Họ & tên" name="name" value="${student.name}"
                   required>
        </div>
        <div class="mb-3">
            <label for="address" class="form-label">Địa chỉ</label>
            <input type="text" class="form-control" id="address" placeholder="Địa chỉ" name="address"
                   value="${student.address}" required>
        </div>
        <div class="mb-3">
            <label for="point" class="form-label">Điểm</label>
            <input type="text" class="form-control" id="point" placeholder="Điểm" name="point" value="${student.point}"
                   required>
        </div>
        <div class="mb-3">
            <label for="nameclass" class="form-label">Lớp</label>
            <select class="form-select w-auto" id="nameclass" name="nameclass" required>
                <c:forEach var="classrooms" items="${classrooms}">
                    <option value="${classrooms.id}" ${classrooms.id == student.id_Class ? 'selected' : ''}>${classrooms.name}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Cập nhật</button>
    </form>
</div>

</body>
</html>
