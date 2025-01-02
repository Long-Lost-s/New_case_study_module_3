package dao;

import model.Student;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Phương thức lấy thông tin học viên theo ID
    public static Student getStudentById(int studentId) {
        Student student = null;
        try (Connection connection = DBConnection.getConnection()) {
            String query = "SELECT * FROM Student WHERE StudentID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                student = new Student(
                        rs.getInt("StudentID"),
                        rs.getString("Fullname"),
                        rs.getString("Email"),
                        rs.getString("DateOfBirth"),
                        rs.getString("Address"),
                        rs.getString("PhoneNumber"),
                        rs.getString("Status")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    public static List<Student> getStudentsByStatus(String status) {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            String query = "SELECT * FROM Student WHERE Status = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("StudentID"),
                        rs.getString("Fullname"),
                        rs.getString("Email"),
                        rs.getString("DateOfBirth"),
                        rs.getString("Address"),
                        rs.getString("PhoneNumber"),
                        rs.getString("Status")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            String query = "SELECT * FROM Student";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("StudentID"),
                        rs.getString("Fullname"),
                        rs.getString("Email"),
                        rs.getString("DateOfBirth"),
                        rs.getString("Address"),
                        rs.getString("PhoneNumber"),
                        rs.getString("Status")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

}
