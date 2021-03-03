package com.roytuts.spring.jdbctemplate.batch.insert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roytuts.spring.jdbctemplate.batch.insert.dao.StudentDao;
import com.roytuts.spring.jdbctemplate.batch.insert.model.Student;

@SpringBootApplication
public class SpringJdbcTemplateBatchInsertApp implements CommandLineRunner {

	@Autowired
	private StudentDao studentDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcTemplateBatchInsertApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Student> students = prepareStudents();

		studentDao.insert(students);
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
