package com.microservices.dental.clinic.dentists.service;

import com.microservices.dental.clinic.dentists.service.data.DentistDTO;
import com.microservices.dental.clinic.dentists.service.data.DentistRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DentistsService {

    private final DentistRepository dentistRepository;

    public List<DentistDTO> getAllDentists() {
        var dentists = dentistRepository.findAll();
        return dentists.stream()
            .map(e -> new DentistDTO(e.getId(), e.getFirstName(), e.getLastName()))
            .collect(Collectors.toUnmodifiableList());
    }

}
