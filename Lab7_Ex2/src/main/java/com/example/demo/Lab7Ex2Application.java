package com.example.demo;

import com.example.demo.controller.StudentRepository;
import com.example.demo.entities.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Lab7Ex2Application {
	private static final Logger logger = LoggerFactory.getLogger(Lab7Ex2Application.class);
	private final StudentRepository studentRepository;

	public Lab7Ex2Application(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Lab7Ex2Application.class, args);
	}

	public void run() {
		logger.info("List Student:");

		studentRepository.save(new Student(1, "Dân", 20, "dan@gmail.com", "9.0"));
		studentRepository.save(new Student(2, "Quân", 20, "quan@gmail.com", "8.0"));
		studentRepository.save(new Student(3, "Đức", 20, "duc@gmail.com", "9.0"));

		List<Student> lstStudent = studentRepository.findAll();
		print(lstStudent);

		studentRepository.save(new Student(1, "Dân S", 18, "dan@gmail.com", "9.0"));

		logger.info("First Student after update:");
		logger.info(studentRepository.findById(1).toString());

		studentRepository.deleteById(2);
		logger.info("List Student after delete student's id 2:");
		print(studentRepository.findAll());
	}

	public void print(List<Student> lstStudent) {
		for (Student s : lstStudent) {
			logger.info(s.toString());
		}
	}
}
