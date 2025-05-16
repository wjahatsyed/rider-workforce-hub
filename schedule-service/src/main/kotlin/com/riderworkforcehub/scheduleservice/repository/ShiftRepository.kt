package com.riderworkforcehub.scheduleservice.repository

import com.riderworkforcehub.scheduleservice.model.Shift
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShiftRepository : JpaRepository<Shift, Long>
