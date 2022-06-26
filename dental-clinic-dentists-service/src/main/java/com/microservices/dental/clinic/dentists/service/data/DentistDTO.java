package com.microservices.dental.clinic.dentists.service.data;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DentistDTO {

    private String id;
    private String name;
    private String surname;
    private Instant birthdate;
    private DentistSpeciality speciality;

}
