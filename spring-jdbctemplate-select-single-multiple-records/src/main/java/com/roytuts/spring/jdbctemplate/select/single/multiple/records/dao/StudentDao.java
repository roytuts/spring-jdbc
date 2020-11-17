package com.roytuts.spring.jdbctemplate.select.single.multiple.records.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.roytuts.spring.jdbctemplate.select.single.multiple.records.model.Student;
import com.roytuts.spring.jdbctemplate.select.single.multiple.records.row.mapper.StudentDaoMapper;

@Repository
public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String SQL_STUDENT_SELECT_NAME = "select student_name from student where student_id = ?";
    private final String SQL_STUDENT_SELECT_SINGLE = "select * from student where student_id = ?";
    private final String SQL_STUDENT_SELECT_MULTIPLE = "select * from student";

    public String selectStudentName(Integer studentId) {
        String name = jdbcTemplate.queryForObject(SQL_STUDENT_SELECT_NAME, String.class, new Object[] { studentId });
        return name;
    }

    public Student selectSingleStudent(Integer studentId) {
        Student student = jdbcTemplate.queryForObject(SQL_STUDENT_SELECT_SINGLE, new StudentDaoMapper(),
                new Object[] { studentId });

        return student;
    }

    public List<Student> selectMultipleStudents() {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_STUDENT_SELECT_MULTIPLE);

        List<Student> students = new ArrayList<Student>();

        for (Map<String, Object> row : rows) {
            Student student = new Student();
            student.setStudentId(Integer.parseInt(String.valueOf(row.get("student_id"))));
            student.setStudentName(String.valueOf(row.get("student_name")));
            student.setStudentDob(String.valueOf(row.get("student_dob")));
            student.setStudentEmail(String.valueOf(row.get("student_email")));
            student.setStudentAddress(String.valueOf(row.get("student_address")));
            students.add(student);
        }

        // or using BeanPropertyRowMapper in a single call
        // List<Student> students = jdbcTemplate.query(SQL_STUDENT_SELECT_MULTIPLE, new
        // BeanPropertyRowMapper(Student.class));

        return students;
    }

}
