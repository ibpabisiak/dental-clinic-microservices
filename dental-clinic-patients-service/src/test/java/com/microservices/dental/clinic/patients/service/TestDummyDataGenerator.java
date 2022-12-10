package com.microservices.dental.clinic.patients.service;

import com.microservices.dental.clinic.patients.service.data.PatientDTO;
import com.microservices.dental.clinic.patients.service.data.PatientEntity;
import com.microservices.dental.clinic.patients.service.data.value.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestDummyDataGenerator {

    public PatientDTO prepareDummyPatientDto() {
        return PatientDTO.builder()
                .id(5)
                .firstName(FirstName.of("n"))
                .lastName(LastName.of("l"))
                .address(Address.of("a"))
                .city(City.of("c"))
                .telephone(Telephone.of("111222333"))
                .pesel(Pesel.of("12345678912"))
                .build();

    }

    public PatientEntity prepareDummyPatientEntity() {
        return PatientEntity.builder()
                .id(5)
                .firstName(FirstName.of("n"))
                .lastName(LastName.of("l"))
                .address(Address.of("a"))
                .city(City.of("c"))
                .telephone(Telephone.of("111222333"))
                .pesel(Pesel.of("12345678912"))
                .build();
    }
}
