package com.riderworkforcehub.incentiveservice.service

import com.riderworkforcehub.incentiveservice.model.Incentive

interface IncentiveService {
    fun saveIncentive(incentive: Incentive): Incentive
}
