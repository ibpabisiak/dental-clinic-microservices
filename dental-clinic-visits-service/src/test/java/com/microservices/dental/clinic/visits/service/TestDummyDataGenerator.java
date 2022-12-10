package com.microservices.dental.clinic.visits.service;

import com.microservices.dental.clinic.visits.service.data.VisitDTO;
import com.microservices.dental.clinic.visits.service.data.VisitEntity;
import lombok.experimental.UtilityClass;

import java.util.Date;

@UtilityClass
public class TestDummyDataGenerator {

    public VisitEntity prepareVisitEntity() {
        return VisitEntity.builder()
                .id(1)
                .date(new Date())
                .description("test description")
                .dentistId(2)
                .patientId(3)
                .build();
    }

    public VisitDTO prepareVisitDto() {
        return VisitDTO.builder()
                .id(1)
                .date(new Date())
                .description("test description")
                .dentistId(2)
                .patientId(3)
                .build();
    }

}
