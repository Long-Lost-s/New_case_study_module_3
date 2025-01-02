<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa điểm học viên</title>
</head>
<body>
    <h2>
        <a href="academicAffair">Quay lại danh sách</a>
    </h2>
    <form method="post">
        <fieldset>
            <legend>Điểm học viên</legend>
            <p>Tên học viên: <c:out value="${studentScore.getStudentName()}"/></p>
            <c:if test="${studentScore != null}">
                <input type="hidden" name="studentId" value="<c:out value='${studentScore.getStudentId()}' />"/>
                <input type="hidden" name="subjectId" value="<c:out value='${studentScore.getSubjectId()}' />"/>
            </c:if>
            <table>
                <tr>
                    <td>Điểm lý thuyết</td>
                    <td><input type="number" name="theoryScore" step="0.01"
                               value="<c:out value="${studentScore.getTheoryScore()}"/>"></td>
                </tr>
                <tr>
                    <td>Điểm thực hành</td>
                    <td><input type="number" name="practicalScore" step="0.01"
                               value="<c:out value="${studentScore.getPracticeScore()}"/>"></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="submit"/>
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
