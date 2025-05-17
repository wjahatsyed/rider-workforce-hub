package com.riderworkforcehub.scheduleservice.event

import java.time.LocalDateTime

data class ShiftCreatedEvent(
    val shiftId: Long,
    val riderId: Long,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val location: String
)
