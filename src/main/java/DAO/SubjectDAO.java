package DAO;

import model.Classes;
import model.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubjectDAO implements ISubjectDAO {
    private final String SELECT_ALL_SUBJECTS = "SELECT * FROM subjects";

    @Override
    public List<Subject> selectAllSubjects() {
        List<Subject> subjects = new ArrayList<Subject>();
        try(Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SUBJECTS);) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int subjectId = rs.getInt("SubjectId");
                String subjectName = rs.getString("SubjectName");
                int teacherId = Integer.parseInt(rs.getString("TeacherId"));
                Subject subject = new Subject(subjectId,subjectName,teacherId);
                subjects.add(subject);
            }
        } catch (SQLException e) {
            Database.printSQLException(e);
        }
        return subjects;
    }

    @Override
    public void insertSubject(Subject subject) {

    }

    @Override
    public void updateSubject(Subject subject) {

    }

    @Override
    public void deleteSubject(Subject subject) {

    }

    @Override
    public Subject selectSubject(int id) {
        return null;
    }
}
