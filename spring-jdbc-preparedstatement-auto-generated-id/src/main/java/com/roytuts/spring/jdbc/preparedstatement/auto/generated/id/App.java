package com.roytuts.spring.jdbc.preparedstatement.auto.generated.id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roytuts.spring.jdbc.preparedstatement.auto.generated.id.dao.UserDao;
import com.roytuts.spring.jdbc.preparedstatement.auto.generated.id.model.User;

@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Generated Id for New User: "
				+ userDao.addUser(new User("Soumitra", "soumitra@email.com", "234567890", "Earth")));
	}

}
