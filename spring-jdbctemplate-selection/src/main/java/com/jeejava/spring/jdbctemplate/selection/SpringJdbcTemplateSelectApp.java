package com.jeejava.spring.jdbctemplate.selection;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jeejava.spring.jdbctemplate.selection.config.SpringJdbcConfig;
import com.jeejava.spring.jdbctemplate.selection.dao.CdDao;
import com.jeejava.spring.jdbctemplate.selection.model.Cd;

public class SpringJdbcTemplateSelectApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.register(SpringJdbcConfig.class);
		context.refresh();

		CdDao cdDao = context.getBean(CdDao.class);

		System.out.println("Select => CD Title: " + cdDao.selectTitle(1l));

		System.out.println();

		Cd cd = cdDao.selectSingle(2l);

		System.out.println(
				"Single selection => Id: " + cd.getId() + ", Title: " + cd.getTitle() + ", Artist: " + cd.getArtist());

		System.out.println();

		System.out.println("Multiple Selection using queryForList");

		List<Cd> cds = cdDao.selectMultipleUsingQueryForList();

		cds.forEach(c -> System.out
				.println("Id: " + c.getId() + ", Title: " + c.getTitle() + ", Artist: " + c.getArtist()));

		System.out.println();

		System.out.println("Multiple Selection using BeanPropertyRowMapper");

		cds = cdDao.selectMultipleUsingBeanPropertyRowMapper();

		cds.forEach(c -> System.out
				.println("Id: " + c.getId() + ", Title: " + c.getTitle() + ", Artist: " + c.getArtist()));

		context.close();
	}

}
