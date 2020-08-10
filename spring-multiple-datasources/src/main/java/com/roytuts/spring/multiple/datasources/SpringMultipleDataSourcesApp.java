package com.roytuts.spring.multiple.datasources;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.roytuts.spring.multiple.datasources.config.Config;

public class SpringMultipleDataSourcesApp {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		DataSources dataSources = context.getBean(DataSources.class);

		dataSources.getDataSources().forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v));

		((ConfigurableApplicationContext) context).close();
	}

}
