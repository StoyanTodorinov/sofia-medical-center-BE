package com.hospital.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.app.domain.models.binding_models.DNATestBindingModelCreate;
import com.hospital.app.domain.models.binding_models.DNATestBindingModelUpdate;
import com.hospital.app.domain.models.view_models.DNATestDetailsViewModel;
import com.hospital.app.domain.models.view_models.DNATestListItemViewModel;
import com.hospital.app.exceptions.NotFoundException;
import com.hospital.app.services.DNATestService;

@RestController
@RequestMapping("/tests")
public class DNATestController {

	private final DNATestService service;

	@Autowired
	public DNATestController(DNATestService service) {
		this.service = service;
	}

	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public Double id(@Valid @RequestBody DNATestBindingModelCreate model) {
		Double testResult = this.service.insertATest(model);
		return testResult;
	}
	
	@PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
	public Double id(@Valid @RequestBody DNATestBindingModelUpdate model) throws NotFoundException {
		Double testResult = this.service.updateATest(model);
		return testResult;
	}
	
	@GetMapping("/details/{id}")
	public DNATestDetailsViewModel findTestsByPhoneNumber(@PathVariable Long id) throws NotFoundException {
		DNATestDetailsViewModel testDetails = this.service.findTestById(id);
    	return testDetails;
	}
	
	@GetMapping("/all")
	public List<DNATestListItemViewModel> findAllTests() {
    	List<DNATestListItemViewModel> tests = this.service.findAllTests();
		return tests;
	}

	@GetMapping("/all/name/{patientName}")
	public List<DNATestListItemViewModel> findTestsByName(@PathVariable String patientName) {
    	List<DNATestListItemViewModel> tests = this.service.findAllTestsByPatientName(patientName);
    	return tests;
	}

	@GetMapping("/all/phone-number/{phoneNumber}")
	public List<DNATestListItemViewModel> findTestsByPhoneNumber(@PathVariable String phoneNumber) {
    	List<DNATestListItemViewModel> tests = this.service.findAllTestsByPatientPhoneNumber(phoneNumber);
    	return tests;
	}
}
