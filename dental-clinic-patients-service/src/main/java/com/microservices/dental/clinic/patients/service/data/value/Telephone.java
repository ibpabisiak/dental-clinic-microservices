package com.microservices.dental.clinic.patients.service.data.value;

import lombok.*;

import javax.validation.constraints.Digits;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor(staticName = "of")
@EqualsAndHashCode
public class Telephone {

    @Digits(fraction = 0, integer = 9)
    private final String telephone;
}
