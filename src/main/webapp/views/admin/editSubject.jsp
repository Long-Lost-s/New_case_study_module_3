<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/2/2025
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Subject</title>
    <link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<h1>Edit Subject</h1>

<!-- Display success or error messages -->
<c:if test="${param.success != null}">
    <p class="success">${param.success}</p>
</c:if>
<c:if test="${param.error != null}">
    <p class="error">${param.error}</p>
</c:if>

<!-- Back to Subjects List -->
<a href="/admin/subjects" class="button-link">Back to Subjects</a>

<!-- Edit Subject Form -->
<form action="/admin/subjects" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${subject.subjectId}">

    <label for="subjectName">Subject Name:</label>
    <input type="text" id="subjectName" name="subjectName" value="${subject.subjectName}" required>

    <button type="submit">Update Subject</button>
</form>
</body>
</html>

