package com.roytuts.spring.namedparameterjdbctemplate.beanpropertysqlparametersource.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.roytuts.spring.namedparameterjdbctemplate.beanpropertysqlparametersource.model.User;

@Component
public class UserDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public void addUser(User user) {
		final String sql = "insert into user(id, name, email, phone, address) values(:id, :name, :email, :phone, :address)";

		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);

		jdbcTemplate.update(sql, paramSource);
	}

	public int countByName(User user) {
		final String sql = "select count(*) from user where name = :name";

		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);

		return jdbcTemplate.queryForObject(sql, paramSource, Integer.class);
	}

}
