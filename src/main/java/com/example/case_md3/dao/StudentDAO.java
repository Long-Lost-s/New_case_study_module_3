package com.example.case_md3.dao;

import com.example.case_md3.model.Student;
import com.example.case_md3.util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Lấy danh sách học viên theo ClassId
    public List<Student> getStudentsByClassId(int classId) {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students WHERE ClassId = ?";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, classId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Student student = new Student();
                    student.setStudentId(resultSet.getInt("StudentId"));
                    student.setFullName(resultSet.getString("FullName"));
                    student.setEmail(resultSet.getString("Email"));
                    student.setPhoneNumber(resultSet.getString("PhoneNumber"));
                    student.setDateOfBirth(resultSet.getString("DateOfBirth")); // Thêm ngày sinh
                    student.setAddress(resultSet.getString("Address"));         // Thêm địa chỉ
                    student.setStatus(resultSet.getString("Status"));
                    students.add(student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    // Lấy danh sách học viên theo ClassId và Status
    public List<Student> getStudentsByClassIdAndStatus(int classId, String status) {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students WHERE ClassId = ? AND Status = ?";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, classId);
            statement.setString(2, status);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Student student = new Student();
                    student.setStudentId(resultSet.getInt("StudentId"));
                    student.setFullName(resultSet.getString("FullName"));
                    student.setEmail(resultSet.getString("Email"));
                    student.setPhoneNumber(resultSet.getString("PhoneNumber"));
                    student.setDateOfBirth(resultSet.getString("DateOfBirth")); // Thêm ngày sinh
                    student.setAddress(resultSet.getString("Address"));         // Thêm địa chỉ
                    student.setStatus(resultSet.getString("Status"));
                    students.add(student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
    public Student getStudentById(int studentId) {
        String query = "SELECT * FROM students WHERE StudentId = ?";
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, studentId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Student student = new Student();
                    student.setStudentId(resultSet.getInt("StudentId"));
                    student.setFullName(resultSet.getString("FullName"));
                    student.setEmail(resultSet.getString("Email"));
                    student.setPhoneNumber(resultSet.getString("PhoneNumber"));
                    student.setStatus(resultSet.getString("Status"));
                    student.setDateOfBirth(String.valueOf(resultSet.getDate("DateOfBirth").toLocalDate()));
                    student.setAddress(resultSet.getString("Address"));
                    return student;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
