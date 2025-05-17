package com.riderworkforcehub.incentiveservice.controller

import com.riderworkforcehub.incentiveservice.dto.IncentiveSummary
import com.riderworkforcehub.incentiveservice.service.IncentiveService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/incentives")
class IncentiveController(
    private val incentiveService: IncentiveService
) {

    @GetMapping("/leaderboard")
    fun getLeaderboard(@RequestParam(defaultValue = "10") limit: Int): ResponseEntity<List<IncentiveSummary>> {
        val topRiders = incentiveService.getTopRiders(limit)
        return ResponseEntity.ok(topRiders)
    }
}
