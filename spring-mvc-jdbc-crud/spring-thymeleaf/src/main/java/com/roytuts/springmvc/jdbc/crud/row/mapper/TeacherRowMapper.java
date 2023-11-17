package com.roytuts.springmvc.jdbc.crud.row.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.roytuts.springmvc.jdbc.crud.model.Teacher;

public class TeacherRowMapper implements RowMapper<Teacher> {

	@Override
	public Teacher mapRow(ResultSet rs, int row) throws SQLException {
		return new Teacher(rs.getInt("id"), rs.getString("name"), rs.getString("expertise"));
	}

}
