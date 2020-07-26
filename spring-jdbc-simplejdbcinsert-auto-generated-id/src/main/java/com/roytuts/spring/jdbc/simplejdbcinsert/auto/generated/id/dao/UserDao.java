package com.roytuts.spring.jdbc.simplejdbcinsert.auto.generated.id.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import com.roytuts.spring.jdbc.simplejdbcinsert.auto.generated.id.model.User;

@Component
public class UserDao {

	@Autowired
	private SimpleJdbcInsert simpleJdbcInsert;

	public long addUser(final User user) {
		simpleJdbcInsert.withTableName("user").usingGeneratedKeyColumns("id");

		Map<String, Object> parameters = new HashMap<String, Object>(4);

		parameters.put("name", user.getName());
		parameters.put("email", user.getEmail());
		parameters.put("phone", user.getPhone());
		parameters.put("address", user.getAddress());

		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);

		return insertedId.longValue();
	}

}
