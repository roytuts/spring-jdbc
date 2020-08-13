package com.roytuts.spring.namedparameterjdbctemplate.mapsqlparametersource.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.roytuts.spring.namedparameterjdbctemplate.mapsqlparametersource.model.User;

@Component
public class UserDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	public void addUser(User user) {
		final String sql = "insert into user(id, name, email, phone, address) values(:id, :name, :email, :phone, :address)";

		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		mapParameters.addValue("id", user.getId());
		mapParameters.addValue("name", user.getName());
		mapParameters.addValue("email", user.getEmail());
		mapParameters.addValue("phone", user.getPhone());
		mapParameters.addValue("address", user.getAddress());

		jdbcTemplate.update(sql, mapParameters);
	}

	public int countByName(User user) {
		final String sql = "select count(*) from user where name = :name";

		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		mapParameters.addValue("name", user.getName());

		return jdbcTemplate.queryForObject(sql, mapParameters, Integer.class);
	}

}
