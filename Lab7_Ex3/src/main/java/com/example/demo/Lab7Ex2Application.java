package com.example.demo;
import com.example.demo.controller.StudentRepository;
import com.example.demo.entities.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab7Ex2Application {
	@Autowired
	StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(Lab7Ex2Application.class, args);

	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("List Student:");
			Student s1 = new Student();
			s1.setName("Dan");
			s1.setAge(20);
			s1.setEmail("dan@gmail.com");
			s1.setIeltsScore("8.0");
			studentRepository.save(s1);
			
			
			studentRepository.save(new Student(1, "Dân", 20, "dan@gmail.com", "9.0"));
			studentRepository.save(new Student(2, "Quân", 20, "quan@gmail.com", "9.0"));
			studentRepository.save(new Student(3, "Đức", 20, "duc@gmail.com", "9.0"));

			ArrayList<Student> lstStudent =  (ArrayList<Student>) studentRepository.findAll();
			print(lstStudent);
			
			studentRepository.save(new Student(1, "Dân S", 18, "dan@gmail.com", "9.0"));

			System.out.println("First Student after update:");
			
			System.out.println(studentRepository.findById(1));
			
			studentRepository.deleteById(2);
			System.out.println("List Student after delete student's id 2:");
			print((ArrayList<Student>) studentRepository.findAll());
			
		};
	}
	
	public void print(ArrayList<Student> lstStudent) {
		for(Student s : lstStudent) {
			System.out.println(s);
		}
	}

}
