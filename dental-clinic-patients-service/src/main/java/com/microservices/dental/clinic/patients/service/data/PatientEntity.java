package com.microservices.dental.clinic.patients.service.data;

import com.microservices.dental.clinic.patients.service.data.value.*;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder(builderClassName = "Patient")
@Table(name = "patients")
@NoArgsConstructor
@AllArgsConstructor
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "first_name"))
    })
    private FirstName firstName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "last_name"))
    })
    private LastName lastName;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "address"))
    })
    private Address address;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "city"))
    })
    private City city;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "telephone"))
    })
    private Telephone telephone;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "pesel"))
    })
    private Pesel pesel;

}
