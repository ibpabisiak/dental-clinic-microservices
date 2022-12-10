package com.microservices.dental.clinic.patients.service;

import com.microservices.dental.clinic.patients.service.data.PatientDTO;
import com.microservices.dental.clinic.patients.service.data.PatientEntity;
import com.microservices.dental.clinic.patients.service.data.PatientRepository;
import com.microservices.dental.clinic.patients.service.exception.ResourceNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PatientsService {

    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    public List<PatientDTO> getAllPatients() {
        log.info("Loading all patients.");

        var entity = patientRepository.findAll();
        var dto = modelMapper.map(entity, PatientDTO.class);
        return patientRepository.findAll().stream()
            .map(e -> modelMapper.map(e, PatientDTO.class))
            .collect(Collectors.toUnmodifiableList());
    }

    public PatientDTO getPatient(String patientId) {
        log.info("Loading {} patient.", patientId);
        return modelMapper.map(getEntity(patientId), PatientDTO.class);
    }

    public PatientDTO createPatient(PatientDTO dto) {
        log.info("Creating a new patient.");
        var saved = patientRepository.save(modelMapper.map(dto, PatientEntity.class));
        return modelMapper.map(saved, PatientDTO.class);
    }

    public void updatePatient(String patientId, PatientDTO dto) {
        log.info("Updating {} patient.", patientId);
        var patientFromDb = getEntity(patientId);
        var updatedEntity = modelMapper.map(dto, PatientEntity.class);
        updatedEntity.setId(patientFromDb.getId());
        patientRepository.save(updatedEntity);
    }

    private PatientEntity getEntity(String patientId) {
        return patientRepository
            .findById(Integer.valueOf(patientId))
            .orElseThrow(() -> new ResourceNotFoundException("Patient not found."));
    }

}
