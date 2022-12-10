package com.microservices.dental.clinic.visits.service.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitDTO {

    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date = new Date();

    private String description;

    private int patientId;

    private int dentistId;

}
