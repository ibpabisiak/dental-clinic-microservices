package com.microservices.dental.clinic.dentists.service.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<DentistEntity, Integer> {
}
