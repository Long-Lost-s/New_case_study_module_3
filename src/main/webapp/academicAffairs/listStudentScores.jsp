<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách điểm học viên</title>
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
        .editable:hover {
            background-color: wheat;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div id="data">
        <table id="table">
            <caption>
                <h2>Danh sách điểm học viên</h2>
                <div id="select-class-id">
                    <p>Môn: </p>
                    <select id="subjectId" name="subjectId" onchange="getStudentScoreBySubject()">
                        <option value="-1" disabled></option>
                        <c:forEach var="subject" items="${subjects}">
                            <option value="${subject.getSubjectId()}">
                                <c:out value="${subject.getSubjectName()}"/>
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </caption>
            <tr>
                <th>Tên học viên</th>
                <th>Lớp</th>
                <th>Điểm lý thuyết</th>
                <th>Điểm thực hành</th>
                <th>Điểm trung bình</th>
            </tr>
            <c:forEach var="studentScore" items="${studentScores}">
                <tr>
                    <td><a href="/academicAffair?action=edit&subjectId=${studentScore.getSubjectId()}&studentId=${studentScore.getStudentId()}">
                        <c:out value="${studentScore.getStudentName()}"/>
                    </a></td>
                    <td><c:out value="${studentScore.getClassId()}"/></td>
                    <td class="editable"><c:out value="${studentScore.getTheoryScore()}"/></td>
                    <td class="editable"><c:out value="${studentScore.getPracticeScore()}"/></td>
                    <td><c:out value="${studentScore.getAverageScore()}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <script>
        let elementSelectClass = document.getElementById("subjectId");
        function setSelectSubjectOption() {
            elementSelectClass.value = "<c:out value="${subjectId}"/>";
        }
        setSelectSubjectOption();

        function getStudentScoreBySubject() {
            let subjectId = elementSelectClass.value;
            window.location.href = "/academicAffair?subjectId=" + subjectId;
        }
    </script>
</body>
</html>