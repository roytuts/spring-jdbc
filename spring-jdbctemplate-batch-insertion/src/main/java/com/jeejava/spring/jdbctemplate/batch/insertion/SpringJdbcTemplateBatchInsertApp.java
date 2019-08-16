package com.jeejava.spring.jdbctemplate.batch.insertion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jeejava.spring.jdbctemplate.batch.insertion.config.SpringJdbcConfig;
import com.jeejava.spring.jdbctemplate.batch.insertion.dao.CdDao;
import com.jeejava.spring.jdbctemplate.batch.insertion.model.Cd;

public class SpringJdbcTemplateBatchInsertApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.register(SpringJdbcConfig.class);
		context.refresh();

		CdDao cdDao = context.getBean(CdDao.class);

		System.out.println("Batch Insertion using JdbcTemplate has been started");

		cdDao.insert(getCdList());

		System.out.println("Batch Insertion using JdbcTemplate has been completed");

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
