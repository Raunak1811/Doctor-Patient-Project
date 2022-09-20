package com.raunak.doctormicroservice.valueobject;

public class DoctorIncludesPatient {

	private long id;
	private String name;
	private int age;
	private String gender;
	private String specialist;
	private int patientCount;

	public DoctorIncludesPatient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DoctorIncludesPatient(long id, String name, int age, String gender, String specialist, int patientCount) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.specialist = specialist;
		this.patientCount = patientCount;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public int getpatientCount() {
		return patientCount;
	}

	public void setpatientCount(int patientCount) {
		this.patientCount = patientCount;
	}
}
