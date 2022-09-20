package com.raunak.doctormicroservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.raunak.doctormicroservice.valueobject.DoctorIncludesPatient;
import com.raunak.doctormicroservice.entity.Doctor;
import com.raunak.doctormicroservice.exception.AdditionalException;

@Service
public interface DoctorMicroserviceService {

	Doctor add(Doctor doc);

	List<Doctor> list();

	DoctorIncludesPatient getById(long id) throws AdditionalException;

	Doctor update(Doctor doc, long id) throws AdditionalException;

	Doctor delete(long id) throws AdditionalException;

	List<Doctor> getByName(String name);

	String getName(long id);
}
