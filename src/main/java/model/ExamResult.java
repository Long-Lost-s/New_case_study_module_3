package model;

import java.util.Date;

public class ExamResult {
    private int examId;
    private int studentId;
    private String examName;
    private Date examDate;
    private float score;

    // Constructor đầy đủ
    public ExamResult(int examId, int studentId, String examName, Date examDate, float score) {
        this.examId = examId;
        this.studentId = studentId;
        this.examName = examName;
        this.examDate = examDate;
        this.score = score;
    }

    // Getters và Setters
    public int getExamId() { return examId; }
    public void setExamId(int examId) { this.examId = examId; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getExamName() { return examName; }
    public void setExamName(String examName) { this.examName = examName; }

    public Date getExamDate() { return examDate; }
    public void setExamDate(Date examDate) { this.examDate = examDate; }

    public float getScore() { return score; }
    public void setScore(float score) { this.score = score; }
}
