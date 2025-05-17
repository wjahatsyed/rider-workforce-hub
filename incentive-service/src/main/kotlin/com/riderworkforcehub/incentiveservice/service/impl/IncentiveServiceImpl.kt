package com.riderworkforcehub.incentiveservice.service.impl

import com.riderworkforcehub.incentiveservice.model.Incentive
import com.riderworkforcehub.incentiveservice.repository.IncentiveRepository
import com.riderworkforcehub.incentiveservice.service.IncentiveService
import org.springframework.stereotype.Service

@Service
class IncentiveServiceImpl(
    private val incentiveRepository: IncentiveRepository
) : IncentiveService {
    override fun saveIncentive(incentive: Incentive): Incentive =
        incentiveRepository.save(incentive)
}
