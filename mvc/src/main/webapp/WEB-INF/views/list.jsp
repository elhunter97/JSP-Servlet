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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body>
<h1>DANH SÁCH HỌC SINH</h1>
<div class="container">
    <p>${message}</p>
    <div class="d-flex justify-content-between align-items-center mt-4">
        <button class="btn btn-primary" onclick="window.location.href='/student?action=create'">Thêm mới</button>
        <form action="/student?action=search" method="post" class="d-flex">
            <input class="form-control border-end-0 border rounded-pill" type="text" name="searchName"
                   id="example-search-input" placeholder="Tìm kiếm">
            <span class="input-group-append">
            <button class="btn btn-outline-secondary bg-white border-bottom-0 border rounded-pill ms-n5"
                    type="submit"><i class="fa fa-search"></i></button>
        </span>
        </form>
    </div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Số thứ tự</th>
            <th>Họ & tên<button class="btn bg-black border-0" onclick="window.location.href='/student?action=sort&sortby=name'"><i class="bi bi-sort-alpha-down"></i></button></th>
            <th>Địa chỉ</th>
            <th>Điểm<button class="btn bg-black border-0" onclick="window.location.href='/student?action=sort&sortby=point'"><i class="bi bi-sort-numeric-down"></i></button></th>
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
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                            data-bs-target="#deleteModal${student.id}">
                        Xoá
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="deleteModal${student.id}" tabindex="-1"
                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Xoá</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    Bạn có muốn xoá học sinh ${student.name} không?
                                    <p class="text-danger">Lưu ý: Hành động này không thể hoàn tác</p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng
                                    </button>
                                    <form action="/student?action=delete" method="post">
                                        <button type="submit" class="btn btn-primary">Xác nhận</button>
                                        <input type="hidden" name="id" value="${student.id}">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <button class="btn btn-warning"
                            onclick="window.location.href = '/student?action=edit&id=${student.id}'">Sửa
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
