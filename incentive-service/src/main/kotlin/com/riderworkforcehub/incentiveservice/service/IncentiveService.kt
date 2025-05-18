package com.riderworkforcehub.incentiveservice.service

import com.riderworkforcehub.incentiveservice.dto.IncentiveSummary
import com.riderworkforcehub.incentiveservice.model.Incentive

interface IncentiveService {
    fun saveIncentive(incentive: Incentive): Incentive
    fun getTopRiders(limit: Int): List<IncentiveSummary>?
    abstract fun getIncentivesByRiderId(riderId: Long): List<Incentive>?
}
