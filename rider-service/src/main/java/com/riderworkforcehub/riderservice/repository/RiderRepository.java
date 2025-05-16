package com.riderworkforcehub.riderservice.repository;

import com.riderworkforcehub.riderservice.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {
}
