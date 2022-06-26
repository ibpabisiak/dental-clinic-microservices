package com.microservices.dental.clinic.dentists.service.data;


import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DentistEntity {

    //TODO implement entity with databse
    private String id;
    private String name;
    private String surname;
    private Instant birthdate;
    private DentistSpeciality speciality;

}
