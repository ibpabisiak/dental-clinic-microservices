package com.microservices.dental.clinic.dentists.service.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DentistDTO {

    private Integer id;
    private String firstName;
    private String lastName;

}
