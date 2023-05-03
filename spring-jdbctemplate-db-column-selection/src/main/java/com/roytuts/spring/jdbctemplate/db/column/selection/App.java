package com.roytuts.spring.jdbctemplate.db.column.selection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roytuts.spring.jdbctemplate.db.column.selection.dao.ItemDao;

@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	private ItemDao itemDao;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("----------------All Records----------------");
		itemDao.fetchItems().stream().forEach(i -> System.out.println(i));

		System.out.println();
		System.out.println();

		System.out.println("----------------Filtered Records----------------");
		itemDao.fetchItemsLike("CD").stream().forEach(i -> System.out.println(i));
	}

}
