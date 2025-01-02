package org.example.schoolmanagement.service;

import org.example.schoolmanagement.dao.MonthlyReportDAO;
import org.example.schoolmanagement.model.MonthlyTeacherReport;

import java.util.List;

public class MonthlyReportService {
    private final MonthlyReportDAO monthlyReportDAO;

    public MonthlyReportService() {
        this.monthlyReportDAO = new MonthlyReportDAO();
    }

    // Retrieve all reports
    public List<MonthlyTeacherReport> getAllReports() {
        return monthlyReportDAO.getAllReports();
    }

    // Add a new report
    public boolean addReport(MonthlyTeacherReport report) {
        return monthlyReportDAO.addReport(report);
    }

    // Retrieve reports by teacher ID
    public List<MonthlyTeacherReport> getReportsByTeacherId(int teacherId) {
        return monthlyReportDAO.getReportsByTeacherId(teacherId);
    }
}
