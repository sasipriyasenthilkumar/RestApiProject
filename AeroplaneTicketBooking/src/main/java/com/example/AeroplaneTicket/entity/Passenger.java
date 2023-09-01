package com.example.AeroplaneTicket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Passenger {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int PassengerId;
	private String name;
	private String mobileNumber;
	private int age;
	public int getPassengerId() {
		return PassengerId;
	}
	public void setPassengerId(int passengerId) {
		PassengerId = passengerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Passenger(int passengerId, String name, String mobileNumber, int age) {
		super();
		PassengerId = passengerId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.age = age;
	}
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
