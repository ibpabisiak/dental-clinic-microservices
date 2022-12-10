package com.microservices.dental.clinic.visits.service.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "visits")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "visit_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Column(name = "description", length = 8192)
    private String description;

    @Column(name = "patient_id")
    private int patientId;

    @Column(name = "dentist_id")
    private int dentistId;

}
