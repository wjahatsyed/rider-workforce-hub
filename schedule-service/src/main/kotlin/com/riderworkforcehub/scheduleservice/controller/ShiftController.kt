package com.riderworkforcehub.scheduleservice.controller

import com.riderworkforcehub.scheduleservice.model.Shift
import com.riderworkforcehub.scheduleservice.service.ShiftService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/shifts")
class ShiftController(private val shiftService: ShiftService) {

    @PostMapping
    fun create(@RequestBody shift: Shift): ResponseEntity<Shift> =
        ResponseEntity.ok(shiftService.createShift(shift))

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Shift> =
        shiftService.getShiftById(id)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @GetMapping
    fun getAll(): ResponseEntity<List<Shift>> =
        ResponseEntity.ok(shiftService.getAllShifts())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody shift: Shift): ResponseEntity<Shift> =
        ResponseEntity.ok(shiftService.updateShift(id, shift))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        shiftService.deleteShift(id)
        return ResponseEntity.noContent().build()
    }
}
