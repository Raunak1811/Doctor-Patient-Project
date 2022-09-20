package com.raunak.patientmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raunak.patientmicroservice.valueobject.PatientIncludesDoctor;
import com.raunak.patientmicroservice.entity.Patient;
import com.raunak.patientmicroservice.exception.AdditionalException;
import com.raunak.patientmicroservice.service.PatientMicroserviceService;

@RestController
@RequestMapping("/patient")
//@CrossOrigin(origins={"http://localhost:4200/"},
//methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class PatientMicroserviceController {

	@Autowired
	PatientMicroserviceService patServe;

	
	@PostMapping("/add")
	public Patient add(@RequestBody Patient patient) {
		return patServe.add(patient);
	}
	
	@GetMapping("/search/{id}")
	public PatientIncludesDoctor searchById(@PathVariable long id) throws AdditionalException
	{
		try {
			return patServe.searchById(id);
		} catch (AdditionalException e) {
			throw new AdditionalException(e.getMessage());
		}
	}
	
	@GetMapping("/with-doctor")
	public List<PatientIncludesDoctor> listPatient()
	{
		return patServe.listWithDoctor();
	}
	
	@GetMapping("/patient-of-doctor/{docId}")
	public int numberOfPatientInDoctor(@PathVariable long docId)
	{
		return patServe.numberOfPatientInDoctor(docId);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) throws AdditionalException
	{
		patServe.deleteById(id);
	}
}
