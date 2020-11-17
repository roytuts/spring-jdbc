package com.roytuts.spring.jdbctemplate.select.single.multiple.records.row.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.roytuts.spring.jdbctemplate.select.single.multiple.records.model.Student;

public class StudentDaoMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int arg1) throws SQLException {
        Student student = new Student();

        student.setStudentId(rs.getInt("student_id"));
        student.setStudentName(rs.getString("student_name"));
        student.setStudentDob(rs.getString("student_dob"));
        student.setStudentEmail(rs.getString("student_email"));
        student.setStudentAddress(rs.getString("student_address"));

        return student;
    }

}
