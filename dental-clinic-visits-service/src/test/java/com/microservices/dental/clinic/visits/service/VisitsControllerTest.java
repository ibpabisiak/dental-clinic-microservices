package com.microservices.dental.clinic.visits.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.microservices.dental.clinic.visits.service.data.VisitDTO;
import com.microservices.dental.clinic.visits.service.data.VisitRepository;
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

import java.time.Instant;

import static com.microservices.dental.clinic.visits.service.ObjectAssertions.assertVisitEntityAndDto;
import static com.microservices.dental.clinic.visits.service.TestDummyDataGenerator.prepareVisitDto;
import static com.microservices.dental.clinic.visits.service.TestDummyDataGenerator.prepareVisitEntity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class VisitsControllerTest {

    @Autowired
    private VisitRepository visitRepository;
    @Autowired
    private WebApplicationContext context;
    private final ObjectMapper om = new ObjectMapper();
    private MockMvc mockMvc;


    @BeforeEach
    void setup() {

        om.registerModule(new JavaTimeModule());
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
        visitRepository.deleteAll();
    }

    @AfterEach
    void cleanup() {
        visitRepository.deleteAll();
    }

    @Test
    void shouldGetAListOfPatientsFromDatabase() throws Exception {

        var saved = visitRepository.save(prepareVisitEntity());
        mockMvc.perform(get("/api/visits").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(saved.getId()));
    }


    @Test
    void shouldGetVisitByIdWithSuccess() throws Exception {
        Instant.now();
        var saved = visitRepository.save(prepareVisitEntity());
        var mvcResult = mockMvc.perform(get("/api/visits/" + saved.getId()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(saved.getId()))
                .andReturn();
        var responseDto = om.readValue(mvcResult.getResponse().getContentAsString(), VisitDTO.class);
        assertVisitEntityAndDto(saved, responseDto);
    }

    @Test
    void shouldReturnNotFoundWithWrongId() throws Exception {
        mockMvc.perform(get("/api/visits/5").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldCreateNewPatient() throws Exception {
        var requestDto = prepareVisitDto();
        var json = om.writeValueAsString(requestDto);

        var response = mockMvc.perform(post("/api/visits").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
        var responseDto = om.readValue(response.getResponse().getContentAsString(), VisitDTO.class);

        Assertions.assertEquals(requestDto.getDescription(), responseDto.getDescription());
    }

}
