package com.microservices.dental.clinic.patients.service.data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {

    private Integer id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String address;
    @NotBlank
    private String city;
    @NotBlank
    @Digits(fraction = 0, integer = 9)
    private String telephone;
}
