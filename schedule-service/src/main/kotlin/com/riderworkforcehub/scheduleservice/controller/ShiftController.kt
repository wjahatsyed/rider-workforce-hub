package com.riderworkforcehub.scheduleservice.controller

import com.riderworkforcehub.scheduleservice.model.Shift
import com.riderworkforcehub.scheduleservice.service.ShiftService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/shifts")
class ShiftController(
    private val shiftService: ShiftService
) {

    @PostMapping
    fun create(@RequestBody shift: Shift): ResponseEntity<Shift> {
        val createdShift = shiftService.createShift(shift)
        return ResponseEntity.ok(createdShift)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Shift> {
        val found = shiftService.getShiftById(id)
        return if (found != null) ResponseEntity.ok(found)
        else ResponseEntity.notFound().build()
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<Shift>> {
        val shifts = shiftService.getAllShifts()
        return ResponseEntity.ok(shifts)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody shift: Shift): ResponseEntity<Shift> {
        val updated = shiftService.updateShift(id, shift)
        return ResponseEntity.ok(updated)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        shiftService.deleteShift(id)
        return ResponseEntity.noContent().build()
    }
}
