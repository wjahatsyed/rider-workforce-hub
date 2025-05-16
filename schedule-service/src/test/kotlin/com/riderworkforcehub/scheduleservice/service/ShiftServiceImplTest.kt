package com.riderworkforcehub.scheduleservice.service

import com.riderworkforcehub.scheduleservice.model.Shift
import com.riderworkforcehub.scheduleservice.repository.ShiftRepository
import com.riderworkforcehub.scheduleservice.service.impl.ShiftServiceImpl
import io.mockk.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.util.*

class ShiftServiceImplTest {

    private lateinit var shiftRepository: ShiftRepository
    private lateinit var shiftService: ShiftService

    @BeforeEach
    fun setup() {
        shiftRepository = mockk()
        shiftService = ShiftServiceImpl(shiftRepository)
    }

    @Test
    fun `should create shift`() {
        val shift = Shift(0, 101, LocalDateTime.now(), LocalDateTime.now().plusHours(2), "Berlin", "SCHEDULED")
        every { shiftRepository.save(shift) } returns shift

        val result = shiftService.createShift(shift)
        assertEquals("Berlin", result.location)
    }

    @Test
    fun `should get shift by ID`() {
        val shift = Shift(1, 101, LocalDateTime.now(), LocalDateTime.now().plusHours(2), "Berlin", "SCHEDULED")
        every { shiftRepository.findById(1) } returns Optional.of(shift)

        val result = shiftService.getShiftById(1)
        assertNotNull(result)
        assertEquals("Berlin", result?.location)
    }

    @Test
    fun `should delete shift`() {
        every { shiftRepository.deleteById(1) } just Runs
        shiftService.deleteShift(1)
        verify(exactly = 1) { shiftRepository.deleteById(1) }
    }
}
