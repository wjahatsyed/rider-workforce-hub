package com.riderworkforcehub.incentiveservice.repository

import com.riderworkforcehub.incentiveservice.dto.IncentiveSummary
import com.riderworkforcehub.incentiveservice.model.Incentive
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface IncentiveRepository : JpaRepository<Incentive, Long> {
    @Query(
        """
    SELECT i.riderId AS riderId, SUM(i.rewardPoints) AS totalPoints
    FROM Incentive i
    GROUP BY i.riderId
    ORDER BY totalPoints DESC
"""
    )
    abstract fun getTopRiders(page: PageRequest): List<IncentiveSummary>
}



