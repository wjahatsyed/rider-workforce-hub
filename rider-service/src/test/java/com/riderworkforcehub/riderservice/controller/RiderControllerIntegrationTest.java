package com.riderworkforcehub.riderservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.riderworkforcehub.riderservice.model.Rider;
import com.riderworkforcehub.riderservice.repository.RiderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RiderControllerIntegrationTest {

    @Autowired private MockMvc mockMvc;
    @Autowired private RiderRepository riderRepository;
    @Autowired private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        riderRepository.deleteAll();
    }

    @Test
    void shouldCreateAndFetchRider() throws Exception {
        Rider rider = Rider.builder()
                .fullName("Test User")
                .email("test@rider.com")
                .phone("1234567890")
                .city("Karachi")
                .active(true)
                .build();

        mockMvc.perform(post("/api/riders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(rider)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName", is("Test User")));

        mockMvc.perform(get("/api/riders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(1)));
    }

    @Test
    void shouldReturnNotFoundForMissingRider() throws Exception {
        mockMvc.perform(get("/api/riders/999"))
                .andExpect(status().isNotFound());
    }
}
