package org.example.schoolmanagement.controller;

import org.example.schoolmanagement.service.MonthlyReportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MonthlyReportController", urlPatterns = {"/admin/generateReports"})
public class MonthlyReportController extends HttpServlet {
    private final MonthlyReportService reportService;

    public MonthlyReportController() {
        this.reportService = new MonthlyReportService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        reportService.generateMonthlyReports();
        response.sendRedirect("/views/admin/monthly_teacher_report.jsp?success=Reports generated successfully");
    }
}
