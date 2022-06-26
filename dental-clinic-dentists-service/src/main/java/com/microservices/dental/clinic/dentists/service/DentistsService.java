package com.microservices.dental.clinic.dentists.service;

import com.microservices.dental.clinic.dentists.service.data.DentistDTO;
import com.microservices.dental.clinic.dentists.service.data.DentistSpeciality;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DentistsService {

    public List<DentistDTO> getAllDentists() {
        //TODO implement loading from database
        return prepareDummyData(5);
    }


    private List<DentistDTO> prepareDummyData(int count) {
        var dentists = new ArrayList<DentistDTO>();
        for (int i = 0; i < count; i++) {
            dentists.add(
                new DentistDTO(UUID.randomUUID().toString(), "John" + i, "Smith", Instant.now(),
                    DentistSpeciality.ENDODONTIST));
        }
        return dentists;
    }

}
