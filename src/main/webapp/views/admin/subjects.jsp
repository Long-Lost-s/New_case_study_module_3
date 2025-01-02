<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <title>Manage Subjects</title>
  <link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<h1>Manage Subjects</h1>

<c:if test="${param.success != null}">
  <p class="success">${param.success}</p>
</c:if>
<c:if test="${param.error != null}">
  <p class="error">${param.error}</p>
</c:if>

<!-- Add new subject -->
<form action="/admin/subjects" method="post">
  <input type="hidden" name="action" value="add">
  <label for="subjectName">Subject Name:</label>
  <input type="text" id="subjectName" name="subjectName" required>
  <button type="submit">Add Subject</button>
</form>

<!-- Display subjects -->
<table class="table">
  <thead>
  <tr>
    <th>Subject ID</th>
    <th>Subject Name</th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="subject" items="${subjects}">
    <tr>
      <td>${subject.subjectId}</td>
      <td>${subject.subjectName}</td>
      <td>
        <a href="/admin/subjects?action=edit&id=${subject.subjectId}" class="button-link">Edit</a>
        <a href="/admin/subjects?action=delete&id=${subject.subjectId}" class="button-link delete-button" onclick="return confirm('Are you sure you want to delete this subject?');">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<a href="/views/admin/admin_dashboard.jsp">Back to Dashboard</a>
</body>
</html>
