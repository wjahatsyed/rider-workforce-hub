package com.riderworkforcehub.scheduleservice.service.impl

import com.riderworkforcehub.scheduleservice.model.Shift
import com.riderworkforcehub.scheduleservice.repository.ShiftRepository
import com.riderworkforcehub.scheduleservice.service.ShiftService
import org.springframework.stereotype.Service

@Service
class ShiftServiceImpl(private val shiftRepo: ShiftRepository) : ShiftService {

    override fun createShift(shift: Shift): Shift = shiftRepo.save(shift)

    override fun getShiftById(id: Long): Shift? = shiftRepo.findById(id).orElse(null)

    override fun getAllShifts(): List<Shift> = shiftRepo.findAll()

    override fun updateShift(id: Long, updated: Shift): Shift {
        val existing = shiftRepo.findById(id).orElseThrow { RuntimeException("Shift not found") }
        val updatedShift = existing.copy(
            riderId = updated.riderId,
            startTime = updated.startTime,
            endTime = updated.endTime,
            location = updated.location,
            status = updated.status
        )
        return shiftRepo.save(updatedShift)
    }

    override fun deleteShift(id: Long) = shiftRepo.deleteById(id)
}
