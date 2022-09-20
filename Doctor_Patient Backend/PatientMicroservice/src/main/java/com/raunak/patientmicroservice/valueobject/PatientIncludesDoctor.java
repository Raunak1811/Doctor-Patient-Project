package com.raunak.patientmicroservice.valueobject;

import java.util.Date;

public class PatientIncludesDoctor {
	private long id;
	private String name;
	private int age;
	private String visitedDoctor;
	private Date visitingDate;
	private String prescription;
	public PatientIncludesDoctor() {
		super();
	}
	public PatientIncludesDoctor(long id, String name, int age, String visitedDoctor, Date visitingDate, String prescription) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.visitedDoctor = visitedDoctor;
		this.visitingDate = visitingDate;
		this.prescription = prescription;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getVisitedDoctor() {
		return visitedDoctor;
	}
	public void setVisitedDoctor(String visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}
	public Date getVisitingDate() {
		return visitingDate;
	}
	public void setVisitingDate(Date visitingDate) {
		this.visitingDate = visitingDate;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	
}
