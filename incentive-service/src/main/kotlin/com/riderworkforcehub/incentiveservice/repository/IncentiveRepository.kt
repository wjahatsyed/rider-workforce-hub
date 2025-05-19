package com.riderworkforcehub.incentiveservice.repository

import com.riderworkforcehub.incentiveservice.dto.IncentiveSummary
import com.riderworkforcehub.incentiveservice.model.Incentive
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface IncentiveRepository : JpaRepository<Incentive, Long> {
    @Query(
        """
    SELECT NEW com.riderworkforcehub.incentiveservice.dto.IncentiveSummary(i.riderId, SUM(i.rewardPoints))
    FROM Incentive i
    GROUP BY i.riderId
    ORDER BY SUM(i.rewardPoints) DESC
"""
    )
    abstract fun getTopRiders(pageable: Pageable): List<IncentiveSummary>


    abstract fun findAllByRiderId(riderId: Long): List<Incentive>


}



