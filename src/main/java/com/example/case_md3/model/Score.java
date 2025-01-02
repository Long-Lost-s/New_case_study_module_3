package com.example.case_md3.model;

public class Score {
    private int studentId;
    private String subjectName;
    private double theoryScore;
    private double practiceScore;
    private double averageScore; // Thêm trường averageScore

    // Getters and Setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public double getTheoryScore() {
        return theoryScore;
    }

    public void setTheoryScore(double theoryScore) {
        this.theoryScore = theoryScore;
    }

    public double getPracticeScore() {
        return practiceScore;
    }

    public void setPracticeScore(double practiceScore) {
        this.practiceScore = practiceScore;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }
}
