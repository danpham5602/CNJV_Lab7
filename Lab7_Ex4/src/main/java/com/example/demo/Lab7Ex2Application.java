package com.example.demo;
import com.example.demo.controller.StudentRepository;
import com.example.demo.entities.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
			ArrayList<Student> lstStudent =  (ArrayList<Student>) studentRepository.findAll();
			print(lstStudent);

			System.out.println("List Student Age Greater Than 19:");
			List<Student> lstSAgeThan19 = studentRepository.findByAgeGreaterThan(19);
			print(lstSAgeThan19);
			///////////////////////////
			System.out.println("List Student have Ielts Score = 9.0:");
			List<Student> lstSILScore = studentRepository.findByIeltsScore("9.0");
			print(lstSILScore);
			///////////////////////////
			System.out.println("List Student' name contain word ng:");
			List<Student> lstSNameLike = studentRepository.findByNameContaining("ng");
			print(lstSNameLike);
			
			
		};
	}
	
	public void print(List<Student> lstSAgeThan19) {
		for(Student s : lstSAgeThan19) {
			System.out.println(s);
		}
	}

}
