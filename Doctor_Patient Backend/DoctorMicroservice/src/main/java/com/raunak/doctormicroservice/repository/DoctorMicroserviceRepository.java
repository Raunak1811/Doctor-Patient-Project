package com.raunak.doctormicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raunak.doctormicroservice.entity.Doctor;

public interface DoctorMicroserviceRepository extends JpaRepository<Doctor, Long> {

	@Query(value = "SELECT * FROM doctor WHERE name LIKE %:name%", nativeQuery = true)
	List<Doctor> finByName(String name);

	@Query(value = "SELECT * FROM doctor WHERE name=:name", nativeQuery = true)
	Doctor ByName(String name);

	@Query(value = "SELECT name FROM doctor WHERE id=:id", nativeQuery = true)
	String getName(long id);

//	@Query(value = "Select * from doctor where name=:name",nativeQuery = true)
//	Doctor getByName(String name);

}
