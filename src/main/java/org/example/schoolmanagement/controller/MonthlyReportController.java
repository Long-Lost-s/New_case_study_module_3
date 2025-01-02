package org.example.schoolmanagement.controller;

import org.example.schoolmanagement.model.MonthlyTeacherReport;
import org.example.schoolmanagement.service.MonthlyReportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

    @WebServlet(name = "MonthlyReportController", urlPatterns = {"/admin/monthly_teacher_report"})
public class MonthlyReportController extends HttpServlet {
    private final MonthlyReportService monthlyReportService;

    public MonthlyReportController() {
        this.monthlyReportService = new MonthlyReportService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Fetch all reports from the database
            List<MonthlyTeacherReport> reports = monthlyReportService.getAllReports();
            request.setAttribute("reports", reports);

            // Forward to the JSP page for displaying reports
            request.getRequestDispatcher("/views/admin/monthly_teacher_report.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving reports.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.sendRedirect("/admin/monthly_teacher_report?success=Monthly reports loaded successfully");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error processing request.");
        }
    }
}
