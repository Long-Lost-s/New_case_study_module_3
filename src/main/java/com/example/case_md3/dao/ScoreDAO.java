package com.example.case_md3.dao;

import com.example.case_md3.model.Score;
import com.example.case_md3.util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScoreDAO {
    public List<Score> getScoresByStudentId(int studentId) {
        List<Score> scores = new ArrayList<>();
        String query = "SELECT s.StudentId, sb.SubjectName, s.TheoryScore, s.PracticeScore, " +
                "((s.TheoryScore + s.PracticeScore) / 2) AS AverageScore " +
                "FROM scores s " +
                "JOIN subjects sb ON s.SubjectId = sb.SubjectId " +
                "WHERE s.StudentId = ?";

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, studentId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Score score = new Score();
                    score.setStudentId(resultSet.getInt("StudentId"));
                    score.setSubjectName(resultSet.getString("SubjectName"));
                    score.setTheoryScore(resultSet.getDouble("TheoryScore"));
                    score.setPracticeScore(resultSet.getDouble("PracticeScore"));
                    score.setAverageScore(resultSet.getDouble("AverageScore"));
                    scores.add(score);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scores;
    }
}
