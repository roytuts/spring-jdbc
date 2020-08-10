package com.roytuts.spring.namedparameterjdbctemplate.collections.singletonmap.dao;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public int countByName(String name) {
		final String sql = "select count(*) from user where name = :name";

		Map<String, String> namedParameters = Collections.singletonMap("name", name);

		return jdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
	}

}
