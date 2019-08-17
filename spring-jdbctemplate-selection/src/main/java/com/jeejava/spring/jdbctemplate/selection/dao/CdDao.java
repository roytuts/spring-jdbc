package com.jeejava.spring.jdbctemplate.selection.dao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jeejava.spring.jdbctemplate.selection.model.Cd;
import com.jeejava.spring.jdbctemplate.selection.rowmapper.CdRowMapper;

@Repository
public class CdDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_SELECT_TITLE = "select title from cd where id = ?";
	private final String SQL_SELECT_SINGLE = "select * from cd where id = ?";
	private final String SQL_SELECT_MULTIPLE = "select * from cd";

	public String selectTitle(Long id) {
		return jdbcTemplate.queryForObject(SQL_SELECT_TITLE, new Object[] { id }, String.class);
	}

	public Cd selectSingle(Long id) {
		Cd cd = jdbcTemplate.queryForObject(SQL_SELECT_SINGLE, new Object[] { id }, new CdRowMapper());
		return cd;
	}

	public List<Cd> selectMultipleUsingQueryForList() {
		List<Map<String, Object>> results = jdbcTemplate.queryForList(SQL_SELECT_MULTIPLE);

		List<Cd> cds = results.stream().map(m -> {
			Cd cd = new Cd();
			cd.setId(Long.parseLong(String.valueOf(m.get("id"))));
			cd.setTitle(String.valueOf(m.get("title")));
			cd.setArtist(String.valueOf(m.get("artist")));
			return cd;
		}).collect(Collectors.toList());
		return cds;
	}

	public List<Cd> selectMultipleUsingBeanPropertyRowMapper() {
		List<Cd> cds = jdbcTemplate.query(SQL_SELECT_MULTIPLE, new BeanPropertyRowMapper<Cd>(Cd.class));
		return cds;
	}

}
