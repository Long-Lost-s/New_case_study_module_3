<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa trạng thái học viên</title>
</head>
<body>
    <h2>
        <a href="teacher">Quay lại danh sách</a>
    </h2>
    <form method="post">
        <fieldset>
            <legend>Thông tin học viên</legend>
            <p>Tên học viên: <c:out value="${student.getFullName()}"/></p>
            <p>Email: <c:out value="${student.getEmail()}"/></p>
            <p>Số điện thoại: <c:out value="${student.getPhoneNumber()}"/></p>
            <p>Ngày sinh: <c:out value="${student.getDateOfBirth()}"/></p>
            <p>Địa chỉ: <c:out value="${student.getAddress()}"/></p>
            <p>Mã lớp: <c:out value="${student.getClassId()}"/></p>
            <c:if test="${student != null}">
                <input type="hidden" name="studentId" value="<c:out value='${student.getStudentId()}' />"/>
            </c:if>
            <div>Trạng thái:
                <select name="status" id="status">
                    <option value="Thôi học">Thôi học</option>
                    <option value="Đình chỉ">Đình chỉ</option>
                    <option value="Chuyển lớp">Chuyển lớp</option>
                    <option value="Đang học">Đang học</option>
                </select>
                <input type="submit" value="submit"/>
            </div>
        </fieldset>
    </form>
    <script>
        let ele = document.getElementById("status");
        ele.value = "<c:out value="${student.getStatus().toString()}"/>";
    </script>
</body>
</html>
