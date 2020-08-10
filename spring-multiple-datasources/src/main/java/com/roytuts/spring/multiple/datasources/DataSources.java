package com.roytuts.spring.multiple.datasources;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DataSources {

	private Map<String, DataSource> dataSourceMap;

	@Autowired
	private ApplicationContext applicationContext;

	@PostConstruct
	public void init() {
		dataSourceMap = applicationContext.getBeansOfType(DataSource.class);
	}

	public Map<String, DataSource> getDataSources() {
		return dataSourceMap;
	}

}
