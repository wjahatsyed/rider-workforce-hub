package com.riderworkforcehub.riderservice.service.impl;

import com.riderworkforcehub.riderservice.model.Rider;
import com.riderworkforcehub.riderservice.repository.RiderRepository;
import com.riderworkforcehub.riderservice.service.RiderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RiderServiceImpl implements RiderService {

    private final RiderRepository riderRepository;

    public RiderServiceImpl(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    @Override
    public Rider createRider(Rider rider) {
        return riderRepository.save(rider);
    }

    @Override
    public Optional<Rider> getRiderById(Long id) {
        return riderRepository.findById(id);
    }

    @Override
    public List<Rider> getAllRiders() {
        return riderRepository.findAll();
    }

    @Override
    public Rider updateRider(Long id, Rider updatedRider) {
        Rider existing = riderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rider not found"));
        existing.setFullName(updatedRider.getFullName());
        existing.setEmail(updatedRider.getEmail());
        existing.setPhone(updatedRider.getPhone());
        existing.setCity(updatedRider.getCity());
        existing.setActive(updatedRider.isActive());
        return riderRepository.save(existing);
    }

    @Override
    public void deleteRider(Long id) {
        riderRepository.deleteById(id);
    }
}
