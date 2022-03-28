package com.roytuts.spring.datasource.oracle.ldap.url.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RecordDao {

	@Autowired
	@Qualifier("devJdbcTemplate")
	private JdbcTemplate devJdbcTemplate;

	@Autowired
	@Qualifier("prodJdbcTemplate")
	private JdbcTemplate prodJdbcTemplate;

	public Object devRecord() {
		Object obj = devJdbcTemplate.queryForObject("sql", Object.class);

		return obj;
	}

	public Object prodRecord() {
		Object obj = prodJdbcTemplate.queryForObject("sql", Object.class);

		return obj;
	}

}
