<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <style>
        #data {
            margin: 20px auto;
            width: fit-content;
            box-shadow: 0 0 10px rgba(60, 60, 150, 0.75);
            padding: 10px;
            border-radius: 10px;
        }

        #table {
            margin: auto;
            border-collapse: collapse;
            font-size: 15px;
        }

        #table td, th {
            border-style: solid;
            border-width: 2px;
            border-color: blue;
            padding: 15px 20px;
        }

        #table th {
            background-color: #a5a0ff;
        }

        #table tr:nth-child(odd) {
            background-color: #d7e3ff;
        }
        caption h2{
            float: left;
        }
        #select-class-id {
            float: right;
        }
        #select-class-id p {
            float: left;
            padding: 0 10px;
        }
        #select-class-id select {

        }
    </style>
</head>
<body>
    <div id="data">
        <table id="table">
            <caption>
                <h2>Danh sách học viên</h2>
                <div id="select-class-id">
                    <p>Lớp: </p>
                    <select id="classId" name="classId" onchange="getStudentByClass()">
                        <option value=""></option>
                        <c:forEach var="classs" items="${classesList}">
                            <option value="${classs.getClassId()}">
                                <c:out value="${classs.getClassName()}"/>
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </caption>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Phone number</th>
                <th>Status</th>
                <th>Date of birth</th>
                <th>Address</th>
            </tr>
            <c:forEach var="student" items="${studentList}">
                <tr>
                    <td><a href="/teacher?action=edit&studentId=${student.getStudentId()}">
                        <c:out value="${student.getFullName()}"/>
                    </a></td>
                    <td><c:out value="${student.getEmail()}"/></td>
                    <td><c:out value="${student.getPhoneNumber()}"/></td>
                    <td><c:out value="${student.getStatus().toString()}"/></td>
                    <td><c:out value="${student.getDateOfBirth()}"/></td>
                    <td><c:out value="${student.getAddress()}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <script>
        let elementSelectClass = document.getElementById("classId");

        function getStudentByClass() {
            let classId = elementSelectClass.value;
            window.location.href = "/teacher?classId=" + classId;
        }

        function setSelectClassOption() {
            elementSelectClass.value = "<c:out value="${classId}"/>";
        }

        setSelectClassOption();
    </script>
</body>
</html>