package com.jeejava.spring.jdbctemplate.selection.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jeejava.spring.jdbctemplate.selection.model.Cd;

public class CdRowMapper implements RowMapper<Cd> {

	@Override
	public Cd mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cd cd = new Cd();

		cd.setId(rs.getLong("id"));
		cd.setTitle(rs.getString("title"));
		cd.setArtist(rs.getString("artist"));

		return cd;
	}

}
