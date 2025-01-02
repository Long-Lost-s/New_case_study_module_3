package org.example.schoolmanagement.dao;

import org.example.schoolmanagement.DatabaseConnection;
import org.example.schoolmanagement.model.MonthlyTeacherReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MonthlyReportDAO {
    public void saveMonthlyReport(MonthlyTeacherReport report) {
        String query = "INSERT INTO monthly_teacher_reports (teacher_id, full_name, total_classes, total_students, report_date) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, report.getTeacherId());
            preparedStatement.setString(2, report.getFullName());
            preparedStatement.setInt(3, report.getTotalClasses());
            preparedStatement.setInt(4, report.getTotalStudents());
            preparedStatement.setDate(5, java.sql.Date.valueOf(report.getReportDate()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
