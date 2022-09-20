package com.raunak.patientmicroservice.implementation;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.raunak.patientmicroservice.entity.Patient;
import com.raunak.patientmicroservice.exception.AdditionalException;
import com.raunak.patientmicroservice.repository.PatientMicroserviceRepository;
import com.raunak.patientmicroservice.service.PatientMicroserviceService;
import com.raunak.patientmicroservice.valueobject.PatientIncludesDoctor;

@Component
public class PatientMicroserviceImplementation implements PatientMicroserviceService {

	@Autowired
	PatientMicroserviceRepository patRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public Patient add(Patient patient) {
		return patRepo.save(patient);
	}

	@Override
	public PatientIncludesDoctor searchById(long id) throws AdditionalException {
		List<Patient> listPatient = patRepo.getByIds(id);
		if(listPatient.size()>0)
		{
			PatientIncludesDoctor listPatDoc = new PatientIncludesDoctor();
			Iterator<Patient> itr = listPatient.iterator();
			
			while(itr.hasNext())
			{
				Patient patient = itr.next();
				String doctorName = restTemplate.getForObject("http://DOCTOR-MICROSERVICE/doctor/get-name/"+patient.getVisitedDoctor(), String.class);
				PatientIncludesDoctor pwd = new PatientIncludesDoctor();
				pwd.setId(patient.getId());
				pwd.setName(patient.getName());
				pwd.setAge(patient.getAge());
				pwd.setVisitedDoctor(doctorName);
				pwd.setVisitingDate(patient.getVisitingDate());
				pwd.setPrescription(patient.getPrescription());
				
				return pwd;
			}
			
		}
		
		throw new AdditionalException("No Patient Found With ID "+id);
		
	}

	@Override
	public List<PatientIncludesDoctor> listWithDoctor() {
		
		List<PatientIncludesDoctor> listPatDoc = new ArrayList<PatientIncludesDoctor>();
		List<Patient> listPatient = patRepo.findAll();
		Iterator<Patient> itr = listPatient.iterator();
		
		while(itr.hasNext())
		{
			Patient patient = itr.next();
			String doctorName = restTemplate.getForObject("http://DOCTOR-MICROSERVICE/doctor/get-name/"+patient.getVisitedDoctor(), String.class);
			PatientIncludesDoctor pwd = new PatientIncludesDoctor();
			pwd.setId(patient.getId());
			pwd.setName(patient.getName());
			pwd.setAge(patient.getAge());
			pwd.setVisitedDoctor(doctorName);
			pwd.setVisitingDate(patient.getVisitingDate());
			pwd.setPrescription(patient.getPrescription());
			
			listPatDoc.add(pwd);
		}
		return listPatDoc;
	}

	@Override
	public int numberOfPatientInDoctor(long docId) {
		return patRepo.countPatByDoc(docId);
	}
	
	@Override
	public void deleteById(long id) {
		patRepo.deleteById(id);
	}

}
