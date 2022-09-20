package com.raunak.patientmicroservice.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.raunak.patientmicroservice.valueobject.PatientIncludesDoctor;
import com.raunak.patientmicroservice.entity.Patient;
import com.raunak.patientmicroservice.exception.AdditionalException;

@Service
public interface PatientMicroserviceService {

	Patient add(Patient patient);
	PatientIncludesDoctor searchById(long id) throws AdditionalException;
	List<PatientIncludesDoctor> listWithDoctor();
	int numberOfPatientInDoctor(long docId);
	void deleteById(long id);
}
