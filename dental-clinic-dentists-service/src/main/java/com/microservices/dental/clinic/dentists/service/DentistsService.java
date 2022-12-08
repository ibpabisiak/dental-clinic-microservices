package com.microservices.dental.clinic.dentists.service;

import com.microservices.dental.clinic.dentists.service.data.DentistDTO;
import com.microservices.dental.clinic.dentists.service.data.DentistRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DentistsService {

    private final DentistRepository dentistRepository;
    private final ModelMapper modelMapper;

    public List<DentistDTO> getAllDentists() {
        var dentists = dentistRepository.findAll();
        return dentists.stream()
            .map(e -> modelMapper.map(e, DentistDTO.class))
            .collect(Collectors.toUnmodifiableList());
    }

}
