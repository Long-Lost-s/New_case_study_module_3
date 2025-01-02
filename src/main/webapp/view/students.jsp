<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Danh sách học viên</h2>
<c:if test="${empty students}">
    <p>Không có học viên nào thuộc lớp này.</p>
</c:if>

<c:if test="${!empty students}">
    <p>Tổng số học viên: ${totalStudents}</p>
    <table border="1">
        <thead>
        <tr>
            <th>Student ID</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th>Status</th>
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
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
