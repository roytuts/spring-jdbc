package com.roytuts.spring.namedparameterjdbctemplate.beanpropertysqlparametersource.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.roytuts.spring.namedparameterjdbctemplate.beanpropertysqlparametersource.model.User;

@Repository
public class UserDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public void addUser(User user) {
		final String sql = "insert into user(id, first_name, last_name) values(:id, :firstName, :lastName)";

		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);

		jdbcTemplate.update(sql, paramSource);
	}

	public int countByName(User user) {
		final String sql = "select count(*) from user where first_name = :firstName";

		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);

		return jdbcTemplate.queryForObject(sql, paramSource, Integer.class);
	}

}
