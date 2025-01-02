<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Danh sách lớp học</title>
    <link rel="stylesheet" href="../styles.css">
</head>
<body>
<h2>Danh sách lớp học</h2>

<table border="1">
    <thead>
    <tr>
        <th>Class ID</th>
        <th>Class Name</th>
        <th>Teacher ID</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="schoolClass" items="${classes}">
        <tr>
            <td>${schoolClass.classId}</td>
            <td>${schoolClass.className}</td>
            <td>${schoolClass.teacherId}</td>
            <td>
            <td><a href="students?classId=${schoolClass.classId}">View Students</a></td>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
