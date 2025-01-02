<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Admin Dashboard</title>
  <link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<h1>Welcome to Admin Dashboard</h1>

<nav>
  <ul>
    <li><a href="/admin/teachers">Manage Teachers</a></li>
    <li><a href="/admin/students">Manage Students</a></li>
    <li><a href="/admin/classes">Manage Classes</a></li>
    <li><a href="/admin/subjects">Manage Subjects</a></li>
    <li><a href="/admin/monthly_teacher_report">Monthly Teacher Reports</a></li>
  </ul>
</nav>

<!-- Success or error message -->
<c:if test="${param.success != null}">
  <p class="success">${param.success}</p>
</c:if>
<c:if test="${param.error != null}">
  <p class="error">${param.error}</p>
</c:if>

<p>Select an option from the menu above to manage the system.</p>
</body>
</html>
