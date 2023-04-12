package com.example.demo.controller;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Student;
@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Integer> {
}
