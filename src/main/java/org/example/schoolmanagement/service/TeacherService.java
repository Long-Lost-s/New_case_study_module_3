package org.example.schoolmanagement.service;

import org.example.schoolmanagement.dao.TeacherDAO;
import org.example.schoolmanagement.model.Teacher;

import java.util.List;

public class TeacherService {
    private final TeacherDAO teacherDAO;

    public TeacherService() {
        this.teacherDAO = new TeacherDAO();
    }

    // Retrieve all teachers
    public List<Teacher> getAllTeachers() {
        return teacherDAO.getAllTeachers();
    }

    // Find teacher by ID
    public Teacher getTeacherById(int teacherId) {
        return teacherDAO.getTeacherById(teacherId);
    }

    // Add a new teacher
    public boolean addTeacher(Teacher teacher) {
        return teacherDAO.addTeacher(teacher);
    }

    // Update teacher
    public boolean updateTeacher(Teacher teacher) {
        return teacherDAO.updateTeacher(teacher);
    }

    // Delete teacher
    public boolean deleteTeacher(int teacherId) {
        return teacherDAO.deleteTeacher(teacherId);
    }
}
