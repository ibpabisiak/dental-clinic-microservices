package com.microservices.dental.clinic.patients.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.dental.clinic.patients.service.data.PatientDTO;
import com.microservices.dental.clinic.patients.service.data.PatientRepository;
import com.microservices.dental.clinic.patients.service.data.value.FirstName;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.microservices.dental.clinic.patients.service.TestDummyDataGenerator.prepareDummyPatientDto;
import static com.microservices.dental.clinic.patients.service.TestDummyDataGenerator.prepareDummyPatientEntity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class PatientsControllerTest {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private WebApplicationContext context;
    private final ObjectMapper om = new ObjectMapper();
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
        patientRepository.deleteAll();
    }

    @AfterEach
    void cleanup() {
        patientRepository.deleteAll();
    }

    @Test
    void shouldGetAListOfPatientsFromDatabase() throws Exception {
        var saved = patientRepository.save(prepareDummyPatientEntity());
        mockMvc.perform(get("/api/patients").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(saved.getId()));
    }

    @Test
    void shouldGetPatientByIdWithSuccess() throws Exception {
        var saved = patientRepository.save(prepareDummyPatientEntity());
        mockMvc.perform(get("/api/patients/" + saved.getId()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(saved.getId()));
    }

    @Test
    void shouldReturnNotFoundWithWrongId() throws Exception {
        mockMvc.perform(get("/api/patients/5").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldCreateNewPatient() throws Exception {
        var requestDto = prepareDummyPatientDto();
        var json = om.writeValueAsString(requestDto);

        var response = mockMvc.perform(post("/api/patients").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
        var responseDto = om.readValue(response.getResponse().getContentAsString(), PatientDTO.class);

        Assertions.assertEquals(requestDto.getFirstName(), responseDto.getFirstName());
    }

    @Test
    void shouldUpdateExistingPatient() throws Exception {
        var saved = patientRepository.save(prepareDummyPatientEntity());
        var requestDto = prepareDummyPatientDto();
        requestDto.setFirstName(FirstName.of("updatedFirstName"));
        var json = om.writeValueAsString(requestDto);

        mockMvc.perform(put("/api/patients/" + saved.getId()).content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
        var updated = patientRepository.findById(saved.getId()).get();

        Assertions.assertEquals(requestDto.getFirstName(), updated.getFirstName());
    }

    @Test
    void shouldReturnNotFoundWhenPatientNotExists() throws Exception {
        var json = om.writeValueAsString(prepareDummyPatientDto());
        mockMvc.perform(put("/api/patients/" + 1).content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }


}
