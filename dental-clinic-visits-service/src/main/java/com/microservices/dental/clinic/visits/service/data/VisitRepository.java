package com.microservices.dental.clinic.visits.service.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<VisitEntity, Integer> {

}
