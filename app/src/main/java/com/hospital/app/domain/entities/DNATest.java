package com.hospital.app.domain.entities;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "dna_test")
public class DNATest extends BaseEntity {

	private Long userId;
	private String name;
	private String patientPhoneNumber;
	private String patientName;
	private Integer age;
	private String email;
	private String dna;
	private Double testResult;
	private LocalDateTime executionDate;

	public DNATest() {
	}
	
	@Column(name = "user_id", nullable = true, unique = false)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Length(min = 2, max = 60)
	@Column(name = "name", nullable = false, unique = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min = 2, max = 60)
	@Column(name = "patient_phone_number", nullable = false, unique = false)
	public String getPatientPhoneNumber() {
		return patientPhoneNumber;
	}

	public void setPatientPhoneNumber(String patientPhoneNumber) {
		this.patientPhoneNumber = patientPhoneNumber;
	}
	
	@Length(min = 2, max = 60)
	@Column(name = "patient_name", nullable = false, unique = false)
	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	@Min(10) 
	@Max(150)
	@Column(name = "age", nullable = false, unique = false)
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Length(min = 2, max = 60)
	@Column(name = "email", nullable = false, unique = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Length(min = 10, max = 255)
	@Column(name = "dna", nullable = false, unique = false)
	public String getDna() {
		return dna;
	}

	public void setDna(String dna) {
		this.dna = dna;
	}

	@Column(name = "test_result", nullable = false, unique = false)
	public Double getTestResult() {
		return testResult;
	}

	public void setTestResult(Double testResult) {
		this.testResult = testResult;
	}

	@Column(name = "execution_date", nullable = false, unique = false)
	public LocalDateTime getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(LocalDateTime executionDate) {
		this.executionDate = executionDate;
	}
}
