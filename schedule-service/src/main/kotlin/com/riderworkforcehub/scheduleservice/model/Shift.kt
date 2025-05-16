package com.riderworkforcehub.scheduleservice.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "shifts")
data class Shift(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val riderId: Long,

    val startTime: LocalDateTime,
    val endTime: LocalDateTime,

    val location: String,
    val status: String // e.g., "SCHEDULED", "COMPLETED", "MISSED"
)
