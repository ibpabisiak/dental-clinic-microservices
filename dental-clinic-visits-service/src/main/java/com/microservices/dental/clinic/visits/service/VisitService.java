package com.microservices.dental.clinic.visits.service;

import com.microservices.dental.clinic.visits.service.data.VisitDTO;
import com.microservices.dental.clinic.visits.service.data.VisitEntity;
import com.microservices.dental.clinic.visits.service.data.VisitRepository;
import com.microservices.dental.clinic.visits.service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
    private final ModelMapper modelMapper;

    public List<VisitDTO> getAllVisits() {
        return visitRepository.findAll()
                .stream().map(e -> modelMapper.map(e, VisitDTO.class))
                .collect(Collectors.toUnmodifiableList());
    }

    public VisitDTO getVisit(String visitId) {
        return modelMapper.map(getEntity(visitId), VisitDTO.class);
    }

    public VisitDTO createVisit(VisitDTO dto) {
        var saved = visitRepository.save(modelMapper.map(dto, VisitEntity.class));
        return modelMapper.map(saved, VisitDTO.class);
    }

    public void deleteVisit(String visitId) {
        var entity = getEntity(visitId);
        visitRepository.delete(entity);
    }

    private VisitEntity getEntity(String id) {
        return visitRepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("Visit not found."));
    }
}
