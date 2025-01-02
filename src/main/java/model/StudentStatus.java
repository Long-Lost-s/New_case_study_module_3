package model;

public enum StudentStatus {
    DROPPED("Thôi học"),
    SUSPENDED("Đình chỉ"),
    TRANSFER("Chuyển lớp"),
    STUDYING("Đang học");

    StudentStatus(String string) {
    }

    public String toString() {
        return this.name();
    }
}
