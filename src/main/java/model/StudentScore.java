package model;

public class StudentScore {
    private int studentId;
    private String studentName;
    private int subjectId;
    private int classId;
    private float theoryScore;
    private float practiceScore;
    private float averageScore;

    public StudentScore(int studentId, String studentName, int subjectId,
                        int classId, float theoryScore,
                        float practiceScore, float averageScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.subjectId = subjectId;
        this.classId = classId;
        this.theoryScore = theoryScore;
        this.practiceScore = practiceScore;
        this.averageScore = averageScore;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public float getTheoryScore() {
        return theoryScore;
    }

    public void setTheoryScore(float theoryScore) {
        this.theoryScore = theoryScore;
    }

    public float getPracticeScore() {
        return practiceScore;
    }

    public void setPracticeScore(float practiceScore) {
        this.practiceScore = practiceScore;
    }

    public float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(float averageScore) {
        this.averageScore = averageScore;
    }
}
