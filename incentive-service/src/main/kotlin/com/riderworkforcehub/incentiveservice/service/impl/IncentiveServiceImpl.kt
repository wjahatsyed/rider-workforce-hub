package com.riderworkforcehub.incentiveservice.service.impl

import com.riderworkforcehub.incentiveservice.dto.IncentiveSummary
import com.riderworkforcehub.incentiveservice.model.Incentive
import com.riderworkforcehub.incentiveservice.repository.IncentiveRepository
import com.riderworkforcehub.incentiveservice.service.IncentiveService
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class IncentiveServiceImpl(
    private val incentiveRepository: IncentiveRepository
) : IncentiveService {
    override fun saveIncentive(incentive: Incentive): Incentive =
        incentiveRepository.save(incentive)

    override fun getTopRiders(limit: Int): List<IncentiveSummary> {
        val page = PageRequest.of(0, limit)
        return incentiveRepository.getTopRiders(page)
    }

}
