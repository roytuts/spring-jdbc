package com.roytuts.spring.jdbc.preparedstatement.auto.generated.id.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.roytuts.spring.jdbc.preparedstatement.auto.generated.id.model.User;

@Component
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_USER = "insert  into `user`(`name`,`email`,`phone`,`address`) values(?, ?, ?, ?)";

	public long addUser(final User user) {
		final PreparedStatementCreator psc = new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
				final PreparedStatement ps = connection.prepareStatement(SQL_INSERT_USER,
						Statement.RETURN_GENERATED_KEYS);

				ps.setString(1, user.getName());
				ps.setString(2, user.getEmail());
				ps.setString(3, user.getPhone());
				ps.setString(4, user.getAddress());

				return ps;
			}
		};

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(psc, keyHolder);

		long insertedId = keyHolder.getKey().longValue();

		return insertedId;
	}

}
