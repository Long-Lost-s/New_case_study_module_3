package org.example.schoolmanagement.service;

import org.example.schoolmanagement.dao.MonthlyReportDAO;
import org.example.schoolmanagement.dao.TeacherDAO;
import org.example.schoolmanagement.model.MonthlyTeacherReport;
import org.example.schoolmanagement.model.Teacher;

import java.time.LocalDate;
import java.util.List;

public class MonthlyReportService {
    private final TeacherDAO teacherDAO;
    private final MonthlyReportDAO monthlyReportDAO;

    public MonthlyReportService() {
        this.teacherDAO = new TeacherDAO();
        this.monthlyReportDAO = new MonthlyReportDAO();
    }

    public void generateMonthlyReports() {
        List<Teacher> teachers = teacherDAO.getAllTeachers();
        LocalDate reportDate = LocalDate.now();

        for (Teacher teacher : teachers) {
            MonthlyTeacherReport report = new MonthlyTeacherReport();
            report.setTeacherId(teacher.getTeacherId());
            report.setFullName(teacher.getFullName());
            report.setTotalClasses(teacher.getTotalClasses());
            report.setTotalStudents(teacher.getTotalStudents());
            report.setReportDate(reportDate);

            monthlyReportDAO.saveMonthlyReport(report);
        }
    }
}
