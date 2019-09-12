package com.roytuts.spring.jdbctemplate.batch.insertion.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.roytuts.spring.jdbctemplate.batch.insertion.model.Cd;

@Repository
public class CdDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final int INSERT_BATCH_SIZE = 2;
	private final String SQL_CD_INSERT = "INSERT INTO cd(id,title,artist) values(?,?,?)";

	public void insert(List<Cd> cds) {
		for (int i = 0; i < cds.size(); i += INSERT_BATCH_SIZE) {

			final List<Cd> batchList = cds.subList(i,
					i + INSERT_BATCH_SIZE > cds.size() ? cds.size() : i + INSERT_BATCH_SIZE);

			jdbcTemplate.batchUpdate(SQL_CD_INSERT, new BatchPreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement pStmt, int j) throws SQLException {
					Cd cd = batchList.get(j);
					pStmt.setLong(1, cd.getId());
					pStmt.setString(2, cd.getTitle());
					pStmt.setString(3, cd.getArtist());
				}

				@Override
				public int getBatchSize() {
					return batchList.size();
				}
			});
		}
	}

}
