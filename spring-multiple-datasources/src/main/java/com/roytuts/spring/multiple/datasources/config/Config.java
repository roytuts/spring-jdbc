package com.roytuts.spring.multiple.datasources.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.roytuts.spring.multiple.datasources.DataSources;

@Configuration
@PropertySource("classpath:jdbc.properties")
@ComponentScan(basePackages = "com.roytuts.spring.multiple.datasources.config")
public class Config {

	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSourceMysql() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.mysql.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.mysql.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.mysql.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.mysql.password"));

		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplateMysql() throws ClassNotFoundException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql());

		return jdbcTemplate;
	}

	@Bean
	public DataSource dataSourcePostgresql() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.postgresql.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.postgresql.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.postgresql.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.postgresql.password"));

		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplatePostgresql() throws ClassNotFoundException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourcePostgresql());

		return jdbcTemplate;
	}

	@Bean
	public DataSources dataSources() {
		return new DataSources();
	}

}
