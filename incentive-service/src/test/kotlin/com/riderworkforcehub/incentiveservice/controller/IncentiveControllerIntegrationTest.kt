package com.riderworkforcehub.incentiveservice.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.riderworkforcehub.incentiveservice.model.Incentive
import com.riderworkforcehub.incentiveservice.repository.IncentiveRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import java.time.LocalDateTime
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@AutoConfigureMockMvc
class IncentiveControllerIntegrationTest {

    @Autowired lateinit var mockMvc: MockMvc
    @Autowired lateinit var objectMapper: ObjectMapper
    @Autowired lateinit var incentiveRepo: IncentiveRepository

    @BeforeEach
    fun setup() {
        incentiveRepo.deleteAll()

        val now = LocalDateTime.now()
        incentiveRepo.saveAll(listOf(
            Incentive(riderId = 101, shiftId = 1, rewardPoints = 10, rewardedAt = now),
            Incentive(riderId = 102, shiftId = 2, rewardPoints = 20, rewardedAt = now),
            Incentive(riderId = 101, shiftId = 3, rewardPoints = 30, rewardedAt = now)
        ))
    }

    @Test
    fun `should fetch leaderboard`() {
        mockMvc.perform(get("/api/incentives/leaderboard"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.size()").value(2))
            .andExpect(jsonPath("$[0].riderId").value(101))
            .andExpect(jsonPath("$[0].totalPoints").value(40))
    }

    @Test
    fun `should fetch incentives by rider ID`() {
        mockMvc.perform(get("/api/incentives/101"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.size()").value(2))
    }
}
