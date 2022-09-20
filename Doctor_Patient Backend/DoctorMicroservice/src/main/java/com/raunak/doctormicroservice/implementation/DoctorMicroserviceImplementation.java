package com.raunak.doctormicroservice.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.raunak.doctormicroservice.valueobject.DoctorIncludesPatient;
import com.raunak.doctormicroservice.entity.Doctor;
import com.raunak.doctormicroservice.exception.AdditionalException;
import com.raunak.doctormicroservice.repository.DoctorMicroserviceRepository;
import com.raunak.doctormicroservice.service.DoctorMicroserviceService;

@Component
public class DoctorMicroserviceImplementation implements DoctorMicroserviceService {

	@Autowired
	DoctorMicroserviceRepository DocRepo;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public Doctor add(Doctor doc) {
		return DocRepo.save(doc);
	}

	@Override
	public List<Doctor> list() {
		return DocRepo.findAll();
	}

	@Override
	public DoctorIncludesPatient getById(long id) throws AdditionalException {
		Optional<Doctor> userOP = DocRepo.findById(id);
		if (userOP.isPresent()) {
			Doctor dc = userOP.get();
			Integer pateintCount = restTemplate
					.getForObject("http://PATIENT-MICROSERVICE/patient/patient-of-doctor/" + id, Integer.class);
			DoctorIncludesPatient DWP = new DoctorIncludesPatient(dc.getId(), dc.getName(), dc.getAge(), dc.getGender(),
					dc.getSpecialist(), pateintCount);
			return DWP;
		}

		throw new AdditionalException("No such Doctor found in the database");
	}

	@Override
	public Doctor update(Doctor doc, long id) throws AdditionalException {
		Doctor getDoc = DocRepo.findById(id).get();
		if (getDoc != null) {
			getDoc.setName(doc.getName());
			getDoc.setAge(doc.getAge());
			getDoc.setGender(doc.getGender());
			getDoc.setSpecialist(doc.getSpecialist());

			return DocRepo.save(getDoc);
		}

		throw new AdditionalException("No Doctor Found In Database");
	}

	@Override
	public Doctor delete(long id) {
		Doctor doc = DocRepo.findById(id).get();

		DocRepo.deleteById(id);
		return doc;
	}

	@Override
	public List<Doctor> getByName(String name) {
		return DocRepo.finByName(name);
	}

	@Override
	public String getName(long id) {
		return DocRepo.getName(id);
	}

}
