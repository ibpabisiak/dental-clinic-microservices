package com.microservices.dental.clinic.patients.service.data.value;

import lombok.*;
import org.hibernate.validator.constraints.pl.PESEL;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor(staticName = "of")
@EqualsAndHashCode
public class Pesel {

    @PESEL
    private final String pesel;
}
