package com.roytuts.spring.jdbctemplate.batch.insert.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.roytuts.spring.jdbctemplate.batch.insert.model.Student;

@Repository
public class StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final int INSERT_BATCH_SIZE = 2;

	private final String SQL_STUDENT_INSERT = "INSERT INTO student(student_name,student_dob,student_email,student_address) values(?,?,?,?)";

	public void insert(List<Student> students) {

		for (int i = 0; i < students.size(); i += INSERT_BATCH_SIZE) {

			final List<Student> batchList = students.subList(i,
					i + INSERT_BATCH_SIZE > students.size() ? students.size() : i + INSERT_BATCH_SIZE);

			jdbcTemplate.batchUpdate(SQL_STUDENT_INSERT, new BatchPreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement pStmt, int j) throws SQLException {
					Student student = batchList.get(j);
					pStmt.setString(1, student.getStudentName());
					pStmt.setString(2, student.getStudentDob());
					pStmt.setString(3, student.getStudentEmail());
					pStmt.setString(4, student.getStudentAddress());
				}

				@Override
				public int getBatchSize() {
					return batchList.size();
				}

			});
		}

	}

}
