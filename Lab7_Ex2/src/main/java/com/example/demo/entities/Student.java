package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String email;
	private String ieltsScore;
	/*
	public Student() {
		super();
	}
	
	public Student(String name, int age, String email, String ieltsScore) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.ieltsScore = ieltsScore;
	}

	public Student(int id, String name, int age, String email, String ieltsScore) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.ieltsScore = ieltsScore;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIeltsScore() {
		return ieltsScore;
	}
	public void setIeltsScore(String ieltsScore) {
		this.ieltsScore = ieltsScore;
	}
	*/
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", ieltsScore="
				+ ieltsScore + "]";
	}
	
	

}
