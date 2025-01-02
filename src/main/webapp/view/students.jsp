<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Danh sách học viên</title>
    <link rel="stylesheet" href="../styles.css">
</head>
<body>
<h2>Danh sách học viên</h2>

<div style="text-align: center; margin-bottom: 20px;">
    <a href="classes">Back to Classes</a>
</div>

<form action="students" method="get" style="text-align: center; margin-bottom: 20px;">
    <input type="hidden" name="classId" value="${classId}">
    <label for="status">Lọc trạng thái:</label>
    <select name="status" id="status" onchange="this.form.submit()">
        <option value="">Tất cả</option>
        <option value="Đang học" ${status == 'Đang học' ? 'selected' : ''}>Đang học</option>
        <option value="Chờ chuyển lớp" ${status == 'Chờ chuyển lớp' ? 'selected' : ''}>Chờ chuyển lớp</option>
        <option value="Thôi học" ${status == 'Thôi học' ? 'selected' : ''}>Thôi học</option>
        <option value="Đình chỉ" ${status == 'Đình chỉ' ? 'selected' : ''}>Đình chỉ</option>
    </select>
</form>

<c:if test="${empty students}">
    <p style="text-align: center;">Không có học viên nào thuộc lớp này.</p>
</c:if>

<c:if test="${!empty students}">
    <p style="text-align: center;">Tổng số học viên: ${totalStudents}</p>
    <table border="1" style="margin: 0 auto; border-collapse: collapse; width: 80%;">
        <thead>
        <tr>
            <th>Student ID</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.studentId}</td>
                <td>${student.fullName}</td>
                <td>${student.email}</td>
                <td>${student.phoneNumber}</td>
                <td>${student.status}</td>
                <td>
                    <a href="studentDetails?studentId=${student.studentId}&classId=${classId}">View Details</a> |
                    <a href="scores?studentId=${student.studentId}&classId=${classId}">View Scores</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
