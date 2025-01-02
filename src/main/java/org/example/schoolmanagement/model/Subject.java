package org.example.schoolmanagement.model;

public class Subject {
    private int subjectId;
    private String subjectName;

    // Constructor
    public Subject() {}

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public Subject(int subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    // Getters and Setters
    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
