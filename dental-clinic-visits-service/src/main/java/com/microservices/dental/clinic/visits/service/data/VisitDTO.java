package com.microservices.dental.clinic.visits.service.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class VisitDTO {

    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date = new Date();

    private String description;

    private int patientId;

    private int dentistId;

}
