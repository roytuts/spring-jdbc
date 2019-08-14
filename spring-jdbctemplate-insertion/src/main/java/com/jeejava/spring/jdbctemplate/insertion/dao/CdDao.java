package com.jeejava.spring.jdbctemplate.insertion.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jeejava.spring.jdbctemplate.insertion.model.Cd;

@Repository
public class CdDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_CD_INSERT = "INSERT INTO cd(id,title,artist) values(?,?,?)";

	public void insertSingleRecord(Cd cd) {
		Object[] studentParam = new Object[] { cd.getId(), cd.getTitle(), cd.getArtist() };
		jdbcTemplate.update(SQL_CD_INSERT, studentParam);
	}

	public void insertMultipleRecords(List<Cd> cds) {
		jdbcTemplate.batchUpdate(SQL_CD_INSERT, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pStmt, int j) throws SQLException {
				Cd cd = cds.get(j);
				pStmt.setLong(1, cd.getId());
				pStmt.setString(2, cd.getTitle());
				pStmt.setString(3, cd.getArtist());
			}

			@Override
			public int getBatchSize() {
				return cds.size();
			}
		});
	}

}
