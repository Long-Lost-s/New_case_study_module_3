<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Điểm số</title>
    <link rel="stylesheet" href="../styles.css">
</head>
<body>
<h2>Điểm số của học viên</h2>
<div style="text-align: center; margin-bottom: 20px;">
    <a href="students?classId=${classId}">Back to Class</a>
</div>

<c:if test="${empty scores}">
    <p>Không có điểm nào được ghi nhận.</p>
</c:if>

<c:if test="${!empty scores}">
    <table border="1" style="margin: 0 auto; border-collapse: collapse; width: 80%;">
        <thead>
        <tr>
            <th>Subject Name</th>
            <th>Theory Score</th>
            <th>Practice Score</th>
            <th>Average Score</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="score" items="${scores}">
            <tr>
                <td>${score.subjectName}</td>
                <td>${score.theoryScore}</td>
                <td>${score.practiceScore}</td>
                <td>${score.averageScore}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>
