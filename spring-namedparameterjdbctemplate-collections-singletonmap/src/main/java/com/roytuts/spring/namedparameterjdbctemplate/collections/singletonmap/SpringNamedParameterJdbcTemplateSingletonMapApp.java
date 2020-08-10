package com.roytuts.spring.namedparameterjdbctemplate.collections.singletonmap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roytuts.spring.namedparameterjdbctemplate.collections.singletonmap.dao.UserDao;

@SpringBootApplication
public class SpringNamedParameterJdbcTemplateSingletonMapApp implements CommandLineRunner {

	@Autowired
	private UserDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringNamedParameterJdbcTemplateSingletonMapApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Count: " + dao.countByName("Soumitra"));
	}

}
