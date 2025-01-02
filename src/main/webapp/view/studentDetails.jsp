<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Chi tiết học viên</title>
    <link rel="stylesheet" href="../styles.css">
</head>
<body>
<h2>Chi tiết học viên</h2>

<div class="navigation">
    <a href="students?classId=${classId}" class="btn-back">Back to Class</a>
</div>

<table class="details-table" style="margin: 0 auto; width: 80%;">
    <thead>
    <tr>
        <th>Student ID</th>
        <th>Full Name</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>Status</th>
        <th>Date of Birth</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${student.studentId}</td>
        <td>${student.fullName}</td>
        <td>${student.email}</td>
        <td>${student.phoneNumber}</td>
        <td>${student.status}</td>
        <td>${student.dateOfBirth}</td>
        <td>${student.address}</td>
    </tr>
    </tbody>
</table>
</body>
</html>
