package com.riderworkforcehub.riderservice.service.impl;

import com.riderworkforcehub.riderservice.model.Rider;
import com.riderworkforcehub.riderservice.repository.RiderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RiderServiceImplTest {

    private RiderRepository riderRepository;
    private RiderServiceImpl riderService;

    @BeforeEach
    void setUp() {
        riderRepository = Mockito.mock(RiderRepository.class);
        riderService = new RiderServiceImpl(riderRepository);
    }

    @Test
    void shouldCreateRider() {
        Rider rider = Rider.builder().fullName("John Doe").email("john@example.com").build();
        when(riderRepository.save(rider)).thenReturn(rider);

        Rider result = riderService.createRider(rider);
        assertEquals("John Doe", result.getFullName());
    }

    @Test
    void shouldGetRiderById() {
        Rider rider = Rider.builder().id(1L).fullName("Jane").build();
        when(riderRepository.findById(1L)).thenReturn(Optional.of(rider));

        Optional<Rider> found = riderService.getRiderById(1L);
        assertTrue(found.isPresent());
        assertEquals("Jane", found.get().getFullName());
    }

    @Test
    void shouldUpdateRider() {
        Rider original = Rider.builder().id(1L).fullName("Old").email("old@example.com").build();
        Rider updated = Rider.builder().fullName("New").email("new@example.com").build();

        when(riderRepository.findById(1L)).thenReturn(Optional.of(original));
        when(riderRepository.save(any(Rider.class))).thenAnswer(i -> i.getArgument(0));

        Rider result = riderService.updateRider(1L, updated);
        assertEquals("New", result.getFullName());
        assertEquals("new@example.com", result.getEmail());
    }

    @Test
    void shouldDeleteRider() {
        riderService.deleteRider(1L);
        verify(riderRepository, times(1)).deleteById(1L);
    }
}
