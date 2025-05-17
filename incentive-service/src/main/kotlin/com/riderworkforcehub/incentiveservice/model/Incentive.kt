package com.riderworkforcehub.incentiveservice.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "incentives")
data class Incentive(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val riderId: Long,
    val shiftId: Long,
    val rewardPoints: Int,
    val rewardedAt: LocalDateTime = LocalDateTime.now()
)
