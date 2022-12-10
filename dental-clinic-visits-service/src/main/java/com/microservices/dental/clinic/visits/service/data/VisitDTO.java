package com.microservices.dental.clinic.visits.service.data;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitDTO {

    private Integer id;

    private Instant date;

    private String description;

    private int patientId;

    private int dentistId;

}
