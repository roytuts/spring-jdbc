package com.roytuts.spring.namedparameterjdbctemplate.beanpropertysqlparametersource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roytuts.spring.namedparameterjdbctemplate.beanpropertysqlparametersource.dao.UserDao;
import com.roytuts.spring.namedparameterjdbctemplate.beanpropertysqlparametersource.model.User;

@SpringBootApplication
public class SpringBeanPropertySqlParameterSourceApp implements CommandLineRunner {

	@Autowired
	private UserDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringBeanPropertySqlParameterSourceApp.class, args).close();
	}

	@Override
	public void run(String... args) throws Exception {
		dao.addUser(new User(1, "Soumitra", "Roy"));

		User user = new User();
		user.setFirstName("Soumitra");
		System.out.println("Number of Users: " + dao.countByName(user));
	}

}
