package com.microservices.dental.clinic.visits.service;

import com.microservices.dental.clinic.visits.service.data.VisitDTO;
import com.microservices.dental.clinic.visits.service.data.VisitEntity;
import org.junit.jupiter.api.Assertions;

public class ObjectAssertions {

    private ObjectAssertions() {
        throw new UnsupportedOperationException();
    }

    public static void assertVisitEntityAndDto(VisitEntity entity, VisitDTO dto) {
        Assertions.assertEquals(entity.getId(), dto.getId());
        Assertions.assertEquals(entity.getDate(), dto.getDate());
        Assertions.assertEquals(entity.getDescription(), dto.getDescription());
        Assertions.assertEquals(entity.getDentistId(), dto.getDentistId());
        Assertions.assertEquals(entity.getPatientId(), dto.getPatientId());
    }

}
