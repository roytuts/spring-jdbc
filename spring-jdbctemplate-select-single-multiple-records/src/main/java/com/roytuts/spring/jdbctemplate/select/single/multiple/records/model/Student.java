package com.roytuts.spring.jdbctemplate.select.single.multiple.records.model;

public class Student {

    private Integer studentId;
    private String studentName;
    private String studentDob;
    private String studentEmail;
    private String studentAddress;

    public Student() {
    }

    public Student(Integer studentId, String studentName, String studentDob, String studentEmail,
            String studentAddress) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentDob = studentDob;
        this.studentEmail = studentEmail;
        this.studentAddress = studentAddress;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentDob() {
        return studentDob;
    }

    public void setStudentDob(String studentDob) {
        this.studentDob = studentDob;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentDob=" + studentDob
                + ", studentEmail=" + studentEmail + ", studentAddress=" + studentAddress + "]";
    }

}
