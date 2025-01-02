package org.example.schoolmanagement.controller;


import org.example.schoolmanagement.model.Teacher;
import org.example.schoolmanagement.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TeacherController", urlPatterns = {"/admin/teachers"})
public class TeacherController extends HttpServlet {
    private final TeacherService teacherService;

    public TeacherController() {
        this.teacherService = new TeacherService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("edit".equals(action)) {
            handleEditRequest(request, response);
        } else if ("delete".equals(action)) {
            handleDeleteRequest(request, response);
        } else {
            handleListRequest(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            handleAddRequest(request, response);
        } else if ("update".equals(action)) {
            handleUpdateRequest(request, response);
        }
    }

    private void handleListRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Teacher> teachers = teacherService.getAllTeachers();
        request.setAttribute("teachers", teachers);
        request.getRequestDispatcher("/views/admin/teachers.jsp").forward(request, response);
    }

    private void handleAddRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Teacher teacher = new Teacher();
        teacher.setFullName(request.getParameter("fullName"));
        teacher.setEmail(request.getParameter("email"));
        teacher.setPhoneNumber(request.getParameter("phone"));
        teacher.setTotalClasses(Integer.parseInt(request.getParameter("totalClasses")));
        teacher.setTotalStudents(Integer.parseInt(request.getParameter("totalStudents")));

        if (teacherService.addTeacher(teacher)) {
            response.sendRedirect("/admin/teachers?action=list&success=Teacher added successfully");
        } else {
            response.sendRedirect("/admin/teachers?action=add&error=Failed to add teacher");
        }
    }

    private void handleEditRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int teacherId = Integer.parseInt(request.getParameter("id"));
        Teacher teacher = teacherService.getTeacherById(teacherId);
        request.setAttribute("teacher", teacher);
        request.getRequestDispatcher("/views/admin/editTeacher.jsp").forward(request, response);
    }

    private void handleUpdateRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int teacherId = Integer.parseInt(request.getParameter("id"));
        Teacher teacher = new Teacher();
        teacher.setTeacherId(teacherId);
        teacher.setFullName(request.getParameter("fullName"));
        teacher.setEmail(request.getParameter("email"));
        teacher.setPhoneNumber(request.getParameter("phone"));
        teacher.setTotalClasses(Integer.parseInt(request.getParameter("totalClasses")));
        teacher.setTotalStudents(Integer.parseInt(request.getParameter("totalStudents")));

        if (teacherService.updateTeacher(teacher)) {
            response.sendRedirect("/admin/teachers?action=list&success=Teacher updated successfully");
        } else {
            response.sendRedirect("/admin/teachers?action=edit&id=" + teacherId + "&error=Failed to update teacher");
        }
    }

    private void handleDeleteRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int teacherId = Integer.parseInt(request.getParameter("id"));
        if (teacherService.deleteTeacher(teacherId)) {
            response.sendRedirect("/admin/teachers?action=list&success=Teacher deleted successfully");
        } else {
            response.sendRedirect("/admin/teachers?action=list&error=Failed to delete teacher");
        }
    }
}
