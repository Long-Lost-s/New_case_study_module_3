package model;

import java.time.LocalDate;

public class Student {
    private int studentId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private StudentStatus status;
    private LocalDate dateOfBirth;
    private String address;
    private int classId;

    public Student(int studentId, String fullName,
                   String email, String phoneNumber,
                   StudentStatus status, LocalDate dateOfBirth,
                   String address, int classId) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.classId = classId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
