package com.example.case_md3.controller;

import com.example.case_md3.dao.StudentDAO;
import com.example.case_md3.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class StudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String classIdParam = request.getParameter("classId");

        if (classIdParam == null || classIdParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing or invalid classId parameter");
            return;
        }

        try {
            int classId = Integer.parseInt(classIdParam);
            StudentDAO studentDAO = new StudentDAO();
            List<Student> students = studentDAO.getStudentsByClassId(classId);
            request.setAttribute("students", students);
            request.setAttribute("totalStudents", students.size());
            request.getRequestDispatcher("view/students.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid classId format");
        }
    }
}
