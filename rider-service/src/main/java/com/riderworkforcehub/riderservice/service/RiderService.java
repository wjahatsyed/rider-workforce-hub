package com.riderworkforcehub.riderservice.service;

import com.riderworkforcehub.riderservice.model.Rider;
import java.util.List;
import java.util.Optional;

public interface RiderService {
    Rider createRider(Rider rider);
    Optional<Rider> getRiderById(Long id);
    List<Rider> getAllRiders();
    Rider updateRider(Long id, Rider rider);
    void deleteRider(Long id);
}
