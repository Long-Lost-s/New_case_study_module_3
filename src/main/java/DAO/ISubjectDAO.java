package DAO;

import model.Classes;
import model.Subject;

import java.util.List;

public interface ISubjectDAO {
    public List<Subject> selectAllSubjects();
    public void insertSubject(Subject subject);
    public void updateSubject(Subject subject);
    public void deleteSubject(Subject subject);
    public Subject selectSubject(int id);
}
