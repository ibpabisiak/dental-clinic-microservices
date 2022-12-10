package com.microservices.dental.clinic.patients.service.data;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.microservices.dental.clinic.patients.service.data.value.*;
import lombok.*;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Patient")
public class PatientDTO {

    private Integer id;
    @NotNull
    @JsonUnwrapped
    private FirstName firstName;
    @NotNull
    @JsonUnwrapped
    private LastName lastName;
    @NotNull
    @JsonUnwrapped
    private Address address;
    @NotNull
    @JsonUnwrapped
    private City city;
    @NotNull
    @JsonUnwrapped
    private Telephone telephone;

    @NotNull
    @JsonUnwrapped
    private Pesel pesel;
}
