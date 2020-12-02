package com.hospital.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.app.domain.entities.DNATest;

import java.util.List;

@Repository
public interface DNATestRepository extends JpaRepository<DNATest, String> {
	
	DNATest findById(Long id);
	
	List<DNATest> findAll();
	
	List<DNATest> findAllByPatientName(String patientName);
	
	List<DNATest> findAllByPatientPhoneNumber(String patientPhoneNumber);
}
