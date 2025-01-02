<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Danh sách lớp học</h2>
<table border="1">
    <thead>
    <tr>
        <th>Class ID</th>
        <th>Class Name</th>
        <th>Teacher ID</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="schoolClass" items="${classes}">
        <tr>
            <td>${schoolClass.classId}</td>
            <td>${schoolClass.className}</td>
            <td>${schoolClass.teacherId}</td>
            <td><a href="students?classId=${schoolClass.classId}">View Students</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
