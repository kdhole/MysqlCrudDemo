package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student 
{
	@Id
	@GeneratedValue
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", Name=" + Name + ", City=" + City + "]";
	}
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		Name = name;
		City = city;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	private String Name;
	private String City;
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	
	
}
