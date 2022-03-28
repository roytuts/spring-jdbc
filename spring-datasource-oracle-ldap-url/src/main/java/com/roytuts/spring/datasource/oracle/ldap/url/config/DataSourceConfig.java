package com.roytuts.spring.datasource.oracle.ldap.url.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
public class DataSourceConfig {

	@Autowired
	private Environment env;

	@Primary
	@Bean(name = "devDataSource")
	public DataSource devDataSource() {
		try {
			OracleDataSource dataSource = new OracleDataSource();
			dataSource.setUser(env.getProperty("db.dev.usr"));
			dataSource.setPassword(env.getProperty("db.dev.pwd"));
			dataSource.setURL(env.getProperty("db.dev.url"));

			return dataSource;
		} catch (Exception e) {
		}

		return null;
	}

	@Bean(name = "prodDataSource")
	public DataSource prodDataSource() {
		try {
			OracleDataSource dataSource = new OracleDataSource();
			dataSource.setUser(env.getProperty("db.prod.usr"));
			dataSource.setPassword(env.getProperty("db.prod.pwd"));
			dataSource.setURL(env.getProperty("db.prod.url"));

			return dataSource;
		} catch (Exception e) {
		}

		return null;
	}

	@Bean(name = "devJdbcTemplate")
	public JdbcTemplate devJdbcTemplate() {
		return new JdbcTemplate(devDataSource());
	}

	@Bean(name = "prodJdbcTemplate")
	public JdbcTemplate prodJdbcTemplate() {
		return new JdbcTemplate(prodDataSource());
	}

}
