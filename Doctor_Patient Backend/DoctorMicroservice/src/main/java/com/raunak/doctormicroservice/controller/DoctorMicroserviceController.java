package com.raunak.doctormicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raunak.doctormicroservice.valueobject.DoctorIncludesPatient;
import com.raunak.doctormicroservice.entity.Doctor;
import com.raunak.doctormicroservice.exception.AdditionalException;
import com.raunak.doctormicroservice.service.DoctorMicroserviceService;

@RestController
@RequestMapping("/doctor")
//@CrossOrigin(origins={"http://localhost:4200/"},
public class DoctorMicroserviceController {

	@Autowired
	DoctorMicroserviceService docService;

	@PostMapping
	public Doctor add(@RequestBody Doctor doc) {
		return docService.add(doc);
	}

	@GetMapping
	public List<Doctor> list() throws AdditionalException {
		if (docService.list().isEmpty()) {
			throw new AdditionalException("No doctor found of that name");
		}
		return docService.list();

	}

	@GetMapping("/search-by-id/{id}")
	public DoctorIncludesPatient getByID(@PathVariable long id) throws AdditionalException {
		try {
			return docService.getById(id);
		} catch (Exception e) {
			throw new AdditionalException(e.getMessage());
		}
	}

	
	@GetMapping("/search")
	public List<Doctor> getByName(@RequestParam String name)
	{
		return docService.getByName(name);
	}
//	
//	@PutMapping("/update/{id}")
//	public Doctor update(@RequestBody Doctor doc,@PathVariable long id) throws AdditionalException
//	{
//		return docService.update(doc, id);
//	}
	
	
	@DeleteMapping("/delete/{id}")
	public Doctor delete(@PathVariable long id) throws AdditionalException {
		return docService.delete(id);
	}

	@GetMapping("/get-name/{id}")
	public String getName(@PathVariable long id) {
		return docService.getName(id);
	}

}
