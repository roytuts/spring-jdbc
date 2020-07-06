package com.roytuts.spring.jdbctemplate.batch.insert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.roytuts.spring.jdbctemplate.batch.insert.config.AppConfig;
import com.roytuts.spring.jdbctemplate.batch.insert.dao.StudentDao;
import com.roytuts.spring.jdbctemplate.batch.insert.model.Student;

public class Application {

	public static void main(String[] args) {
		List<Student> students = prepareStudents();

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		StudentDao studentDao = context.getBean(StudentDao.class);

		studentDao.insert(students);

		((ConfigurableApplicationContext) context).close();
	}

	private static List<Student> prepareStudents() {
		List<Student> students = new ArrayList<Student>();

		Student student = new Student();
		student.setStudentName("Sumit");
		student.setStudentDob("01-01-1980");
		student.setStudentEmail("sumit@email.com");
		student.setStudentAddress("Garifa");
		students.add(student);

		student = new Student();
		student.setStudentName("Gourab");
		student.setStudentDob("01-01-1982");
		student.setStudentEmail("gourab@email.com");
		student.setStudentAddress("Garia");
		students.add(student);

		student = new Student();
		student.setStudentName("Debina");
		student.setStudentDob("01-01-1982");
		student.setStudentEmail("debina@email.com");
		student.setStudentAddress("Salt Lake");
		students.add(student);

		student = new Student();
		student.setStudentName("Souvik");
		student.setStudentDob("01-01-1992");
		student.setStudentEmail("souvik@email.com");
		student.setStudentAddress("Alipore");
		students.add(student);

		student = new Student();
		student.setStudentName("Liton");
		student.setStudentDob("01-01-1990");
		student.setStudentEmail("liton@email.com");
		student.setStudentAddress("Salt Lake");
		students.add(student);

		return students;
	}

}
