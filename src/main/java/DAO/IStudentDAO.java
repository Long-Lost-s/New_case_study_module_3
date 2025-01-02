package DAO;

import model.Student;

import java.util.List;

public interface IStudentDAO {
    public List<Student> selectAllStudents();
    public void insertStudent(Student student);
    public void updateStudent(Student student);
    public void deleteStudent(Student student);
    public Student selectStudent(int id);
    public List<Student> selectStudentsByClass(int id);
}
