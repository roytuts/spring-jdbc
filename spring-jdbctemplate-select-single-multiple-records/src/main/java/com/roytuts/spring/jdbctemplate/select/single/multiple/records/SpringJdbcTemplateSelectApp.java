package com.roytuts.spring.jdbctemplate.select.single.multiple.records;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roytuts.spring.jdbctemplate.select.single.multiple.records.dao.StudentDao;

@SpringBootApplication
public class SpringJdbcTemplateSelectApp implements CommandLineRunner {

    @Autowired
    private StudentDao studentDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcTemplateSelectApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(studentDao.selectStudentName(1));

        System.out.println(studentDao.selectSingleStudent(2));

        studentDao.selectMultipleStudents().stream().forEach(s -> System.out.println(s));
    }

}
