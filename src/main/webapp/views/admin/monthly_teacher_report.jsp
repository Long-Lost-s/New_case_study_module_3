<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Monthly Teacher Report</title>
  <link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<h1>Monthly Teacher Report</h1>

<p><a href="/views/admin/admin_dashboard.jsp">Back to Dashboard</a></p>

<!-- Success or error message -->
<c:if test="${param.success != null}">
  <p class="success">${param.success}</p>
</c:if>
<c:if test="${param.error != null}">
  <p class="error">${param.error}</p>
</c:if>

<!-- Table displaying the monthly teacher reports -->
<table class="table">
  <thead>
  <tr>
    <th>Teacher ID</th>
    <th>Full Name</th>
    <th>Total Classes</th>
    <th>Total Students</th>
    <th>Report Date</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="report" items="${reports}">
    <tr>
      <td>${report.teacherId}</td>
      <td>${report.fullName}</td>
      <td>${report.totalClasses}</td>
      <td>${report.totalStudents}</td>
      <td>${report.reportDate}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
