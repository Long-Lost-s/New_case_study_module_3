package DAO;

import model.StudentScore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentScoreDAO {
    private final String SELECT_STUDENT_SCORE_BY_SUBJECT = "SELECT" +
            " students.StudentId, students.FullName, students.ClassId," +
            " scores.TheoryScore, scores.PracticeScore, scores.average_score\n" +
            "FROM students\n" +
            "JOIN scores\n" +
            "ON students.StudentId = scores.StudentId\n" +
            "WHERE scores.SubjectId = ?;";
    private final String SELECT_STUDENT_SCORE_BY_SUBJECT_AND_STUDENT = "SELECT" +
            " students.StudentId, students.FullName, students.ClassId," +
            " scores.TheoryScore, scores.PracticeScore, scores.average_score\n" +
            "FROM students\n" +
            "JOIN scores\n" +
            "ON students.StudentId = scores.StudentId\n" +
            "WHERE scores.SubjectId = ? AND scores.StudentId = ?;";
    private final String UPDATE_STUDENT_SCORE = "UPDATE scores " +
            "SET TheoryScore = ?, PracticeScore = ? " +
            "WHERE StudentId = ? AND SubjectId = ?;";

    public List<StudentScore> getStudentScoreBySubject(int subjectId) {
        List<StudentScore> studentScores = new ArrayList<StudentScore>();

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_SCORE_BY_SUBJECT);) {

            preparedStatement.setInt(1, subjectId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int studentId = resultSet.getInt("StudentId");
                String fullName = resultSet.getString("FullName");
                int classId = resultSet.getInt("ClassId");
                float theoryScore = resultSet.getFloat("TheoryScore");
                float practiceScore = resultSet.getFloat("PracticeScore");
                float averageScore = resultSet.getFloat("average_score");
                StudentScore studentScore = new StudentScore(studentId,fullName,subjectId,classId,theoryScore,practiceScore,averageScore);
                studentScores.add(studentScore);
            }
        } catch (SQLException e) {
            Database.printSQLException(e);
        }
        return studentScores;
    }

    public StudentScore getStudentScoreBySubjectAndStudent(int subjectId, int studentId) {
        StudentScore studentScore = null;

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_SCORE_BY_SUBJECT_AND_STUDENT);) {

            preparedStatement.setInt(1, subjectId);
            preparedStatement.setInt(2, studentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String fullName = resultSet.getString("FullName");
                int classId = resultSet.getInt("ClassId");
                float theoryScore = resultSet.getFloat("TheoryScore");
                float practiceScore = resultSet.getFloat("PracticeScore");
                float averageScore = resultSet.getFloat("average_score");
                studentScore = new StudentScore(studentId,fullName,subjectId,classId,theoryScore,practiceScore,averageScore);
            }
        } catch (SQLException e) {
            Database.printSQLException(e);
        }
        return studentScore;
    }

    public int updateStudentScore(int studentId, int subjectId, float theoryScore, float practiceScore) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SCORE);) {
            preparedStatement.setFloat(1, theoryScore);
            preparedStatement.setFloat(2, practiceScore);
            preparedStatement.setInt(3, studentId);
            preparedStatement.setInt(4, subjectId);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
