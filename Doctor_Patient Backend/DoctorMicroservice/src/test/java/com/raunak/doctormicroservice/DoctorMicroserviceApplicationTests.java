package com.raunak.doctormicroservice;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.raunak.doctormicroservice.controller.DoctorMicroserviceController;
import com.raunak.doctormicroservice.entity.Doctor;
import com.raunak.doctormicroservice.exception.AdditionalException;
import com.raunak.doctormicroservice.repository.DoctorMicroserviceRepository;

@SpringBootTest
class DoctorMicroserviceApplicationTests {

	@Autowired
    private DoctorMicroserviceRepository docRepo;
	
	@Autowired
	DoctorMicroserviceController docControl;
	
	@Test
	void testAdd() {
		Doctor docsample = new Doctor(6L,"Dr Sample Test",43,"Female","Neuro");
		Doctor addDoc = docControl.add(docsample);
		assertEquals(docRepo.ByName("Dr Sample Test").getName(),addDoc.getName());
	}
	@Test
	void testList() throws AdditionalException
	{
		assertEquals(docRepo.findAll().size(),docControl.list().size());
	}
}

