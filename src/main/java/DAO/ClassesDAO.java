package DAO;

import model.Classes;
import model.Student;
import model.StudentStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassesDAO implements IClassesDAO {
    private String SELECT_ALL_CLASSES = "SELECT * FROM classes";

    @Override
    public List<Classes> selectAllClasses() {
        List<Classes> classes = new ArrayList<Classes>();
        try(Connection connection = Database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLASSES);) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int classId = rs.getInt("ClassId");
                String className = rs.getString("ClassName");
                int teacherId = Integer.parseInt(rs.getString("TeacherId"));
                Classes classs = new Classes(classId,className,teacherId);
                classes.add(classs);
            }
        } catch (SQLException e) {
            Database.printSQLException(e);
        }
        return classes;
    }

    @Override
    public void insertClasses(Classes classes) {

    }

    @Override
    public void updateClasses(Classes classes) {

    }

    @Override
    public void deleteClasses(Classes classes) {

    }

    @Override
    public Classes selectClasses(int id) {
        return null;
    }
}
