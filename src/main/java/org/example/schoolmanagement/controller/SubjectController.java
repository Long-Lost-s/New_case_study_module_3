package org.example.schoolmanagement.controller;

import org.example.schoolmanagement.model.Subject;
import org.example.schoolmanagement.service.SubjectService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SubjectController", urlPatterns = {"/admin/subjects"})
public class SubjectController extends HttpServlet {
    private final SubjectService subjectService;

    public SubjectController() {
        this.subjectService = new SubjectService();
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            handleAddRequest(request, response);
        } else if ("update".equals(action)) {
            handleUpdateRequest(request, response);
        }
    }

    private void handleListRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Subject> subjects = subjectService.getAllSubjects();
        request.setAttribute("subjects", subjects);
        request.getRequestDispatcher("/views/admin/subjects.jsp").forward(request, response);
    }

    private void handleAddRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String subjectName = request.getParameter("subjectName");
        Subject subject = new Subject(1, subjectName);

        try {
            if (subjectService.addSubject(subject)) {
                response.sendRedirect("/admin/subjects?success=Subject added successfully");
            } else {
                response.sendRedirect("/admin/subjects?error=Failed to add subject");
            }
        } catch (IllegalArgumentException e) {
            response.sendRedirect("/admin/subjects?error=" + e.getMessage());
        }
    }

    private void handleEditRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int subjectId = Integer.parseInt(request.getParameter("id"));
        Subject subject = subjectService.getSubjectById(subjectId);
        request.setAttribute("subject", subject);
        request.getRequestDispatcher("/views/admin/editSubject.jsp").forward(request, response);
    }

    private void handleUpdateRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int subjectId = Integer.parseInt(request.getParameter("id"));
        String subjectName = request.getParameter("subjectName");

        Subject subject = new Subject(subjectId, subjectName);
        subject.setSubjectId(subjectId);

        try {
            if (subjectService.updateSubject(subject)) {
                response.sendRedirect("/admin/subjects?success=Subject updated successfully");
            } else {
                response.sendRedirect("/admin/subjects?error=Failed to update subject");
            }
        } catch (IllegalArgumentException e) {
            response.sendRedirect("/admin/subjects?error=" + e.getMessage());
        }
    }

    private void handleDeleteRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int subjectId = Integer.parseInt(request.getParameter("id"));

        if (subjectService.deleteSubject(subjectId)) {
            response.sendRedirect("/admin/subjects?success=Subject deleted successfully");
        } else {
            response.sendRedirect("/admin/subjects?error=Failed to delete subject");
        }
    }
}
