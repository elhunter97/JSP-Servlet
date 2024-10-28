<%--
  Created by IntelliJ IDEA.
  User: dung
  Date: 10/28/2024
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách học sinh</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>DANH SÁCH HỌC SINH</h1>
<div class="container">
  <button class="btn btn-primary mt-4" onclick="window.location.href='/student?action=create'">Thêm mới</button>
  <table class="table table-hover">
    <thead>
    <tr>
      <th>Số thứ tự</th>
      <th>Họ & tên</th>
      <th>Địa chỉ</th>
      <th>Điểm</th>
      <th>Xếp hạng</th>
      <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}" varStatus="status">
      <tr>
        <td>${status.count}</td>
        <td>${student.name}</td>
        <td>${student.address}</td>
        <td>${student.point}</td>
        <td>
          <c:choose>
            <c:when test="${student.point >= 8}">Giỏi</c:when>
            <c:when test="${student.point >= 7}">Khá</c:when>
            <c:when test="${student.point >= 6.5}">Trung Bình</c:when>
            <c:when test="${student.point >= 5}">Yếu</c:when>
            <c:otherwise>Kém</c:otherwise>
          </c:choose>
        </td>
        <td>
          <button class="btn btn-danger">Xóa</button>
          <button class="btn btn-warning">Sửa</button>
        </td>
      </tr>
    </c:forEach>
    <tr>
      <td></td>
    </tr>
    </tbody>

  </table>

</div>
</body>
</html>
