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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
			System.out.println("List Student :");
			List<Student> lstS = (List<Student>) studentRepository.findAll();
			print(lstS);
			
			System.out.println("\nList Student sort by name then sort by ielts score:");
			List<Student> lstSNameLike = (List<Student>) studentRepository.findAll(Sort.by("name").and(Sort.by("ieltsScore")));
			print(lstSNameLike);
			
			System.out.println("\nList Student id between 4 and 6:");
			Pageable pageBetweenFourAndSixElements = PageRequest.of(1, 3);
			Page<Student> lstSFrom4to6 = studentRepository.findAll(pageBetweenFourAndSixElements);
			print(lstSFrom4to6);
		};
	}
	
	public void print(List<Student> lst) {
		for(Student s : lst) {
			System.out.println(s);
		}
	}
	
	public void print(Page<Student> lst) {
		for(Student s : lst) {
			System.out.println(s);
		}
	}

}
