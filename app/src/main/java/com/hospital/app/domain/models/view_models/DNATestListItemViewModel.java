package com.hospital.app.domain.models.view_models;

public class DNATestListItemViewModel extends BaseViewModel {

	private String patientName;
	private String patientPhoneNumber;
	private String name;
	private String dna;
	private double testResult;
	
	public DNATestListItemViewModel() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientPhoneNumber() {
		return patientPhoneNumber;
	}

	public void setPatientPhoneNumber(String patientPhoneNumber) {
		this.patientPhoneNumber = patientPhoneNumber;
	}
}
