package dao;

import model.ExamResult;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExamResultDAO {

    public static List<ExamResult> getScoresByStudentId(int studentId) {
        List<ExamResult> results = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            String query = "SELECT * FROM ExamResult WHERE StudentID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                results.add(new ExamResult(
                        rs.getInt("ExamID"),          // int
                        rs.getInt("StudentID"),       // int
                        rs.getString("ExamName"),     // String
                        rs.getDate("ExamDate"),       // Date
                        rs.getFloat("Score")          // float
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
}
