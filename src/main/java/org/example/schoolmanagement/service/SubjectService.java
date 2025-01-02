package org.example.schoolmanagement.service;

import org.example.schoolmanagement.dao.SubjectDAO;
import org.example.schoolmanagement.model.Subject;

import java.util.List;

public class SubjectService {
    private final SubjectDAO subjectDAO;

    public SubjectService() {
        this.subjectDAO = new SubjectDAO();
    }

    // Add a new subject
    public boolean addSubject(Subject subject) {
        if (subject.getSubjectName() == null || subject.getSubjectName().isEmpty()) {
            throw new IllegalArgumentException("Subject name cannot be empty.");
        }
        return subjectDAO.addSubject(subject);
    }

    // Retrieve all subjects
    public List<Subject> getAllSubjects() {
        return subjectDAO.getAllSubjects();
    }

    // Retrieve a subject by ID
    public Subject getSubjectById(int id) {
        return subjectDAO.getSubjectById(id);
    }

    // Update a subject
    public boolean updateSubject(Subject subject) {
        if (subject.getSubjectName() == null || subject.getSubjectName().isEmpty()) {
            throw new IllegalArgumentException("Subject name cannot be empty.");
        }
        return subjectDAO.updateSubject(subject);
    }

    // Delete a subject by ID
    public boolean deleteSubject(int id) {
        return subjectDAO.deleteSubject(id);
    }
}
