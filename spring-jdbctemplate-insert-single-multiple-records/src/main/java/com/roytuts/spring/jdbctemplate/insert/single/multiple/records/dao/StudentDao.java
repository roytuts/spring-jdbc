package com.roytuts.spring.jdbctemplate.insert.single.multiple.records.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.roytuts.spring.jdbctemplate.insert.single.multiple.records.model.Student;

@Repository
public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String SQL_STUDENT_INSERT = "INSERT INTO student(student_name,student_dob,student_email,student_address) values(?,?,?,?)";

    public void insertSingleStudent(Student student) {
        Object[] studentParam = new Object[] { student.getStudentName(), student.getStudentDob(),
                student.getStudentEmail(), student.getStudentAddress() };

        jdbcTemplate.update(SQL_STUDENT_INSERT, studentParam);
    }

    public void insertMultipleStudents(List<Student> students) {
        jdbcTemplate.batchUpdate(SQL_STUDENT_INSERT, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement pStmt, int j) throws SQLException {
                Student student = students.get(j);
                pStmt.setString(1, student.getStudentName());
                pStmt.setString(2, student.getStudentDob());
                pStmt.setString(3, student.getStudentEmail());
                pStmt.setString(4, student.getStudentAddress());
            }

            @Override
            public int getBatchSize() {
                return students.size();
            }

        });
    }

}
