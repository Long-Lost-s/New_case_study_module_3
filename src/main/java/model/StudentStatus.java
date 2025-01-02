package model;

public enum StudentStatus {
    DROPPED("Thôi học"),
    SUSPENDED("Đình chỉ"),
    TRANSFER("Chuyển lớp"),
    STUDYING("Đang học");

    private final String name;

    StudentStatus(String string) {
        name = string;
    }

    public String toString() {
        return this.name;
    }

    public static StudentStatus fromString(String string) {
        switch (string) {
            case "Thôi học":
                return DROPPED;
            case "Đình chỉ":
                return SUSPENDED;
            case "Chuyển lớp":
                return TRANSFER;
            case "Đang học":
                return STUDYING;
            default:
                return null;
        }
    }
}
