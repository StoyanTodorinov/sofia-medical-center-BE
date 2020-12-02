package com.hospital.app.services;

import java.util.List;

import com.hospital.app.domain.models.binding_models.DNATestBindingModelCreate;
import com.hospital.app.domain.models.binding_models.DNATestBindingModelUpdate;
import com.hospital.app.domain.models.view_models.DNATestDetailsViewModel;
import com.hospital.app.domain.models.view_models.DNATestListItemViewModel;
import com.hospital.app.exceptions.NotFoundException;

public interface DNATestService {

	Double insertATest(DNATestBindingModelCreate model);
	
	Double updateATest(DNATestBindingModelUpdate model) throws NotFoundException;
	
	List<DNATestListItemViewModel> findAllTests();
	
	DNATestDetailsViewModel findTestById(Long id) throws NotFoundException;
	
	List<DNATestListItemViewModel> findAllTestsByPatientName(String name);
	
	List<DNATestListItemViewModel> findAllTestsByPatientPhoneNumber(String phoneNumber);
}
