package com.example.demo.controller;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Student;
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
	@Query("from Student s where s.age > :age")
	List<Student> findByAgeGreaterThan1(@Param("age") int age);
	
	@Query("from Student s where s.ieltsScore = :ielts_scores")
	List<Student> findByIeltsScore1(@Param("ielts_scores") String score);
	
	@Query("from Student s where s.name like %:name%")
	List<Student> findByNameContaining1(@Param("name") String name);
}
