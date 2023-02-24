package com.systudent.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private String enrollment;
	private String name;
	private String lastName;
	private String surName;
	public String getEnrollment() {
		return enrollment;
	}
	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	@Override
	public String toString() {
		return "Student [enrollment=" + enrollment + ", name=" + name + ", lastName=" + lastName + ", surName="
				+ surName + "]";
	}
	
	
	
}
