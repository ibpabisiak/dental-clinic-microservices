package com.microservices.dental.clinic.patients.service.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {

}
