package com.roytuts.spring.jdbctemplate.queryfor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roytuts.spring.jdbctemplate.queryfor.dao.CdDao;
import com.roytuts.spring.jdbctemplate.queryfor.model.Cd;

@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	private CdDao cdDao;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		System.out.println("Select => CD Title: " + cdDao.selectTitle(1l));
		System.out.println();

		Cd cd = cdDao.selectSingle(2l);
		System.out.println(
				"Single Record selection => Id: " + cd.getId() + ", Title: " + cd.getTitle() + ", Artist: " + cd.getArtist());
		System.out.println();

		System.out.println("Multiple Records Selection using queryForList");
		System.out.println("---------------------------------------------");
		List<Cd> cds = cdDao.selectMultipleUsingQueryForList();
		cds.forEach(c -> System.out
				.println("Id: " + c.getId() + ", Title: " + c.getTitle() + ", Artist: " + c.getArtist()));
		System.out.println();

		System.out.println("Multiple Records Selection using BeanPropertyRowMapper");
		System.out.println("------------------------------------------------------");
		cds = cdDao.selectMultipleUsingBeanPropertyRowMapper();
		cds.forEach(c -> System.out
				.println("Id: " + c.getId() + ", Title: " + c.getTitle() + ", Artist: " + c.getArtist()));
		System.out.println();
	}
}
