package com.microservices.dental.clinic.visits.service;

import com.microservices.dental.clinic.visits.service.data.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
}
