<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Chi tiết học viên</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
      background-color: #f9f9f9;
      color: #333;
    }
    h1 {
      color: #0066cc;
    }
    p {
      font-size: 16px;
      margin: 10px 0;
    }
    a {
      text-decoration: none;
      color: #fff;
      background-color: #007bff;
      padding: 10px 15px;
      border-radius: 5px;
      font-size: 14px;
    }
    a:hover {
      background-color: #0056b3;
    }
    .container {
      max-width: 600px;
      margin: 0 auto;
      padding: 20px;
      background: #fff;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .info {
      margin-bottom: 20px;
      padding: 10px;
      background-color: #e7f3ff;
      border: 1px solid #b3d7ff;
      border-radius: 5px;
    }
    .info strong {
      color: #333;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>Chi tiết học viên</h1>
  <div class="info">
    <p><strong>Mã học viên:</strong> ${student.studentId}</p>
    <p><strong>Họ và tên:</strong> ${student.fullname}</p>
    <p><strong>Email:</strong> ${student.email}</p>
    <p><strong>Ngày sinh:</strong> ${student.dateOfBirth}</p>
    <p><strong>Địa chỉ:</strong> ${student.address}</p>
    <p><strong>Số điện thoại:</strong> ${student.phoneNumber}</p>
    <p><strong>Trạng thái:</strong>
      <c:choose>
        <c:when test="${student.status == 'Active'}">Đang học</c:when>
        <c:when test="${student.status == 'Inactive'}">Ngừng học</c:when>
        <c:when test="${student.status == 'Graduated'}">Tốt nghiệp</c:when>
        <c:when test="${student.status == 'Dropped'}">Bỏ học</c:when>
      </c:choose>
    </p>
  </div>
  <a href="studentDetail">Quay lại danh sách</a>
</div>
</body>
</html>
