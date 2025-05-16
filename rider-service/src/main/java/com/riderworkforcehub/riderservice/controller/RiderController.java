package com.riderworkforcehub.riderservice.controller;

import com.riderworkforcehub.riderservice.model.Rider;
import com.riderworkforcehub.riderservice.service.RiderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/riders")
public class RiderController {

    private final RiderService riderService;

    public RiderController(RiderService riderService) {
        this.riderService = riderService;
    }

    @PostMapping
    public ResponseEntity<Rider> createRider(@Valid @RequestBody Rider rider) {
        return ResponseEntity.ok(riderService.createRider(rider));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rider> getRider(@PathVariable Long id) {
        return riderService.getRiderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Rider>> getAll() {
        return ResponseEntity.ok(riderService.getAllRiders());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rider> updateRider(@PathVariable Long id, @Valid @RequestBody Rider rider) {
        return ResponseEntity.ok(riderService.updateRider(id, rider));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        riderService.deleteRider(id);
        return ResponseEntity.noContent().build();
    }
}
