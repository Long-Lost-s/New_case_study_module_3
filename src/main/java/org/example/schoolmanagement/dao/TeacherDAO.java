package org.example.schoolmanagement.dao;

import org.example.schoolmanagement.DatabaseConnection;
import org.example.schoolmanagement.model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {
    // Retrieve all teachers
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        String query = "SELECT * FROM teachers";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Teacher teacher = new Teacher(
                        resultSet.getInt("teacher_id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getInt("total_classes"),
                        resultSet.getInt("total_students")
                );
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    // Find teacher by ID
    public Teacher getTeacherById(int teacherId) {
        String query = "SELECT * FROM teachers WHERE teacher_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, teacherId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Teacher(
                            resultSet.getInt("teacher_id"),
                            resultSet.getString("full_name"),
                            resultSet.getString("email"),
                            resultSet.getString("phone_number"),
                            resultSet.getInt("total_classes"),
                            resultSet.getInt("total_students")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Add a new teacher
    public boolean addTeacher(Teacher teacher) {
        String query = "INSERT INTO teachers (full_name, email, phone_number, total_classes, total_students) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, teacher.getFullName());
            preparedStatement.setString(2, teacher.getEmail());
            preparedStatement.setString(3, teacher.getPhoneNumber());
            preparedStatement.setInt(4, teacher.getTotalClasses());
            preparedStatement.setInt(5, teacher.getTotalStudents());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update teacher
    public boolean updateTeacher(Teacher teacher) {
        String query = "UPDATE teachers SET full_name = ?, email = ?, phone_number = ?, total_classes = ?, total_students = ? WHERE teacher_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, teacher.getFullName());
            preparedStatement.setString(2, teacher.getEmail());
            preparedStatement.setString(3, teacher.getPhoneNumber());
            preparedStatement.setInt(4, teacher.getTotalClasses());
            preparedStatement.setInt(5, teacher.getTotalStudents());
            preparedStatement.setInt(6, teacher.getTeacherId());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete teacher
    public boolean deleteTeacher(int teacherId) {
        String query = "DELETE FROM teachers WHERE teacher_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, teacherId);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
