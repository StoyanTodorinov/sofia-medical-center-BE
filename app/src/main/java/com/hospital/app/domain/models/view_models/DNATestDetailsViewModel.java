package com.hospital.app.domain.models.view_models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DNATestDetailsViewModel extends BaseViewModel {
	
	private long userId;
	private String name;
	private String patientPhoneNumber;
	private String patientName;
	private int age;
	private String email;
	private String dna;
	private double testResult;
	private String executionDate;

	public DNATestDetailsViewModel() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDna() {
		return this.dna;
	}

	public void setDna(String dna) {
		this.dna = dna;
	}

	public double getTestResult() {
		return this.testResult;
	}

	public void setTestResult(double testResult) {
		this.testResult = testResult;
	}

	public String getExecutionDate() {
		return this.executionDate;
	}

	public void setExecutionDate(LocalDateTime executionDate) {
		this.executionDate = executionDate.format(DateTimeFormatter.ISO_DATE_TIME);
	}

	public String getPatientPhoneNumber() {
		return patientPhoneNumber;
	}

	public void setPatientPhoneNumber(String patientPhoneNumber) {
		this.patientPhoneNumber = patientPhoneNumber;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
}
