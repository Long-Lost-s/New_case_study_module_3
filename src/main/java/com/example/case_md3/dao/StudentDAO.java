package com.example.case_md3.dao;

import com.example.case_md3.model.Student;
import com.example.case_md3.util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public List<Student> getStudentsByClassId(int classId) {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students WHERE ClassId = ?";

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            System.out.println("Executing query for classId: " + classId);
            statement.setInt(1, classId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Student student = new Student();
                    student.setStudentId(resultSet.getInt("StudentId"));
                    student.setFullName(resultSet.getString("FullName"));
                    student.setEmail(resultSet.getString("Email"));
                    student.setPhoneNumber(resultSet.getString("PhoneNumber"));
                    student.setStatus(resultSet.getString("Status"));
                    students.add(student);
                }
            }

            System.out.println("Students found: " + students.size());
            for (Student student : students) {
                System.out.println("Student: " + student.getFullName());
            }

        } catch (SQLException e) {
            System.err.println("Error fetching students for classId " + classId + ": " + e.getMessage());
            e.printStackTrace();
        }
        return students;
    }
}