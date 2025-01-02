package DAO;

import model.Student;
import model.StudentStatus;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentDAO implements IStudentDAO {
    private final String SELECT_ALL_STUDENTS = "SELECT * FROM students";
    private final String INSERT_STUDENT = "INSERT INTO students " +
            "(FullName,Email,PhoneNumber," +
            "Status,DateOfBirth,Address,ClassId) " +
            "VALUES(?,?,?,?,?,?,?)";
    private final String UPDATE_STUDENT = "UPDATE students SET " +
            "FullName = ?,Email = ?,PhoneNumber = ?," +
            "Status = ?,DateOfBirth = ?,Address = ?," +
            "ClassId = ? WHERE StudentId = ?;";
    private final String DELETE_STUDENT = "DELETE FROM students WHERE StudentId = ?;";
    private final String SELECT_STUDENT_BY_ID = "SELECT * FROM students WHERE StudentId = ?";
    private final String SELECT_STUDENT_BY_CLASS_ID = "SELECT * FROM students WHERE ClassId = ?";

    @Override
    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();
        try(Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int studentId = rs.getInt("StudentId");
                String fullName = rs.getString("FullName");
                String email = rs.getString("Email");
                String phoneNumber = rs.getString("PhoneNumber");
                StudentStatus status = StudentStatus.fromString(rs.getString("Status"));
                LocalDate dateOfBirth = rs.getDate("DateOfBirth").toLocalDate();
                String address = rs.getString("Address");
                int classId = rs.getInt("ClassId");
                Student student = new Student(studentId,fullName,email,phoneNumber,status,dateOfBirth,address,classId);
                students.add(student);
            }
        } catch (SQLException e) {
            Database.printSQLException(e);
        }
        return students;
    }

    @Override
    public void insertStudent(Student student) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void deleteStudent(Student student) {

    }

    @Override
    public Student selectStudent(int id) {
        return null;
    }

    @Override
    public List<Student> selectStudentsByClass(int id) {
        return Collections.emptyList();
    }
}
