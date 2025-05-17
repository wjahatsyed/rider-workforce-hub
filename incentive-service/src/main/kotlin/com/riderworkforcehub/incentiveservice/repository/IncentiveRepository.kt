package com.riderworkforcehub.incentiveservice.repository

import com.riderworkforcehub.incentiveservice.model.Incentive
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IncentiveRepository : JpaRepository<Incentive, Long>
