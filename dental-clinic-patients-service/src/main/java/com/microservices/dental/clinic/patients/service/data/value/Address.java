package com.microservices.dental.clinic.patients.service.data.value;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor(staticName = "of")
@EqualsAndHashCode
public class Address {

    private final String address;
}
