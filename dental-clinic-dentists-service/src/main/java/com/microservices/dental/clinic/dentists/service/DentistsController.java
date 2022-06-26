package com.microservices.dental.clinic.dentists.service;

import com.microservices.dental.clinic.dentists.service.data.DentistDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dentists")
@RequiredArgsConstructor
public class DentistsController {

    private final DentistsService dentistsService;

    @GetMapping
    public ResponseEntity<List<DentistDTO>> getAllDentists() {
        return ResponseEntity.ok().body(dentistsService.getAllDentists());
    }

}
