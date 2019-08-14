package com.jeejava.spring.jdbctemplate.insertion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jeejava.spring.jdbctemplate.insertion.config.SpringJdbcConfig;
import com.jeejava.spring.jdbctemplate.insertion.dao.CdDao;
import com.jeejava.spring.jdbctemplate.insertion.model.Cd;

public class SpringJdbcTemplateInsertApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.register(SpringJdbcConfig.class);
		context.refresh();

		CdDao cdDao = context.getBean(CdDao.class);

		System.out.println("Single Insertion using JdbcTemplate has been started");

		Cd cd = new Cd();
		cd.setId(10l);
		cd.setTitle("Single Title");
		cd.setArtist("Single Artist");
		cdDao.insertSingleRecord(cd);

		System.out.println("Single Insertion using JdbcTemplate has been completed");

		System.out.println();

		System.out.println("Multiple Insertion using JdbcTemplate has been started");

		cdDao.insertMultipleRecords(getCdList());

		System.out.println("Multiple Insertion using JdbcTemplate has been completed");

		context.close();
	}

	private static List<Cd> getCdList() {
		List<Cd> cds = new ArrayList<>();

		Cd cd = new Cd();
		cd.setId(1l);
		cd.setTitle("Title 1");
		cd.setArtist("Artist 1");

		cds.add(cd);

		cd = new Cd();
		cd.setId(2l);
		cd.setTitle("Title 2");
		cd.setArtist("Artits 2");

		cds.add(cd);

		cd = new Cd();
		cd.setId(3l);
		cd.setTitle("Title 3");
		cd.setArtist("Artist 3");

		cds.add(cd);

		cd = new Cd();
		cd.setId(4l);
		cd.setTitle("Title 4");
		cd.setArtist("Artist 4");

		cds.add(cd);

		cd = new Cd();
		cd.setId(5l);
		cd.setTitle("Title 5");
		cd.setArtist("Artist 5");

		cds.add(cd);

		return cds;
	}

}
