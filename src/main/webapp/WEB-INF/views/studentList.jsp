<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh sách học viên</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f4f4f4;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1>Danh sách học viên</h1>
<table>
    <thead>
    <tr>
        <th>Mã học viên</th>
        <th>Họ và tên</th>
        <th>Email</th>
        <th>Trạng thái</th>
        <th>Chi tiết</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.studentId}</td>
            <td>${student.fullname}</td>
            <td>${student.email}</td>
            <td>
                <c:choose>
                    <c:when test="${student.status == 'Active'}">Đang học</c:when>
                    <c:when test="${student.status == 'Inactive'}">Ngừng học</c:when>
                    <c:when test="${student.status == 'Graduated'}">Tốt nghiệp</c:when>
                    <c:when test="${student.status == 'Dropped'}">Bỏ học</c:when>
                </c:choose>
            </td>
            <td><a href="studentDetail?id=${student.studentId}">Xem chi tiết</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
