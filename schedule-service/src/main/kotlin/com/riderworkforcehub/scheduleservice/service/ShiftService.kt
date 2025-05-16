package com.riderworkforcehub.scheduleservice.service

import com.riderworkforcehub.scheduleservice.model.Shift

interface ShiftService {
    fun createShift(shift: Shift): Shift
    fun getShiftById(id: Long): Shift?
    fun getAllShifts(): List<Shift>
    fun updateShift(id: Long, updated: Shift): Shift
    fun deleteShift(id: Long)
}
