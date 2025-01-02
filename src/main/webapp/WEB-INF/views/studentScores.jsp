<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Điểm thi của học viên</title>
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
      text-decoration: none;
      color: #007bff;
    }
    a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
<h1>Điểm thi của học viên</h1>
<table>
  <thead>
  <tr>
    <th>Mã bài thi</th>
    <th>Tên bài thi</th>
    <th>Ngày thi</th>
    <th>Điểm</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="score" items="${scores}">
    <tr>
      <td>${score.examId}</td>
      <td>${score.examName}</td>
      <td>${score.examDate}</td>
      <td>${score.score}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="studentList">Quay lại danh sách học viên</a>
</body>
</html>
