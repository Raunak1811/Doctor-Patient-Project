package com.raunak.patientmicroservice.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.raunak.patientmicroservice.entity.Patient;
import com.raunak.patientmicroservice.repository.PatientMicroserviceRepository;

@SpringBootTest
public class TestPatientMicroserviceController {

	@Autowired
    PatientMicroserviceController patControl;
     
    @Autowired
    PatientMicroserviceRepository patRepo;
    
    @Test
    void testList()
    {
    	assertThat(patControl.listPatient().size()).isGreaterThan(0);
    }
    
    @Test
    void testAdd()
    {
    	Patient p1=null;
		try {
			p1 = new Patient(10L,"Raunak Mitra",34,3L,new SimpleDateFormat("yyyy-mm-dd").parse("2022-08-20"),"CT SYXSXkHA");
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	patControl.add(p1);
    	
    	assertEquals("Raunak Mitra",patRepo.byName("Raunak Mitra").getName());
    }
    
  
    @Test
    void testListPatient()
    {
    	assertThat(patControl.listPatient().size()).isGreaterThan(0);
    }
    
    void testNumberOfPatientOfDoctor()
    {
    	assertThat(patControl.numberOfPatientInDoctor(3L)).isGreaterThan(0);
    }
}
