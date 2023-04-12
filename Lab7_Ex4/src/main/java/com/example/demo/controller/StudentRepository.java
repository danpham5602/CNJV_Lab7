package com.example.demo.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Student;
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
	List<Student> findByAgeGreaterThan(int age);
	List<Student> findByIeltsScore(String score);
	List<Student> findByNameContaining(String name);
}
