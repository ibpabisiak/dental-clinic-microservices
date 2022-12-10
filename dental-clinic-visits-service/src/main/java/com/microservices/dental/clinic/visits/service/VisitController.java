package com.microservices.dental.clinic.visits.service;

import com.microservices.dental.clinic.visits.service.data.VisitDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
@RequiredArgsConstructor
public class VisitController {

    private final VisitService visitService;

    @GetMapping
    public ResponseEntity<List<VisitDTO>> getAllVisits() {
        return ResponseEntity.ok().body(visitService.getAllVisits());
    }

    @GetMapping("/{visitId}")
    public ResponseEntity<VisitDTO> getVisit(@PathVariable String visitId) {
        return ResponseEntity.ok().body(visitService.getVisit(visitId));
    }

    @PostMapping
    public ResponseEntity<VisitDTO> createVisit(@RequestBody VisitDTO dto) {
        return ResponseEntity.ok().body(visitService.createVisit(dto));
    }

    @DeleteMapping("/{visitId}")
    public ResponseEntity<Void> deleteVisit(@PathVariable String visitId) {
        visitService.deleteVisit(visitId);
        return ResponseEntity.ok().build();
    }

}
