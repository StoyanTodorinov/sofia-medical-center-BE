package com.hospital.app.domain.models.binding_models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class DNATestBindingModelCreate {

	private String name;
	private String patientPhoneNumber;
	private String patientName;
	private int age;
	private String email;
	private String dna;

    DNATestBindingModelCreate() {
    }

	@Length(min = 2, max = 60)
	@NotNull
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Min(10)
	@Max(150)
	@NotNull
	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Length(min = 2, max = 60)
	@NotNull
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Length(min = 10, max = 255)
	@NotNull
	public String getDna() {
		return this.dna;
	}

	public void setDna(String dna) {
		this.dna = dna;
	}

	@Length(min = 2, max = 60)
	@NotNull
	public String getPatientPhoneNumber() {
		return this.patientPhoneNumber;
	}

	public void setPatientPhoneNumber(String patientPhoneNumber) {
		this.patientPhoneNumber = patientPhoneNumber;
	}

	@Length(min = 2, max = 60)
	@NotNull
	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
}