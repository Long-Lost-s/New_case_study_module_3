package model;

public class Classes {
    private int classId;
    private String className;
    private String teacherId;

    public Classes(int classId, String className, String teacherId) {
        this.classId = classId;
        this.className = className;
        this.teacherId = teacherId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
