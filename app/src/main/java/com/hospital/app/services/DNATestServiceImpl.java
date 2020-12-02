package com.hospital.app.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital.app.domain.entities.DNATest;
import com.hospital.app.domain.models.binding_models.DNATestBindingModelCreate;
import com.hospital.app.domain.models.binding_models.DNATestBindingModelUpdate;
import com.hospital.app.domain.models.view_models.DNATestDetailsViewModel;
import com.hospital.app.domain.models.view_models.DNATestListItemViewModel;
import com.hospital.app.exceptions.NotFoundException;
import com.hospital.app.repositories.DNATestRepository;
import com.hospital.app.utils.Algorithms;

@Service
public class DNATestServiceImpl implements DNATestService {

	private final ModelMapper modelMapper;
	private final DNATestRepository DNATestRepo;

	@Autowired
	public DNATestServiceImpl(ModelMapper modelMapper, DNATestRepository DNATestRepo) {
		this.modelMapper = modelMapper;
		this.DNATestRepo = DNATestRepo;
	}

	@Override
	public Double insertATest(DNATestBindingModelCreate model) {
		DNATest test = this.modelMapper.map(model, DNATest.class);

		test.setUserId(null);
		test.setTestResult(Algorithms.getGeneticDisorderProbability(test.getDna()));
		test.setExecutionDate(LocalDateTime.now());

		DNATest insertedTest = this.DNATestRepo.saveAndFlush(test);
		return insertedTest.getTestResult();
	}

	@Override
	public Double updateATest(DNATestBindingModelUpdate model) throws NotFoundException {
		DNATest test = this.modelMapper.map(model, DNATest.class);

		test.setUserId(null);
		test.setTestResult(Algorithms.getGeneticDisorderProbability(test.getDna()));
		test.setExecutionDate(LocalDateTime.now());

		try {
			DNATest updatedTest = this.DNATestRepo.saveAndFlush(test);
			return updatedTest.getTestResult();
		} catch (Exception e) {
			throw new NotFoundException("Test missing!");
		}
	}

	@Override
	public DNATestDetailsViewModel findTestById(Long id) throws NotFoundException {
		try {
			DNATest test = this.DNATestRepo.findById(id);
			DNATestDetailsViewModel mapped = this.modelMapper.map(test, DNATestDetailsViewModel.class);
			return mapped;
		} catch (Exception e) {
			throw new NotFoundException("Test missing!");
		}
	}

	@Override
	public List<DNATestListItemViewModel> findAllTests() {
		List<DNATest> tests = this.DNATestRepo.findAll();
		List<DNATestListItemViewModel> mappedTests = this.mapDnaTestsToViewList(tests);
		return mappedTests;
	}

	@Override
	public List<DNATestListItemViewModel> findAllTestsByPatientName(String name) {
		List<DNATest> tests = this.DNATestRepo.findAllByPatientName(name);
		List<DNATestListItemViewModel> mappedTests = this.mapDnaTestsToViewList(tests);
		return mappedTests;
	}

	@Override
	public List<DNATestListItemViewModel> findAllTestsByPatientPhoneNumber(String phoneNumber) {
		List<DNATest> tests = this.DNATestRepo.findAllByPatientPhoneNumber(phoneNumber);
		List<DNATestListItemViewModel> mappedTests = this.mapDnaTestsToViewList(tests);
		return mappedTests;
	}

	private List<DNATestListItemViewModel> mapDnaTestsToViewList(List<DNATest> tests) {
		List<DNATestListItemViewModel> mappedTests = new ArrayList<>();
		
		for (DNATest test : tests) {
			DNATestListItemViewModel mapped = this.modelMapper.map(test, DNATestListItemViewModel.class);
			mappedTests.add(mapped);
		}

		return mappedTests;
	}
}
