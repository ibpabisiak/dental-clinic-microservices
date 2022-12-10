package com.microservices.dental.clinic.visits.service;

import com.microservices.dental.clinic.visits.service.data.VisitDTO;
import com.microservices.dental.clinic.visits.service.data.VisitEntity;

import java.time.Instant;

public class TestDummyDataGenerator {

    private TestDummyDataGenerator() {
        throw new UnsupportedOperationException();
    }

    public static VisitEntity prepareVisitEntity() {
        return VisitEntity.builder()
                .id(1)
                .date(Instant.now())
                .description("test description")
                .dentistId(2)
                .patientId(3)
                .build();
    }

    public static VisitDTO prepareVisitDto() {
        return VisitDTO.builder()
                .id(1)
                .date(Instant.now())
                .description("test description")
                .dentistId(2)
                .patientId(3)
                .build();
    }

}
