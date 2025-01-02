package org.example.schoolmanagement.dao;

import org.example.schoolmanagement.DatabaseConnection;
import org.example.schoolmanagement.model.MonthlyTeacherReport;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MonthlyReportDAO {

    // Retrieve all monthly reports
    public List<MonthlyTeacherReport> getAllReports() {
        List<MonthlyTeacherReport> reports = new ArrayList<>();
        String query = "SELECT * FROM monthly_teacher_reports ORDER BY report_date DESC";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                MonthlyTeacherReport report = new MonthlyTeacherReport();
                report.setTeacherId(resultSet.getInt("teacher_id"));
                report.setFullName(resultSet.getString("full_name"));
                report.setTotalClasses(resultSet.getInt("total_classes"));
                report.setTotalStudents(resultSet.getInt("total_students"));
                report.setReportDate(resultSet.getDate("report_date").toLocalDate());
                reports.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reports;
    }

    // Add a new monthly report
    public boolean addReport(MonthlyTeacherReport report) {
        String query = "INSERT INTO monthly_teacher_reports (teacher_id, full_name, total_classes, total_students, report_date) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, report.getTeacherId());
            preparedStatement.setString(2, report.getFullName());
            preparedStatement.setInt(3, report.getTotalClasses());
            preparedStatement.setInt(4, report.getTotalStudents());
            preparedStatement.setDate(5, java.sql.Date.valueOf(report.getReportDate()));

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // Retrieve reports by teacher ID
    public List<MonthlyTeacherReport> getReportsByTeacherId(int teacherId) {
        List<MonthlyTeacherReport> reports = new ArrayList<>();
        String query = "SELECT * FROM monthly_teacher_reports WHERE teacher_id = ? ORDER BY report_date DESC";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, teacherId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    MonthlyTeacherReport report = new MonthlyTeacherReport();

                    report.setTeacherId(resultSet.getInt("teacher_id"));
                    report.setFullName(resultSet.getString("full_name"));
                    report.setTotalClasses(resultSet.getInt("total_classes"));
                    report.setTotalStudents(resultSet.getInt("total_students"));
                    report.setReportDate(resultSet.getDate("report_date").toLocalDate());
                    reports.add(report);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reports;
    }
}
