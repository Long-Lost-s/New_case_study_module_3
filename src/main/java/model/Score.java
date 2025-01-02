package model;

public class Score {
    private int studentId;
    private int teacherId;
    private float theoryScore;
    private float practiceScore;
    private float averageScore;

    public Score(int studentId, int teacherId,
                 float theoryScore, float practiceScore,
                 float averageScore) {
        this.studentId = studentId;
        this.teacherId = teacherId;
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

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
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
