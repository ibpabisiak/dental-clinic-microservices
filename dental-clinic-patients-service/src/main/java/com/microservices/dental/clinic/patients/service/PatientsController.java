package com.microservices.dental.clinic.patients.service;

import com.microservices.dental.clinic.patients.service.data.PatientDTO;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientsController {

    private final PatientsService patientsService;

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        return ResponseEntity.ok(patientsService.getAllPatients());
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientDTO> getPatient(@PathVariable String patientId) {
        return ResponseEntity.ok(patientsService.getPatient(patientId));
    }

    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(@Valid @RequestBody PatientDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(patientsService.createPatient(dto));
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<Void> updatePatient(@PathVariable String patientId, @Valid @RequestBody PatientDTO dto) {
        patientsService.updatePatient(patientId, dto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
